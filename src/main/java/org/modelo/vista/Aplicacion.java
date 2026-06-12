package org.modelo.vista;
import org.modelo.domain.*;
import org.modelo.logica.*;
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
                        //menuDelegaciones();
                        break;
                    case 3:
                        //menuOrganizacion();
                        break;
                    case 4:
                        //menuEventos();
                        break;
                    case 5:
                        //menuInformes();
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
}