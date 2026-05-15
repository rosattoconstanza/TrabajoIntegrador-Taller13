package modelo;
import java.util.ArrayList<>;

public class Jugador extends Persona {
    /** Clase Jugador hereda de Persona.
     * Asociada con clase Evento y clase Seleccion.
     */

    private int dorsal;
    private  Posicion posicion;
    private float peso;
    private float altura;
    private ArrayList<Evento> eventos;

    //Constructores
    Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos= new ArrayList<>();
    }
    Jugador() {

    }

    //Getters y Setters
    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }

    //Agregar Jugadores
    public void agregarEvento(Evento e){
        eventos.add(e); //0 o mas eventos por Jugador
    }
}

