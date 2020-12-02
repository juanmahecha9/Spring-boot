package net.javaguides.springboot.producto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.producto.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
