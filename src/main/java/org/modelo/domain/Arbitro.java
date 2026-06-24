package org.modelo.domain;
import java.util.ArrayList;

/**
 * Clase Arbitro.
 * Hereda de la clase Persona.
 * Está asociada con la clase Pais y con la clase Partido (a través de Arbitraje).
 *
 * @author Rosatto Constanza
 * @version 1.0
 */
public class Arbitro extends Persona {

    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje> arbitraje;

    /**
     * Constructor por defecto de la clase Arbitro.
     * Inicializa los atributos con valores predeterminados.
     *
     */
    public Arbitro() {
        this("", 0, 0, null, new ArrayList<Arbitraje>());
    }

    /**
     * Constructor parametrizado completo.
     *
     * @param nombre Nombre del árbitro
     * @param fecNacimiento Fecha de nacimiento del árbitro
     * @param aniosExperiencia Años de experiencia como árbitro
     * @param pais País al que representa el árbitro
     * @param arbitraje Lista de arbitrajes que realizó
     *
     */
    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais, ArrayList<Arbitraje> arbitraje) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitraje= arbitraje;
    }

    /**
     * Constructor parametrizado básico.
     * Inicializa un árbitro sin arbitrajes registrados (multiplicidad 0..*).
     *
     * @param nombre Nombre del árbitro
     * @param fecNacimiento Fecha de nacimiento del árbitro
     * @param aniosExperiencia Años de experiencia como árbitro
     * @param pais País al que representa el árbitro
     *
     */
    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais) {
        //sin ARBITRAJE por multiplicidad 0...*
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitraje = new ArrayList<Arbitraje>();
    }

    /**
     * Obtiene los años de experiencia del árbitro.
     *
     * @return años de experiencia
     */
    public int getAniosExperiencia() { return aniosExperiencia; }

    /**
     * Obtiene el país al que representa el árbitro.
     *
     * @return país del árbitro
     */
    public Pais getPais() { return pais; }

    /**
     * Obtiene la lista de arbitrajes realizados por el árbitro.
     *
     * @return lista de arbitrajes
     */
    public ArrayList<Arbitraje> getArbitraje() { return arbitraje; }

    /**
     * Establece los años de experiencia del árbitro.
     *
     * @param aniosExperiencia nuevos años de experiencia
     */
    public void setAniosExperiencia(int aniosExperiencia) { this.aniosExperiencia = aniosExperiencia; }

    /**
     * Establece el país del árbitro.
     *
     * @param pais nuevo país asociado
     */
    public void setPais(Pais pais) { this.pais = pais; }

    /**
     * Establece la lista completa de arbitrajes del árbitro.
     *
     * @param arbitraje nueva lista de arbitrajes
     */
    public void setArbitraje(ArrayList<Arbitraje> arbitraje) { this.arbitraje = arbitraje; }

    /**
     * Agrega un arbitraje a la lista del árbitro.
     *
     * @param a arbitraje a agregar
     */
    public void agregarArbitraje(Arbitraje a) { this.arbitraje.add(a); }
}

