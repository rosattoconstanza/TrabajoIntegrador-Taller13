package org.modelo.domain;

/**
 * Clase Participacion.
 * Clase agregada que surge de la asociación entre las clases Partido y Seleccion.
 * Representa la actuación de una selección dentro de un partido específico.
 *
 * @author Rosatto Constanza, Alegre Juani
 * @version 1.1
 */
public class Participacion {

    private boolean esLocal;
    private Seleccion selecciones;
    private Partido partido;

    /**
     * Constructor por defecto de la clase Participacion.
     * Inicializa los atributos con valores predeterminados.
     */
    public Participacion(){
        this(false, null, null);
    }

    /**
     * Constructor parametrizado de la clase Participacion.
     *
     * @param esLocal Indica si la selección juega como local
     * @param selecciones Selección que participa
     * @param partido Partido en el que participa
     */
    public Participacion(boolean esLocal, Seleccion selecciones, Partido partido) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.selecciones = selecciones;
    }


    /**
     * Cuenta los goles convertidos por esta selección en este partido.
     * Recorre los eventos del partido y filtra los de tipo Gol cuyo jugador
     * pertenezca a la selección de esta participación.
     *
     * @return cantidad de goles convertidos
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

    /**
     * Cuenta las tarjetas amarillas recibidas por esta selección en este partido.
     *
     * @return cantidad de tarjetas amarillas
     */
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

    /**
     * Cuenta las tarjetas rojas recibidas por esta selección en este partido.
     * Incluye TarjetaRoja y DobleAmarilla, ya que ambas implican expulsión.
     *
     * @return cantidad de tarjetas rojas
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


    /**
     * Indica si la selección participó como local en el partido.
     *
     * @return true si es local, false si es visitante
     */
    public boolean getEsLocal() { return esLocal; }

    /**
     * Obtiene el partido al que corresponde esta participación.
     *
     * @return partido asociado
     */
    public Partido getPartido() { return partido; }

    /**
     * Obtiene la selección que participa en el partido.
     *
     * @return selección asociada
     */
    public Seleccion getSelecciones(){
        return selecciones;
    }


    /**
     * Establece si la selección participa como local.
     *
     * @param esLocal nuevo valor de localía
     */
    public void setEsLocal(boolean esLocal) { this.esLocal = esLocal; }

    /**
     * Establece la selección asociada a esta participación.
     *
     * @param selecciones nueva selección
     */
    public void setSelecciones(Seleccion selecciones) { this.selecciones = selecciones; }

    /**
     * Establece el partido asociado a esta participación.
     *
     * @param partido nuevo partido
     */
    public void setPartido(Partido partido) { this.partido = partido; }
}
