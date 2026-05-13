import java.util.ArrayList;

public class Pais {
    private String nombre;
    private String bandera;
    private ArrayList<Sede> sedes;
    private Seleccion seleccion;
    private ArrayList<Arbitro> arbitros;

    /** Constructor parametrizado
     *
     */
    public Pais(String nombre, String bandera,Seleccion seleccion) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<>();
        this.seleccion= seleccion;
        this.arbitros= new ArrayList<>();
    }

    /** Constructor por defecto
     *
     */
    public Pais(){
    }

    /** Getters
     *
     */
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

    /** Setters
     *
     */
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

    /** Multiplicidades/Asosiciacion con Sede y Arbitro
     *
     */
    public void agregarSede(Sede sede){
        sedes.add(sede); //Ninguna o mas sedes por Pais
    }
    public void agregarArbitro(Arbitro arbitro){
        arbitros.add(arbitro); //Ninguno o mas arbitros por Pais
    }
}