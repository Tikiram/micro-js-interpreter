package com.drunkdevelopers.microjs.language.nodes;

import com.drunkdevelopers.microjs.language.FileLocation;
import com.drunkdevelopers.microjs.language.excepetions.LocatedSemanticException;
import com.drunkdevelopers.microjs.language.excepetions.SemanticException;
import com.drunkdevelopers.microjs.language.types.ZProtoObject;
import com.drunkdevelopers.microjs.language.utilities.ZMathUtilities;
import com.drunkdevelopers.microjs.language.utilities.ZUtilities;
import org.jetbrains.annotations.NotNull;

public class DivisionNode extends ProAstNode{
    private AstNode derechaNode;
    private AstNode izquierdaNode;

    public DivisionNode(FileLocation fileLocation, AstNode derechaNode, AstNode izquierdaNode) {
        super(fileLocation);
        this.derechaNode = derechaNode;
        this.izquierdaNode = izquierdaNode;
    }

    @Override
    public @NotNull ZProtoObject safeExecute(@NotNull ZProtoObject ambit) throws LocatedSemanticException, SemanticException {
        ZProtoObject valorDerecha = ZUtilities.unwrap(this.derechaNode.execute(ambit));
        ZProtoObject valorIzquierda = ZUtilities.unwrap(this.izquierdaNode.execute(ambit));

        return ZMathUtilities.dynamicCall("division","/",valorDerecha,valorIzquierda);
    }
}
