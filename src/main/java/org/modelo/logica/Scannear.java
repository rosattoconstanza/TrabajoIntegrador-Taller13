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


    public Fase configurarFases(){
        Scanner sc = new Scanner(System.in);
        Fase fase = null;
        boolean excepcion = false;

        while (!excepcion){
            try {
                NombreFase[] nombres = NombreFase.values();
                for (int i = 0; i < nombres.length; i++) {
                    System.out.println((i + 1) + "-" + nombres[i]);
                }
                System.out.println("ELija el numero de la Fase a crear:");
                int indice = numValido(1, nombres.length) - 1;

                fase = new Fase(nombres[indice], new ArrayList<Partido>(),new ArrayList<Grupo>());

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
            int cantidad = sc.nextInt(); sc.nextLine();

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

            System.out.println("Grupo" + identificacion + "creado correctamente.");
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

        while (!excepcion) {
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
        System.out.print("Nombre del país: ");
        String nombre = sc.nextLine();
        System.out.print("Bandera (descripción): ");
        String bandera = sc.nextLine();

        return new Pais(nombre, bandera);
    }

    public Seleccion cargarSeleccionYJugadores(Pais pais) throws NumNegativoException {
        Scanner sc = new Scanner(System.in);
        Seleccion seleccion = null;

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

            seleccion = new Seleccion(federacion, camisetaPrincipal, camisetaSecundaria, cabezaGrupo, ranking, pais);
            System.out.println("Selección creada correctamente. Continuemos con los jugadores...");

            System.out.print("¿Cuántos jugadores desea añadir?: ");
            int cantidad = sc.nextInt();
            sc.nextLine();

            if (cantidad <= 0) {
                throw new NumNegativoException("Parece que ingresaste un numero negativo o cero, pruebe nuevamente.");
            }

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
                System.out.print("Peso: ");
                float peso = sc.nextFloat();
                sc.nextLine();
                System.out.print("Altura: ");
                float altura = sc.nextFloat();
                sc.nextLine();

                // Elegir posición mostrando opciones numeradas
                Posicion posicion = elegirPosicion(sc);

                Jugador jugador = new Jugador(nombre, nacimiento, dorsal, posicion, peso, altura);
                seleccion.agregarJugador(jugador);
                System.out.println("Jugador " + (i + 1) + " agregado correctamente.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Lamentamos la interrupción, parece que se ingresó un dato que no corresponde, intente nuevamente.");
            sc.nextLine();
        } catch (NumNegativoException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.getMessage();
        }
        finally {
            sc.close();
        }

        return seleccion;
    }

    public ArrayList<DirectorTecnico> cargarDirectores() throws NumNegativoException {
        Scanner sc = new Scanner(System.in);
        ArrayList<DirectorTecnico> directores = new ArrayList<DirectorTecnico>();
        boolean salir = false;

        while(salir == false) {
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
                System.out.println(e.getMessage());
            }
            finally {
                sc.close();
            }
        }

        return directores;
    }

    public ArrayList<CuerpoTecnico> cargarCuerpos() throws NumNegativoException {
        Scanner sc = new Scanner(System.in);
        ArrayList<CuerpoTecnico> cuerposT = new ArrayList<CuerpoTecnico>();
        boolean salir = false;

        while (salir == false) {
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
                    Rol rol = elegirRol(sc);

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
                System.out.println(e.getMessage());
            }
            finally {
                sc.close();
            }
        }

        return cuerposT;
    }


//no se corta la linea esta ;( aaaaaa















        //---------------------------------------------------------------------------
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

        private Posicion elegirPosicion(Scanner sc) {
            Posicion[] posiciones = Posicion.values();
            for (int i = 0; i < posiciones.length; i++) {
                System.out.println((i + 1) + ". " + posiciones[i]);
            }
            System.out.print("Elija la posición: ");
            return posiciones[numValido(1, posiciones.length) - 1];
        }

        private Rol elegirRol(Scanner sc) {
            Rol[] roles = Rol.values();
            for (int i = 0; i < roles.length; i++) {
                System.out.println((i + 1) + ". " + roles[i]);
            }
            System.out.print("Elija el rol: ");
            return roles[numValido(1, roles.length) - 1];
        }
}


