package net.javaguides.springboot.producto.service;

import java.util.List;

import net.javaguides.springboot.producto.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
	Product createProduct(Product product);

	Product updateProduct(Product product);

	List<Product> getAllProduct();

	Product getProductById(long productId);

	void deleteProduct(long id);
}
