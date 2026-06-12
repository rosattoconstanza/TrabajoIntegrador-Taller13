package org.modelo.logica;
import java.util.*;
import org.modelo.domain.*;

public class Scannear {
    //------------------------------------------------------------
    public Mundial inicializarMundial() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;
        Mundial mundial = null;

        while (!excepcion) {
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
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupcion, parece que se ingresó un " +
                        "texto que deberia ser un entero, intente nuevamente.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally {
                sc.close();
            }
        }
        return mundial;
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
                //configurarGrupo();
                break;

            case 2:
                //configurarFases();
                break;

            case 3:
                //planificarPartido();
                break;
        }
    }

    public static void registroDeEventosDeCampo() {
    }


    public Fase configurarFases(ArrayList<Fase> fases){
        Scanner sc = new Scanner(System.in);
        Fase fase = null;
        boolean excepcion = false;
        NombreFase[] nombres = NombreFase.values();
        while (!excepcion){
            try {
                for (int i=0; i<nombres.length; i++){
                    System.out.println(i + "-" + nombres[i]);
                }
                System.out.println("ELija el numero de la Fase a crear:");
                int indice = sc.nextInt();
                fase = new Fase(nombres[indice]);
                System.out.println("Fases creadas correctamente.");
                excepcion = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                sc.close();
            }
        }
        return fase;
    }

//----------------------------------------------------------------------
public Grupo configurarGrupo(ArrayList<Pais> paises) {
    Grupo grupo = null;
    Scanner sc = new Scanner(System.in);
    boolean excepcion = false;

    while (!excepcion) {
        try {
            System.out.println("Identificación:");
            String identificacion = sc.nextLine();

            System.out.println("Descripción:");
            String descripcion = sc.nextLine();

            grupo = new Grupo(identificacion, descripcion);
            listarPaises();
            for (int i = 0; i < 4; i++) {
                System.out.println("Seleccione una selección:");
                int indice = sc.nextInt();
                Pais pais = paises.get(indice);
                grupo.agregarSeleccion(pais.getSeleccion());
            }
            System.out.println("Grupo creado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
    return grupo;
}
//----------------------------------------------------------------------------------


//----------------------------------------------------------------------------------

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

    public Estadio registrarEstadio() {
        Scanner sc = new Scanner(System.in);
        boolean excepcion = false;
        Estadio estadio = null;

        while (excepcion == false) {
            try {
                System.out.println("Nombre del Estadio: ");
                String nombreEstadio = sc.nextLine();
                System.out.println("Capacidad del Estadio: ");
                int capacidadEstadio = sc.nextInt();

                estadio = new Estadio(nombreEstadio, capacidadEstadio);
                excepcion = true;
            } catch (InputMismatchException e) {
                System.out.println("Lamentamos la interrupción, parece que se no ingresó un número, intente nuevamente.");
                sc.nextLine();
            } catch (Exception e) {
                e.getMessage();
            }
            finally {
                sc.close();
            }
        }
        return estadio;
    }

    //--------------------------------------------------------------------------------

    public Pais cargarPais() {
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


    public void cargarSeleccionyJugadores() {
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

    public static void cargarCuerpoyDirector() {
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
        public static int numValido (Scanner sc,int min, int max){
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
}


