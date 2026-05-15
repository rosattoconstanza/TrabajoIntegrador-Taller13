package modelo;


import java.util.ArrayList;

public class Arbitraje {

    private CategoriaArbitro rol;
    private ArrayList<Arbitro> arbitros;
    private ArrayList<Partido> partidos;

    public Arbitraje(CategoriaArbitro rol) {
        this.rol = rol;
        this.arbitros= new ArrayList<>();
        this.partidos = new ArrayList<>();
    }
    //Getters
    public CategoriaArbitro getRol() {return rol;}

    public ArrayList<Arbitro> getArbitros() {return arbitros;}

    public ArrayList<Partido> getPartidos() {return partidos;}

    //Setters

    public void setRol(CategoriaArbitro rol) {this.rol = rol;}

    public void agregarArbitros(Arbitro arbitros) {this.arbitros.add(arbitros);}

    public void agregarPartido(Partido partido) {
        this.partidos.add(partido);
    }

}
