package org.modelo.domain;
import java.util.ArrayList;

public class  Grupo {
    /**Clase Grupo.
     * Asociada con clase Fase y Selección.
     */
    private String identificacion;
    private String descripcion;
    private Fase fase;
    private ArrayList<Seleccion> seleccion;

    /** Constructores parametrizado y por defecto */
    public Grupo(){
        this("", "", null, new ArrayList<Seleccion>());
    }

    public Grupo(String identificacion, String descripcion, Fase fase, ArrayList<Seleccion> seleccion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
        this.seleccion = seleccion;
    }

    /** Getters */
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

    /** Setters */
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

    /** Agregar Selecciones (Asociacion) */
    public void agregarSeleccion(Seleccion s) {
        this.seleccion.add(s);
    } //1 o mas selecciones

    /** Metodos de la clase */
    public int obtenerPuntos(Seleccion s) {
        int totalPuntos = 0;

        for (Participacion miParticipacion : s.getParticipacion()) {

            Partido partido = miParticipacion.getPartido();

            if (partido.getFase() == null ||
                    !partido.getFase().getNombre().equals(this.fase.getNombre())) {
                continue; // salta partidos que no son de esta fase
            }  //Solo los partidos que pasen este filtro llegan al cálculo de goles y puntos.

            Participacion[] participacionesDelPartido = partido.getParticipacion();
            Participacion p1 = participacionesDelPartido[0];
            Participacion p2 = participacionesDelPartido[1];


            Participacion rivalParticipacion;
            if (p1.equals(miParticipacion)) {
                rivalParticipacion = p2;
            } else {
                rivalParticipacion = p1;
            }


            if (miParticipacion.cantidadGoles() > rivalParticipacion.cantidadGoles()) {
                totalPuntos += 3;
            } else if (miParticipacion.cantidadGoles() == rivalParticipacion.cantidadGoles()) {
                totalPuntos += 1;
            }
        }

        return totalPuntos;
    }
}
