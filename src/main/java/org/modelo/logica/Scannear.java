package org.modelo.logica;
import java.util.*;
public class Scannear {
    public static void organizaciónDeportiva(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Configurar los Grupos 2. Configurar las Fases de eliminación \n" +
                "3.Planificar los Partidos.");
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


    public static void registroDeEventosDeCampo(){
    }

    public static void configurarGrupo(){
        System.out.println("Cantidad de grupos a añadir: ");
        cantidad = sc.nextInt();
        for (int i=0; i<cantidad;i++){
            System.out.println("Identificacion: ");
        }
    }
}
