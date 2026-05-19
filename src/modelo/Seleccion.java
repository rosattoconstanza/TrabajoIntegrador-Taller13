package modelo;
import java.util.ArrayList;

public class Seleccion {
    /**Clase Seleccion.
     * Asociada con clase Grupo, Pais.
     * Asociada con clase Jugador, Director Tecnico y Cuerpo Tecnico (Agregacion).
     * Asociada con clase Partido (Creando Participacion).
     */

    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;
    private Participacion participacion;
    private Grupo grupo;
    private Pais pais;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<DirectorTecnico> directoresTecnicos = new ArrayList<>();
    private ArrayList<CuerpoTecnico> cuerposTecnicos = new ArrayList<>();


    //Constructores
    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
                     int rankingFIFA, Participacion participacion, Grupo grupo, Pais pais, ArrayList<DirectorTecnico> directoresTecnicos,
                     ArrayList<CuerpoTecnico> cuerposTecnicos) {
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
    }

    public Seleccion() {

    }

    //Getters
    public String getNombreFederacion() {
        return nombreFederacion;
    }

    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }

    public boolean getCabezaGrupo() {
        return cabezaGrupo;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

    public Participacion getParticipacion() {
        return participacion;
    }

    public Pais getPais() {
        return pais;
    }

    public ArrayList<DirectorTecnico> getDirectoresTecnicos() {
        return directoresTecnicos;
    }

    public ArrayList<CuerpoTecnico> getCuerposTecnicos() {
        return cuerposTecnicos;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    //Setters
    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    public void setParticipacion(Participacion participacion) {
        this.participacion = participacion;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setJugadores(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void setDirectoresTecnicos(ArrayList<DirectorTecnico> directoresTecnicos) {
        this.directoresTecnicos = directoresTecnicos;
    }

    public void setCuerposTecnicos(ArrayList<CuerpoTecnico> cuerposTecnicos) {
        this.cuerposTecnicos = cuerposTecnicos;
    }

    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }


    //Agregar Director Tecnico, Cuerpo Tecnico
    public void agregarDirectorTecnico(DirectorTecnico directorTecnico) {
        this.directoresTecnicos.add(directorTecnico);
    }

    public void agregarCuerpoTecnico(CuerpoTecnico cuerpoTecnico) {
        this.cuerposTecnicos.add(cuerpoTecnico);
    }
}


