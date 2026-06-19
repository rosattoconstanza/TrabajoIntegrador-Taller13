package org.modelo.domain;
import java.util.ArrayList;
/**
 * Clase Estadio.
 * Representa un estadio donde se disputan partidos del Mundial.
 *
 * Está asociada con las clases Sede y Partido.
 *
 * @author Rosatto Constanza, Rougier Valentina
 * @version 1.0
 */

public class Estadio {

    private String nombre;
    private int capacidad;
    private Sede sede;
    private ArrayList<Partido> partidos;

    /**
     * Constructor parametrizado completo.
     *
     * @param nombre Nombre del estadio
     * @param capacidad Capacidad máxima de espectadores
     * @param sede Sede a la que pertenece el estadio
     * @param partidos Lista de partidos disputados en el estadio
     *
     * @author Rougier Valentina
     * @version 1.0
     */
    public Estadio(String nombre, int capacidad, Sede sede, ArrayList<Partido> partidos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos = partidos;
    }

    /**
     * Constructor parametrizado.
     * Inicializa un estadio asociado a una sede y sin partidos registrados.
     *
     * @param nombre Nombre del estadio
     * @param capacidad Capacidad máxima de espectadores
     * @param sede Sede a la que pertenece el estadio
     *
     * @author Rougier Valentina
     * @version 1.0
     */
    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos = new ArrayList<Partido>();
    }

    /**
     * Constructor parametrizado básico.
     * Inicializa un estadio sin sede asociada y sin partidos registrados.
     *
     * @param nombre Nombre del estadio
     * @param capacidad Capacidad máxima de espectadores
     *
     * @author Rougier Valentina
     * @version 1.0
     */
    public Estadio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.partidos = new ArrayList<Partido>();
    }

    /**
     * Constructor por defecto.
     * Inicializa los atributos con valores predeterminados.
     *
     * @author Rosatto Constanza
     * @version 1.0
     */
    public Estadio(){
        this("", 0, null, new ArrayList<Partido>());
    }
//---------------------------------------------------------------------------------------------
    /**
     * Obtiene el nombre del estadio.
     *
     * @return nombre del estadio
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la capacidad del estadio.
     *
     * @return capacidad máxima de espectadores
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Obtiene la sede a la que pertenece el estadio.
     *
     * @return sede del estadio
     */
    public Sede getSede() {
        return sede;
    }

    /**
     * Obtiene los partidos disputados en el estadio.
     *
     * @return lista de partidos
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
//---------------------------------------------------------------------------------------------
    /**
     * Establece el nombre del estadio.
     *
     * @param nombre nuevo nombre del estadio
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la capacidad del estadio.
     *
     * @param capacidad nueva capacidad del estadio
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Establece la sede del estadio.
     *
     * @param sede nueva sede del estadio
     */
    public void setSede(Sede sede) {
        this.sede = sede;
    }

    /**
     * Establece la lista de partidos del estadio.
     *
     * @param partidos nueva lista de partidos
     */
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

//---------------------------------------------------------------------------------------------
    /**
     * Agrega un partido al estadio.
     *
     * @param p partido a agregar
     *
     * @author Rougier Valentina
     */
    public void agregarPartidos(Partido p){
        partidos.add(p); //1 o mas partidos por Estadio
    }

    /**
     * Devuelve una representación en texto del estadio.
     *
     * @return información del estadio
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Capacidad: " + capacidad + ", Partidos: " + partidos;
    }
}