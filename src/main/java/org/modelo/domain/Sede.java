package org.modelo.domain;
import java.util.ArrayList;

/** Clase Sede.
 * Asociada con las clases Pais y Estadio.
 * Presenta una agregación con la clase Mundial.

 * @author Rosatto Constanza, Rougier Valentina
 * @version 1.0
 */

public class Sede {

    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private ArrayList<Estadio> estadios;
    private Pais pais;

/** Constructor básico de la clase Sede.
 * Inicializa una sede con sus datos principales.

 * @param ciudad Ciudad donde se encuentra la sede
 * @param alturaNivelMar Altura sobre el nivel del mar de la sede
 * @param clima Clima característico de la sede
 * @param zonaHoraria Zona horaria correspondiente a la sede
 * @author Rougier Valentina
 * @version 1.0
 */
  public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = null;
        this.estadios = new ArrayList<Estadio>();
    }

    /**
     * Constructor completo de la clase Sede.
     *
     * @param ciudad         Ciudad donde se encuentra la sede
     * @param alturaNivelMar Altura sobre el nivel del mar de la sede
     * @param clima          Clima característico de la sede
     * @param zonaHoraria    Zona horaria correspondiente a la sede
     * @param pais           País al que pertenece la sede
     * @param estadios       Lista de estadios asociados a la sede
     * @author Rougier Valentina
     * @version 1.0
     */
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais, ArrayList<Estadio> estadios) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.estadios = estadios;
        this.pais = pais;
    }

    /**
     * Constructor por defecto de la clase Sede.
     * Inicializa los atributos con valores predeterminados.
     *
     * @author Rosatto Constanza
     * @version 1.0
     */

    public Sede() {
        this("", 0, "", "", null, new ArrayList<Estadio>());
    }
//--------------------------------------------------------------------

    /**
     * Obtiene la ciudad de la sede.
     *
     * @return ciudad de la sede
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Obtiene la altura sobre el nivel del mar de la sede.
     *
     * @return altura de la sede
     */
    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }

    /**
     * Obtiene el clima de la sede.
     *
     * @return clima de la sede
     */
    public String getClima() {
        return clima;
    }

    /**
     * Obtiene la zona horaria de la sede.
     *
     * @return zona horaria de la sede
     */
    public String getZonaHoraria() {
        return zonaHoraria;
    }

    /**
     * Obtiene los estadios asociados a la sede.
     *
     * @return lista de estadios de la sede
     */
    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }

    /**
     * Obtiene el país al que pertenece la sede.
     *
     * @return país de la sede
     */
    public Pais getPais() {
        return pais;
    }

//--------------------------------------------------------------------

    /**
     * Agrega un estadio a la sede.
     *
     * @param e estadio que se incorpora a la sede
     * @author Rougier Valentina
     */
    public void agregarEstadio(Estadio e){
        this.estadios.add(e); //1 o mas Estadios por Sede
    }
//--------------------------------------------------------------------
    /**
     * Establece la ciudad de la sede.
     *
     * @param ciudad nueva ciudad de la sede
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Establece la altura sobre el nivel del mar de la sede.
     *
     * @param alturaNivelMar nueva altura de la sede
     */
    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    /**
     * Establece el clima de la sede.
     *
     * @param clima nuevo clima de la sede
     */
    public void setClima(String clima) {
        this.clima = clima;
    }

    /**
     * Establece la zona horaria de la sede.
     *
     * @param zonaHoraria nueva zona horaria de la sede
     */
    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    /**
     * Establece el país de la sede.
     *
     * @param pais nuevo país asociado a la sede
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    /**
     * Establece la lista de estadios de la sede.
     *
     * @param estadios nueva lista de estadios asociados a la sede
     */
    public void setEstadios(ArrayList<Estadio> estadios) {
        this.estadios = estadios;
    }
//--------------------------------------------------------------------
    /**
     * Devuelve una representación textual de la sede.
     *
     * @return cadena con los datos principales de la sede
     */
    @Override
    public String toString() {
        return "Ciudad: " + ciudad + ", Altura del Nivel Mar:" + alturaNivelMar + ", Clima: " + clima +
                ", Zona Horaria: " + zonaHoraria + ", Pais: " + pais;
    }
}