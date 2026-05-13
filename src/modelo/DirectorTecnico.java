package modelo;

public class DirectorTecnico extends Persona {
    /**Clase DirectorTecnico hereda de Persona.
     * Asociada con clase Seleccion.
     */
    private int fechaNombramiento;

    //Constructores
    DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }
    public DirectorTecnico() {

    }

    //Getters y Setters
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }
}
