package com.juanamhecha9.Base_de_datos.Producto.Controller;

import com.juanamhecha9.Base_de_datos.Producto.Model.Producto;
import com.juanamhecha9.Base_de_datos.Producto.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProdcutos(){
        return ResponseEntity.ok().body(this.productoService.getAllProducto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id, @RequestBody Producto producto){
        return ResponseEntity.ok().body(this.productoService.getProdcutoById(id));
    }
}
