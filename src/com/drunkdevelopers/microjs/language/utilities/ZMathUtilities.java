package com.drunkdevelopers.microjs.language.utilities;

import com.drunkdevelopers.microjs.language.excepetions.SemanticException;
import com.drunkdevelopers.microjs.language.types.ZContainer;
import com.drunkdevelopers.microjs.language.types.ZNumber;
import com.drunkdevelopers.microjs.language.types.ZProtoObject;
import com.drunkdevelopers.microjs.language.types.ZString;

import java.lang.reflect.InvocationTargetException;

public class ZMathUtilities {

    public static ZProtoObject dynamicCall(String name, String symbol, ZProtoObject v1, ZProtoObject v2)
            throws SemanticException {
        try {
            var method= ZMathUtilities.class.getDeclaredMethod(name, v1.getClass(), v2.getClass());
            return (ZProtoObject) method.invoke(null, v1, v2);
        } catch (NoSuchMethodException e) {
            throw new SemanticException(String.format("La operacion [%s %s %s] no es posible.",v1.toNiceString(),symbol, v2.toNiceString()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            if (e.getCause() != null) {
                if (e.getCause() instanceof SemanticException) {
                    throw (SemanticException) e.getCause();
                }
                throw new RuntimeException(e.getCause());
            }
            throw new RuntimeException(e);
        }
    }

    private static ZNumber add(ZNumber v1, ZNumber v2){
        return new ZNumber(v1.valor+v2.valor);
    }

    private static ZString add(ZString v1, ZString v2){
        return new ZString(v1.valor+v2.valor);
    }

    private static ZString add(ZNumber v1, ZString v2){
        return new ZString(v1.valor+v2.valor);
    }

    private static ZString add(ZString v1, ZNumber v2){
        return new ZString(v1.valor+v2.valor);
    }

    private static ZNumber division(ZNumber v1, ZNumber v2) throws SemanticException {
        if (v2.valor==0)
            throw new SemanticException(String.format("No se puede dividir %s en 0.",v1.toNiceString()));
        return new ZNumber(v1.valor/v2.valor);
    }
}
