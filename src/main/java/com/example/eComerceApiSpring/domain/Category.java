package com.example.eComerceApiSpring.domain;

public class Category {
    private Integer categoryIdCompra;
    private String descripcion;
    private Boolean estado;

    public Integer getCategoryIdCompra() {
        return categoryIdCompra;
    }

    public void setCategoryIdCompra(Integer categoryIdCompra) {
        this.categoryIdCompra = categoryIdCompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean isEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
