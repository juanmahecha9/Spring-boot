package net.javaguides.springboot.producto.controller;

        import java.util.List;

        import net.javaguides.springboot.producto.model.Product;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;

        import org.springframework.security.access.prepost.PreAuthorize;

        import net.javaguides.springboot.producto.service.ProductService;

@RestController
public class ProductoController {

    //Establecer la autorización para cada ruta dependiendo de que tipo de usuario este autenticado


    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok().body(productService.getAllProduct());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }


    // Los metodos post, put y delete solo puede ser realizados por un rol administrador


    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(this.productService.createProduct(product));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
        product.setId(id);
        return ResponseEntity.ok().body(this.productService.updateProduct(product));
    }
    
    @DeleteMapping("/products/{id}")
    public HttpStatus deleteProduct(@PathVariable long id){
        this.productService.deleteProduct(id);
        return HttpStatus.OK;
    }

}
