package modelo;

public class CuerpoTecnico extends Persona {
    /** Clase CuerpoTecnico hereda de Persona.
     * Asociada con clase Seleccion (Agregacion).
     */

    private Rol rol;

    //Constructores
    CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;

    }
    CuerpoTecnico() {

    }

    //Getter
    public Rol getRol() {
        return rol;
    }

    //Setter
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
