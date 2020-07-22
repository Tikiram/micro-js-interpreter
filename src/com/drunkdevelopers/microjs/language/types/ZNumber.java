package com.drunkdevelopers.microjs.language.types;

public class ZNumber extends ZProtoObject {

    public final double valor;

    public ZNumber(double valor) {
        this.valor = valor;
    }

    @Override
    public String toNiceString() {
        return String.valueOf(valor);
    }
}
