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

    public Grupo(){

    }

    public Grupo(String identificacion, String descripcion, Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int obtenerPuntos(Seleccion s){
        return 1; // Ver mas adelante
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void agregarSeleccion(Seleccion seleccion) {
        this.seleccion.add(seleccion);
    } //1 o mas selecciones

    public ArrayList<Seleccion> getSeleccion() {
        return seleccion;
    }

}
