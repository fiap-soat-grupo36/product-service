package br.com.fiap.oficina.product_service.exception;

public class RoleInvalidaException extends RuntimeException {

    public RoleInvalidaException(String message) {
        super(message);
    }

    public RoleInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
