package org.modelo.domain;
import java.util.ArrayList;
import java.util.Scanner;

public class planificarPartidoVale {
    public Partido planificarPartido(ArrayList<Fase> fases, ArrayList<Grupo> grupos) {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<fases.size(); i++){
            System.out.println(i + "-" + fases.get(i));
        }
        System.out.println("En que fase se encuentra el partido que cargara?");
        int respuesta = sc.nextInt();
        Fase fase = fases.get(respuesta);
        






    }
}
