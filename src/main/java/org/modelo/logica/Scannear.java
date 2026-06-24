package org.modelo.logica;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.modelo.domain.*;

/**
 * Clase Scannear.
 * Centraliza toda la carga de datos del sistema a través de la consola (Scanner).
 * Cada método crea y retorna el objeto correspondiente, dejando que la clase
 * Aplicacion se encargue de guardarlo en las listas globales del sistema.
 *
 * @author Rosatto Constanza, Rougier Valentina, Alegre Juan
 * @version 1.4
 */
public class Scannear {
    /**
     * Solicita por consola los datos iniciales del Mundial (año, mascota,
     * fecha de inicio y fecha de finalización) y crea el objeto Mundial.
     *
     * @return Mundial creado con los datos ingresados
     */
    public Mundial inicializarMundial() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;
        Mundial mundial = null;

        while (!excepcion) {
            try {
                System.out.println("----ORGANICEMOS EL MUNDIAL----");
                System.out.println("Para comenzar, necesitamos datos iniciales: ");
                System.out.println("Ingrese Año: ");
                int anio = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese la mascota: ");
                String mascota = sc.nextLine();
                System.out.println("Ingrese fecha de inicio (ddmmaa): ");
                int fechaInicio = sc.nextInt();
                System.out.println("Ingrese fecha de finalización (ddmmaa): ");
                int fechaFinal = sc.nextInt();

                mundial = new Mundial(anio, mascota, fechaInicio, fechaFinal);
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se ingresó un " +
                        "texto que debería ser un entero, intente nuevamente.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return mundial;
    }


    /**
     * Solicita por consola el nombre de la fase a crear (de la lista de
     * NombreFase) y crea el objeto Fase correspondiente.
     *
     * @return Fase creada
     */
    public Fase configurarFases(ArrayList<Fase> fases) {
        Scanner sc = new Scanner(System.in);
        Fase fase = null;
        boolean excepcion = false;

        while (!excepcion) {
            try {
                NombreFase[] nombres = NombreFase.values();

                System.out.println("Fases disponibles:");
                for (int i = 0; i < nombres.length; i++) {
                    System.out.println((i + 1) + " - " + nombres[i]);
                }
                System.out.println("Elija el número de la Fase a crear:");
                int indice = numValido(1, nombres.length) - 1;

                NombreFase faseElegida = nombres[indice];

                // Verificar si la fase ya existe
                boolean existe = false;
                for (Fase f : fases) {
                    if (f.getNombre() == faseElegida) {
                        existe = true;
                        break;
                    }
                }
                if (existe) {
                    System.out.println("La fase " + faseElegida + " ya fue creada.");
                    System.out.println("Seleccione una fase diferente.");
                    continue; // vuelve al inicio del while
                }

                fase = new Fase(faseElegida, new ArrayList<Partido>(), new ArrayList<Grupo>());
                System.out.println("Fase creada correctamente.");
                excepcion = true;

            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que no ingresó un número. Intente nuevamente.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado.");
            }
        }
        return fase;
    }

    /**
     * Solicita por consola los datos de un Grupo y le asigna selecciones
     * a partir de los países ya registrados que tengan selección cargada.
     *
     * @param paises lista de países registrados, para elegir sus selecciones
     * @param fase fase a la que pertenece el grupo
     *
     * @return Grupo creado con sus selecciones asignadas
     */
    public Grupo configurarGrupo(ArrayList<Pais> paises, Fase fase) {
    Scanner sc = new Scanner(System.in);
    Grupo grupo = null;

    boolean excepcion = false;

    while (!excepcion) {
        try {
            System.out.println("Identificación:");
            String identificacion = sc.nextLine();

            System.out.println("Descripción:");
            String descripcion = sc.nextLine();

            grupo = new Grupo(identificacion, descripcion, fase, new ArrayList<Seleccion>());

            System.out.print("¿Cuántas selecciones desea agregar a este grupo?: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < cantidad; i++) {
                listarPaises(paises);
                System.out.print("Seleccione el número de País cuya selección quiere agregar: ");
                int indice = numValido(1, paises.size()) - 1;
                Pais pais = paises.get(indice);

                if (pais.getSeleccion() == null) {
                    System.out.println("Este país no tiene selección cargada, saltando...");
                    continue;
                }

                grupo.agregarSeleccion(pais.getSeleccion());
                pais.getSeleccion().setGrupo(grupo);
                System.out.println(pais.getSeleccion().getNombreFederacion() + " agregada al grupo.");
            }

            System.out.println("Grupo " + identificacion + " creado correctamente.");
            excepcion = true;

        } catch (InputMismatchException e) {
            System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
            sc.nextLine();
        }
        catch (Exception e) {
            System.out.println("Ocurrió un error inesperado.");
        }
    }
    return grupo;
}

    /**
     * Solicita por consola todos los datos necesarios para planificar un partido:
     * fase, selecciones (local y visitante), fecha, horario, duración, estadio
     * y equipo de arbitraje. Garantiza que el partido tenga asignado al menos
     * un árbitro con rol Principal antes de guardarlo.
     *
     * @param fases lista de fases disponibles
     * @param grupos lista de grupos disponibles
     * @param paises lista de países disponibles (para selecciones en fases eliminatorias)
     * @param estadios lista de estadios disponibles
     * @param arbitros lista de árbitros disponibles
     *
     * @return Partido creado con sus participaciones y arbitraje asignados
     */
    public Partido planificarPartido(ArrayList<Fase> fases, ArrayList<Grupo> grupos, ArrayList<Pais> paises, ArrayList<Estadio> estadios, ArrayList<Arbitro> arbitros) {
    Scanner sc = new Scanner(System.in);
    Partido partido = null;
    boolean excepcion = false;

    while (!excepcion) {
        try {
            // Selección de Fase
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

            NombreFase faseAnterior = obtenerFaseAnterior(faseSeleccionada.getNombre());

            if (!puedePlanificarFase(fases, faseSeleccionada.getNombre())) {
                System.out.println("No se puede planificar la fase " + faseSeleccionada.getNombre()
                        + ". Primero debe planificar la fase " + faseAnterior + ".");
                continue;
            }

            Seleccion local = null;
            Seleccion visitante = null;

            if (grupos.isEmpty()) {
                System.out.println("No hay grupos configurados. Debe configurar grupos antes de planificar partidos.");
                return null;
            }
            //Selección de Equipos (si es Fase de Grupos o Eliminatoria)
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

                if (grupoSeleccionado.getSeleccion().isEmpty()) {
                    System.out.println("El grupo no tiene selecciones asignadas. Debe configurarlas primero.");
                    return null;
                }

                if (grupoSeleccionado.getSeleccion().size() < 2) {
                    System.out.println("Deben existir al menos dos selecciones en el grupo para poder planificar un partido.");
                    return null;
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
                boolean haySelecciones = false;
                for (Pais p : paises) {
                    if (p.getSeleccion() != null) {
                        haySelecciones = true;
                        break;
                    }
                }
                if (!haySelecciones) {
                    System.out.println("No hay selecciones registradas. Debe cargarlas antes de planificar partidos.");
                    return null;
                }

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
                        if (p.getSeleccion().getNombreFederacion().equalsIgnoreCase(nombreLocal)) {
                            local = p.getSeleccion();
                        }
                        if (p.getSeleccion().getNombreFederacion().equalsIgnoreCase(nombreVisitante)) {
                            visitante = p.getSeleccion();
                        }
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

            // 3. Datos del Partido
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
            sc.nextLine();

            // 4. Selección de Estadio (Listando los existentes)
            System.out.println("Estadios disponibles:");
            for (int i = 0; i < estadios.size(); i++) {
                System.out.println((i + 1) + ". " + estadios.get(i).getNombre() + " (Capacidad: " + estadios.get(i).getCapacidad() + ")");
            }
            System.out.println("Seleccione el NÚMERO del Estadio:");
            int indiceEstadio = sc.nextInt() - 1;
            sc.nextLine();

            if (indiceEstadio < 0 || indiceEstadio >= estadios.size()) {
                System.out.println("Error: Estadio inválido. Intente nuevamente.");
                continue;
            }
            Estadio estadioSeleccionado = estadios.get(indiceEstadio);

            // 5. Creación del Partido y Participaciones
            Participacion[] participaciones = new Participacion[2];
            participaciones[0] = new Participacion(true, local, null);
            participaciones[1] = new Participacion(false, visitante, null);

            partido = new Partido(fecha, hora, duracion, tiempoAdicional, estadioSeleccionado, faseSeleccionada, participaciones, new ArrayList<Arbitraje>());
            participaciones[0].setPartido(partido);
            participaciones[1].setPartido(partido);

            //Vinculamos cada Participacion a la lista de su Seleccion
            local.getParticipacion().add(participaciones[0]);
            visitante.getParticipacion().add(participaciones[1]);

            // 6. Asignación de Arbitros
            if (arbitros.isEmpty()) {
                System.out.println("No hay árbitros registrados. Debe cargar árbitros antes de planificar un partido.");
                return null;
            }
            boolean tienePrincipal = false;

            while (!tienePrincipal) {
                System.out.println("Cuántos árbitros tendrá este partido? (debe incluir al menos 1 Principal):");
                int cantidadArbitros = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < cantidadArbitros; i++) {
                    System.out.println("Árbitros registrados:");
                    for (int j = 0; j < arbitros.size(); j++) {
                        System.out.println((j + 1) + ". " + arbitros.get(j).getNombre());
                    }
                    System.out.println("Seleccione el NÚMERO del árbitro " + (i + 1) + ":");
                    int indiceArbitro = sc.nextInt() - 1;
                    sc.nextLine();

                    if (indiceArbitro < 0 || indiceArbitro >= arbitros.size()) {
                        System.out.println("Árbitro no válido. Se omite esta asignación.");
                        continue;
                    }
                    Arbitro arbitroSeleccionado = arbitros.get(indiceArbitro);

                    System.out.println("Roles disponibles:");
                    for (CategoriaArbitro opcion : CategoriaArbitro.values()) {
                        System.out.println("-" + opcion);
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

                        if (categoriaArbitro == CategoriaArbitro.Principal) {
                            tienePrincipal = true;
                        }
                    } else {
                        System.out.println("Rol no válido. No se asignó este árbitro.");
                    }
                }

                if (!tienePrincipal) {
                    System.out.println("El partido no puede guardarse sin un árbitro Principal.");
                    System.out.println("Vuelva a cargar el equipo de arbitraje.");
                    partido.getArbitraje().clear();
                } else {
                    System.out.println("Equipo arbitral cargado correctamente.");
                }
            }

            // 7. VINCULAR Y FINALIZAR
            faseSeleccionada.agregarPartidos(partido);
            estadioSeleccionado.agregarPartidos(partido);
            System.out.println("Partido planificado y guardado correctamente!");
            excepcion = true; // Corta el bucle while infinito e indica éxito
        }
        catch (InputMismatchException e) {
                System.out.println("Error. Se esperaba un número. Intente nuevamente.");
                sc.nextLine();
            }
        catch (Exception e) {
                System.out.println("Ocurrió un error inesperado.");
            }
    }
    // Cierra el while
    return partido;
}

    /**
     * Solicita por consola los datos de un Árbitro y lo asocia a un país
     * ya registrado en el sistema.
     *
     * @param paises lista de países registrados, para elegir el país del árbitro
     *
     * @return Arbitro creado, o null si no hay países registrados
     */
    public Arbitro crearArbitro(ArrayList<Pais> paises) {
    if (paises == null || paises.isEmpty()) {
        System.out.println("No hay países cargados en el sistema. Debe registrar al menos un país antes de crear un árbitro.");
        return null;
    }
    Scanner sc = new Scanner(System.in);
    System.out.println("Nombre del árbitro:");
    String nombreArbitro = sc.nextLine();

    System.out.println("Fecha de nacimiento del árbitro (Ej: 19800512):");
    int fechaNacimArbitro = sc.nextInt();
    sc.nextLine();

    System.out.println("Años de experiencia del árbitro:");
    int aniosExpeArbitro = sc.nextInt();
    sc.nextLine();

    Pais paisArbitro = null;

    while (paisArbitro == null) {
        System.out.println("\nPaíses disponibles:");
        for (Pais p : paises) {
            System.out.println("- " + p.getNombre());
        }

        System.out.println("Escriba el País del árbitro:");
        String pais = sc.nextLine();

        for (Pais p : paises) {
            if (p.getNombre().equalsIgnoreCase(pais)) {
                paisArbitro = p;
                break;
            }
        }
        if (paisArbitro == null) {
            System.out.println("País no encontrado. Escriba el nombre tal cual aparece en la lista.");
        }
    }

    return new Arbitro(nombreArbitro, fechaNacimArbitro, aniosExpeArbitro, paisArbitro);
}


    /**
     * Solicita por consola los datos de un Evento ocurrido durante un partido
     * (minuto, equipo, jugador y tipo de evento) y lo registra tanto en el
     * jugador involucrado como en el partido.
     *
     * @param partido partido en el que ocurre el evento
     *
     * @return Evento creado y registrado
     */
    public Evento registrarEventoCampo(Partido partido) {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;
        Evento nuevoEvento= null;

        while (!excepcion) {
            try {
                System.out.println("Minuto en que ocurrió el Evento:");
                int minuto = sc.nextInt();
                Seleccion local = partido.getParticipacion()[0].getSelecciones();
                Seleccion visitante = partido.getParticipacion()[1].getSelecciones();

                System.out.println("A qué equipo pertenece el evento?");
                System.out.println("1. " + local.getNombreFederacion());
                System.out.println("2. " + visitante.getNombreFederacion());
                int opcionEquipo = sc.nextInt(); //poner num valido
                sc.nextLine();

                Seleccion equipoSeleccionado = null;
                if (opcionEquipo == 1) {
                    equipoSeleccionado = local;
                } else {
                    equipoSeleccionado = visitante;
                }
                System.out.println("Jugadores de " + equipoSeleccionado.getNombreFederacion() + ":");
                ArrayList<Jugador> listaJugadores = equipoSeleccionado.getJugadores();
                for (int i = 0; i < listaJugadores.size(); i++) {
                    System.out.println((i + 1) + ".[" + listaJugadores.get(i).getDorsal() + "] " + listaJugadores.get(i).getNombre());
                }
                System.out.println("Seleccione el NÚMERO del jugador involucrado:");
                int indiceJugador = sc.nextInt() - 1; //num valido agregar
                sc.nextLine();
                Jugador jugadorInvolucrado = listaJugadores.get(indiceJugador);

                //Seleccionar Tipo de Evento
                for (TipoEvento tipo : TipoEvento.values()) {
                    System.out.println(tipo);
                }
                System.out.println("Seleccione el evento ocurrido:");
                String eventoSeleccionado = sc.nextLine();
                TipoEvento tipoElegido = null;

                for (TipoEvento tipo : TipoEvento.values()) {
                    if (tipo.name().equalsIgnoreCase(eventoSeleccionado)) {
                        tipoElegido = tipo;
                        break;
                    }
                }

                if (tipoElegido == null){
                    System.out.println("Tipo de evento no reconocido. Escriba el nombre tal cual aparece en la lista.");
                    continue;
                }

                nuevoEvento = new Evento(tipoElegido, minuto, jugadorInvolucrado);
                jugadorInvolucrado.agregarEvento(nuevoEvento);
                partido.getEventos().add(nuevoEvento);
                System.out.println("Evento registrado con éxito!");
                excepcion = true; // Esto rompe el bucle while

            } catch (InputMismatchException e) {
                System.out.println("Error. Se esperaba un número entero. Se reinicia la carga.");
                sc.nextLine();
            } catch (NullPointerException e) {
                System.out.println("Error. Faltan datos estructurales.");
            } catch (Exception e) {
                System.out.println("Error Desconocido: " + e.getMessage());
            }
        }
        return nuevoEvento;
    }


    /**
     * Solicita por consola los datos de una Sede (ciudad, altura sobre el
     * nivel del mar, clima y zona horaria) y crea el objeto correspondiente.
     *
     * @return Sede creada
     */
    public Sede registrarSede() {
        Scanner sc = new Scanner(System.in);
        Sede sede = null;
        boolean excepcion = false;

        while (!excepcion) {
            try {
                System.out.println("Ingrese la ciudad de la Sede: ");
                String ciudad = sc.nextLine();

                System.out.println("Ingrese la altura al nivel del mar de la Sede: ");
                float alturaNivelMar = sc.nextFloat();
                sc.nextLine();

                System.out.println("Ingrese el clima de la Sede: ");
                String clima = sc.nextLine();

                System.out.println("Ingrese la zona horaria de la Sede: ");
                String zonaHoraria = sc.nextLine();

                sede = new Sede(ciudad, alturaNivelMar, clima, zonaHoraria);
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }

        return sede;
    }

    /**
     * Solicita por consola los datos de un Estadio (nombre y capacidad)
     * y crea el objeto correspondiente.
     *
     * @return Estadio creado
     */
    public Estadio registrarEstadio() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;
        Estadio estadio = null;

        while (!excepcion) {
            try {
                System.out.println("Nombre del Estadio: ");
                String nombreEstadio = sc.nextLine();
                System.out.println("Capacidad del Estadio (Solo numero): ");
                int capacidadEstadio = sc.nextInt();
                sc.nextLine();

                estadio = new Estadio(nombreEstadio, capacidadEstadio);
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
        return estadio;
    }


    /**
     * Solicita por consola los datos de un País (nombre y bandera)
     * y crea el objeto correspondiente.
     *
     * @return Pais creado
     */
    public Pais cargarPais() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del país: ");
        String nombre = sc.nextLine();
        System.out.print("Bandera (descripción): ");
        String bandera = sc.nextLine();

        return new Pais(nombre, bandera);
    }

    /**
     * Solicita por consola los datos de una Selección. A continuación,
     * solicita los datos de cada jugador y los agrega a la selección creada.
     *
     * @return Seleccion creada con sus jugadores cargados
     */
    public Seleccion cargarSeleccionYJugadores() {
        Scanner sc = new Scanner(System.in);
        Seleccion seleccion = null;
        boolean condicion = false;

        while(!condicion) {
            try {
                System.out.print("Nombre de la federación: ");
                String federacion = sc.nextLine();
                System.out.print("Camiseta principal: ");
                String camisetaPrincipal = sc.nextLine();
                System.out.print("Camiseta secundaria: ");
                String camisetaSecundaria = sc.nextLine();
                System.out.print("¿Es cabeza de grupo? (true/false): ");
                boolean cabezaGrupo = sc.nextBoolean();
                sc.nextLine();
                System.out.print("Ranking FIFA: ");
                int ranking = sc.nextInt();
                sc.nextLine();


                seleccion = new Seleccion(federacion, camisetaPrincipal, camisetaSecundaria, cabezaGrupo, ranking);
                System.out.println("Selección creada correctamente. Continuemos con los jugadores...");

                System.out.print("¿Cuántos jugadores desea añadir? (23 a 26 jugadores): ");
                int cantidad = numValido(23, 26);
                sc.nextLine();

                for (int i = 0; i < cantidad; i++) {
                    System.out.println("-- Jugador " + (i + 1) + " --");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Año de nacimiento: ");
                    int nacimiento = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Dorsal: ");
                    int dorsal = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Peso (kg): ");
                    float peso = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Altura (cm): ");
                    float altura = sc.nextFloat();
                    sc.nextLine();

                    // Elegir posición mostrando opciones numeradas
                    Posicion posicion = elegirPosicion();

                    Jugador jugador = new Jugador(nombre, nacimiento, dorsal, posicion, peso, altura);
                    seleccion.agregarJugador(jugador);
                    System.out.println("Jugador " + (i + 1) + " agregado correctamente.");

                }
                condicion = true;

            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se ingresó un dato que no corresponde, intente nuevamente.");
                sc.nextLine();
            }
            catch (Exception e) {
                System.out.println("Ocurrió un error inesperado:" + e.getMessage());
            }
        }

        return seleccion;
    }

    /**
     * Solicita por consola la cantidad de Directores Técnicos a cargar
     * y los datos de cada uno.
     *
     * @return lista de Directores Técnicos creados
     */
    public ArrayList<DirectorTecnico> cargarDirectores() {
        Scanner sc = new Scanner(System.in);
        ArrayList<DirectorTecnico> directores = new ArrayList<DirectorTecnico>();
        boolean salir = false;

        while(!salir) {
            try {
                System.out.print("¿Cuántos Directores Técnicos desea añadir?: ");
                int cantidadDT = sc.nextInt();
                sc.nextLine();

                if (cantidadDT <= 0) {
                    throw new NumNegativoException("Parece que ingresaste un numero negativo o cero, pruebe nuevamente.");
                }

                for (int i = 0; i < cantidadDT; i++) {
                    System.out.println("-- Director Técnico " + (i + 1) + " --");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Año de nacimiento: ");
                    int nacimiento = sc.nextInt(); sc.nextLine();
                    System.out.print("Año de nombramiento: ");
                    int nombramiento = sc.nextInt(); sc.nextLine();

                    DirectorTecnico dt = new DirectorTecnico(nombre, nacimiento, nombramiento);
                    directores.add(dt);
                    System.out.println("Director Técnico " + (i + 1) + " agregado correctamente.");
                }

                salir = true;
            } catch(InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se ingresó un dato que no corresponde, intente nuevamente.");
                sc.nextLine();
            } catch (NumNegativoException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Ocurrió un error inesperado:" + e.getMessage()); //menssje
            }
        }

        return directores;
    }

    /**
     * Solicita por consola la cantidad de integrantes del Cuerpo Técnico
     * a cargar y los datos de cada uno, incluyendo su rol.
     *
     * @return lista de integrantes del Cuerpo Técnico creados
     */
    public ArrayList<CuerpoTecnico> cargarCuerpos() {
        Scanner sc = new Scanner(System.in);
        ArrayList<CuerpoTecnico> cuerposT = new ArrayList<CuerpoTecnico>();
        boolean salir = false;

        while (!salir) {
            try {
                System.out.print("¿Cuántos integrantes del Cuerpo Técnico desea añadir?: ");
                int cantidadCT = sc.nextInt();
                sc.nextLine();

                if (cantidadCT <= 0) {
                    throw new NumNegativoException("Parece que ingresaste un numero negativo o cero, pruebe nuevamente.");
                }

                for (int i = 0; i < cantidadCT; i++) {
                    System.out.println("-- Cuerpo Técnico " + (i + 1) + " --");
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Año de nacimiento: ");
                    int nacimiento = sc.nextInt();
                    sc.nextLine();

                    // Elegir rol
                    Rol rol = elegirRol();

                    CuerpoTecnico ct = new CuerpoTecnico(nombre, nacimiento, rol);
                    cuerposT.add(ct);
                    System.out.println("Integrante del Cuerpo Técnico " + (i + 1) + " agregado correctamente.");
                }

                salir = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se ingresó un dato que no corresponde, intente nuevamente.");
                sc.nextLine();
            } catch (NumNegativoException e) {
                System.out.println(e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Ocurrió un error inesperado:" + e.getMessage());
            }
        }

        return cuerposT;
    }


    //---------------------------------------------------------------------------
    /**
     * Solicita por consola un número entero dentro de un rango válido,
     * repitiendo la solicitud hasta que el valor ingresado sea correcto.
     *
     * @param min valor mínimo aceptado (inclusive)
     * @param max valor máximo aceptado (inclusive)
     *
     * @return número entero válido ingresado por el usuario
     */
    public static int numValido (int min, int max) {
            Scanner sc = new Scanner(System.in);
            int op;

            do {
                System.out.print("Ingrese una opción válida: ");
                op = sc.nextInt();

                if (op < min || op > max) {
                    System.out.println("Opción inválida.");
                }

            } while (op < min || op > max);

            return op;
        }

    /**
     * Imprime por consola todas las sedes registradas en el Mundial,
     * junto con los estadios de cada una.
     *
     * @param mundial Mundial del que se obtienen las sedes
     */
    public void listarSedes(Mundial mundial) {
        System.out.println("Sedes registradas:\n");
        int i = 1;
        for (Sede s : mundial.getSedes()) {
            System.out.println(i++ + ". " + s);
            for (Estadio e : s.getEstadios()) {
                System.out.println("Estadio -> " + e);
            }
        }
    }

    /**
     * Imprime por consola todos los países registrados, indicando
     * el nombre de su selección si tiene una asignada.
     *
     * @param paises lista de países a mostrar
     */
    public static void listarPaises (ArrayList<Pais> paises) {
        System.out.println("Países registrados:\n");
        for (int i = 0; i < paises.size(); i++) {
            Pais p = paises.get(i);
            String sel = "Sin selección";
            if (p.getSeleccion() != null) {
                sel = p.getSeleccion().getNombreFederacion();
            }
            System.out.println((i + 1) + ". " + p + " | Seleccion -> " + sel);
        }
    }

    /**
     * Muestra por consola las posiciones disponibles (enum Posicion)
     * y retorna la elegida por el usuario.
     *
     * @return Posición elegida
     */
    private Posicion elegirPosicion() {
        Posicion[] posiciones = Posicion.values();
        for (int i = 0; i < posiciones.length; i++) {
            System.out.println((i + 1) + ". " + posiciones[i]);
        }
        System.out.print("Elija la posición: ");
        return posiciones[numValido(1, posiciones.length) - 1];
    }

    /**
     * Muestra por consola los roles disponibles (enum Rol)
     * y retorna el elegido por el usuario.
     *
     * @return Rol elegido
     */
    private Rol elegirRol() {
        Rol[] roles = Rol.values();
        for (int i = 0; i < roles.length; i++) {
            System.out.println((i + 1) + ". " + roles[i]);
        }
        System.out.print("Elija el rol: ");
        return roles[numValido(1, roles.length) - 1];
    }
    //--------------------------------------------------------------------------
    private Fase buscarFase(ArrayList<Fase> fases, NombreFase nombreFase) {
        for (Fase f : fases) {
            if (f.getNombre() == nombreFase) {
                return f;
            }
        }
        return null;
    }
    private NombreFase obtenerFaseAnterior(NombreFase faseActual) {
        switch (faseActual) {
            case Dieciseisavos:
                return NombreFase.Grupos;
            case Octavos:
                return NombreFase.Dieciseisavos;
            case Cuartos:
                return NombreFase.Octavos;
            case Semifinal:
                return NombreFase.Cuartos;
            case Final:
                return NombreFase.Semifinal;
            default:
                return null;
        }
    }
    private boolean puedePlanificarFase(ArrayList<Fase> fases, NombreFase faseAEvaluar) {
        if (faseAEvaluar == NombreFase.Grupos) {
            return true;
        }
        NombreFase faseAnteriorEnum = obtenerFaseAnterior(faseAEvaluar);
        Fase faseAnterior = buscarFase(fases, faseAnteriorEnum);
        if (faseAnterior == null) {
            return false;
        }
        if (faseAnterior.getPartidos().isEmpty()) {
            return false;
        }
        return true;
    }
}