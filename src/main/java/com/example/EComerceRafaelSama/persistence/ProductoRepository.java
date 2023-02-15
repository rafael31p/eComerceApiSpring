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
    public List<Product> getAll(){
        List<producto> productos= (List<producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return Optional.empty();
    }

    @Override
    public Product save(Product product) {
        return null;
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
