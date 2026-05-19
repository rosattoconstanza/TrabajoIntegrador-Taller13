package modelo;
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
    private ArrayList<Evento> eventos = new ArrayList<>();

    //Constructores
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
    Jugador() {

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

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    //Agregar Jugadores
    public void agregarEvento(Evento e){
        this.eventos.add(e); //0 o mas eventos por Jugador
    }

    //ANTES DE HACER METODOS/INTERACTUAR CON "EVENTO", VERIFICAR QUE NO ESTE VACIA LA LISTA

}

