package modelo;
import java.util.ArrayList;

public class Fase {
    /**Clase Fase.
     * Asociada con clase Grupo y Partido.
     */
    private NombreFase nombre;
    private ArrayList<Grupo> grupos = new ArrayList<>();
    private ArrayList<Partido> partidos = new ArrayList<>();

    //Constructores
    Fase(){

    }

    Fase(NombreFase nombre, ArrayList<Partido> partidos) { //sin GRUPO al tener multiplicidad cero
        this.nombre = nombre;
        this.partidos = partidos;
    }

    Fase(NombreFase nombre, ArrayList<Grupo> grupos, ArrayList<Partido> partidos) {
        this.nombre = nombre;
        this.grupos = grupos;
        this.partidos = partidos;
    }


    //Getters
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public NombreFase getNombre() {
        return nombre;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }


    //Setters
    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }


    //Agregar Partidos y Grupos
    public void agregarPartidos(Partido p){
        this.partidos.add(p); //1 o mas partidos por Fase
    }

    public void agregarGrupos(Grupo g) {
        this.grupos.add(g); //Ninguno o mas grupos por Fase
    }

    //ANTES DE HACER METODOS/INTERACTUAR CON "GRUPO", VERIFICAR QUE NO ESTE VACIA LA LISTA
}