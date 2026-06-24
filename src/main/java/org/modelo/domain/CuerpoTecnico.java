package org.modelo.domain;

/**
 * Clase CuerpoTecnico.
 * Hereda de la clase Persona.
 * Está asociada con la clase Seleccion (Agregación).
 *
 * @author Rosatto Constanza
 * @version 1.0
 */
public class CuerpoTecnico extends Persona {

    private Rol rol;

    /**
     * Constructor parametrizado de la clase CuerpoTecnico.
     *
     * @param nombre Nombre del integrante del cuerpo técnico
     * @param fecNacimiento Fecha de nacimiento
     * @param rol Rol que cumple dentro del cuerpo técnico
     *
     */
    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;

    }

    /**
     * Constructor por defecto de la clase CuerpoTecnico.
     * Inicializa los atributos con valores predeterminados.
     *
     */
    public CuerpoTecnico() {
        this("", 0, null);
    }

    /**
     * Obtiene el rol del integrante del cuerpo técnico.
     *
     * @return rol asignado
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol del integrante del cuerpo técnico.
     *
     * @param rol nuevo rol asignado
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
