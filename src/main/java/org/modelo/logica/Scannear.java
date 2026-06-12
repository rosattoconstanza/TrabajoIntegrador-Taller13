package org.modelo.logica;
import java.util.*;
import org.modelo.domain.*;
public class Scannear {
    //------------------------------------------------------------
    public Mundial inicializarMundial() {
        boolean excepcion = false;

        while (excepcion == false) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Para comenzar, necesitamos datos iniciales: ");
                System.out.println("Ingrese Año: ");
                int anio = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese la mascota: ");
                String mascota = sc.nextLine();
                System.out.println("Ingrese fecha de inicio: ");
                int fechaInicio = sc.nextInt();
                System.out.println("Ingrese fecha de finalización: ");
                int fechaFinal = sc.nextInt();

                Mundial mundial = new Mundial(anio, mascota, fechaInicio, fechaFinal);
                System.out.println("El Mundial se creo correctamente, muchas gracias.");
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupcion, parece que se ingresó un " +
                        "texto que deberia ser un entero, intente nuevamente.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //finally con close de scanner
        }
        return mundial;
    }

    //---------------------------------------------------------------------------

    public static void menuInical() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (salir == false) {
            try {
                System.out.println("¡Bienvenido a la organización del Mundial de fútbol 2026! ¿Que desea hacer?:\n" +
                        "1. Gestión de Infraestructura.\n" + "2. Administración de Delegaciones.\n" +
                        "3.Organización Deportiva.\n" + "4.Registro de Eventos de Campo.\n" + "5.Informes.\n" + "6. Salir.");
                int eleccionUsuario = numValido(sc, 1, 6);
                switch (eleccionUsuario) {
                    case 1:
                        GestionDeInfraestructura();
                        break;
                    case 2:
                        AdministracionDeDelegaciones();
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        System.out.println("Gracias por utilizar nuestro sistema, vuelva pronto :)");
                        salir = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un entero, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    //-----------------------------------------------------------------------

    public static void organizacionDeportiva(){

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Configurar Grupos");
        System.out.println("2. Configurar Fases");
        System.out.println("3. Planificar Partidos");

        int opcion = sc.nextInt();

        switch(opcion){

            case 1:
                configurarGrupo();
                break;

            case 2:
                configurarFases();
                break;

            case 3:
                //planificarPartido();
                break;
        }
    }

    public static void registroDeEventosDeCampo() {
    }

    public Fase configurarFases(){
        ArrayList<Fase> fases = new ArrayList<>();

        fases.add(new Fase(NombreFase.Grupos));
        fases.add(new Fase(NombreFase.Dieciseisavos));
        fases.add(new Fase(NombreFase.Octavos));
        fases.add(new Fase(NombreFase.Cuartos));
        fases.add(new Fase(NombreFase.Semifinal));
        fases.add(new Fase(NombreFase.Final));

        System.out.println("Fases creadas correctamente.");
        return fases;
    }
    //----------------------------------------------------------------------
    public Grupo configurarGrupo(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Identificación:");
        String identificacion = sc.nextLine();
        System.out.println("Descripción:");
        String descripcion = sc.nextLine();
        Grupo grupo = new Grupo(identificacion, descripcion, null);
        listarPaises();

        for(int i = 0; i < 4; i++){

            System.out.println("Seleccione una selección:");
            int indice = sc.nextInt();

            Pais pais = paises.get(indice);
            grupo.agregarSeleccion(pais.getSeleccion());
        }
        System.out.println("Grupo creado correctamente.");
        return grupo;
    }

    //----------------------------------------------------------------------------------
    public static void GestionDeInfraestructura() {
        Scanner sc = new Scanner(System.in);
        boolean volver = false;
        while (volver == false) {
            try {
                System.out.println("¿En que nos enfocamos?\n" + "1. Registrar Sede. \n" +
                        "2. Registrar Estadio a Sede. \n" + "3. Volver.");
                int eleccionusuario = numValido(sc, 1, 3);

                switch (eleccionusuario) {
                    case 1:
                        registrarSede();
                        break;
                    case 2:
                        registrarEstadio();
                        break;
                    case 3:
                        volver = true;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un entero, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    private static void registrarSede() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;

        while (excepcion == false) {
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

                Sede sede = new Sede(ciudad, alturaNivelMar, clima, zonaHoraria);
                mundial.agregarSede(sede);
                System.out.println("La Sede se creó correctamente.");
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    private static void registrarEstadio() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;
        List<Sede> sedes = mundial.getSedes();

        if (sedes.isEmpty()) {
            System.out.println("Parece que aún no se registraron sedes, vuelva a intentarlo.");
            return;
        }
        listarSedes();
        while (excepcion == false) {
            try {
                System.out.println("Ingrese el número de Sede que le desea añadir un Estadio: ");
                int eleccionUsuario = numValido(sc, 1, sedes.size());
                sc.nextLine();

                int indice = eleccionUsuario - 1;
                Sede sede = sedes.get(indice);
                System.out.println("Nombre del Estadio: ");
                String nombreEstadio = sc.nextLine();
                System.out.println("Capacidad del Estadio: ");
                int capacidadEstadio = sc.nextInt();

                Estadio e = new Estadio(nombreEstadio, capacidadEstadio, sede);
                sede.agregarEstadio(e);
                System.out.println("El Estadio se creó correctamente.");
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    //--------------------------------------------------------------------------------

    public static void AdministracionDeDelegaciones() {
        Scanner sc = new Scanner(System.in);
        boolean volver = false;

        while (volver == false) {
            try {
                System.out.println("¿En que nos enfocamos?\n" + "1. Cargar Pais participante.\n" +
                        "2. Cargar Seleccion y su lista de jugadores.\n" + "3. Cargar Cuerpo Tecnico y Director Tecnico.\n" +
                        "4. Volver.");
                int eleccionUsuario = numValido(sc, 1, 4);

                switch (eleccionUsuario) {
                    case 1:
                        cargarPais();
                        break;
                    case 2:
                        cargarSeleccionyJugadores();
                        break;
                    case 3: cargarCuerpoyDirector(); break;
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

    private static void cargarPais() {
        Scanner sc = new Scanner(System.in);
        List<Sede> sedes = mundial.getSedes();
        boolean excepcion = false;

        System.out.println("Ingrese nombre del pais participante: ");
        String nombrePais = sc.nextLine();
        System.out.println("Ingrese la bandera correspondiente: ");
        String banderaPais = sc.nextLine();

        Pais pais = new Pais(nombrePais, banderaPais);
        System.out.println("El pais se creó correctamente, vamos a asignarlo a una Sede.");
        if (sedes.isEmpty()) {
            System.out.println("Parece que aún no se registraron sedes, vuelva a intentarlo.");
            return;
        }
        listarSedes();

        while (excepcion == false) {
            try {
                System.out.println("Ingrese el número de Sede que le desea asignar al Pais: ");
                int eleccionUsuario = numValido(sc, 1, sedes.size());
                sc.nextLine();

                int indice = eleccionUsuario - 1;
                Sede sede = sedes.get(indice);
                sede.setPais(pais);

                System.out.println("Muchas gracias, la Sede ya tiene un Pais asignado.");
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }
    }


    private static void cargarSeleccionyJugadores() {
        Scanner sc = new Scanner(System.in);

        if (paises.isEmpty()) {
            System.out.println("Porfavor, ingrese un País antes de comenzar con esta sección.");
            return;
        }

        try {
            listarPaises();
            System.out.println("Seleccione el número de País para asignar la Selección: ");
            int indice = numValido(sc, 1, paises.size()) - 1;
            sc.nextLine();
            Pais pais = paises.get(indice);

            if (pais.getSeleccion() != null) {
                System.out.println("Este país ya tiene una selección asignada.");
                return;
            }


            System.out.println("Comenzemos a cargar una seleccion a este pais, ingrese el nombre de Federación: ");
            String federacion = sc.nextLine();
            System.out.println("Ingrese la camiseta principal: ");
            String camisetaPrincipal = sc.nextLine();
            System.out.println("Ingrese la camiseta secundaria: ");
            String camisetaSecundaria = sc.nextLine();
            sc.nextLine();
            System.out.println("¿Su selección es Cabeza de grupo? (true o false): ");
            boolean cabezaGrupo = sc.nextBoolean();
            sc.nextLine();
            System.out.println("Ingrese el ranking de su Seleccion: ");
            int ranking = sc.nextInt();


            Seleccion seleccion = new Seleccion(federacion, camisetaPrincipal, camisetaSecundaria, cabezaGrupo, ranking, pais);
            pais.setSeleccion(seleccion);
            System.out.println("La seleccion se creó correctamente. Continuemos con sus jugadores...");


            System.out.println("¿Cuantos jugadores desea añadir?: ");
            int cantidadJugadores = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < cantidadJugadores; i++) {
                System.out.println("Ingrese el nombre del jugador " + (i + 1) + ": ");
                String nombre = sc.nextLine();
                System.out.println("Ingrese la fecha de nacimiento del jugador " + (i + 1) + ": ");
                int nacimiento = sc.nextInt();
                System.out.println("Ingrese el número del jugador " + (i + 1) + ": ");
                int dorsal = sc.nextInt();
                System.out.println("Ingrese el peso del jugador " + (i + 1) + ": ");
                float peso = sc.nextFloat();
                System.out.println("Ingrese la altura del jugador " + (i + 1) + ": ");
                float altura = sc.nextFloat();
                System.out.println("Ingrese la posición del jugador " + (i + 1) +
                        " (¡Verifique escribir una opción correctamente! -> Arquero, Defensor, Mediocampista, Delantero): ");
                String posicionJug = sc.nextLine();

                Posicion posicion = null;
                boolean posicionValida = false;

                while (!posicionValida) {
                    try {
                        posicion = Posicion.valueOf(posicionJug);
                        posicionValida = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Parece que la posición ingresada no es válida, intente nuevamente: ");
                        posicionJug = sc.nextLine();
                    }
                }

                Jugador jugador = new Jugador(nombre, nacimiento, dorsal, posicion, peso, altura);
                seleccion.agregarJugador(jugador);
                System.out.println("Jugador " + (i+1) + " agregado correctamente.");
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Lamentamos la interrupción, parece que se ingresó un dato que no corresponde, intente nuevamente.");
            sc.nextLine();
        }
    }

    private static void cargarCuerpoyDirector() {
        Scanner sc = new Scanner(System.in);

        if (paises.isEmpty()) {
            System.out.println("Primero debe cargar al menos un País con su Selección para empezar con esta sección.");
            return;
        }

        try {
            listarPaises();
            System.out.println("¿La seleccion de que pais desea asignarle su Cuerpo y Director Tecnico?");
            int numeroUsuario = numValido(sc, 1, paises.size()) - 1;
            sc.nextLine();

            Pais paisElegido = paises.get(numeroUsuario);
            if(paisElegido.getSeleccion() == null) {
                System.out.println("Este pais no tiene una seleccion cargada. Porfavor, cargue primero una selección.");
                return;
            }
            Seleccion seleccionElegida = paisElegido.getSeleccion();

            // ------------------ DT ------------

            System.out.println("Vamos a comenzar cargando a los Directores Tecnicos de la seleccion "
                    + seleccionElegida.getNombreFederacion() + " ¿Cuantos desea añadir?: ");
            int cantidadDT = sc.nextInt();
            sc.nextLine();

            for(int i = 0; i < cantidadDT; i++) {
                System.out.println("Nombre del DT numero " + (i+1) + ":");
                String nombreDT = sc.nextLine();
                System.out.println("Fecha de nacimiento del DT numero " + (i+1) + ":");
                int nacimientoDT = sc.nextInt();
                sc.nextLine();
                System.out.println("Fecha de nombramiento del DT numero " + (i+1) + ":");
                int nombramientoDT = sc.nextInt();
                sc.nextLine();

                DirectorTecnico dt = new DirectorTecnico(nombreDT, nacimientoDT, nombramientoDT);
                seleccionElegida.agregarDirectorTecnico(dt);
                System.out.println("Director Tecnico numero " + (i+1) + " agregado correctamente.");
            }
            System.out.println("¡Tu seleccion ya tiene sus Directores Tecnicos! Continuemos con el Cuerpo Tecnico...");



            //---------------- CT ---------
        }
        catch(InputMismatchException e) {
            System.out.println("Lamentamos la interrupción, parece que se ingresó un dato que no corresponde, intente nuevamente.");
            sc.nextLine();
        }


    }

//no se corta la linea esta ;( aaaaaa
    //revisar en ejecucion si hay q poner while rodeando los trys















        //---------------------------------------------------------------------------
        private static int numValido (Scanner sc,int min, int max){
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

        private static void listarSedes () {
            System.out.println("Sedes registradas:\n");
            int i = 1;
            for (Sede s : mundial.getSedes()) {
                System.out.println(i++ + ". " + s);
                for (Estadio e : s.getEstadios()) {
                    System.out.println("Estadio -> " + e);
                }
            }
        }

        private static void listarPaises () {
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
}


