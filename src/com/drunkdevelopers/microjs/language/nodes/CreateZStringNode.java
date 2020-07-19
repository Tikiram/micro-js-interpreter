package com.drunkdevelopers.microjs.language.nodes;

import com.drunkdevelopers.microjs.language.FileLocation;
import com.drunkdevelopers.microjs.language.excepetions.LocatedSemanticException;
import com.drunkdevelopers.microjs.language.excepetions.SemanticException;
import com.drunkdevelopers.microjs.language.types.ZProtoObject;
import com.drunkdevelopers.microjs.language.types.ZString;

public class CreateZStringNode extends ProAstNode {

    private String valor;

    public CreateZStringNode(FileLocation fileLocation, String valor) {
        super(fileLocation);
        this.valor = valor;
    }

    @Override
    public ZProtoObject safeExecute(ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        return new ZString(this.valor);
    }
}
