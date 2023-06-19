package com.example.eComerceApiSpring.persistence.crud;

import com.example.eComerceApiSpring.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {
    Cliente findByIdCliente(String idCliente);
}
