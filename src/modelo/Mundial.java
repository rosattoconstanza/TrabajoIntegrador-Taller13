package modelo;

import java.util.ArrayList;

public class Mundial {
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private ArrayList<Sede> sedes; //En la clase componente (Sede) no hay referencia a la clase contenedora (Mundial)

    /**Constructor parametrizado
     *
     */
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<>();
    }

    /**Constructor por defecto
     *
     */
    public Mundial(){
    }

    /**Getters
     *
     */
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

    /**Setters
     *
     */
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


    /** Multiplicidades/Asosiciacion con Sede
     *
     */

    public void agregarSede(Sede sede){
        sedes.add(sede); //1 o mas sedes por Mundial
    }

}