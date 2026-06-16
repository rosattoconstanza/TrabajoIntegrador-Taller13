package org.modelo.domain;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class planificarPartidoVale {



    public Partido planificarPartido(ArrayList<Fase> fases, ArrayList<Grupo> grupos, ArrayList<Pais> paises, ArrayList<Estadio> estadios, ArrayList<Arbitro> arbitros) {
        Scanner sc = new Scanner(System.in);
        Partido partido = null;
        boolean excepcion = false;

        while (!excepcion) {
            try {
                // 1. SELECCIÓN DE FASE
                System.out.println("\nFases disponibles:");
                for (int i = 0; i < fases.size(); i++) {
                    System.out.println("- " + fases.get(i).getNombre());
                }
                System.out.println("Escriba el nombre de la fase en la que se encuentra el partido:");
                String respuestaFase = sc.nextLine();

                Fase faseSeleccionada = null;
                for (Fase fase : fases) {
                    if (fase.getNombre().name().equalsIgnoreCase(respuestaFase)) {
                        faseSeleccionada = fase;
                        break;
                    }
                }

                if (faseSeleccionada == null) {
                    System.out.println("Error: Fase no encontrada. Intente nuevamente.");
                    continue; // Reinicia el bucle sin sacar al usuario
                }

                Seleccion local = null;
                Seleccion visitante = null;

                // 2. SELECCIÓN DE EQUIPOS (Con lógica separada si es Fase de Grupos o Eliminatoria)
                if (faseSeleccionada.getNombre() == NombreFase.Grupos) {
                    System.out.println("\nGrupos disponibles:");
                    for (Grupo grupo : grupos) {
                        System.out.println("- Grupo " + grupo.getIdentificacion());
                    }
                    System.out.println("Escriba la Identificación del grupo a planificar:");
                    String identificacionGrupo = sc.nextLine();

                    Grupo grupoSeleccionado = null;
                    for (Grupo g : grupos) {
                        if (g.getIdentificacion().equalsIgnoreCase(identificacionGrupo)) {
                            grupoSeleccionado = g;
                            break;
                        }
                    }

                    if (grupoSeleccionado == null) {
                        System.out.println("Error: Grupo inexistente. Intente nuevamente.");
                        continue;
                    }

                    System.out.println("\nSelecciones en el Grupo " + grupoSeleccionado.getIdentificacion() + ":");
                    for (Seleccion seleccion : grupoSeleccionado.getSeleccion()) {
                        System.out.println("- " + seleccion.getNombreFederacion());
                    }
                    System.out.println("Escriba el nombre de la selección local:");
                    String nombreLocal = sc.nextLine();
                    System.out.println("Escriba el nombre de la selección visitante:");
                    String nombreVisitante = sc.nextLine();

                    for (Seleccion seleccion : grupoSeleccionado.getSeleccion()) {
                        if (seleccion.getNombreFederacion().equalsIgnoreCase(nombreLocal)) local = seleccion;
                        if (seleccion.getNombreFederacion().equalsIgnoreCase(nombreVisitante)) visitante = seleccion;
                    }

                } else {
                    // Si es Octavos, Cuartos, Semis o Final, busca en todos los países cargados
                    System.out.println("\nSelecciones disponibles:");
                    for (Pais p : paises) {
                        if (p.getSeleccion() != null) {
                            System.out.println("- " + p.getSeleccion().getNombreFederacion());
                        }
                    }
                    System.out.println("Escriba el nombre de la selección local:");
                    String nombreLocal = sc.nextLine();
                    System.out.println("Escriba el nombre de la selección visitante:");
                    String nombreVisitante = sc.nextLine();

                    for (Pais p : paises) {
                        if (p.getSeleccion() != null) {
                            if (p.getSeleccion().getNombreFederacion().equalsIgnoreCase(nombreLocal)) local = p.getSeleccion();
                            if (p.getSeleccion().getNombreFederacion().equalsIgnoreCase(nombreVisitante)) visitante = p.getSeleccion();
                        }
                    }
                }

                // Validaciones de Selecciones
                if (local == null || visitante == null) {
                    System.out.println("Error: Una o ambas selecciones no existen. Intente nuevamente.");
                    continue;
                }
                if (local.equals(visitante)) {
                    System.out.println("Error: Una selección no puede jugar contra sí misma. Intente nuevamente.");
                    continue;
                }

                // 3. DATOS DEL PARTIDO
                DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

                System.out.println("\nIngrese fecha del partido (dd/MM/yyyy):");
                LocalDate fecha = LocalDate.parse(sc.nextLine(), formatoFecha);

                System.out.println("Ingrese hora del partido (HH:mm):");
                LocalTime hora = LocalTime.parse(sc.nextLine(), formatoHora);

                System.out.println("Ingrese duración del partido (minutos):");
                int duracion = sc.nextInt();

                System.out.println("Ingrese tiempo adicional del partido (minutos):");
                int tiempoAdicional = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer del teclado

                // 4. SELECCIÓN DE ESTADIO (Listando los existentes)
                System.out.println("\nEstadios disponibles:");
                for (int i = 0; i < estadios.size(); i++) {
                    System.out.println((i + 1) + ". " + estadios.get(i).getNombre() + " (Capacidad: " + estadios.get(i).getCapacidad() + ")");
                }
                System.out.println("Seleccione el NÚMERO del Estadio:");
                int indiceEstadio = sc.nextInt() - 1;
                sc.nextLine(); // Limpiar buffer

                if (indiceEstadio < 0 || indiceEstadio >= estadios.size()) {
                    System.out.println("Error: Estadio inválido. Intente nuevamente.");
                    continue;
                }
                Estadio estadioSeleccionado = estadios.get(indiceEstadio);

                // 5. CREACIÓN DEL PARTIDO Y PARTICIPACIONES
                Participacion[] participaciones = new Participacion[2];
                participaciones[0] = new Participacion(true, local, null);
                participaciones[1] = new Participacion(false, visitante, null);

                partido = new Partido(fecha, hora, duracion, tiempoAdicional, estadioSeleccionado, faseSeleccionada, participaciones, new ArrayList<Arbitraje>());
                participaciones[0].setPartido(partido);
                participaciones[1].setPartido(partido);

                // 6. ASIGNACIÓN DE ÁRBITROS
                System.out.println("\n¿Cuántos árbitros tendrá este partido?:");
                int cantidadArbitros = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < cantidadArbitros; i++) {
                    System.out.println("\nÁrbitros registrados:");
                    for (int j = 0; j < arbitros.size(); j++) {
                        System.out.println((j + 1) + ". " + arbitros.get(j).getNombre());
                    }
                    System.out.println("Seleccione el NÚMERO del árbitro " + (i + 1) + ":");
                    int indiceArbitro = sc.nextInt() - 1;
                    sc.nextLine();

                    if (indiceArbitro < 0 || indiceArbitro >= arbitros.size()) {
                        System.out.println("Árbitro no válido. Se omite esta asignación.");
                        continue; // Pasa al siguiente árbitro del ciclo for
                    }
                    Arbitro arbitroSeleccionado = arbitros.get(indiceArbitro);

                    System.out.println("Roles disponibles:");
                    for (CategoriaArbitro opcion : CategoriaArbitro.values()) {
                        System.out.println("- " + opcion);
                    }
                    System.out.println("Escriba el rol de este árbitro:");
                    String categoria = sc.nextLine();
                    CategoriaArbitro categoriaArbitro = null;

                    for (CategoriaArbitro opcion : CategoriaArbitro.values()) {
                        if (opcion.name().equalsIgnoreCase(categoria)) {
                            categoriaArbitro = opcion;
                            break;
                        }
                    }

                    if (categoriaArbitro != null) {
                        Arbitraje arbitraje = new Arbitraje(categoriaArbitro, arbitroSeleccionado, partido);
                        arbitroSeleccionado.agregarArbitraje(arbitraje);
                        partido.agregarArbitraje(arbitraje);
                        System.out.println("Árbitro asignado con éxito.");
                    } else {
                        System.out.println("Rol no válido. No se asignó este árbitro.");
                    }
                }

                // 7. VINCULAR Y FINALIZAR
                faseSeleccionada.agregarPartidos(partido);
                System.out.println("\n¡Partido planificado y guardado correctamente!");
                excepcion = true; // Corta el bucle while infinito

            } catch (InputMismatchException e) {
                System.out.println("\n[Error] Se esperaba un número. Intente nuevamente toda la carga del partido.");
                sc.nextLine(); // Limpia la basura del scanner
            } catch (Exception e) {
                System.out.println("\n[Error] Formato de fecha/hora incorrecto o dato inválido. Intente nuevamente.");
            }
        }
        return partido;
    }

