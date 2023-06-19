package com.example.eComerceApiSpring.persistence;

import com.example.eComerceApiSpring.domain.Customer;
import com.example.eComerceApiSpring.domain.repository.CustomerRepository;
import com.example.eComerceApiSpring.persistence.Mapper.CustomerMapper;
import com.example.eComerceApiSpring.persistence.crud.ClienteCrudRepository;
import com.example.eComerceApiSpring.persistence.crud.CompraCrudRepository;
import com.example.eComerceApiSpring.persistence.entity.Cliente;
import com.example.eComerceApiSpring.persistence.entity.Compra;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements CustomerRepository {


    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Cliente> getAll() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    @Override
    public Optional<List<Compra>> getByCompras(String idCustomer) {
        return compraCrudRepository.findByIdCliente(idCustomer);
    }
    @Override
    public Optional<Customer> getCustomer(String idCustomer){
        return Optional.of(customerMapper.toCustomer(clienteCrudRepository.findByIdCliente(idCustomer)));
    }

    @Transactional
    @Override
    public Cliente saveCustomer(Customer customer) {
        return clienteCrudRepository.save(customerMapper.toCliente(customer));
    }

    @Transactional
    @Override
    public void deleteCustomer(String idCustomer) {
        clienteCrudRepository.delete(clienteCrudRepository.findByIdCliente(idCustomer));
    }
}
