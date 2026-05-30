package org.modelo.domain;

public class CuerpoTecnico extends Persona {
    /** Clase CuerpoTecnico hereda de Persona.
     * Asociada con clase Seleccion (Agregacion).
     */

    private Rol rol;

    /** Constructores parametrizado y por defecto */
    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;

    }
    public CuerpoTecnico() {
        this("", 0, null);
    }

    /** Getter */
    public Rol getRol() {
        return rol;
    }

    /** Setter */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
