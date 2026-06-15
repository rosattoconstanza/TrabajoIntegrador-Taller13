package org.modelo.domain;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class planificarPartidoVale {



    public Partido planificarPartido(ArrayList<Fase> fases, ArrayList<Grupo> grupos, ArrayList<Pais> paises) {
        Scanner sc = new Scanner(System.in);
        Partido partido = null;
        boolean excepcion = false;

        while (!excepcion) {
            try {
        for (int i=0; i<fases.size(); i++){
            System.out.println(i + "-" + fases.get(i));
        }
        System.out.println("En que fase se encuentra el partido que cargara?");
        String respuesta = sc.nextLine();
        Fase faseSeleccionada = null;
        for(Fase fase : fases){
            if(fase.getNombre().name().equalsIgnoreCase(respuesta)){
                faseSeleccionada = fase;
            }
        }

        if(faseSeleccionada != null){
            if(faseSeleccionada.getNombre() == NombreFase.Grupos){
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
                if(grupo == null){
                    System.out.println("Grupo inexistente.");
                    return null;
                }
                for (int i=0; i<grupo.getSeleccion().size(); i++) {
                    System.out.println(grupo.getSeleccion().get(i));
                }
                System.out.println("Seleccione selección local");
                String seleccionLocal = sc.nextLine();
                System.out.println("Seleccione selección visitante");
                String seleccionVisitante = sc.nextLine();

                Seleccion local = null;
                Seleccion visitante = null;

                for(Seleccion seleccion : grupo.getSeleccion()){
                    if(seleccion.getNombreFederacion().equalsIgnoreCase(seleccionLocal)){
                        local = seleccion;
                    }
                    if(seleccion.getNombreFederacion().equalsIgnoreCase(seleccionVisitante)){
                        visitante = seleccion;
                    }
                }
                if(local == null || visitante == null){
                    System.out.println("Una o ambas selecciones no existen en el grupo.");
                    return null;
                }
                if(local.equals(visitante)){
                    System.out.println("Una selección no puede jugar contra sí misma.");
                    return null;
                }

                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

                System.out.println("Ingrese fecha del partido(dd/MM/yyyy):");
                String fechaTexto = sc.nextLine();
                LocalDate fecha = LocalDate.parse(fechaTexto, formatoFecha);
                System.out.println("Ingrese hora del partido(HH:mm):");
                String horaTexto = sc.nextLine();
                LocalTime hora = LocalTime.parse(horaTexto, formatoHora);
                System.out.println("Ingrese duracion del partido:");
                int duracion = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese tiempo Adicional del partido:");
                int tiempoAdicional = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese nombre del Estadio en que se juega dicho partido:");
                String nombreEstadio = sc.nextLine();
                System.out.println("Ingrese capacidad de dicho Estadio:");
                int capacidadEstadio = sc.nextInt();
                Estadio estadio = new Estadio(nombreEstadio, capacidadEstadio);

                Participacion participacion[]= new Participacion[2];
                participacion[0] = new Participacion(true, local, null);
                participacion[1] = new Participacion(false, visitante, null);

                partido = new Partido(fecha, hora, duracion,tiempoAdicional,estadio, faseSeleccionada, participacion,new ArrayList<Arbitraje>());
                participacion[0].setPartido(partido);
                participacion[1].setPartido(partido);

                System.out.println("Cantidad de arbitros en su partido:");
                int cantidadArbitros = sc.nextInt();
                sc.nextLine();

                for (int i=0; i<cantidadArbitros;i++) {
                    System.out.println("Nombre del arbitro " + (i + 1));
                    String nombreArbitro = sc.nextLine();
                    System.out.println("Fecha de nacimiento del arbitro " + (i + 1));
                    int fechaNacimArbitro = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Años de experiencia del arbitro " + (i + 1));
                    int aniosExpeArbitro = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Pais del arbitro " + (i + 1));
                    String pais = sc.nextLine();
                    Pais paisArbitro = null;

                    for (int j = 0; j < paises.size(); j++) {
                        if (paises.get(j).getNombre().equalsIgnoreCase(pais)) {
                            paisArbitro = paises.get(j);
                        }
                    }

                    Arbitro arbitro = new Arbitro(nombreArbitro, fechaNacimArbitro, aniosExpeArbitro, paisArbitro);

                    for (CategoriaArbitro opcion : CategoriaArbitro.values()) {
                        System.out.println("- " + opcion);
                    }
                    System.out.println("Rol del arbitro ");
                    String categoria = sc.nextLine();
                    CategoriaArbitro categoriaArbitro = null;

                    for (CategoriaArbitro opcion : CategoriaArbitro.values()) {
                        if (opcion.name().equalsIgnoreCase(categoria)) {
                            categoriaArbitro = opcion;
                        }
                    }
                    Arbitraje arbitraje = new Arbitraje(categoriaArbitro, arbitro, partido);
                    arbitro.agregarArbitraje(arbitraje);
                    partido.agregarArbitraje(arbitraje);
                }
                    faseSeleccionada.agregarPartidos(partido);
                }

                excepcion = true;
            }
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }
        return partido;
    }
}

