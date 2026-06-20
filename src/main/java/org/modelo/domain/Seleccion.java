package org.modelo.domain;
import java.util.ArrayList;

/**
 * Clase Seleccion.
 * Asociada con las clases Grupo y Pais.
 * Asociada con las clases Jugador, DirectorTecnico y CuerpoTecnico (Agregación).
 * Asociada con la clase Partido (mediante Participación).
 *
 * @author Rosatto Constanza, Rougier Valentina, Alegre Juan
 * @version 1.1
 */
public class Seleccion {

    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;
    private ArrayList<Participacion> participacion;
    private Grupo grupo;
    private Pais pais;
    private ArrayList<Jugador> jugadores;
    private ArrayList<DirectorTecnico> directoresTecnicos;
    private ArrayList<CuerpoTecnico> cuerposTecnicos;


    /**
     * Constructor parametrizado completo.
     *
     * @param nombreFederacion Nombre de la federación
     * @param camisetaPrincipal Color/diseño de la camiseta principal
     * @param camisetaSecundaria Color/diseño de la camiseta secundaria
     * @param cabezaGrupo Indica si es cabeza de grupo
     * @param rankingFIFA Posición en el ranking FIFA
     * @param participacion Lista de participaciones en partidos
     * @param grupo Grupo al que pertenece
     * @param pais País al que representa
     * @param directoresTecnicos Lista de directores técnicos
     * @param cuerposTecnicos Lista del cuerpo técnico
     * @param jugadores Lista de jugadores
     */
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
                     int rankingFIFA, ArrayList<Participacion> participacion, Grupo grupo, Pais pais, ArrayList<DirectorTecnico> directoresTecnicos,
                     ArrayList<CuerpoTecnico> cuerposTecnicos, ArrayList<Jugador> jugadores) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.participacion = participacion;
        this.grupo = grupo;
        this.pais = pais;
        this.directoresTecnicos = directoresTecnicos;
        this.cuerposTecnicos = cuerposTecnicos;
        this.jugadores = jugadores;
    }

    /**
     * Constructor parametrizado básico, sin listas asociadas.
     *
     * @param nombreFederacion Nombre de la federación
     * @param camisetaPrincipal Color/diseño de la camiseta principal
     * @param camisetaSecundaria Color/diseño de la camiseta secundaria
     * @param cabezaGrupo Indica si es cabeza de grupo
     * @param rankingFIFA Posición en el ranking FIFA
     */
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria,
                     boolean cabezaGrupo, int rankingFIFA) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;

        this.participacion = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
        this.jugadores = new ArrayList<>();
    }

    /**
     * Constructor por defecto de la clase Seleccion.
     * Inicializa los atributos con valores predeterminados.
     */
    public Seleccion() {
        this("", "", "", false, 0, new ArrayList<Participacion>(), null, null, new ArrayList<DirectorTecnico>(),
                new ArrayList<CuerpoTecnico>(), new ArrayList<Jugador>());
    }

    /**
     * Constructor parametrizado con país, sin grupo asociado todavía.
     *
     * @param nombreFederacion Nombre de la federación
     * @param camisetaPrincipal Color/diseño de la camiseta principal
     * @param camisetaSecundaria Color/diseño de la camiseta secundaria
     * @param cabezaGrupo Indica si es cabeza de grupo
     * @param rankingFIFA Posición en el ranking FIFA
     * @param pais País al que representa la selección
     */
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
                     int rankingFIFA, Pais pais) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.pais = pais;
        this.participacion = new ArrayList<Participacion>();
        this.directoresTecnicos = new ArrayList<DirectorTecnico>();
        this.cuerposTecnicos = new ArrayList<CuerpoTecnico>();
        this.jugadores = new ArrayList<Jugador>();
    }

    /**
     * Obtiene el nombre de la federación.
     *
     * @return nombre de la federación
     */
    public String getNombreFederacion() {
        return nombreFederacion;
    }

    /**
     * Obtiene la camiseta principal de la selección.
     *
     * @return camiseta principal
     */
    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    /**
     * Obtiene la camiseta secundaria de la selección.
     *
     * @return camiseta secundaria
     */
    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }

    /**
     * Indica si la selección es cabeza de grupo.
     *
     * @return true si es cabeza de grupo
     */
    public boolean getCabezaGrupo() {
        return cabezaGrupo;
    }

    /**
     * Obtiene el ranking FIFA de la selección.
     *
     * @return ranking FIFA
     */
    public int getRankingFIFA() {
        return rankingFIFA;
    }

    /**
     * Obtiene las participaciones de la selección en los partidos.
     *
     * @return lista de participaciones
     */
    public ArrayList<Participacion> getParticipacion() {
        return participacion;
    }

    /**
     * Obtiene el país al que representa la selección.
     *
     * @return país de la selección
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * Obtiene los directores técnicos de la selección.
     *
     * @return lista de directores técnicos
     */
    public ArrayList<DirectorTecnico> getDirectoresTecnicos() {
        return directoresTecnicos;
    }

    /**
     * Obtiene el cuerpo técnico de la selección.
     *
     * @return lista del cuerpo técnico
     */
    public ArrayList<CuerpoTecnico> getCuerposTecnicos() {
        return cuerposTecnicos;
    }

    /**
     * Obtiene el grupo al que pertenece la selección.
     *
     * @return grupo de la selección
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * Obtiene los jugadores de la selección.
     *
     * @return lista de jugadores
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Establece el ranking FIFA de la selección.
     *
     * @param rankingFIFA nuevo ranking FIFA
     */
    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    /**
     * Establece la lista de participaciones de la selección.
     *
     * @param participacion nueva lista de participaciones
     */
    public void setParticipacion(ArrayList<Participacion> participacion) {
        this.participacion = participacion;
    }

    /**
     * Establece el grupo de la selección.
     *
     * @param grupo nuevo grupo asociado
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * Establece el país de la selección.
     *
     * @param pais nuevo país asociado
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }

    /**
     * Establece la lista de jugadores de la selección.
     *
     * @param jugadores nueva lista de jugadores
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * Establece la lista de directores técnicos de la selección.
     *
     * @param directoresTecnicos nueva lista de directores técnicos
     */
    public void setDirectoresTecnicos(ArrayList<DirectorTecnico> directoresTecnicos) {
        this.directoresTecnicos = directoresTecnicos;
    }

    /**
     * Establece la lista del cuerpo técnico de la selección.
     *
     * @param cuerposTecnicos nueva lista del cuerpo técnico
     */
    public void setCuerposTecnicos(ArrayList<CuerpoTecnico> cuerposTecnicos) {
        this.cuerposTecnicos = cuerposTecnicos;
    }

    /**
     * Establece el nombre de la federación.
     *
     * @param nombreFederacion nuevo nombre de la federación
     */
    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    /**
     * Establece la camiseta principal de la selección.
     *
     * @param camisetaPrincipal nueva camiseta principal
     */
    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    /**
     * Establece la camiseta secundaria de la selección.
     *
     * @param camisetaSecundaria nueva camiseta secundaria
     */
    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    /**
     * Establece si la selección es cabeza de grupo.
     *
     * @param cabezaGrupo nuevo valor de cabeza de grupo
     */
    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }


    /**
     * Agrega un director técnico a la selección.
     *
     * @param directorTecnico director técnico a agregar
     */
    public void agregarDirectorTecnico(DirectorTecnico directorTecnico) {
        this.directoresTecnicos.add(directorTecnico);
    }

    /**
     * Agrega un integrante del cuerpo técnico a la selección.
     *
     * @param cuerpoTecnico integrante a agregar
     */
    public void agregarCuerpoTecnico(CuerpoTecnico cuerpoTecnico) {
        this.cuerposTecnicos.add(cuerpoTecnico);
    }

    /**
     * Agrega un jugador a la selección.
     *
     * @param j jugador a agregar
     */
    public void agregarJugador(Jugador j) {
        this.jugadores.add(j);
    }
}