package org.modelo.vista;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        /** Menú principal visible para el usaurio */
        System.out.println("¡Bienvenido a la organización del Mundial de fútbol 2026! ¿Que desea hacer?:\n" +
                "1. Cargar informacion.\n" + "2. Acceso a informes.");
        int eleccionUsuario = sc.nextInt();

        switch (eleccionUsuario) {
            case 1: System.out.println("¡Genial! ¿Que información desea cargar?:\n" +  "1. Gestion de Infraestructura.\n" +
                    "2. Administración de Delegaciones.\n" + "3. Organización Deportiva.\n" + "4. Registro de Eventos de Campo.");
            case 2: System.out.println("¡Genial! ¿Que informe está buscando? :\n" + "1. Tabla de Posiciones por Grupo.\n" +
                    "2. Tabla de Resultados por Selección.\n" + "3. Ranking de Goleadores.\n" + "4. Informe Disciplinario.\n" +
                    "5. Ficha Técnica de Partido.\n" + "6. Estadísticas de Sedes.");
            default: System.out.println("Parece que tu eleccion no es válida. Prueba nuevamente: ");
        }
    }
}

//IDEASS PARA MANEJAR EL MENU

/* public int pedirEleccion(); //Y retornar la opcion que elija, verificando ya aca adentro que sea valida.
   public void menuPrincipal(); public void menuCargaInformacion();  public void menuInformes();
   //Arriba de ttodo en el main (O preguntar como podemos hacer metodos al aire en la carpeta "logica",
   y despues el switch se hace brevemente llamando a los metodos.
 */

