package main.java.org.modelo.domain;

public class DirectorTecnico extends Persona {
    /**Clase DirectorTecnico hereda de Persona.
     * Asociada con clase Seleccion (Agregacion).
     */

    private int fechaNombramiento;

    //Constructores
    DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }
    public DirectorTecnico() {
        this("", 0, 0);
    }

    //Getters
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }

    //Setter
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }

}
