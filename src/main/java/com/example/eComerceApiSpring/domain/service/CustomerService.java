package com.example.eComerceApiSpring.domain.service;

import com.example.eComerceApiSpring.domain.Customer;
import com.example.eComerceApiSpring.domain.Purchase;
import com.example.eComerceApiSpring.domain.repository.CustomerRepository;
import com.example.eComerceApiSpring.persistence.Mapper.CustomerMapper;
import com.example.eComerceApiSpring.persistence.Mapper.PurchaseMapper;
import com.example.eComerceApiSpring.persistence.entity.Compra;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private PurchaseMapper purchaseMapper;
    @PersistenceContext
    private EntityManager entityManager;
    public List<Customer> getAll(){
        return customerMapper.toCustomers(customerRepository.getAll());
    }

    public Optional<List<Purchase>> getByPurchaseIdClient(String idCustomer){
        return customerRepository.getByCompras(idCustomer).map(compras -> purchaseMapper.toPurchases(compras));
    }
    public Optional<Customer> getCustomer(String idCustomer){
        Optional<Customer> customer = customerRepository.getCustomer(idCustomer);
        customer.get().setCompras(purchaseMapper.toPurchases(customerRepository.getByCompras(idCustomer).get()));
        return customer;
    }
    @Transactional
    public Customer saveClient(Customer customer){
        return customerMapper.toCustomer(customerRepository.saveCustomer(customer));
    }
    @Transactional
    public Boolean deleteCustomer(String idCustomer){
        return getCustomer(idCustomer).map(customer -> {
           customerRepository.deleteCustomer(idCustomer);
           entityManager.flush();
           entityManager.clear();
           return true;
        }).orElse(false);

    }
}
