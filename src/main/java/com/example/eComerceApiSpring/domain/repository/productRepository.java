package com.example.eComerceApiSpring.domain.repository;

import com.example.eComerceApiSpring.domain.Product;

import java.util.List;
import java.util.Optional;

public interface productRepository {
    List <Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProduct(int quantity);
    Optional<Product> getProduct(int productId);

    Optional<List<Product>> getByCategory(Integer categoryId);

    Optional<List<Product>> getScarseProduct(Integer quantity);

    Optional<Product> getProduct(Integer productId);

    Product save(Product product);

    void delete(Integer idProducto);
}
