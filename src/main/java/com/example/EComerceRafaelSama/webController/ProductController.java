package com.example.EComerceRafaelSama.webController;

import com.example.EComerceRafaelSama.domain.Product;
import com.example.EComerceRafaelSama.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    public List<Product> getAll(){
        return productService.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return productService.getProduct(productId);
    }
    public Optional<List<Product>> getByCategory(int categoriaId){
        return productService.getByCategory(categoriaId);
    }
    public Product save(Product product){
        return productService.save(product);
    }
    public Boolean delete(int productId){
        return productService.delete(productId);
    }
}
