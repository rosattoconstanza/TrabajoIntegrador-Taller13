package org.modelo.logica;
import org.modelo.domain.*;
import java.util.*;

/**
 * Clase Informes.
 * Contiene los 6 informes del sistema de gestión del Mundial:
 * tabla de posiciones por grupo, resultados por selección, ranking de
 * goleadores, informe disciplinario, ficha técnica de partido y
 * estadísticas de sedes. Cada método imprime el informe directamente
 * por consola.
 *
 * @author Alegre Juani
 * @version 1.0
 */
public class Informes {

    /**
     * Imprime la tabla de posiciones de un grupo, ordenada de mayor a menor
     * puntaje (victoria = 3 puntos, empate = 1 punto, derrota = 0 puntos).
     *
     * @param grupo grupo a informar
     */
    public void tablaPosicionesPorGrupo(Grupo grupo) {

        System.out.println("TABLA DE POSICIONES - Grupo: " + grupo.getIdentificacion());

        ArrayList<Seleccion> sels = new ArrayList<Seleccion>(grupo.getSeleccion());

        /** Ordenamos de mayor a menor puntos usando Collections.sort */
        Collections.sort(sels, new Comparator<Seleccion>() {
            public int compare(Seleccion a, Seleccion b) {
                return grupo.obtenerPuntos(b) - grupo.obtenerPuntos(a);
            }
        });

        /** Imprimimos cada seleccion con sus puntos */
        for (Seleccion s : sels) {
            System.out.println(s.getNombreFederacion() + " | " + grupo.obtenerPuntos(s) + " punto(s)");

        }
    }

    /**
     * Imprime todos los partidos jugados por una selección, el resultado
     * de cada uno, los puntos obtenidos y la última instancia alcanzada.
     *
     * @param seleccion selección a consultar
     */
    public void resultadosPorSeleccion(Seleccion seleccion) {

        System.out.println("RESULTADOS - " + seleccion.getNombreFederacion());

        int totalPts = 0;
        String ultimaFase = "-";

        for (Participacion miParticipacion : seleccion.getParticipacion()) {
            Partido partido = miParticipacion.getPartido();

            /** Obtenemos el rival igual que en obtenerPuntos de Grupo */
            Participacion p1 = partido.getParticipacion()[0];
            Participacion p2 = partido.getParticipacion()[1];
            Participacion rivalParticipacion;
            if (p1.equals(miParticipacion)) {
                rivalParticipacion = p2;
            } else {
                rivalParticipacion = p1;
            }

            int golesA = miParticipacion.cantidadGoles();
            int golesR = rivalParticipacion.cantidadGoles();
            int pts = 0;
            if (golesA > golesR) pts = 3;
            else if (golesA == golesR) pts = 1;
            totalPts += pts;

            if (partido.getFase() != null) {
                ultimaFase = partido.getFase().getNombre().name();
            }

            System.out.println("Fecha: " + partido.getFecha() +
                    " | Rival: " + rivalParticipacion.getSelecciones().getNombreFederacion() +
                    " | Resultado: " + golesA + " - " + golesR +
                    " | Puntos: " + pts);
        }

        System.out.println("Puntos totales: " + totalPts);
        System.out.println("Ultima instancia: " + ultimaFase);
    }

    /**
     * Imprime el ranking de jugadores que convirtieron al menos un gol,
     * ordenados de mayor a menor cantidad de goles.
     *
     * @param selecciones lista con todas las selecciones del Mundial
     */
    public void rankingGoleadores(ArrayList<Seleccion> selecciones) {
        System.out.println("RANKING DE GOLEADORES");

        /** Recolectamos todos los jugadores que hicieron al menos un gol */
        final ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        final ArrayList<String> nombSels   = new ArrayList<String>();

        for (Seleccion sel : selecciones) {
            for (Jugador j : sel.getJugadores()) {
                if (contarGolesJugador(j, sel) > 0) {
                    jugadores.add(j);
                    nombSels.add(sel.getNombreFederacion());
                }
            }
        }

        /** Ordenamos por goles de mayor a menor usando Collections.sort
        Usamos una lista auxiliar de indices para mantener sincronizado nombSels */
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < jugadores.size(); i++) {
            indices.add(i);
        }

        /** No necesitamos seleccion para contar goles desde eventos del jugador
        los goles ya estan en los eventos del partido, buscamos por jugador */
        Collections.sort(indices, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int golesA = contarGolesTotal(jugadores.get(a));
                int golesB = contarGolesTotal(jugadores.get(b));
                return golesB - golesA;
            }
        });

        /** Imprimimos en el orden del sort */
        for (int i = 0; i < indices.size(); i++) {
            int idx = indices.get(i);
            Jugador j = jugadores.get(idx);
            System.out.println((i + 1) + ". " + j.getNombre() +
                    " (" + nombSels.get(idx) + ")" + " - Goles: " + contarGolesTotal(j));
        }
    }

    /**
     * Imprime la cantidad de tarjetas amarillas y rojas de cada selección.
     *
     * @param selecciones lista con todas las selecciones del Mundial
     */
    public void informeDisciplinarioPorSeleccion(ArrayList<Seleccion> selecciones) {
        System.out.println("INFORME DISCIPLINARIO POR SELECCION");

        for (Seleccion sel : selecciones) {
            int amarillas = 0;
            int rojas = 0;
            for (Participacion p : sel.getParticipacion()) {
                amarillas += p.cantidadTarjAmarillas();
                rojas += p.cantidadTarjRojas();
            }
            System.out.println(sel.getNombreFederacion() + " | Amarillas: " + amarillas + " | Rojas: " + rojas);
        }
    }

    /**
     * Imprime la cantidad de tarjetas amarillas y rojas de un jugador
     * específico, dentro de su selección.
     *
     * @param jugador   jugador a consultar
     * @param seleccion selección a la que pertenece el jugador
     */
    public void informeDisciplinarioPorJugador(Jugador jugador, Seleccion seleccion) {
        System.out.println("INFORME DISCIPLINARIO - " + jugador.getNombre());

        int amarillas = 0;
        int rojas = 0;

        for (Participacion p : seleccion.getParticipacion()) {
            for (Evento e : p.getPartido().getEventos()) {
                if (e.getJugador() == null) continue;
                if (!e.getJugador().equals(jugador)) continue;
                if (e.getTipo() == TipoEvento.TarjetaAmarilla) amarillas++;
                if (e.getTipo() == TipoEvento.TarjetaRoja || e.getTipo() == TipoEvento.DobleAmarilla)  rojas++;
            }
        }

        System.out.println("Seleccion: " + seleccion.getNombreFederacion());
        System.out.println("Tarjetas amarillas: " + amarillas);
        System.out.println("Tarjetas rojas: " + rojas);
    }

    /**
     * Imprime el detalle completo de un partido: fecha, horario, estadio,
     * fase, resultado final, alineaciones de ambos equipos, árbitros
     * asignados y eventos ocurridos ordenados por minuto.
     *
     * @param partido partido a informar
     */
    public void fichaTecnicaPartido(Partido partido) {
        System.out.println("FICHA TECNICA DE PARTIDO");
        System.out.println("Fecha: " + partido.getFecha());
        System.out.println("Horario: " + partido.getHorario());

        if (partido.getEstadio() != null) {
            System.out.println("Estadio: " + partido.getEstadio().getNombre());
        }
        if (partido.getFase() != null) {
            System.out.println("Fase: " + partido.getFase().getNombre());
        }

        /** Tomamos las dos participaciones directamente del array */
        Participacion p1 = partido.getParticipacion()[0];
        Participacion p2 = partido.getParticipacion()[1];

        System.out.println("RESULTADO: " +
                p1.getSelecciones().getNombreFederacion() + " " + p1.cantidadGoles() +
                " - " + p2.cantidadGoles() + " " + p2.getSelecciones().getNombreFederacion());

        /** Alineaciones */
        System.out.println("[LOCAL] " + p1.getSelecciones().getNombreFederacion());
        for (Jugador j : p1.getSelecciones().getJugadores()) {
            System.out.println("#" + j.getDorsal() + " " + j.getNombre() + " (" + j.getPosicion() + ")");
        }
        System.out.println("[VISITANTE] " + p2.getSelecciones().getNombreFederacion());
        for (Jugador j : p2.getSelecciones().getJugadores()) {
            System.out.println("#" + j.getDorsal() + " " + j.getNombre() + " (" + j.getPosicion() + ")");
        }

        /** Arbitros */
        System.out.println("ARBITROS:");
        for (Arbitraje a : partido.getArbitraje()) {
            System.out.println(a.getRol() + ": " + a.getArbitro().getNombre());
        }

        /** Eventos ordenados por minuto con Collections.sort */
        ArrayList<Evento> evs = new ArrayList<Evento>(partido.getEventos());
        Collections.sort(evs, new Comparator<Evento>() {
            public int compare(Evento a, Evento b) {
                return a.getMinuto() - b.getMinuto();
            }
        });

        System.out.println("EVENTOS:");
        for (Evento e : evs) {
            System.out.println("Min " + e.getMinuto() + "' - " + e.getTipo() + " - " + e.getJugador().getNombre());
        }
    }

    /**
     * Imprime la cantidad de partidos jugados en un estadio específico,
     * junto con la fecha y los equipos de cada uno.
     *
     * @param estadio estadio a consultar
     */
    public void estadisticasPorEstadio(Estadio estadio) {
        System.out.println("ESTADISTICAS - " + estadio.getNombre());

        int total = 0;
        for (Partido p : estadio.getPartidos()) {
            total++;
            String loc = p.getParticipacion()[0].getSelecciones().getNombreFederacion();
            String vis = p.getParticipacion()[1].getSelecciones().getNombreFederacion();
            System.out.println(p.getFecha() + " - " + loc + " vs " + vis);
        }
        System.out.println("Total de partidos: " + total);
    }

    /**
     * Imprime la cantidad de partidos jugados en una ciudad específica,
     * recorriendo todas las sedes del Mundial ubicadas en esa ciudad.
     *
     * @param ciudad  nombre de la ciudad a consultar
     * @param mundial Mundial del que se obtienen las sedes
     */
    public void estadisticasPorCiudad(String ciudad, Mundial mundial) {
        System.out.println("ESTADISTICAS - Ciudad: " + ciudad);

        int total = 0;
        for (Sede sede : mundial.getSedes()) {
            if (!sede.getCiudad().equalsIgnoreCase(ciudad)) continue;
            for (Estadio est : sede.getEstadios()) {
                for (Partido p : est.getPartidos()) {
                    total++;
                    System.out.println(p.getFecha() + " - " + est.getNombre());
                }
            }
        }
        System.out.println("Total de partidos en " + ciudad + ": " + total);
    }


    /** MÉTODOS AUXILIARES PRIVADOS */

    /**
     * Cuenta los goles de un jugador recorriendo los eventos de todos
     * los partidos jugados por su selección.
     *
     * @param jugador jugador a consultar
     * @param sel     selección a la que pertenece el jugador
     * @return cantidad de goles del jugador
     */
    private int contarGolesJugador(Jugador jugador, Seleccion sel) {
        int goles = 0;
        for (Participacion p : sel.getParticipacion()) {
            for (Evento e : p.getPartido().getEventos()) {
                if (e.getTipo() == TipoEvento.Gol && jugador.equals(e.getJugador())) {
                    goles++;
                }
            }
        }
        return goles;
    }

    /**
     * Cuenta los goles de un jugador recorriendo directamente
     * su propia lista de eventos.
     *
     * @param jugador jugador a consultar
     * @return cantidad de goles del jugador
     */
    private int contarGolesTotal(Jugador jugador) {
        int goles = 0;
        if (jugador.getEventos() == null) return 0;
        for (Evento e : jugador.getEventos()) {
            if (e.getTipo() == TipoEvento.Gol) {
                goles++;
            }
        }
        return goles;
    }
}
