package com.example.EComerceRafaelSama.persistence;
import com.example.EComerceRafaelSama.domain.Product;
import com.example.EComerceRafaelSama.domain.repository.productRepository;
import com.example.EComerceRafaelSama.persistence.Mapper.ProductMapper;
import com.example.EComerceRafaelSama.persistence.entity.producto;
import com.example.EComerceRafaelSama.persistence.crud.ProductoCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements productRepository {
    private ProductoCrudRepository productoCrudRepository;

    private ProductMapper mapper;
    @Override
    public List<Product> getAll(){
        List<producto> productos= (List<producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
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
    public producto save(producto producto){
        return productoCrudRepository.save(producto);
    }
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
