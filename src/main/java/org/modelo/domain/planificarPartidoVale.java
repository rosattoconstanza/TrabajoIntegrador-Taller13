package org.modelo.domain;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class planificarPartidoVale {



    public Partido planificarPartido(ArrayList<Fase> fases, ArrayList<Grupo> grupos) {
        Scanner sc = new Scanner(System.in);
        Partido partido = null;
        boolean excepcion = false;

        while (!excepcion) {
            try {
        for (int i=0; i<fases.size(); i++){
            System.out.println(i + "-" + fases.get(i));
        }
        System.out.println("En que fase se encuentra el partido que cargara?");
        int respuesta = sc.nextInt();
        sc.nextLine();
        Fase fase = fases.get(respuesta);

        if (respuesta == 0){ //fase de grupos aun
            for (Grupo grupo : grupos){
                System.out.println(grupo.getIdentificacion());
            }
            System.out.println("Escribe la Identificacion del grupo a planificar:");
            String identificacionGrupo = sc.nextLine();
            Grupo grupo = null;

            for(Grupo g : grupos){
                if(g.getIdentificacion().equalsIgnoreCase(identificacionGrupo)){
                    grupo = g;
                }
            }
            for (int i=0; i<grupo.getSeleccion().size(); i++) {
                System.out.println(grupo.getSeleccion().get(i));
            }
            System.out.println("Seleccione selección local");
            String seleccionLocal = sc.nextLine();
            System.out.println("Seleccione selección visitante");
            String seleccionVisitante = sc.nextLine();

                    System.out.println("Ingrese fecha del partido:");
                    LocalDate fecha = sc.nextDate();
                    System.out.println("Ingrese hora del partido:");
                    LocalTime hora = sc.nextTime();
                    System.out.println("Ingrese duracion del partido:");
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese tiempo Adicional del partido:");
                    int tiempoAdicional = sc.nextInt();
                    System.out.println("Ingrese Estadio en que se juega dicho partido:");



                    partido = new Partido()
                    excepcion = true;
                }

            }
        }
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }
        return partido;
    }








}
}
