package main.java.org.modelo.domain;

public class Arbitraje {
    /** Clase Agregada Arbitraje.
     * Surge de la asociación de la clase Arbitro y la clase Partido.
     */

    private CategoriaArbitro rol;
    private Arbitro arbitro;
    private Partido partido;

    //Constructores
    public Arbitraje(CategoriaArbitro rol, Arbitro arbitro, Partido partido) {
        this.rol = rol;
        this.arbitro= arbitro;
        this.partido = partido;
    }
    Arbitraje() {
        this(null, null, null);
    }


    //Getters
    public CategoriaArbitro getRol() {return rol;}

    public Arbitro getArbitro() {return arbitro;}

    public Partido getPartido() {return partido;}


    //Setters
    public void setRol(CategoriaArbitro rol) {this.rol = rol;}

    public void setArbitro(Arbitro arbitro) {this.arbitro = arbitro;}

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

}
