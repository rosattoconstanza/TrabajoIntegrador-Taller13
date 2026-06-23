package org.modelo.vista;

/**
 * Clase Main.
 * Punto de entrada del sistema de gestión del Mundial.
 * Crea una instancia de Aplicacion y lanza su ejecución.
 *
 * @author Rosatto Constanza
 * @version 1.1
 */
public class Main {

    /**
     * Método principal que inicia el sistema.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String args[]) {
        Aplicacion app = new Aplicacion();
        app.ejecutar();
    }
}
