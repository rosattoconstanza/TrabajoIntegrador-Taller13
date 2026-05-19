package modelo;
import java.util.ArrayList;

public class Grupo {
    /**Clase Grupo.
     * Asociada con clase Fase y Selección.
     */
    private String identificacion;
    private String descripcion;
    private Fase fase;
    private ArrayList<Seleccion> seleccion = new ArrayList<>();

    //Constructores
    public Grupo(){

    }

    public Grupo(String identificacion, String descripcion, Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
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

    //Agregar Selecciones
    public void agregarSeleccion(Seleccion seleccion) {
        this.seleccion.add(seleccion);
    } //1 o mas selecciones

    //Metodos (CORREGIR CUERPO!!)
    public int obtenerPuntos(Seleccion s){
        return 1;
    }

}
