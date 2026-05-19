package modelo;
import java.util.ArrayList;

public class Participacion {
    /** Clase Agregada Participacion.
     * Surge de la asociacion de la clase Partido y la clase Seleccion.
     */

    private boolean esLocal;
    private Seleccion [] selecciones = new Seleccion [2];
    private ArrayList<Partido> partido = new ArrayList<>();

    //Constructores
    public Participacion(){

    }

    public Participacion(boolean esLocal, Seleccion[] selecciones, ArrayList<Partido> partido) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.selecciones = selecciones;
    }

    //Metodos propios de la clase (CORREGIR CUERPO!!)
    public int cantidadGoles(){
        return 1;
    }
    public int cantidadTarjAmarillas(){
        return 1;
    }
    public int cantidadTarjRojas(){
        return 1;
    }

    //Getters
    public boolean getEsLocal() {
        return esLocal;
    }

    public ArrayList<Partido> getPartido() {
        return partido;
    }

    public Seleccion[] getSeleccion(){
        return selecciones;
    }

    //Setter
    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }


    //Agregar Partido y dos selecciones.
    public void agregarSelecciones(Seleccion seleccion1, Seleccion seleccion2){
        selecciones[0] = seleccion1;
        selecciones[1] = seleccion2;
    }

    public void agregarPartido(Partido p) {
        this.partido.add(p);
    }
}
