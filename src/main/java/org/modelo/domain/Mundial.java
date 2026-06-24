package org.modelo.domain;
import java.util.ArrayList;
/**
 * Clase Mundial.
 * Representa un Mundial de fútbol con sus datos generales y las sedes
 * donde se desarrollará la competencia.
 *
 * Presenta una agregación con la clase Sede.
 *
 * @author Rosatto Constanza, Rougier Valentina
 * @version 1.0
 */
public class Mundial {

    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private ArrayList<Sede> sedes; //En la clase componente (Sede) no hay referencia a la clase contenedora (Mundial)

    /**
     * Constructor por defecto.
     * Inicializa los atributos con valores predeterminados.
     *
     */

    public Mundial(){
        this(0, "", 0, 0, new ArrayList<Sede>());
    }

    /**
     * Constructor parametrizado completo.
     *
     * @param anio Año del Mundial
     * @param mascota Mascota oficial
     * @param fechaDesde Fecha de inicio
     * @param fechaHasta Fecha de finalización
     * @param sedes Lista de sedes del Mundial
     *
     */
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta, ArrayList<Sede> sedes) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = sedes;
    }
    /**
     * Constructor parametrizado básico.
     * Inicializa el Mundial sin sedes registradas.
     *
     * @param anio Año del Mundial
     * @param mascota Mascota oficial
     * @param fechaDesde Fecha de inicio
     * @param fechaHasta Fecha de finalización
     *
     */
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<Sede>();
    }

// --------------------------------------------------------------------
    /**
     * Obtiene el año del Mundial.
     *
     * @return año del Mundial
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Obtiene la mascota oficial del Mundial.
     *
     * @return mascota del Mundial
     */
    public String getMascota() {
        return mascota;
    }

    /**
     * Obtiene la fecha de inicio del Mundial.
     *
     * @return fecha de inicio
     */
    public int getFechaDesde() {
        return fechaDesde;
    }

    /**
     * Obtiene la fecha de finalización del Mundial.
     *
     * @return fecha de finalización
     */
    public int getFechaHasta() {
        return fechaHasta;
    }

    /**
     * Obtiene la lista de sedes registradas.
     *
     * @return lista de sedes
     */
    public ArrayList<Sede> getSedes() {
        return sedes;
    }

// --------------------------------------------------------------------
    /**
     * Establece la lista de sedes del Mundial.
     *
     * @param sedes nueva lista de sedes
     */
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    /**
     * Establece la fecha de finalización del Mundial.
     *
     * @param fechaHasta nueva fecha de finalización
     */
    public void setFechaHasta(int fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    /**
     * Establece la fecha de inicio del Mundial.
     *
     * @param fechaDesde nueva fecha de inicio
     */
    public void setFechaDesde(int fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    /**
     * Establece la mascota oficial del Mundial.
     *
     * @param mascota nueva mascota
     */
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    /**
     * Establece el año del Mundial.
     *
     * @param anio nuevo año del Mundial
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    // --------------------------------------------------------------------
    /**
     * Agrega una sede al Mundial.
     * Corresponde a la agregación entre Mundial y Sede.
     *
     * @param s sede a agregar
     */
    public void agregarSede(Sede s){
        this.sedes.add(s);
    }
}