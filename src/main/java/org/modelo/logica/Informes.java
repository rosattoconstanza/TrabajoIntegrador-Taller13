package org.modelo.logica;
import org.modelo.domain.*;
import java.util.*;

public class Informes {

    /**informe 1*/
    public void tablaPosicionesPorGrupo(Grupo grupo) {

        System.out.println("TABLA DE POSICIONES — Grupo: " + grupo.getIdentificacion());

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

    /** informe 2*/
    public void resultadosPorSeleccion(Seleccion seleccion) {

        System.out.println("RESULTADOS — " + seleccion.getNombreFederacion());

        int totalPts = 0;
        String ultimaFase = "—";

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
}
