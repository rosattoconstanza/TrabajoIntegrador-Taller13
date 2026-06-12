package org.modelo.vista;
import org.modelo.domain.*;
import org.modelo.logica.*;

public class Aplicacion {
    Scannear scannear;
    public void ejecutar() {
        System.out.println("------------ SISTEMA DE MUNDIAL ------------");

        Mundial mundial = new Mundial(2026, "Mulita", 1106, 1907);
        Pais argentina = new Pais("Argentina", "Celeste y Blanca");
        Pais brasil = new Pais("Brasil", "Verde y Amarilla");
        Seleccion seleccionArgentina = new Seleccion("AFA", "Albiceleste","casaca", true,1);
        Seleccion seleccionBrasil = new Seleccion("Confederación Brasileña de Fútbol", "Canarinha", "Camisa Azulina", false, 2);
        seleccionArgentina.setPais(argentina);



        Mundial mundial = scannear.inicializarMundial();
    }
}