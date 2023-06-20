package com.example.eComerceApiSpring.utils.genericos;

import java.io.Serializable;

public class ObjetoListaDTO implements Serializable {
    private Boolean exitos;
    private String etiqueta;
    private String valor;
    private String mensajeError;

    public ObjetoListaDTO() {
    }

    public ObjetoListaDTO(Boolean exitos, String etiqueta, String valor, String mensajeError) {
        this.exitos = exitos;
        this.etiqueta = etiqueta;
        this.valor = valor;
        this.mensajeError = mensajeError;
    }

    public Boolean getExitos() {
        return exitos;
    }

    public void setExitos(Boolean exitos) {
        this.exitos = exitos;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}
