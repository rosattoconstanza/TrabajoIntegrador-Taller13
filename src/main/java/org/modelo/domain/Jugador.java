package org.modelo.domain;
import java.util.ArrayList;

/**
 * Clase Jugador.
 * Hereda de la clase Persona.
 * Está asociada con la clase Evento y con la clase Seleccion (Agregación).
 *
 * @author Rosatto Constanza, Rougier Valentina
 * @version 1.0
 */
public class Jugador extends Persona {

    private int dorsal;
    private  Posicion posicion;
    private float peso;
    private float altura;
    private ArrayList<Evento> eventos;

    /**
     * Constructor por defecto de la clase Jugador.
     * Inicializa los atributos con valores predeterminados.
     */
    public Jugador() {
        this("", 0, 0, null, 0, 0, new ArrayList<Evento>());
    }

    /**
     * Constructor parametrizado completo.
     *
     * @param nombre Nombre del jugador
     * @param fecNacimiento Fecha de nacimiento
     * @param dorsal Número de camiseta
     * @param posicion Posición en la que juega
     * @param peso Peso del jugador
     * @param altura Altura del jugador
     * @param eventos Lista de eventos en los que participó
     */
    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura, ArrayList<Evento> eventos) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos= eventos;
    }

    /**
     * Constructor parametrizado sin eventos (multiplicidad cero).
     *
     * @param nombre Nombre del jugador
     * @param fecNacimiento Fecha de nacimiento
     * @param dorsal Número de camiseta
     * @param posicion Posición en la que juega
     * @param peso Peso del jugador
     * @param altura Altura del jugador
     */
    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos = new ArrayList<>(); // ← esto no afecta el UML, lo cumple
    }

    /**
     * Obtiene el dorsal del jugador.
     *
     * @return número de dorsal
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     * Obtiene la posición del jugador.
     *
     * @return posición en la que juega
     */
    public Posicion getPosicion() {
        return posicion;
    }

    /**
     * Obtiene el peso del jugador.
     *
     * @return peso del jugador
     */
    public float getPeso() {
        return peso;
    }

    /**
     * Obtiene la altura del jugador.
     *
     * @return altura del jugador
     */
    public float getAltura() {
        return altura;
    }

    /**
     * Obtiene los eventos en los que participó el jugador.
     *
     * @return lista de eventos del jugador
     */
    public ArrayList<Evento> getEventos() {
        return eventos;
    }


    /**
     * Establece la altura del jugador.
     *
     * @param altura nueva altura
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * Establece el dorsal del jugador.
     *
     * @param dorsal nuevo dorsal
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * Establece el peso del jugador.
     *
     * @param peso nuevo peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * Establece la lista de eventos del jugador.
     *
     * @param eventos nueva lista de eventos
     */
    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    /**
     * Establece la posición del jugador.
     *
     * @param posicion nueva posición
     */
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }


    /**
     * Agrega un evento a la lista del jugador.
     *
     * @param e evento a agregar
     */
    public void agregarEvento(Evento e){
        this.eventos.add(e); //0 o mas eventos por Jugador
    }

}

