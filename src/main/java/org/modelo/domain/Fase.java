package org.modelo.domain;
import java.util.ArrayList;

/**
 * Clase Fase.
 * Asociada con las clases Grupo y Partido.
 * Representa una etapa del torneo (Grupos, Octavos, Cuartos, etc.).
 *
 * @author Rosatto Constanza, Rougier Valentina, Alegre Juan
 * @version 1.1
 */
public class Fase {

    private NombreFase nombre;
    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;

    /**
     * Constructor parametrizado básico.
     * Inicializa una fase sin partidos ni grupos registrados.
     *
     * @param nombre Nombre de la fase según el enum NombreFase
     */
    public Fase(NombreFase nombre){
        this(nombre, new ArrayList<Partido>(), new ArrayList<Grupo>());
    }

    /**
     * Constructor parametrizado sin grupos (multiplicidad cero para Grupo en fases eliminatorias).
     *
     * @param nombre   Nombre de la fase
     * @param partidos Lista de partidos de esta fase
     */
    public Fase(NombreFase nombre, ArrayList<Partido> partidos) { //sin GRUPO al tener multiplicidad cero
        this.nombre = nombre;
        this.partidos = partidos;
    }

    /**
     * Constructor parametrizado completo.
     *
     * @param nombre   Nombre de la fase
     * @param partidos Lista de partidos de esta fase
     * @param grupos   Lista de grupos de esta fase (solo aplica si es Fase de Grupos)
     */
    public Fase(NombreFase nombre, ArrayList<Partido> partidos, ArrayList<Grupo> grupos) {
        this.nombre = nombre;
        this.grupos = grupos;
        this.partidos = partidos;
    }


    /**
     * Obtiene los partidos correspondientes a esta fase.
     *
     * @return lista de partidos
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    /**
     * Obtiene el nombre de la fase.
     *
     * @return nombre de la fase
     */
    public NombreFase getNombre() {
        return nombre;
    }

    /**
     * Obtiene los grupos correspondientes a esta fase.
     *
     * @return lista de grupos
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }


    /**
     * Establece la lista de grupos de la fase.
     *
     * @param grupos nueva lista de grupos
     */
    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    /**
     * Establece el nombre de la fase.
     *
     * @param nombre nuevo nombre de la fase
     */
    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la lista de partidos de la fase.
     *
     * @param partidos nueva lista de partidos
     */
    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }


    /**
     * Agrega un partido a la fase.
     *
     * @param p partido a agregar
     */
    public void agregarPartidos(Partido p){
        this.partidos.add(p); //1 o mas partidos por Fase
    }

    /**
     * Agrega un grupo a la fase.
     *
     * @param g grupo a agregar
     */
    public void agregarGrupos(Grupo g) {
        this.grupos.add(g); //Ninguno o mas grupos por Fase
    }


    //ANTES DE HACER METODOS/INTERACTUAR CON "GRUPO", VERIFICAR QUE NO ESTE VACIA LA LISTA
}