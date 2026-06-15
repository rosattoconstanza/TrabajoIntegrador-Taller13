package org.modelo.logica;

public class NumNegativoException extends Exception {
    private String mensaje;

    NumNegativoException() {
        this("");
    }
    NumNegativoException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
