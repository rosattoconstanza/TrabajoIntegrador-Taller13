package org.modelo.vista;
import org.modelo.domain.*;
import org.modelo.logica.Scannear;
import java.util.*;

public class Aplicacion {
    private Scannear scannear;
    private Mundial mundial;
    private ArrayList<Pais> paises;
    private ArrayList<Fase> fases;
    private ArrayList<Grupo> grupos;


    Aplicacion() {
        this.scannear = new Scannear();
        this.paises = new ArrayList<Pais>();
        this.fases = new ArrayList<Fase>();
        this.grupos = new ArrayList<Grupo>();
    }


    //ARRANCA
    public void ejecutar() {
        this.mundial = scannear.inicializarMundial();
        System.out.println("El Mundial se creo correctamente, muchas gracias.");
        menuPrincipal();
    }

    // MENUS
    private void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (salir == false) {
            try {
                System.out.println("¡Bienvenido a la organización del Mundial de fútbol 2026! ¿Que desea hacer?:\n" +
                        "1. Gestión de Infraestructura.\n" + "2. Administración de Delegaciones.\n" +
                        "3.Organización Deportiva.\n" + "4.Registro de Eventos de Campo.\n" + "5.Informes.\n" + "6. Salir.");
                int eleccionUsuario = scannear.numValido(sc, 1, 6);
                switch (eleccionUsuario) {
                    case 1:
                        menuInfraestructura();
                        break;
                    case 2:
                        menuDelegaciones();
                        break;
                    case 3:
                        //menuOrganizacion();
                        break;
                    case 4:
                        menuEventos();
                        break;
                    case 5:
                        menuInformes();
                        break;
                    case 6:
                        System.out.println("Gracias por utilizar nuestro sistema, vuelva pronto :)");
                        salir = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un entero, intente nuevamente.");
                sc.nextLine();
            } catch (Exception e) {
                e.getMessage();
            }
            finally {
                sc.close();
            }
        }
    }

    public void menuInfraestructura() {
        Scanner sc = new Scanner(System.in);
        boolean volver = false;

        while (volver == false) {
            try {
                System.out.println("¿En que nos enfocamos?\n" + "1. Registrar Sede. \n" +
                        "2. Registrar Estadio a Sede. \n" + "3. Volver.");
                int eleccionusuario = scannear.numValido(sc, 1, 3);

                switch(eleccionusuario) {
                    case 1: Sede sede = scannear.registrarSede();
                        mundial.agregarSede(sede);
                        System.out.println("Sede agregada correctamente.");
                        break;
                    case 2:
                        if (mundial.getSedes().isEmpty()) {
                            System.out.println("Parece que aún no se registraron sedes, vuelva a intentarlo.");
                            return;
                        }

                        scannear.listarSedes(mundial);
                        System.out.println("Ingrese el número de Sede que le desea añadir un Estadio: ");
                        int eleccionUsuario = scannear.numValido(sc, 1, mundial.getSedes().size());
                        sc.nextLine();

                        int indice = eleccionUsuario - 1;
                        Sede sedeElegida = mundial.getSedes().get(indice);

                        Estadio estadio = scannear.registrarEstadio();
                        sedeElegida.agregarEstadio(estadio);
                        System.out.println("Estadio agregado correctamente.");
                        break;
                    case 3: volver = true; break;
                }

            }
            catch(InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un entero, intente nuevamente.");
                sc.nextLine();
            }
            catch(Exception e) {
                e.getMessage();
            }
            finally {
                sc.close();
            }

        }
    }

    private void menuDelegaciones() {
        Scanner sc = new Scanner(System.in);
        boolean volver = false;

        while (volver == false) {
            try {
                System.out.println("¿En que nos enfocamos?\n" + "1. Cargar Pais participante.\n" +
                        "2. Cargar Seleccion y su lista de jugadores.\n" + "3. Cargar Cuerpo Tecnico y Director Tecnico.\n" +
                        "4. Volver.");
                int eleccionUsuario = scannear.numValido(sc, 1, 4);

                switch (eleccionUsuario) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        volver = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    private void menuEventos() {
        ArrayList<Partido> todosPartidos = obtenerTodosLosPartidos();
        if (todosPartidos.isEmpty()) { System.out.println("No hay partidos planificados."); return; }
       // scannear.ingresarEventosPartido(todosPartidos);
    }

    private void menuInformes() {
        org.modelo.logica.Informes informes = new org.modelo.logica.Informes();
        Scanner sc = new Scanner(System.in);
        boolean volver = false;

        while (!volver) {
            System.out.println("\n-- INFORMES --\n" +
                    "1. Tabla de posiciones por Grupo\n" +
                    "2. Resultados por Selección\n" +
                    "3. Ranking de Goleadores\n" +
                    "4. Informe Disciplinario por Selección\n" +
                    "5. Informe Disciplinario por Jugador\n" +
                    "6. Ficha Técnica de Partido\n" +
                    "7. Estadísticas por Estadio\n" +
                    "8. Estadísticas por Ciudad\n" +
                    "9. Volver");
            int op = scannear.numValido(sc,1, 9);

            switch (op) {
                case 1:
                    if (grupos.isEmpty()) { System.out.println("No hay grupos."); break; }
                    for (int i = 0; i < grupos.size(); i++)
                        System.out.println((i+1) + ". Grupo " + grupos.get(i).getIdentificacion());
                    int gIdx = scannear.numValido(sc,1, grupos.size()) - 1;
                    informes.tablaPosicionesPorGrupo(grupos.get(gIdx));
                    break;
                case 2:
                    if (paises.isEmpty()) { System.out.println("No hay países."); break; }
                    scannear.listarPaises(paises);
                    Seleccion s2 = paises.get(scannear.numValido(sc,1, paises.size()) - 1).getSeleccion();
                    if (s2 == null) { System.out.println("Sin selección."); break; }
                    informes.resultadosPorSeleccion(s2);
                    break;
                case 3:
                    informes.rankingGoleadores(obtenerTodasLasSelecciones());
                    break;
                case 4:
                    informes.informeDisciplinarioPorSeleccion(obtenerTodasLasSelecciones());
                    break;
                case 5:
                    if (paises.isEmpty()) { System.out.println("No hay países."); break; }
                    scannear.listarPaises(paises);
                    Seleccion s5 = paises.get(scannear.numValido(sc,1, paises.size()) - 1).getSeleccion();
                    if (s5 == null || s5.getJugadores().isEmpty()) { System.out.println("Sin jugadores."); break; }
                    for (int i = 0; i < s5.getJugadores().size(); i++)
                        System.out.println((i+1) + ". " + s5.getJugadores().get(i).getNombre());
                    Jugador j5 = s5.getJugadores().get(scannear.numValido(sc,1, s5.getJugadores().size()) - 1);
                    informes.informeDisciplinarioPorJugador(j5, s5);
                    break;
                case 6:
                    ArrayList<Partido> partidos = obtenerTodosLosPartidos();
                    if (partidos.isEmpty()) { System.out.println("No hay partidos."); break; }
                    for (int i = 0; i < partidos.size(); i++)
                        System.out.println((i+1) + ". " + partidos.get(i).getFecha() + " - " +
                                partidos.get(i).getParticipacion()[0].getSelecciones().getNombreFederacion() + " vs " +
                                partidos.get(i).getParticipacion()[1].getSelecciones().getNombreFederacion());
                    informes.fichaTecnicaPartido(partidos.get(scannear.numValido(sc,1, partidos.size()) - 1));
                    break;
                case 7:
                    ArrayList<Estadio> estadios = obtenerTodosLosEstadios();
                    if (estadios.isEmpty()) { System.out.println("No hay estadios."); break; }
                    for (int i = 0; i < estadios.size(); i++)
                        System.out.println((i+1) + ". " + estadios.get(i).getNombre());
                    informes.estadisticasPorEstadio(estadios.get(scannear.numValido(sc,1, estadios.size()) - 1));
                    break;
                case 8:
                    System.out.println("Ingrese ciudad: ");
                    informes.estadisticasPorCiudad(sc.nextLine(), mundial);
                    break;
                case 9:
                    volver = true;
                    break;
            }
        }
    }

    private ArrayList<Partido> obtenerTodosLosPartidos() {
        ArrayList<Partido> todos = new ArrayList<Partido>();
        for (Sede s : mundial.getSedes())
            for (Estadio e : s.getEstadios())
                todos.addAll(e.getPartidos());
        return todos;
    }

    private ArrayList<Estadio> obtenerTodosLosEstadios() {
        ArrayList<Estadio> estadios = new ArrayList<Estadio>();
        for (Sede s : mundial.getSedes())
            estadios.addAll(s.getEstadios());
        return estadios;
    }

    private ArrayList<Seleccion> obtenerTodasLasSelecciones() {
        ArrayList<Seleccion> sels = new ArrayList<Seleccion>();
        for (Pais p : paises)
            if (p.getSeleccion() != null) sels.add(p.getSeleccion());
        return sels;
    }

}