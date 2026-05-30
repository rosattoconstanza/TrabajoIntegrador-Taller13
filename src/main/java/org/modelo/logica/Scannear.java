package org.modelo.logica;
import java.util.Scanner;
    public class Scannear {
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
}
