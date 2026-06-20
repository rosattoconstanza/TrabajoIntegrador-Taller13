package org.modelo.domain;

/**
 * Clase Evento.
 * Asociada con la clase Jugador y en composición con la clase Partido.
 * Representa un suceso ocurrido durante un partido (gol, tarjeta, etc.).
 *
 * @author Rougier Valentina
 * @version 1.0
 */
public class Evento {

    private TipoEvento tipo;
    private int minuto;
    private Jugador jugador;

    /**
     * Constructor parametrizado de la clase Evento.
     *
     * @param tipo Tipo de evento ocurrido
     * @param minuto Minuto del partido en que ocurrió
     * @param jugador Jugador involucrado en el evento
     *
     * @author Rougier Valentina
     * @version 1.0
     */
    public Evento(TipoEvento tipo, int minuto, Jugador jugador) {
        this.tipo = tipo;
        this.minuto = minuto;
        this.jugador = jugador;
    }

    /**
     * Constructor por defecto de la clase Evento.
     * Inicializa los atributos con valores predeterminados.
     *
     * @author Rougier Valentina
     * @version 1.0
     */
    public Evento(){
        this(null, 0, null);
    }

    /**
     * Obtiene el tipo de evento.
     *
     * @return tipo de evento
     */
    public TipoEvento getTipo() {
        return tipo;
    }

    /**
     * Obtiene el minuto en que ocurrió el evento.
     *
     * @return minuto del evento
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Obtiene el jugador involucrado en el evento.
     *
     * @return jugador del evento
     */
    public Jugador getJugador() {
        return jugador;
    }

    /**
     * Establece el tipo de evento.
     *
     * @param tipo nuevo tipo de evento
     */
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece el minuto del evento.
     *
     * @param minuto nuevo minuto del evento
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * Establece el jugador involucrado en el evento.
     *
     * @param jugador nuevo jugador del evento
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}