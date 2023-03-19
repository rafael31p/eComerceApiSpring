package com.example.eComerceApiSpring.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class compraProducto {
    @EmbeddedId
    private compraProductoPk Id;
    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private compra compras;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private producto producto;
    public compraProductoPk getId() {
        return Id;
    }

    public void setId(compraProductoPk id) {
        Id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
