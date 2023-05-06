package com.example.eComerceApiSpring.domain.service;

import com.example.eComerceApiSpring.domain.Product;
import com.example.eComerceApiSpring.persistence.ProductoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductoRepository productoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> getAll(){
        return productoRepository.getAll();
    }
    public Optional<Product> getProduct(Integer productId){
        return productoRepository.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(Integer categoryId){
        return productoRepository.getByCategory(categoryId);
    }
    public Product save(Product product){
        return productoRepository.save(product);
    }
    @Transactional
    public Boolean delete(Integer productId){
        return getProduct(productId).map(prod -> {
            productoRepository.delete(productId);
            entityManager.flush();
            entityManager.clear();
            return true;
        }).orElse(false);
    }
}
