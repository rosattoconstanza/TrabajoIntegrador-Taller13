package org.modelo.domain;

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
