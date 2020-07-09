# micro-js-interpreter
Just a micro javascript interpreter

```java
private static ZContainer dynamicCall(String name, String symbol, ZContainer v1, ZContainer v2)
            throws SemanticException {
        v1 = ZMap.unwrap(v1);
        v2 = ZMap.unwrap(v2);

        try {
            var method= MathMap.class.getDeclaredMethod(name, v1.getClass(), v2.getClass());
            return (ZContainer) method.invoke(null, v1, v2);

        } catch (NoSuchMethodException e) {
            throw new BinaryOperationNotSupported(v1, v2, symbol);
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
    ```
