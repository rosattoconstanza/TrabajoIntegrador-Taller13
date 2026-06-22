package org.modelo.vista;
import org.modelo.domain.*;
import org.modelo.logica.*;
import java.util.*;

/**
 * Clase Aplicacion.
 * Controla el flujo principal del sistema mediante menús por consola.
 * Coordina las llamadas a Scannear (para la carga de datos) e Informes
 * (para la generación de los reportes), y mantiene las listas globales
 * de países, fases, grupos y árbitros del Mundial.
 *
 * @author Rosatto Constanza, Rougier Valentina, Alegre Juan
 * @version 1.5
 */
public class Aplicacion {
    private Scannear scannear;
    private Mundial mundial;
    private ArrayList<Pais> paises;
    private ArrayList<Fase> fases;
    private ArrayList<Grupo> grupos;
    private ArrayList<Arbitro> arbitros;

    /**
     * Constructor de la clase Aplicacion.
     * Inicializa el objeto Scannear y todas las listas globales del sistema.
     */
    Aplicacion() {
        this.scannear = new Scannear();
        this.paises = new ArrayList<Pais>();
        this.fases = new ArrayList<Fase>();
        this.grupos = new ArrayList<Grupo>();
        this.arbitros = new ArrayList<Arbitro>();
    }


    /**
     * Punto de entrada del sistema desde Main.
     * Inicializa el Mundial pidiendo sus datos por consola
     * y lanza el menú principal.
     */
    public void ejecutar() {
        this.mundial = scannear.inicializarMundial();
        System.out.println("El Mundial se creo correctamente, muchas gracias.");
        menuPrincipal();
    }

    /**
     * Muestra el menú principal del sistema y redirige a cada submenú
     * según la opción elegida por el usuario.
     */
    private void menuPrincipal() {
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("-------------------------------------------");
                System.out.println("¡Bienvenido a la organización del Mundial de fútbol " + mundial.getAnio() + "! ¿Que desea hacer?:\n" +
                        "1. Gestión de Infraestructura.\n" + "2. Administración de Delegaciones.\n" +
                        "3.Organización Deportiva.\n" + "4.Registro de Eventos de Campo.\n" + "5.Informes.\n" + "6. Salir.");
                int eleccionUsuario = Scannear.numValido(1, 6);
                switch (eleccionUsuario) {
                    case 1:
                        menuInfraestructura();
                        break;
                    case 2:
                        menuDelegaciones();
                        break;
                    case 3:
                        menuOrganizacion();
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
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Submenú de Gestión de Infraestructura.
     * Permite registrar Sedes y agregar Estadios a una Sede existente.
     */
    public void menuInfraestructura() {
        boolean volver = false;

        while (!volver) {
            try {
                System.out.println("--------------------------------------");
                System.out.println("¿En que nos enfocamos?\n" + "1. Registrar Sede. \n" +
                        "2. Registrar Estadio a Sede. \n" + "3. Volver.");
                int eleccionusuario = Scannear.numValido(1, 3);

                switch (eleccionusuario) {
                    case 1:
                        Sede sede = scannear.registrarSede();
                        mundial.agregarSede(sede);
                        System.out.println("Sede agregada correctamente.");
                        break;
                    case 2:
                        if (mundial.getSedes().isEmpty()) {
                            System.out.println("Parece que aún no se registraron sedes, vuelva a intentarlo.");
                            break;
                        }

                        scannear.listarSedes(mundial);
                        System.out.println("Ingrese el número de Sede que le desea añadir un Estadio: ");
                        int eleccionUsuario = Scannear.numValido(1, mundial.getSedes().size());

                        int indice = eleccionUsuario - 1;
                        Sede sedeElegida = mundial.getSedes().get(indice);

                        Estadio estadio = scannear.registrarEstadio();
                        sedeElegida.agregarEstadio(estadio);
                        System.out.println("Estadio agregado correctamente.");
                        break;
                    case 3:
                        volver = true;
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un entero, intente nuevamente.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Submenú de Administración de Delegaciones.
     * Permite cargar Países, Selecciones con sus jugadores,
     * y el Cuerpo Técnico junto al Director Técnico de cada selección.
     */
    private void menuDelegaciones() {
        boolean volver = false;

        while (!volver) {
            try {
                System.out.println("--------------------------------------------");
                System.out.println("¿En que nos enfocamos?\n" + "1. Cargar Pais participante.\n" +
                        "2. Cargar Seleccion y su lista de jugadores.\n" + "3. Cargar Cuerpo Tecnico y Director Tecnico.\n" +
                        "4. Volver.");
                int eleccionUsuario = Scannear.numValido(1, 4);

                switch (eleccionUsuario) {
                    case 1:
                        Pais pais = scannear.cargarPais();
                        paises.add(pais);
                        if (!mundial.getSedes().isEmpty()) {
                            System.out.println("El pais se cargó correctamente, ahora debemos asignarle una sede," +
                                    " ingrese el numero correspondiente...");
                            scannear.listarSedes(mundial);
                            int indice = (Scannear.numValido(1, mundial.getSedes().size())) - 1;
                            Sede sedeElegida = mundial.getSedes().get(indice);
                            sedeElegida.setPais(pais);
                            pais.agregarSede(sedeElegida);
                            System.out.println("País asignado a la sede correctamente.");
                        }
                        break;
                    case 2:
                        if (paises.isEmpty()) {
                            System.out.println("Porfavor, cargue primero un país.");
                            break;
                        }
                        System.out.println("Ingrese el numero del pais de la seleccion que desea cargar, porfavor.");
                        Scannear.listarPaises(paises);
                        int indice2 = (Scannear.numValido(1, paises.size())) - 1;
                        Pais paisSel = paises.get(indice2);

                        if (paisSel.getSeleccion() != null) {
                            System.out.println("Ya tiene selección asignada.");
                            break;
                        }
                        Seleccion seleccion = scannear.cargarSeleccionYJugadores(paisSel);
                        System.out.println("La seleccion junto a sus jugadores se cargaron correctamente.");
                        break;
                    case 3:
                        if (paises.isEmpty()) {
                            System.out.println("Cargue primero un país.");
                            break;
                        }

                        System.out.println("Ingrese el numero del pais al que le desea cargar sus directores" +
                                " y cuerpos tecnicos de su respectiva seleccion, porfavor.");
                        Scannear.listarPaises(paises);
                        int indice3 = (Scannear.numValido(1, paises.size())) - 1;
                        Pais paisDT = paises.get(indice3);
                        if (paisDT.getSeleccion() == null) {
                            System.out.println("Ese país no tiene selección.");
                            break;
                        }
                        ArrayList<DirectorTecnico> DTs = scannear.cargarDirectores();
                        paisDT.getSeleccion().setDirectoresTecnicos(DTs);
                        System.out.println("Todos sus Directores Técnicos fueron cargados correctamente...continuemos");

                        ArrayList<CuerpoTecnico> CTs = scannear.cargarCuerpos();
                        paisDT.getSeleccion().setCuerposTecnicos(CTs);
                        System.out.println("Todo su Cuerpo Técnico se cargo correctamente.");
                        break;
                    case 4:
                        volver = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Submenú de Organización Deportiva.
     * Permite configurar Fases, Grupos, registrar Árbitros del torneo
     * y planificar Partidos.
     */
    private void menuOrganizacion() {
        boolean volver = false;

        while (!volver) {
            try {
                System.out.println("-------------------------------------------------");
                System.out.println("¿En qué nos enfocamos?\n" + "1. Configurar Fases \n" +
                        "2. Configurar Grupo\n" + "3. Registrar Árbitros del Torneo\n" +
                        "4. Planificar Partido\n" + "5. Volver al Menú Principal");
                int eleccionUsuario = Scannear.numValido(1, 5);
                switch (eleccionUsuario) {
                    case 1:
                        Fase nuevaFase = scannear.configurarFases();
                        if (nuevaFase != null) {
                            fases.add(nuevaFase); // La guardamos en lista global
                        }
                        break;
                    case 2:
                        if (fases.isEmpty()) {
                            System.out.println("Primero debe crear al menos una Fase.");
                            break;
                        }
                        if (paises.isEmpty()) {
                            System.out.println("No se pueden armar grupos si no hay países cargados");
                            break;
                        }
                        // qué fase vincular este grupo
                        System.out.println("¿A qué fase pertenece este grupo?:");
                        for (int i = 0; i < fases.size(); i++) {
                            System.out.println((i + 1) + ". " + fases.get(i).getNombre());
                        }
                        int indiceFase = Scannear.numValido(1, fases.size()) - 1;
                        Fase faseElegida = fases.get(indiceFase);

                        if (faseElegida.getNombre() != NombreFase.Grupos) {
                            System.out.println("Los grupos solo pueden crearse dentro de la Fase de Grupos.");
                            break;
                        }

                        Grupo nuevoGrupo = scannear.configurarGrupo(paises, faseElegida);
                        if (nuevoGrupo != null) {
                            grupos.add(nuevoGrupo);
                            faseElegida.agregarGrupos(nuevoGrupo);
                        }
                        break;
                    case 3:
                        Arbitro nuevoArbitro = scannear.crearArbitro(paises);
                        if (nuevoArbitro != null) {
                            arbitros.add(nuevoArbitro); // Lo guardás en tu lista global
                            System.out.println("Árbitro registrado con éxito.");
                        }
                        break;
                    case 4:
                        ArrayList<Estadio> estadiosDisponibles = obtenerTodosLosEstadios();
                        if (estadiosDisponibles.isEmpty()) {
                            System.out.println("No hay estadios cargados en el Mundial todavía (Cárguelos en Infraestructura).");
                            break;
                        }
                        Partido nuevoPartido = scannear.planificarPartido(fases, grupos, paises, estadiosDisponibles, arbitros);
                        if (nuevoPartido != null) {
                            System.out.println("Partido registrado y vinculado al sistema.");
                        }
                        break;
                    case 5:
                        volver = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error en el menú de organización: " + e.getMessage());
            }
        }
    }

    /**
    * Submenú de Registro de Eventos de Campo.
    * Permite seleccionar un partido ya planificado y registrarle
    * un evento (gol, tarjeta, etc.) ocurrido durante el encuentro.
    */
    private void menuEventos () {
        System.out.println("\n-- REGISTRAR EVENTOS DE PARTIDO --");
        ArrayList<Partido> partidos = obtenerTodosLosPartidos();
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos planificados en el sistema.");
            return;
        }

        try {
            // 2. Listamos los partidos usando exactamente la misma lógica que Juani usó en el Caso 6
            for (int i = 0; i < partidos.size(); i++) {
                System.out.println((i + 1) + ". " + partidos.get(i).getFecha() + " - " +
                        partidos.get(i).getParticipacion()[0].getSelecciones().getNombreFederacion() +
                        " vs " +
                        partidos.get(i).getParticipacion()[1].getSelecciones().getNombreFederacion());
            }

            System.out.print("Seleccione el número de partido para registrar el evento: ");
            int pIdx = Scannear.numValido(1, partidos.size()) - 1;

            Partido partidoSeleccionado = partidos.get(pIdx);
            Evento nuevoEvento = scannear.registrarEventoCampo(partidoSeleccionado);

            if (nuevoEvento != null) {
                System.out.println("El evento se acopló con éxito a la simulación del partido.");
            }

        } catch (NullPointerException e) {
            System.out.println("No se pudo procesar el partido. Verifique que los equipos tengan nombres y jugadores cargados.");
        } catch (Exception e) {
            System.out.println("Ocurrió un fallo inesperado: " + e.getMessage());
        }
    }

    /**
     * Submenú de Informes.
     * Permite acceder a los 6 informes del sistema: tabla de posiciones,
     * resultados por selección, ranking de goleadores, informe disciplinario
     * (por selección y por jugador), ficha técnica de partido y estadísticas
     * de sedes (por estadio y por ciudad).
     */
    private void menuInformes () {
                Informes informes = new Informes();
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
                    int op = Scannear.numValido(1, 9);

                    switch (op) {
                        case 1:
                            if (grupos.isEmpty()) {
                                System.out.println("No hay grupos.");
                                break;
                            }
                            for (int i = 0; i < grupos.size(); i++)
                                System.out.println((i + 1) + ". Grupo " + grupos.get(i).getIdentificacion());
                            int gIdx = Scannear.numValido(1, grupos.size()) - 1;
                            informes.tablaPosicionesPorGrupo(grupos.get(gIdx));
                            break;
                        case 2:
                            if (paises.isEmpty()) {
                                System.out.println("No hay países.");
                                break;
                            }
                            Scannear.listarPaises(paises);
                            Seleccion s2 = paises.get(Scannear.numValido(1, paises.size()) - 1).getSeleccion();
                            if (s2 == null) {
                                System.out.println("Sin selección.");
                                break;
                            }
                            informes.resultadosPorSeleccion(s2);
                            break;
                        case 3:
                            informes.rankingGoleadores(obtenerTodasLasSelecciones());
                            break;
                        case 4:
                            informes.informeDisciplinarioPorSeleccion(obtenerTodasLasSelecciones());
                            break;
                        case 5:
                            if (paises.isEmpty()) {
                                System.out.println("No hay países.");
                                break;
                            }
                            Scannear.listarPaises(paises);
                            Seleccion s5 = paises.get(Scannear.numValido(1, paises.size()) - 1).getSeleccion();
                            if (s5 == null || s5.getJugadores().isEmpty()) {
                                System.out.println("Sin jugadores.");
                                break;
                            }
                            for (int i = 0; i < s5.getJugadores().size(); i++)
                                System.out.println((i + 1) + ". " + s5.getJugadores().get(i).getNombre());
                            Jugador j5 = s5.getJugadores().get(Scannear.numValido(1, s5.getJugadores().size()) - 1);
                            informes.informeDisciplinarioPorJugador(j5, s5);
                            break;
                        case 6:
                            ArrayList<Partido> partidos = obtenerTodosLosPartidos();
                            if (partidos.isEmpty()) {
                                System.out.println("No hay partidos.");
                                break;
                            }
                            for (int i = 0; i < partidos.size(); i++)
                                System.out.println((i + 1) + ". " + partidos.get(i).getFecha() + " - " +
                                        partidos.get(i).getParticipacion()[0].getSelecciones().getNombreFederacion() +
                                        " vs " +
                                        partidos.get(i).getParticipacion()[1].getSelecciones().getNombreFederacion());
                            informes.fichaTecnicaPartido(partidos.get(Scannear.numValido(1, partidos.size()) - 1));
                            break;
                        case 7:
                            ArrayList<Estadio> estadios = obtenerTodosLosEstadios();
                            if (estadios.isEmpty()) {
                                System.out.println("No hay estadios.");
                                break;
                            }
                            for (int i = 0; i < estadios.size(); i++)
                                System.out.println((i + 1) + ". " + estadios.get(i).getNombre());
                            informes.estadisticasPorEstadio(estadios.get(Scannear.numValido(1, estadios.size()) - 1));
                            break;
                        case 8:
                            System.out.print("Ingrese ciudad: ");
                            String ciudad = new Scanner(System.in).nextLine();
                            informes.estadisticasPorCiudad(ciudad, mundial);
                            break;
                        case 9: volver = true; break;
                    }
                }
    }

    //------------------------------------------------------------------------------

    /**
     * Recorre todas las sedes y estadios del Mundial y devuelve
     * todos los partidos planificados hasta el momento.
     *
     * @return lista con todos los partidos del Mundial
     */
    private ArrayList<Partido> obtenerTodosLosPartidos () {
        ArrayList<Partido> todos = new ArrayList<Partido>();
        for (Sede s : mundial.getSedes())
            for (Estadio e : s.getEstadios())
                todos.addAll(e.getPartidos());
        return todos;
    }

    /**
     * Recorre todas las sedes del Mundial y devuelve todos los estadios
     * registrados hasta el momento.
     *
     * @return lista con todos los estadios del Mundial
     */
    private ArrayList<Estadio> obtenerTodosLosEstadios () {
        ArrayList<Estadio> estadios = new ArrayList<Estadio>();
        for (Sede s : mundial.getSedes())
            estadios.addAll(s.getEstadios());
        return estadios;
    }

    /**
     * Recorre la lista de países y devuelve las selecciones
     * que tienen asignada (descarta los países sin selección).
     *
     * @return lista con todas las selecciones del Mundial
     */
    private ArrayList<Seleccion> obtenerTodasLasSelecciones () {
        ArrayList<Seleccion> sels = new ArrayList<Seleccion>();
        for (Pais p : paises)
            if (p.getSeleccion() != null) sels.add(p.getSeleccion());
        return sels;
    }
}