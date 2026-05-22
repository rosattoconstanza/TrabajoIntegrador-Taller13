package org.modelo.domain;

public class Participacion {
    /** Clase Agregada Participacion.
     * Surge de la asociacion de la clase Partido y la clase Seleccion.
     */

    private boolean esLocal;
    private Seleccion selecciones;
    private Partido partido;

    //Constructores
    public Participacion(){

    }

    public Participacion(boolean esLocal, Seleccion selecciones, Partido partido) {
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

    public Partido getPartido() {
        return partido;
    }

    public Seleccion getSelecciones(){
        return selecciones;
    }

    //Setter
    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public void setSelecciones(Seleccion selecciones) {
        this.selecciones = selecciones;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
