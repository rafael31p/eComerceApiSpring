package com.example.eComerceApiSpring.persistence;
import com.example.eComerceApiSpring.domain.Product;
import com.example.eComerceApiSpring.domain.repository.productRepository;
import com.example.eComerceApiSpring.persistence.Mapper.ProductMapper;
import com.example.eComerceApiSpring.persistence.entity.producto;
import com.example.eComerceApiSpring.persistence.crud.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements productRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;
    @Override
    public List<Product> getAll(){
        List<producto> productos= (List<producto>) productoCrudRepository.findAll();
        return mapper.toProductos(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProductos(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProductos(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public Product save(Product product) {
        producto producto = mapper.toProduct(product);
        return mapper.toProduct(producto);
    }

    public List<producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<List<producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
    public Optional<producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
