package com.example.eComerceApiSpring.domain.DTO;

import com.example.eComerceApiSpring.persistence.entity.CompraProductoPk;
import com.example.eComerceApiSpring.utils.enums.MedioPagoEnum;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CompraProductoDTO implements Serializable {
    private String idCliente;
    private MedioPagoEnum medioPagoEnum;
    private LocalDateTime fecha;
    private Integer idProducto;
    private String NombreCliente;
    private String ApellidosCliente;

}
