package modelo;

public class CuerpoTecnico extends Persona {
    /** Clase CuerpoTecnico hereda de Persona.
     * Asociada con clase Seleccion.
     */

    private Rol rol;
    private Seleccion seleccion;

    //Constructores
    CuerpoTecnico(String nombre, int fecNacimiento, Rol rol,Seleccion seleccion) {
        super(nombre, fecNacimiento);
        this.rol = rol;
        this.seleccion=seleccion;
    }
    CuerpoTecnico() {

    }

    //Getters y Setters
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public Seleccion getSeleccion() {return seleccion;}
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }
}
