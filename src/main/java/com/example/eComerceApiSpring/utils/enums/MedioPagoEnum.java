package com.example.eComerceApiSpring.utils.enums;

public enum MedioPagoEnum {
    TARJETA_DEBITO("TARJETA DEBITO"),
    TARJETA_CREDITO("TARJETA CREDITO"),
    NEQUI("NEQUI"),
    EFECTIVO("EFECTIVO");

    private final String codigoMessage;

    MedioPagoEnum(String codigoMessage) {
        this.codigoMessage = codigoMessage;
    }

    public String getCodigoMessage() {
        return codigoMessage;
    }
}
