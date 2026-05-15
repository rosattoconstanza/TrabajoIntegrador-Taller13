package modelo;
import java.util.ArrayList;

public class Participacion {

    private boolean esLocal;
    private Seleccion [] selecciones = new Seleccion [2];
    private ArrayList<Partido> partido = new ArrayList<>();

    public Participacion(){

    }

    public Participacion(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public int cantidadGoles(){
        return 1;
    }
    public int cantidadTarjAmarillas(){
        return 1;
    }
    public int cantidadTarjRojas(){
        return 1;
    }

    public void agregarSeleccion(Seleccion seleccion1, Seleccion seleccion2){
        selecciones[0] = seleccion1;
        selecciones[1] = seleccion2;

    }
    public Seleccion[] getSeleccion(){
        return selecciones;
    }

    public void agregarPartido(Partido partido) {
        this.partido.add(partido);
    }

    public ArrayList<Partido> getPartido() {
        return partido;
    }


}
