package com.example.eComerceApiSpring.persistence.crud;
import com.example.eComerceApiSpring.persistence.entity.Producto;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{
    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);
    Optional<List<Producto>> findByCantidadLessThanAndEstado(Integer cantidad, Boolean estado);

}
