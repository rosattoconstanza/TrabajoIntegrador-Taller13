package org.modelo.logica;
import java.util.*;
public class Scannear {
    public static void organizaciónDeportiva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Configurar los Grupos 2. Configurar las Fases de eliminación \n" +
                "3.Planificar los Partidos.");
        int eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
                configurarGrupo();
                break;

            case 2:
                configurarFases();
                break;

            case 3:
                planificarPartidos();
                break;

            default:
                System.out.println("Opción inválida");
        }
    }

    public static void registroDeEventosDeCampo () {
    }

    public static void configurarGrupo () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cantidad de grupos a añadir: ");
        int cantidad = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Identificacion: ");
        }
    }

    public static void GestionDeInfraestructura() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1.Registrar Sede. \n" + "Registrar Estadio.");
        int eleccionusuario = sc.nextInt();

        if(eleccionusuario == 1) {
            registrarSedes();
        }
        else if(eleccionusuario == 2) {

        }
        else {

        }
    }

    public static void registrarSedes() {
        Scanner sc = new Scanner(System.in);
        int contador = 1;
        System.out.println("Ingrese la ciudad de la Sede número " + contador + " (Ingrese 'fin' si desea finalizar el proceso): ");
        String ciudad = sc.nextLine();
        while(!ciudad.equalsIgnoreCase("fin")) {
            System.out.println("Ingrese la altura al nivel del mar de la Sede número " + contador + " (Ingrese 'fin' si desea finalizar el proceso): ");
            float alturaNivelMar = sc.nextFloat();

            System.out.println("Ingrese el clima de la Sede número " + contador + " (Ingrese 'fin' si desea finalizar el proceso): ");
            String clima = sc.nextLine();

            System.out.println("Ingrese la zona horaria de la Sede número " + contador + " (Ingrese 'fin' si desea finalizar el proceso): ");
            String zonaHoraria = sc.nextLine();

        }
    }
}
