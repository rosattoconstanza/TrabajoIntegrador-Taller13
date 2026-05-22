package main.java.org.modelo.domain;

public abstract class Persona {
    /** Clase abstracta Persona. Cumple el papel de clase base
     *     de clase Jugador, DirectorTecnico, CuerpoTecnico y Arbitro.
     */
    private String nombre;
    private int fecNacimiento;

    //Constructores
    Persona(String nombre, int fecNacimiento) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }
    Persona() {
        this("", 0);
    }


    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getFecNacimiento() {
        return fecNacimiento;
    }


    //Setters
    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
