package com.drunkdevelopers.microjs.language.nodes;

import com.drunkdevelopers.microjs.language.LocatedSemanticException;
import com.drunkdevelopers.microjs.language.types.ZProtoObject;
import org.jetbrains.annotations.NotNull;

public interface AstNode {
    ZProtoObject execute(@NotNull ZProtoObject ambit) throws LocatedSemanticException;


}
