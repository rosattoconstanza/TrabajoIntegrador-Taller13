package org.modelo.domain;
import java.util.ArrayList;
/**
 * Clase Pais.
 * Representa un país participante del Mundial.
 *
 * Está asociada con las clases Sede, Seleccion y Arbitro.
 *
 * @author Rosatto Constanza, Rougier Valentina
 * @version 1.0
 */
public class Pais {

    private String nombre;
    private String bandera;
    private ArrayList<Sede> sedes;
    private Seleccion seleccion;
    private ArrayList<Arbitro> arbitros;

    /**
     * Constructor por defecto.
     * Inicializa los atributos con valores predeterminados.
     *
     * @author Rosatto Constanza
     * @version 1.0
     */
    public Pais(){
        this("", "", null, new ArrayList<Sede>(), new ArrayList<Arbitro>());
    }

    /**
     * Constructor parametrizado completo.
     *
     * @param nombre Nombre del país
     * @param bandera Bandera representativa del país
     * @param seleccion Selección nacional del país
     * @param sedes Lista de sedes pertenecientes al país
     * @param arbitros Lista de árbitros pertenecientes al país
     *
     * @author Rougier Valentina
     * @version 1.0
     */
    public Pais(String nombre, String bandera,Seleccion seleccion, ArrayList<Sede> sedes, ArrayList<Arbitro> arbitros) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = sedes;
        this.seleccion= seleccion;
        this.arbitros= arbitros;
    }
    /**
     * Constructor parametrizado básico.
     * Inicializa un país sin sedes, árbitros ni selección asociada.
     *
     * @param nombre Nombre del país
     * @param bandera Bandera representativa del país
     *
     * @author Rougier Valentina
     * @version 1.0
     */
    public Pais(String nombre, String bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
        this.seleccion = null;
    }
//--------------------------------------------------------------------------------------------
    /**
     * Obtiene el nombre del país.
     *
     * @return nombre del país
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la bandera representativa del país.
     *
     * @return bandera del país
     */
    public String getBandera() {
        return bandera;
    }

    /**
     * Obtiene las sedes asociadas al país.
     *
     * @return lista de sedes
     */
    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    /**
     * Obtiene la selección nacional del país.
     *
     * @return selección del país
     */
    public Seleccion getSeleccion() {
        return seleccion;
    }

    /**
     * Obtiene los árbitros pertenecientes al país.
     *
     * @return lista de árbitros
     */
    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

//--------------------------------------------------------------------------------------------
    /**
     * Establece el nombre del país.
     *
     * @param nombre nuevo nombre del país
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la bandera del país.
     *
     * @param bandera nueva bandera del país
     */
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    /**
     * Establece las sedes asociadas al país.
     *
     * @param sedes nueva lista de sedes
     */
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    /**
     * Establece la selección nacional del país.
     *
     * @param seleccion nueva selección del país
     */
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    /**
     * Establece la lista de árbitros del país.
     *
     * @param arbitros nueva lista de árbitros
     */
    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

//--------------------------------------------------------------------------------------------
    /**
     * Agrega una sede al país.
     *
     * @param s sede a agregar
     *
     * @author Rougier Valentina
     */
    public void agregarSede(Sede s){
        this.sedes.add(s); //Ninguna o mas sedes por Pais
    }

    /**
     * Agrega una arbitro al país.
     *
     * @param arbitro - arbitro a agregar
     *
     * @author Rougier Valentina
     */
    public void agregarArbitro(Arbitro arbitro){
        this.arbitros.add(arbitro); //Ninguno o mas arbitros por Pais
    }

    /**
     * Devuelve una representación en texto del país.
     *
     * @return nombre y bandera del país
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Bandera: " + bandera;
    }
}

//ANTES DE HACER METODOS/INTERACTUAR CON "SEDE", "ARBITRO" O "SELECCION", VERIFICAR QUE NO ESTE VACIA LA LISTA/SEA NULL