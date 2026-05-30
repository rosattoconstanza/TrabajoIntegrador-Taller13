package org.modelo.logica;
import org.modelo.domain.*;
import java.util.*;

public class Informes {

    /** INFORME 1 - Tabla de posiciones por grupo
    // Victoria = 3 pts | Empate = 1 pt | Derrota = 0 pts */

    /** Imprime la tabla de posiciones de un grupo ordenada por puntos de mayor a menor.
     * Usa Collections.sort con un Comparator que compara los puntos de cada seleccion. */
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

    /** INFORME 2 — Resultados por selección */

     /** Imprime todos los partidos jugados por una selección,
     el resultado de cada uno y los puntos obtenidos.*/
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

    /** INFORME 4 — Informe disciplinario */

    /** Imprime las tarjetas amarillas y rojas de cada seleccion. */
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

    /** Imprime las tarjetas recibidas por un jugador especifico.*/
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

    /** INFORME 5 — Ficha técnica de partido */

    /** Imprime el detalle completo de un partido:
     * equipos, arbitros, eventos cronologicos y resultado final. */
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

    /** INFORME 6 — Estadísticas de sedes */

    /** Imprime los partidos jugados en un estadio especifico.*/
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

    /** Imprime los partidos jugados en una ciudad especifica.*/
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

    /** Cuenta los goles de un jugador recorriendo los eventos de todos los partidos de su seleccion. */
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

    /** Cuenta los goles de un jugador recorriendo sus propios eventos. Se usa en el ranking de goleadores.*/
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
