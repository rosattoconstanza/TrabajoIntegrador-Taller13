package org.modelo.domain;

/**
 * Clase abstracta Persona.
 * Cumple el papel de clase base de las clases Jugador, DirectorTecnico,
 * CuerpoTecnico y Arbitro.
 *
 * @author Rosatto Constanza
 * @version 1.0
 */
public abstract class Persona {

    private String nombre;
    private int fecNacimiento;

    /**
     * Constructor parametrizado de la clase Persona.
     *
     * @param nombre Nombre de la persona
     * @param fecNacimiento Fecha de nacimiento de la persona
     */
    public Persona(String nombre, int fecNacimiento) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }

    /**
     * Constructor por defecto de la clase Persona.
     * Inicializa los atributos con valores predeterminados.
     */
    public Persona() {
        this("", 0);
    }


    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return fecha de nacimiento
     */
    public int getFecNacimiento() {
        return fecNacimiento;
    }


    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fecNacimiento nueva fecha de nacimiento
     */
    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
