package modelo;
import java.util.ArrayList;

public class Arbitro extends Persona {
    /** Clase Arbitro hereda de Persona.
     * Asociada con clase Pais.
     * Asociada con Partido (creando Arbitraje).
     */

    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje> arbitraje;

    //Constructores
    Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais, ArrayList<Arbitraje> arbitraje) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitraje= arbitraje;
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
    public void agregarArbitraje(Arbitraje a) {
        this.arbitraje.add(a);
    }
}
