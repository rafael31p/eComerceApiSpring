package com.example.EComerceRafaelSama.persistence;
import com.example.EComerceRafaelSama.persistence.entity.producto;
import com.example.EComerceRafaelSama.persistence.crud.ProductoCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
    public List<producto> getAll(){
        return (List<producto>) productoCrudRepository.findAll();
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
