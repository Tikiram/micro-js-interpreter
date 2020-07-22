package com.drunkdevelopers.microjs.language.nodes;

import com.drunkdevelopers.microjs.language.FileLocation;
import com.drunkdevelopers.microjs.language.excepetions.LocatedSemanticException;
import com.drunkdevelopers.microjs.language.excepetions.SemanticException;
import com.drunkdevelopers.microjs.language.types.ZNumber;
import com.drunkdevelopers.microjs.language.types.ZProtoObject;

public class CreateZNumberNode extends ProAstNode{


    private double valor;

    public CreateZNumberNode(FileLocation fileLocation, double valor) {

        super(fileLocation);
        this.valor = valor;
    }

    @Override
    public ZProtoObject safeExecute(ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return new ZNumber(this.valor);
    }
}
