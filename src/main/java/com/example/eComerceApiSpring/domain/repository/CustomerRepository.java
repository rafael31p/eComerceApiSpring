package com.example.eComerceApiSpring.domain.repository;

import com.example.eComerceApiSpring.domain.Customer;
import com.example.eComerceApiSpring.persistence.entity.Cliente;
import com.example.eComerceApiSpring.persistence.entity.Compra;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Cliente> getAll();
    Optional<List<Compra>> getByCompras(String idCustomer);

    Optional<Customer> getCustomer(String idCustomer);

    Cliente saveCustomer(Customer customer);
    void deleteCustomer(String idCustomer);
}
