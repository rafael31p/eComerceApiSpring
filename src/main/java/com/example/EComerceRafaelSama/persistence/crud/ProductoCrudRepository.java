package com.example.EComerceRafaelSama.persistence.crud;
import com.example.EComerceRafaelSama.persistence.entity.producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<producto, Integer>{
    List<producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
