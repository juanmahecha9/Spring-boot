package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
	Product createProduct(Product product);

	Product updateProduct(Product product);

	List<Product> getAllProduct();

	Product getProductById(long productId);

	void deleteProduct(long id);
}
