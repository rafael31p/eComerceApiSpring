package com.example.eComerceApiSpring.web.Controller;

import com.example.eComerceApiSpring.domain.Customer;
import com.example.eComerceApiSpring.domain.Purchase;
import com.example.eComerceApiSpring.domain.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/All")
    public ResponseEntity<List<Customer>> getAll(){
        return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idCustomer}")
    public ResponseEntity<List<Purchase>> getPurchaseByIdCustomer(@PathVariable String idCustomer){
        return customerService.getByPurchaseIdClient(idCustomer)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/Customer/{idCustomer}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String idCustomer){
        return customerService.getCustomer(idCustomer).map(customer ->
                new ResponseEntity<>(customer, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> saveNewCustomer(Customer customer){
        return new ResponseEntity<>(customerService.saveClient(customer), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{idCustomer}")
    public ResponseEntity deleteCustomer(@PathVariable String idCustomer){
        if(customerService.deleteCustomer(idCustomer)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
