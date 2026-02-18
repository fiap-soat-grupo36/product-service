package br.com.fiap.oficina.product_service.exception;

public class QuantidadeInvalidaParaReservaException extends BusinessException {

    public QuantidadeInvalidaParaReservaException(String message) {
        super(message);
    }

    public QuantidadeInvalidaParaReservaException(String message, Throwable cause) {
        super(message, cause);
    }
}
