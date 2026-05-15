package modelo;

public class DirectorTecnico extends Persona {
    /**Clase DirectorTecnico hereda de Persona.
     * Asociada con clase Seleccion.
     */
    private int fechaNombramiento;
    private Seleccion seleccion;

    //Constructores
    DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento,Seleccion seleccion) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
        this.seleccion=seleccion;
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
    public Seleccion getSeleccion() {return seleccion;}
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }
}
