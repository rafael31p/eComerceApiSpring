package com.example.EComerceRafaelSama.persistence;
import com.example.EComerceRafaelSama.persistence.entity.producto;
import com.example.EComerceRafaelSama.persistence.crud.ProductoCrudRepository;

import java.util.List;
import java.util.Optional;

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
}
