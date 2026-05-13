package modelo;

public class Arbitro extends Persona {
    /** Clase Arbitro hereda de Persona.
     * Asociada con clase Pais y Partido.
     */

    private int aniosExperiencia;
    private Pais pais;

    //Constructores
    Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
    }
    Arbitro() {

    }

    //Getters y Setters
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
    public Pais getPais() {
        return pais;
    }
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
