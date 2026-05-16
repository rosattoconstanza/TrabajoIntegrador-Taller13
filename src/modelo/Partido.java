package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Partido {
    /**Clase Partido.
     * Asociada con clase Estadio y Fase.
     * Composicion con Evento.
     * Asociada con Seleccion (creando Participacion) y Arbitro (creando Arbitraje).
     */
    private LocalDate fecha;
    private LocalTime horario;
    private int duracion;
    private int tiempoAdicional;
    private Estadio estadio;
    private Fase fase;
    private Participacion participacion;
    private ArrayList<Arbitraje> arbitraje;
    private ArrayList<Evento> eventos;

    //Constructores.
    public Partido() {

    }

    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional, Estadio estadio, Fase fase,
                   Participacion participacion,ArrayList<Arbitraje> arbitraje) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.estadio = estadio;
        this.fase = fase;
        this.participacion = participacion;
        this.eventos = new ArrayList<>();
        this.arbitraje = arbitraje;
    }

    //Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    public void setTiempoAdicional(int tiempoAdicional) {
        this.tiempoAdicional = tiempoAdicional;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void setParticipacion(Participacion participacion) {
        this.participacion = participacion;
    }

    public void setEventos(TipoEvento tipo, int min, Jugador jugador) {
        this.eventos.add(new Evento(tipo, min, jugador));
    }

    //Agregar Eventos y Arbitraje
    public void agregarEventos(TipoEvento tipo, int minuto, Jugador jugador){
        Evento evento = new Evento(tipo, minuto, jugador);
        eventos.add(evento);
    }

    public void agregarArbitraje(Arbitraje a) {
        this.arbitraje.add(a);
    }
}

