package org.modelo.domain;
import java.util.ArrayList;

/**
 * Clase Grupo.
 * Asociada con las clases Fase y Seleccion.
 * Representa un grupo de la fase de grupos del torneo.
 *
 * @author Rosatto Constanza, Rougier Valentina, Alegre Juan
 * @version 1.1
 */
public class  Grupo {

    private String identificacion;
    private String descripcion;
    private Fase fase;
    private ArrayList<Seleccion> seleccion;

    /**
     * Constructor por defecto de la clase Grupo.
     * Inicializa los atributos con valores predeterminados.
     */
    public Grupo() {
        this("", "", null, new ArrayList<Seleccion>());
    }

    /**
     * Constructor parametrizado completo.
     *
     * @param identificacion Identificación del grupo (ej: A, B, C)
     * @param descripcion Descripción del grupo
     * @param fase Fase a la que pertenece el grupo
     * @param seleccion Lista de selecciones que integran el grupo
     */
    public Grupo(String identificacion, String descripcion, Fase fase, ArrayList<Seleccion> seleccion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
        this.seleccion = seleccion;
    }

    /**
     * Obtiene la identificación del grupo.
     *
     * @return identificación del grupo
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Obtiene la descripción del grupo.
     *
     * @return descripción del grupo
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la fase a la que pertenece el grupo.
     *
     * @return fase del grupo
     */
    public Fase getFase() {
        return fase;
    }

    /**
     * Obtiene las selecciones que integran el grupo.
     *
     * @return lista de selecciones del grupo
     */
    public ArrayList<Seleccion> getSeleccion() {
        return seleccion;
    }

    /**
     * Establece la identificación del grupo.
     *
     * @param identificacion nueva identificación
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Establece la descripción del grupo.
     *
     * @param descripcion nueva descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece la fase del grupo.
     *
     * @param fase nueva fase asociada
     */
    public void setFase(Fase fase) {
        this.fase = fase;
    }

    /**
     * Establece la lista de selecciones del grupo.
     *
     * @param seleccion nueva lista de selecciones
     */
    public void setSeleccion(ArrayList<Seleccion> seleccion) {
        this.seleccion = seleccion;
    }

    /**
     * Agrega una selección al grupo.
     *
     * @param s selección a agregar
     */
    public void agregarSeleccion(Seleccion s) {
        this.seleccion.add(s);
    } //1 o mas selecciones

    /**
     * Calcula los puntos totales obtenidos por una selección en la fase de grupos.
     * Victoria = 3 puntos, Empate = 1 punto, Derrota = 0 puntos.
     * Solo se consideran los partidos correspondientes a la fase de este grupo.
     *
     * @param s Selección de la cual se calculan los puntos
     * @return puntos totales acumulados por la selección
     */
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
