package org.modelo.domain;

/**
 * Clase Arbitraje.
 * Clase agregada que surge de la asociación entre las clases Arbitro y Partido.
 * Representa el rol que cumple un árbitro determinado dentro de un partido específico.
 *
 * @author Rosatto Constanza, Rougier Valentina
 * @version 1.0
 */
public class Arbitraje {

    private CategoriaArbitro rol;
    private Arbitro arbitro;
    private Partido partido;

    /**
     * Constructor parametrizado de la clase Arbitraje.
     *
     * @param rol Categoría que cumple el árbitro en este partido
     * @param arbitro Árbitro asignado
     * @param partido Partido al que pertenece este arbitraje
     *
     */
    public Arbitraje(CategoriaArbitro rol, Arbitro arbitro, Partido partido) {
        this.rol = rol;
        this.arbitro= arbitro;
        this.partido = partido;
    }

    /**
     * Constructor por defecto de la clase Arbitraje.
     * Inicializa los atributos con valores predeterminados (null).
     *
     */
    Arbitraje() {
        this(null, null, null);
    }

    /**
     * Obtiene la categoría del árbitro en este partido.
     *
     * @return rol del árbitro
     */
    public CategoriaArbitro getRol() {return rol;}

    /**
     * Obtiene el árbitro asignado.
     *
     * @return árbitro de este arbitraje
     */
    public Arbitro getArbitro() {return arbitro;}

    /**
     * Obtiene el partido al que pertenece este arbitraje.
     *
     * @return partido asociado
     */
    public Partido getPartido() {return partido;}


    /**
     * Establece la categoría del árbitro.
     *
     * @param rol nuevo rol del árbitro
     */
    public void setRol(CategoriaArbitro rol) {this.rol = rol;}

    /**
     * Establece el árbitro asignado.
     *
     * @param arbitro nuevo árbitro
     */
    public void setArbitro(Arbitro arbitro) {this.arbitro = arbitro;}

    /**
     * Establece el partido asociado a este arbitraje.
     *
     * @param partido nuevo partido
     */
    public void setPartido(Partido partido) {
        this.partido = partido;
    }

}
