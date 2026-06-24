package org.modelo.domain;

/**
 * Clase DirectorTecnico.
 * Hereda de la clase Persona.
 * Está asociada con la clase Seleccion (Agregación).
 *
 * @author Rosatto Constanza
 * @version 1.0
 */
public class DirectorTecnico extends Persona {

    private int fechaNombramiento;

    /**
     * Constructor parametrizado de la clase DirectorTecnico.
     *
     * @param nombre Nombre del director técnico
     * @param fecNacimiento Fecha de nacimiento
     * @param fechaNombramiento Fecha en la que fue nombrado director técnico
     *
     */
    public DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }

    /**
     * Constructor por defecto de la clase DirectorTecnico.
     * Inicializa los atributos con valores predeterminados.
     *
     */
    public DirectorTecnico() {
        this("", 0, 0);
    }

    /**
     * Obtiene la fecha de nombramiento del director técnico.
     *
     * @return fecha de nombramiento
     */
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }

    /**
     * Establece la fecha de nombramiento del director técnico.
     *
     * @param fechaNombramiento nueva fecha de nombramiento
     */
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }

}
