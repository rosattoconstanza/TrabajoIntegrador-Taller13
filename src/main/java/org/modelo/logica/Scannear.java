package org.modelo.logica;
import java.util.*;
import org.modelo.domain.*;
public class Scannear {
    //------------------------------------------------------------
    static Mundial mundial;
    public static void inicializarMundial() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;

        while(excepcion == false) {
            try {
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

                mundial = new Mundial(anio, mascota, fechaInicio, fechaFinal);
                System.out.println("El Mundial se creo correctamente, muchas gracias.");
                excepcion = true;
            }
            catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupcion, parece que se ingresó un " +
                        "texto que deberia ser un entero, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    //---------------------------------------------------------------------------

    public static void menuInical() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while(salir == false) {
            try {
                System.out.println("¡Bienvenido a la organización del Mundial de fútbol 2026! ¿Que desea hacer?:\n" +
                        "1. Gestión de Infraestructura.\n" + "2. Administración de Delegaciones.\n" +
                        "3.Organización Deportiva.\n" + "4.Registro de Eventos de Campo.\n" + "5.Informes.\n" + "6. Salir.");
                int eleccionUsuario = numValido(sc, 1, 6);
                switch (eleccionUsuario) {
                    case 1: GestionDeInfraestructura(); break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6: System.out.println("Gracias por utilizar nuestro sistema, vuelva pronto :)");
                        salir = true;
                        break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un entero, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    //-----------------------------------------------------------------------

    public static void organizaciónDeportiva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Configurar los Grupos 2. Configurar las Fases de eliminación \n" +
                "3.Planificar los Partidos.");
        int eleccion = sc.nextInt();
        switch (eleccion) {
            case 1:
                configurarGrupo();
                break;

            case 2:
                //configurarFases();
                break;

            case 3:
                //planificarPartidos();
                break;

            default:
                System.out.println("Opción inválida");
        }
    }

    public static void registroDeEventosDeCampo () {
    }

    public static void configurarGrupo () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cantidad de grupos a añadir: ");
        int cantidad = sc.nextInt();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Identificacion: ");
        }
    }

    //----------------------------------------------------------------------------------
    public static void GestionDeInfraestructura() {
        Scanner sc = new Scanner(System.in);
        boolean volver = false;
        while(volver == false) {
            try {
                System.out.println("¿En que nos encofacos?\n" +"1.Registrar Sede. \n" +
                        "2. Registrar Estadio a Sede. \n" + "3. Volver.");
                int eleccionusuario = numValido(sc, 1, 3);

                switch(eleccionusuario) {
                    case 1: registrarSede(); break;
                    case 2: registrarEstadio(); break;
                    case 3: volver = true; break;
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un entero, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    private static void registrarSede() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;

        while(excepcion == false) {
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
            }
            catch(InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    private static void registrarEstadio() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;
        List<Sede> sedes = mundial.getSedes();

        if(sedes.isEmpty()) {
            System.out.println("Parece que aún no se registraron sedes, vuelva a intentarlo.");
            return;
        }
        listarSedes();
        while(excepcion == false) {
            try {
                System.out.println("Ingrese el número de Sede que le desea añadir un Estadio: ");
                int eleccionUsuario = numValido(sc, 1, sedes.size());

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
            }
            catch(InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            }
        }
    }

    //--------------------------------------------------------------------------------
























    //---------------------------------------------------------------------------
    private static int numValido(Scanner sc, int min, int max) {
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

    private static void listarSedes() {
        System.out.println("Sedes registradas:\n");
        int i = 1;
        for (Sede s : mundial.getSedes()) {
            System.out.println(i++ + ". " + s);
            for (Estadio e : s.getEstadios()) {
                System.out.println("-> " + e);
            }
        }
    }
}
