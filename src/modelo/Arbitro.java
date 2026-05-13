package modelo;

public class Arbitro extends Persona {
    /** Clase Arbitro hereda de Persona.
     * Asociada con clase Pais y Partido.
     */

    private int aniosExperiencia;

    //Constructores
    Arbitro(String nombre, int fecNacimiento, int aniosExperiencia) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
    }
    Arbitro() {

    }

    //Getters y Setters
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
}
