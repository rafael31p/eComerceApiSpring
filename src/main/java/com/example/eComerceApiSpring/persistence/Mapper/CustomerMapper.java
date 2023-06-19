package com.example.eComerceApiSpring.persistence.Mapper;

import com.example.eComerceApiSpring.domain.Customer;
import com.example.eComerceApiSpring.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mappings({
            @Mapping(target = "idCliente", source = "idCliente"),
            @Mapping(target = "nombre", source = "apellidos"),
            @Mapping(target = "apellidos", source = "apellidos"),
            @Mapping(target = "celular", source = "celular"),
            @Mapping(target = "direccion", source = "direccion"),
            @Mapping(target = "correoElectronico", source = "correoElectronico"),
            @Mapping(target = "compras", ignore = true)
    })
    Customer toCustomer(Cliente cliente);
    List<Customer> toCustomers(List<Cliente> clientes);
    @InheritInverseConfiguration
    Cliente toCliente(Customer customer);
}
