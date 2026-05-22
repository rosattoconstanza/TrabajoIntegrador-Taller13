package main.java.org.modelo.domain;
import java.util.ArrayList;

public class Grupo {
    /**Clase Grupo.
     * Asociada con clase Fase y Selección.
     */
    private String identificacion;
    private String descripcion;
    private Fase fase;
    private ArrayList<Seleccion> seleccion;

    //Constructores
    public Grupo(){
        this("", "", null, new ArrayList<Seleccion>());

    }

    public Grupo(String identificacion, String descripcion, Fase fase, ArrayList<Seleccion> seleccion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
        this.seleccion = seleccion;
    }

    //Getters
    public String getIdentificacion() {
        return identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Fase getFase() {
        return fase;
    }

    public ArrayList<Seleccion> getSeleccion() {
        return seleccion;
    }

    //Setters
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void setSeleccion(ArrayList<Seleccion> seleccion) {
        this.seleccion = seleccion;
    }

    //Agregar Selecciones
    public void agregarSeleccion(Seleccion s) {
        this.seleccion.add(s);
    } //1 o mas selecciones

    //Metodos (CORREGIR CUERPO!!)
    public int obtenerPuntos(Seleccion s){
        return 1;
    }

}
