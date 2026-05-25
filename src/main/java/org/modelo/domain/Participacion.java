package org.modelo.domain;

public class Participacion {
    /** Clase Agregada Participacion.
     * Surge de la asociacion de la clase Partido y la clase Seleccion.
     */

    private boolean esLocal;
    private Seleccion selecciones;
    private Partido partido;

    /** Constructores parametrizado y por defecto */
    public Participacion(){
        this(false, null, null);
    }

    public Participacion(boolean esLocal, Seleccion selecciones, Partido partido) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.selecciones = selecciones;
    }


    /** Metodos propios de la clase.
     *  Cuenta los goles echos por esta Seleccion en este Partido,
     *  recorriendo todos los eventos del partido y contando los de tipo Gol,
     *  cuyo Jugador pertenezca a la Seleccion de esta Participacion.
     */
    public int cantidadGoles() {
        int goles = 0;
        for (Evento e : partido.getEventos()) {
            if (e.getTipo() == TipoEvento.Gol) {
                if (selecciones.getJugadores().contains(e.getJugador())) {
                    goles++;
                }
            }
        }
        return goles;
    }

    /** Cuenta las tarjetas amarrillas recibidas por esta Seleccion en este Partido */
    public int cantidadTarjAmarillas() {
        int amarillas = 0;
        for (Evento e : partido.getEventos()) {
            if (e.getTipo() == TipoEvento.TarjetaAmarilla) {
               if (selecciones.getJugadores().contains(e.getJugador())) {
                   amarillas++;
               }
            }
        }
        return amarillas;
    }

    /** Cuenta las tarjetas rojas recibidas por esta Seleccion en este Partido.
     *  Se incluyen TarjetaRoja y DobleAmarrilla (ambas implican expulsion).
     */
    public int cantidadTarjRojas(){
        int rojas = 0;
        for (Evento e : partido.getEventos()) {
            if (e.getTipo() == TipoEvento.TarjetaRoja || e.getTipo() == TipoEvento.DobleAmarilla) {
                if (selecciones.getJugadores().contains(e.getJugador())) {
                    rojas++;
                }
            }
        }
        return rojas;
    }


    /** Getters */
    public boolean getEsLocal() {
        return esLocal;
    }

    public Partido getPartido() {
        return partido;
    }

    public Seleccion getSelecciones(){
        return selecciones;
    }


    /** Setters */
    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public void setSelecciones(Seleccion selecciones) {
        this.selecciones = selecciones;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
