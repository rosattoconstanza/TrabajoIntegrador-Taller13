package main.java.org.modelo.domain;
import java.util.ArrayList;

public class Jugador extends Persona {
    /** Clase Jugador hereda de Persona.
     * Asociada con clase Evento.
     * Asociada con clase Seleccion (Agregaion).
     */

    private int dorsal;
    private  Posicion posicion;
    private float peso;
    private float altura;
    private ArrayList<Evento> eventos;

    //Constructores
    Jugador() {
        this("", 0, 0, null, 0, 0, new ArrayList<Evento>());
    }

    Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura, ArrayList<Evento> eventos) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos= eventos;
    }

    Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        //sin EVENTO al ser multiplicidad cero
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
    }


    //Getters
    public int getDorsal() {
        return dorsal;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }


    //Setters
    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }


    //Agregar Evento
    public void agregarEvento(Evento e){
        this.eventos.add(e); //0 o mas eventos por Jugador
    }


    //ANTES DE HACER METODOS/INTERACTUAR CON "EVENTO", VERIFICAR QUE NO ESTE VACIA LA LISTA
}

