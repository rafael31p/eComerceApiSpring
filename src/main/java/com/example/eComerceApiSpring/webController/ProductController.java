package com.example.eComerceApiSpring.webController;

import com.example.eComerceApiSpring.domain.Product;
import com.example.eComerceApiSpring.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@RequestParam(value = "productId") int productId){
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
