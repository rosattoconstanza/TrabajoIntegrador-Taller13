package modelo;

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

    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getFecNacimiento() {
        return fecNacimiento;
    }
    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }
}
