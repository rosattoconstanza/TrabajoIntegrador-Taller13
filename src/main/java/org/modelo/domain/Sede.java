package org.modelo.domain;
import java.util.ArrayList;

public class Sede {
    /**Clase Sede.
     * Asociada con clase Pais, Estadio y agregación con Mundial.
     */
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private ArrayList<Estadio> estadios = new ArrayList<>();
    private Pais pais;

    /** Constructor parametrizado */
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria,Pais pais, ArrayList<Estadio> estadios) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.estadios = estadios;
        this.pais = pais;
    }

    /** Constructor por defecto */
    public Sede(){
    }

    /** Getters */
    public String getCiudad() {
        return ciudad;
    }

    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public String getClima() {
        return clima;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }

    public Pais getPais() {
        return pais;
    }


    /** Multiplicidad/Asociacion con Estadio */
    public void agregarEstadio(Estadio e){
        this.estadios.add(e); //1 o mas Estadios por Sede
    }

    /** Setters */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setEstadios(ArrayList<Estadio> estadios) {
        this.estadios = estadios;
    }
}