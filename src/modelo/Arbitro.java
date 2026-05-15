package modelo;

public class Arbitro extends Persona {
    /** Clase Arbitro hereda de Persona.
     * Asociada con clase Pais y Partido.
     */

    private int aniosExperiencia;
    private Pais pais;
    private Arbitraje arbitraje;

    //Constructores
    Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais, Arbitraje arbitraje) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitraje=arbitraje;
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
    public void setArbitraje(Arbitraje arbitraje) {this.arbitraje = arbitraje;}
}
