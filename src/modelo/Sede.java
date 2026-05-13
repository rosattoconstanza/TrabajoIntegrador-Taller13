package modelo;
import java.util.ArrayList;

public class Sede {
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private ArrayList<Estadio> estadios;
    private Pais pais;

    /**Constructor parametrizado
     *
     */
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria,Pais pais) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.estadios= new ArrayList<>();
        this.pais=pais;
    }
    /**Constructor por defecto
     *
     */
    public Sede(){
    }

    /**Getters
     *
     */
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

    /**Setters
     *
     */

    public void agregarEstadio(Estadio estadio){
        estadios.add(estadio); //1 o mas Estadios por Sede
    }

}