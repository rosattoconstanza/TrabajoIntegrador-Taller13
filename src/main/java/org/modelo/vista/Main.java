package org.modelo.vista;
import java.util.Scanner;
import static org.modelo.logica.Scannear.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        /** Menú principal visible para el usaurio */
        System.out.println("¡Bienvenido a la organización del Mundial de fútbol 2026! ¿Que desea hacer?:\n" +
                "1. Gestión de Infraestructura.\n" + "2. Administración de Delegaciones.\n" +
                "3.Organización Deportiva.\n" + "4.Registro de Eventos de Campo.");
        int eleccionUsuario = sc.nextInt();

        switch (eleccionUsuario) {
            case 1: GestionDeInfraestructura();
            case 2:
            case 3:
            case 4:
            default:
        }
    }
}

