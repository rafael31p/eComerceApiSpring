package com.example.eComerceApiSpring.domain;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
    private String idCliente;
    private String nombre;
    private String apellidos;
    private Double celular;
    private String direccion;
    private String correoElectronico;
    private List<Purchase> compras;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Double getCelular() {
        return celular;
    }

    public void setCelular(Double celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Purchase> getCompras() {
        return compras;
    }

    public void setCompras(List<Purchase> compras) {
        this.compras = compras;
    }
}
