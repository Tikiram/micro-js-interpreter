package com.drunkdevelopers.microjs.language.nodes;

import com.drunkdevelopers.microjs.language.FileLocation;
import com.drunkdevelopers.microjs.language.excepetions.LocatedSemanticException;
import com.drunkdevelopers.microjs.language.excepetions.SemanticException;
import com.drunkdevelopers.microjs.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public abstract class ProAstNode implements AstNode {

    public final @NotNull
    FileLocation fileLocation;

    public ProAstNode(@NotNull FileLocation fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public final ZProtoObject execute(@NotNull ZProtoObject ambit) throws LocatedSemanticException {
        try {
            return safeExecute(ambit);
        } catch (SemanticException semanticException) {
            System.out.println("Error:" + semanticException+" [fila: " + fileLocation.getY()+", columna: "+ fileLocation.getX()+"]");
            throw new LocatedSemanticException(this.fileLocation, semanticException);
        }
    }

    @NotNull
    public abstract ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException;

}
