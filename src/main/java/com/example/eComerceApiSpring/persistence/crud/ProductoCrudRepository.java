package com.example.eComerceApiSpring.persistence.crud;
import com.example.eComerceApiSpring.persistence.entity.producto;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface ProductoCrudRepository extends CrudRepository<producto, Integer>{
    List<producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);
    Optional<List<producto>> findByCantidadLessThanAndEstado(Integer cantidad, Boolean estado);

}
