package org.modelo.domain;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Partido {
    /** Clase Partido.
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
    private Participacion participacion[];
    private ArrayList<Arbitraje> arbitraje;
    private ArrayList<Evento> eventos;

    /** Constructores parametrizado y por defecto */
    public Partido() {
        this(null, null, 0, 0, null, null,
                new Participacion[2], new ArrayList<>());
        this.eventos = new ArrayList<Evento>();
    }

    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional, Estadio estadio, Fase fase,
                   Participacion [] participacion,ArrayList<Arbitraje> arbitraje) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.estadio = estadio;
        this.fase = fase;
        this.participacion = participacion;
        this.arbitraje = arbitraje;
        this.eventos = new ArrayList<Evento>(); //Composicion!
    }


    /** Getters */
    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public Fase getFase() {
        return fase;
    }

    public ArrayList<Evento> getEventos() { //Puede ser nulo.
        if (eventos == null) {
            eventos = new ArrayList<>();
        }
        return eventos;
    }

    public Participacion[] getParticipacion() {
        return participacion;
    }

    public ArrayList<Arbitraje> getArbitraje() {
        return arbitraje;
    }


    /** Setters */ //(No de evento porque es una composicion)
    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void setParticipacion(Participacion[] participacion) {
        this.participacion = participacion;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public void setTiempoAdicional(int tiempoAdicional) {
        this.tiempoAdicional = tiempoAdicional;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public void setArbitraje(ArrayList<Arbitraje> arbitraje) {
        this.arbitraje = arbitraje;
    }


    /** Agregar Eventos y Arbitraje (Asociaciones) */
    public void agregarEventos(TipoEvento tipo, int minuto, Jugador jugador){
        Evento evento = new Evento(tipo, minuto, jugador); //Composicion = el objeto se crea dentro
        eventos.add(evento);
    }

    public void agregarArbitraje(Arbitraje a) {
        this.arbitraje.add(a);
    }
}

