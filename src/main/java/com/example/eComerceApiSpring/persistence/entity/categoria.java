package com.example.eComerceApiSpring.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categorias")
public class categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private Boolean estado;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")
    private List<producto> productos;

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}
