package org.modelo.logica;

/**
 * Clase NumNegativoException.
 * Excepción personalizada que se lanza cuando el usuario ingresa
 * una cantidad negativa o igual a cero en contextos donde no corresponde
 * (por ejemplo, al pedir cuántos jugadores o directores técnicos cargar).
 *
 * @author Rosatto Constanza, Alegre Juan
 * @version 1.0
 */
public class NumNegativoException extends Exception {

    /**
     * Constructor por defecto de la excepción.
     */
    NumNegativoException() {
        this("");
    }

    /**
     * Constructor parametrizado de la excepción.
     * Llama a super(mensaje) para que el mensaje quede disponible
     * a través del método getMessage() heredado de Exception.
     *
     * @param mensaje Mensaje descriptivo del error
     */
    NumNegativoException(String mensaje) {
        super(mensaje);
    }
}
