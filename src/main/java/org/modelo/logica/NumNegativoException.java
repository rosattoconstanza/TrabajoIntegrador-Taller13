package org.modelo.logica;

public class NumNegativoException extends Exception {

    NumNegativoException() {
        this("");
    }
    NumNegativoException(String mensaje) {
        super(mensaje);
    }

}
