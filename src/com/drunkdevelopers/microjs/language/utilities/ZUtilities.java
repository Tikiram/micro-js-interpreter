package com.drunkdevelopers.microjs.language.utilities;

import com.drunkdevelopers.microjs.language.excepetions.SemanticException;
import com.drunkdevelopers.microjs.language.types.ZContainer;
import com.drunkdevelopers.microjs.language.types.ZNumber;
import com.drunkdevelopers.microjs.language.types.ZProtoObject;
import com.drunkdevelopers.microjs.language.types.ZString;

public class ZUtilities {

    public static ZProtoObject unwrap(ZProtoObject container) throws SemanticException {
        if (container instanceof ZContainer)
            return ((ZContainer) container).content;

        if (container instanceof ZString || container instanceof ZNumber)
            return container;

        throw new SemanticException("El container es incorrecto, no se puede desempacar.");
    }

}
