/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.pa.bibliotech.model;

import cl.ucn.disc.pa.bibliotech.services.Utils;

/**
 * Clase que representa a un Socio.
 *
 * @author Programacion Avanzada.
 */
public final class Socio {

    /**
     * Número máximo de libros que puede tener el Socio.
     */
    private static final int NUMERO_LIBROS_MAXIMO = 5;

    /**
     * Nombre del socio.
     */
    private String nombre;

    /**
     * Apellido del socio.
     */
    private String apellido;

    /**
     * Email del socio.
     */
    private String correoElectronico;

    /**
     * Numero del socio.
     */
    private int numeroDeSocio;

    /**
     * Contraseña del socio.
     */
    private String contrasenia;

    /**
     * Libros que el Socio tiene en préstamo (máximo 10).
     */
    private Libro[] librosEnPrestamo = new Libro[0];

    /**
     * The Constructor.
     *
     * @param nombre            del socio.
     * @param apellido          del socio.
     * @param correoElectronico del socio.
     * @param numeroDeSocio     del socio.
     * @param contrasenia       del socio.
     */
    public Socio(String nombre, String apellido, String correoElectronico, int numeroDeSocio, String contrasenia) {

        // TODO: agregar validación
        if (nombre == null || nombre.length() == 0) {
            throw new IllegalArgumentException("Nombre no valido!");
        }
        this.nombre = nombre;

        // TODO: agregar validación
        if (apellido == null || apellido.length() == 0) {
            throw new IllegalArgumentException("Apellido no valido!");
        }
        this.apellido = apellido;

        // método estático para validación de email.
        Utils.validarEmail(correoElectronico);
        this.correoElectronico = correoElectronico;

        // TODO: agregar validación
        if (numeroDeSocio != 1) {
            throw new IllegalArgumentException("Número de socio no valido!");
        }
        this.numeroDeSocio = numeroDeSocio;

        // TODO: agregar validación
        if (contrasenia == null || contrasenia.length() == 0) {
            throw new IllegalArgumentException("Contraseña no valida!");
        }
        this.contrasenia = contrasenia;
    }

    /**
     * @return el nombre del Socio.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return el apellido del Socio.
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * @return el nombre completo del Socio.
     */
    public String getNombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    /**
     * @return el correo electronico del Socio.
     */
    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    /**
     * @return el numero del Socio.
     */
    public int getNumeroDeSocio() {
        return this.numeroDeSocio;
    }

    /**
     * @return la contraseña del Socio.
     */
    public String getContrasenia() {
        return this.contrasenia;
    }

    /**
     * Agrega un libro en préstamo al Socio.
     *
     * @param libro a agregar.
     */
    public void agregarLibro(final Libro libro) {
        // validacion
        if (this.librosEnPrestamo.length == NUMERO_LIBROS_MAXIMO) {
            throw new IllegalArgumentException("El Socio ya tiene la maxima cantidad de libros en prestamo: " + NUMERO_LIBROS_MAXIMO);
        }
        // agrego el libro
        Utils.append(this.librosEnPrestamo, libro);
    }

    /**
     * Cambio la contraseña del Socio.
     *
     * @param contrasenia nueva contraseña.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Cambio el correo electrónico del Socio.
     *
     * @param correoElectronico nuevo correo electrónico.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
