 package modelo;
import java.util.ArrayList;

public class Pais {
    /**Clase Pais.
     * Asociada con clase Sede, Seleccion y Arbitro.
     */

    private String nombre;
    private String bandera;
    private ArrayList<Sede> sedes = new ArrayList<>();
    private Seleccion seleccion;
    private ArrayList<Arbitro> arbitros = new ArrayList<>();

    /** Constructor parametrizado */
    Pais(String nombre, String bandera,Seleccion seleccion, ArrayList<Sede> sedes, ArrayList<Arbitro> arbitros) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = sedes;
        this.seleccion= seleccion;
        this.arbitros= arbitros;
    }

    /** Constructor parametrizado SIN SEDE, ARBITRO NI SELECCION (Multiplicidad 0...*) */
    Pais(String nombre, String bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
    }

    /** Constructor por defecto */
    Pais(){
    }

    /** Getters */
    public String getNombre() {
        return nombre;
    }

    public String getBandera() {
        return bandera;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    /** Setters */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }


    /** Multiplicidades/Asociacion con Sede y Arbitro */
    public void agregarSede(Sede s){
        this.sedes.add(s); //Ninguna o mas sedes por Pais
    }
    public void agregarArbitro(Arbitro arbitro){
        this.arbitros.add(arbitro); //Ninguno o mas arbitros por Pais
    }
}

//ANTES DE HACER METODOS/INTERACTUAR CON "SEDE", "ARBITRO" O "SELECCION", VERIFICAR QUE NO ESTE VACIA LA LISTA/SEA NULL