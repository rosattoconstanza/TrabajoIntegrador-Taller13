package modelo;
import java.util.ArrayList;

public class Seleccion {
    /**Clase Seleccion.
     * Asociada con clase Grupo, Pais, Jugador, Director Tecnico y Cuerpo Tecnico.
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


    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
                     int rankingFIFA, Participacion participacion, Grupo grupo, Pais pais) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.participacion = participacion;
        this.grupo = grupo;
        this.pais = pais;
    }


    public Seleccion() {

    }

    public String getNombreFederacion() {
        return nombreFederacion;
    }

    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }

    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    public boolean isCabezaGrupo() {
        return cabezaGrupo;
    }

    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

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


    public void setDirectoresTecnicos(DirectorTecnico directorTecnico) {
        this.directoresTecnicos.add(directorTecnico);
    }


    public void setCuerposTecnicos(CuerpoTecnico cuerposTecnico) {
        this.cuerposTecnicos.add(cuerposTecnico);
    }


}


