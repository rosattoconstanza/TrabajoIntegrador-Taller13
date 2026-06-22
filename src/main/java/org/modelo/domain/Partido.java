package org.modelo.domain;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/** Clase Partido.
 * Asociada con clase Estadio y Fase.
 * Presenta una composición con clase Evento.
 * Asociada con Seleccion (mediante Participación) y Árbitro (mediante Arbitraje).
 *
 * @author Rosatto Constanza, Rougier Valentina
 * @version 1.0
 */
public class Partido {
    private LocalDate fecha;
    private LocalTime horario;
    private int duracion;
    private int tiempoAdicional;
    private Estadio estadio;
    private Fase fase;
    private Participacion participacion[];
    private ArrayList<Arbitraje> arbitraje;
    private ArrayList<Evento> eventos;



    /**
     * Constructor por defecto de la clase Partido.
     * Inicializa los atributos con valores predeterminados.
     *
     * @author Rosatto Constanza
     * @version 1.0
     */
    public Partido() {
        this(null, null, 0, 0, null, null,
                new Participacion[2], new ArrayList<>());
        this.eventos = new ArrayList<Evento>();
    }

    /**
     * Constructor que inicializa los atributos de la clase Partido con los valores proporcionados.
     *
     * @param fecha Fecha del partido
     * @param horario Horario de comienzo del partido
     * @param duracion Duración del partido en minutos
     * @param tiempoAdicional Tiempo agregado en el partido en minutos
     * @param estadio Estadio en el que se juega el partido
     * @param fase Fase correspondiente del partido
     * @param participacion Arreglo de participaciones de las selecciones en el partido
     * @param arbitraje Lista de árbitros asignados al partido
     *
     * @author Rougier Valentina
     * @version 1.1
     */
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

    //-------------------------------------------------------------------------------------

    /**
     * Obtiene la fecha del partido.
     *
     * @return fecha del partido
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Obtiene el horario del partido.
     *
     * @return horario del partido
     */
    public LocalTime getHorario() {
        return horario;
    }

    /**
     * Obtiene la duracion del partido.
     *
     * @return duracion del partido
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Obtiene el tiempo adicional del partido.
     *
     * @return tiempo adicional del partido
     */
    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    /**
     * Obtiene el estadio en el que se juega el partido.
     *
     * @return estadio del partido
     */
    public Estadio getEstadio() {
        return estadio;
    }

    /**
     * Obtiene la fase correspondiente del partido.
     *
     * @return fase del partido
     */
    public Fase getFase() {
        return fase;
    }

    /**
     * Obtiene los eventos ocurridos en el partido.
     *
     * @return lista de eventos ocurridos en el partido
     */
    public ArrayList<Evento> getEventos() { //Puede estar vacia (No tiene Setter porque es una composicion)
        return eventos;
    }

    /**
     * Obtiene las selecciones que participan en el partido.
     *
     * @return arreglo de dos posiciones con las selecciones participantes del partido
     */
    public Participacion[] getParticipacion() {
        return participacion;
    }

    /**
     * Obtiene el equipo de arbitraje del partido.
     *
     * @return lista de arbitros con sus roles correspondientes al partido
     */
    public ArrayList<Arbitraje> getArbitraje() {
        return arbitraje;
    }

    //----------------------------------------------------------------------------

    /**
     * Establece la fase del partido.
     *
     * @param fase Nueva fase del partido
     */
    public void setFase(Fase fase) {
        this.fase = fase;
    }

    /**
     * Establece las selecciones que participan del partido.
     *
     * @param participacion Nuevas selecciones participantes del partido
     */
    public void setParticipacion(Participacion[] participacion) {
        this.participacion = participacion;
    }

    /**
     * Establece el estadio del partido.
     *
     * @param estadio Nuevo estadio en el que se realiza el partido
     */
    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    /**
     * Establece el tiempo adicional del partido.
     *
     * @param tiempoAdicional Nuevo tiempo adicional del partido
     */
    public void setTiempoAdicional(int tiempoAdicional) {
        this.tiempoAdicional = tiempoAdicional;
    }

    /**
     * Establece la fecha del partido.
     *
     * @param fecha Nueva fecha del partido
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece la duracion del partido.
     *
     * @param duracion Nueva duracion del partido
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * Establece el horario del partido.
     *
     * @param horario Nuevo horario del partido
     */
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    /**
     * Establece el equipo de arbitraje completo del partido.
     *
     * @param arbitraje Nueva lista completa de arbitraje del partido
     */
    public void setArbitraje(ArrayList<Arbitraje> arbitraje) {
        this.arbitraje = arbitraje;
    }


    //-----------------------------------------------------------------------------------
    /**
     * Agrega un evento que ocurra durante el partido.
     *
     * @param tipo Tipo de evento según el enum TipoEvento
     * @param minuto Minuto del partido en el que ocurre el evento
     * @param jugador Jugador que realizó el evento en el partido
     *
     * @author Rougier Valentina
     * */
    public void agregarEvento(TipoEvento tipo, int minuto, Jugador jugador){
        boolean participa = false;
        for(Participacion p : participacion){
            if(p != null && p.getSelecciones().getJugadores().contains(jugador)){
                participa = true;
                break;
            }
        }
        if(!participa){
            throw new IllegalArgumentException("El jugador no participa en este partido");
        }
        Evento evento = new Evento(tipo, minuto, jugador);
        eventos.add(evento);
    }
    /**
     * Agrega un árbitro al equipo de arbitraje del partido.
     *
     * @param a Arbitro y rol que se agrega al arbitraje del partido
     *
     * @author Rosatto Constanza
     * */
    public void agregarArbitraje(Arbitraje a) {
        this.arbitraje.add(a);
    }
}