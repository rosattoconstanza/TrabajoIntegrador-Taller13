package org.modelo.domain;
import java.util.ArrayList;

public class Arbitro extends Persona {
    /** Clase Arbitro hereda de Persona.
     * Asociada con clase Pais.
     * Asociada con Partido (creando Arbitraje).
     */

    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje> arbitraje;

    /** Constructores parametrizados y por defecto */
    public Arbitro() {
        this("", 0, 0, null, new ArrayList<Arbitraje>());
    }

    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais, ArrayList<Arbitraje> arbitraje) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitraje= arbitraje;
    }

    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais) {
        //sin ARBITRAJE por multiplicidad 0...*
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
    }


    /** Getters */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public Pais getPais() {
        return pais;
    }

    public ArrayList<Arbitraje> getArbitraje() {
        return arbitraje;
    }

    /** Setters */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setArbitraje(ArrayList<Arbitraje> arbitraje) {
        this.arbitraje = arbitraje;
    }

    /** Agregar Arbitraje (Asociacion) */
    public void agregarArbitraje(Arbitraje a) {
        this.arbitraje.add(a);
    }

    //ANTES DE HACER METODOS/INTERACTUAR CON "ARBITRAJE", VERIFICAR QUE NO ESTE VACIA LA LISTA
}

