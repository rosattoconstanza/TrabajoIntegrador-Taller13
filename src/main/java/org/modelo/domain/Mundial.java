package org.modelo.domain;
import java.util.ArrayList;

public class Mundial {
    /**Clase Mundial.
     * Asociada con clase Sede (Agregacion).
     */
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private ArrayList<Sede> sedes; //En la clase componente (Sede) no hay referencia a la clase contenedora (Mundial)

    /** Constructor por defecto */
    public Mundial(){
        this(0, "", 0, 0, new ArrayList<Sede>());
    }

    /** Constructor parametrizado */
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta, ArrayList<Sede> sedes) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = sedes;
    }


    /** Getters */
    public int getAnio() {
        return anio;
    }

    public String getMascota() {
        return mascota;
    }

    public int getFechaDesde() {
        return fechaDesde;
    }

    public int getFechaHasta() {
        return fechaHasta;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }


    /** Setters */
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    public void setFechaHasta(int fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setFechaDesde(int fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }


    /** Multiplicidades/Asosiciacion con Sede */
    public void agregarSede(Sede s){
        this.sedes.add(s); //1 o mas sedes por Mundial
    }
}