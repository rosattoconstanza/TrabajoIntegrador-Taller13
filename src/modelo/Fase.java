package modelo;
import java.util.ArrayList;

public class Fase {
    private NombreFase nombre;
    private ArrayList<Grupo> grupos = new ArrayList<>();
    private ArrayList<Partido> partidos = new ArrayList<>();

    public Fase(){

    }

    public Fase(NombreFase nombre) {
        this.nombre = nombre;
    }


    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public NombreFase getNombre() {
        return nombre;
    }

    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Grupo grupo) {
        this.grupos.add(grupo);
    }

    public void agregarPartidos(Partido partido){
        partidos.add(partido); //1 o mas partidos por Fase
    }

}
