package com.drunkdevelopers.microjs.language.types;

public class ZString extends ZProtoObject {

    public final String valor;

    public ZString(String valor) {
        this.valor = valor;
    }

    @Override
    public String toNiceString() {
        return valor;
    }
}
