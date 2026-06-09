package org.modelo.vista;
import org.modelo.domain.Mundial;
import org.modelo.domain.Pais;
import org.modelo.domain.Seleccion;

import static org.modelo.logica.Scannear.*;

public class Main {
    public static void main(String args[]) {
        System.out.println("------------ SISTEMA DE MUNDIAL ------------");

        Mundial mundial = new Mundial(2026, "Mulita", 1106, 1907);
        Pais argentina = new Pais("Argentina", "Celeste y Blanca");
        Pais brasil = new Pais("Brasil", "Verde y Amarilla");
        Seleccion seleccionArgentina = new Seleccion("AFA", "Albiceleste","casaca", true,1);
        Seleccion seleccionBrasil = new Seleccion("Confederación Brasileña de Fútbol", "Canarinha", "Camisa Azulina", false, 2);
        seleccionArgentina.setPais(argentina);
    }
}