package com.juanamhecha9.Base_de_datos.Exception;

public class ResourceNotFoundException  extends RuntimeException{
    private static final int serialVersionUID = (int) 1L;

    public ResourceNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
