package modelo;

public class Evento {
    /**Clase Evento.
     * Asociada con clase Jugador y composición con Partido.
     */

    private TipoEvento tipo;
    private int minuto;
    private Jugador jugador;

    /** Constructor parametrizado */
    public Evento(TipoEvento tipo, int minuto, Jugador jugador) {
        this.tipo = tipo;
        this.minuto = minuto;
        this.jugador = jugador;
    }
    /** Constructor por defecto */
    public Evento(){
    }

    /** Getters */
    public TipoEvento getTipo() {
        return tipo;
    }

    public int getMinuto() {
        return minuto;
    }

    public Jugador getJugador() {
        return jugador;
    }

    /** Setters */
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}