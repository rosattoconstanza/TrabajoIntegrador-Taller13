package org.modelo.domain;
import java.util.ArrayList;

public class Estadio {
    /**Clase Estadio.
     * Asociada con clase Sede y Partido.
     */
    private String nombre;
    private int capacidad;
    private Sede sede;
    private ArrayList<Partido> partidos;

    /** Constructor parametrizado */
    public Estadio(String nombre, int capacidad, Sede sede, ArrayList<Partido> partidos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos = partidos;
    }

    /** Constructor parametrizado (solo sedes)*/
    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos = new ArrayList<Partido>();
    }

    /** Constructor parametrizado basico */
    public Estadio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.partidos = new ArrayList<Partido>();
    }

    /** Constructor por defecto */
    public Estadio(){
        this("", 0, null, new ArrayList<Partido>());
    }

    /** Getters */
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Sede getSede() {
        return sede;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    /** Setters */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    /** Multiplicidad/Asociacion con Partido */
    public void agregarPartidos(Partido p){
        partidos.add(p); //1 o mas partidos por Estadio
    }

    /** toString() */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Capacidad: " + capacidad + ", Partidos: " + partidos;
    }
}