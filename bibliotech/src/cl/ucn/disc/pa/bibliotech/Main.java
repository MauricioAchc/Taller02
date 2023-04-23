/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.pa.bibliotech;

import cl.ucn.disc.pa.bibliotech.model.Socio;
import cl.ucn.disc.pa.bibliotech.services.Sistema;
import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

import java.io.IOException;
import java.util.Objects;

/**
 * The Main.
 *
 * @author Programacion Avanzada.
 */
public final class Main {

    /**
     * The main.
     *
     * @param args to use.
     * @throws IOException en caso de un error.
     */
    public static void main(final String[] args) throws IOException {

        // inicialización del sistema.
        Sistema sistema = new Sistema();

        StdOut.println(sistema.obtegerCatalogoLibros());

        String opcion = null;
        while (!Objects.equals(opcion, "2")) {

            StdOut.println("""
                    [*] Bienvenido a BiblioTech [*]
                                    
                    [1] Iniciar Sesión
                    [2] Salir
                    """);
            StdOut.print("Escoja una opcion: ");
            opcion = StdIn.readLine();

            switch (opcion) {
                case "1" -> iniciarSesion(sistema);
                case "2" -> StdOut.println("¡Hasta Pronto!");
                default -> StdOut.println("Opción no valida, intente nuevamente");
            }
        }
    }

    /**
     * Inicia la sesión del Socio en el Sistema.
     *
     * @param sistema a utilizar.
     */
    private static void iniciarSesion(final Sistema sistema) {
        StdOut.println("[*] Iniciar sesión en BiblioTech [*]");
        StdOut.print("Ingrese su numero de socio: ");
        int numeroSocio = StdIn.readInt();
        StdIn.readLine();

        StdOut.print("Ingrese su contraseña: ");
        String contrasenia = StdIn.readLine();

        // intento el inicio de session
        try {
            sistema.iniciarSession(numeroSocio, contrasenia);
        } catch (IllegalArgumentException ex) {
            StdOut.println("Ocurrió un error: " + ex.getMessage());
            return;
        }

        // mostrar menu principal
        menuPrincipal(sistema);
    }

    /**
     * El menú principal del Sistema.
     *
     * @param sistema a utilizar.
     */
    private static void menuPrincipal(final Sistema sistema) {
        String opcion = null;
        while (!Objects.equals(opcion, "4")) {
            StdOut.println("""
                    [*] BiblioTech [*]
                                        
                    [1] Préstamo de un libro
                    [2] Editar información
                    [3] Calificar libro
                                        
                    [4] Cerrar sesión
                    """);

            StdOut.print("Escoja una opción: ");
            opcion = StdIn.readLine();

            switch (opcion) {
                case "1" -> menuPrestamo(sistema);
                case "2" -> editarInformacion(sistema);
                // case "3" -> TODO: Crear método de calificar libro.
                case "4" -> sistema.cerrarSession();
                default -> StdOut.println("Opción no valida, intente nuevamente");
            }
        }
    }

    /**
     * Menú préstamo del Sistema.
     *
     * @param sistema a utilizar.
     */
    private static void menuPrestamo(Sistema sistema) {
        StdOut.println("[*] Préstamo de un Libro [*]");
        StdOut.println(sistema.obtegerCatalogoLibros());

        StdOut.print("Ingrese el ISBN del libro a tomar prestado: ");
        String isbn = StdIn.readLine();

        try {
            sistema.realizarPrestamoLibro(isbn);
        } catch (IOException ex) {
            StdOut.println("Ocurrió un error, intente nuevamente: " + ex.getMessage());
        }
    }

    /**
     * Edita la información del Socio en el Sistema.
     *
     * @param sistema a utilizar.
     */
    private static void editarInformacion(Sistema sistema) {

        String opcion = null;
        while (!Objects.equals(opcion, "3")) {

            StdOut.println("[*] Editar Perfil [*]");
            StdOut.println(sistema.obtenerDatosSocioLogeado());
            StdOut.println("""               
                    [1] Editar correo Electrónico
                    [2] Editar Contraseña
                                        
                    [3] Volver atrás
                    """);
            StdOut.print("Escoja una opción: ");
            opcion = StdIn.readLine();

            switch (opcion) {
                case "1" -> editarCorreo(sistema);
                case "2" -> cambiarContrasenia(sistema);
                case "3" -> StdOut.println("Volviendo al menú anterior...");
                default -> StdOut.println("Opción no valida, intente nuevamente");
            }
        }
    }

    /**
     * Cambia la contraseña del Socio en el Sistema.
     *
     * @param sistema a utilizar.
     */
    private static void cambiarContrasenia(Sistema sistema) {

        // TODO: implementar este método

        // Pido la nueva contraseña del socio.
        StdOut.print("Ingrese su nueva contraseña: ");
        String contrasenia = StdIn.readLine();

        // Cambio la contraseña.
        sistema.cambiarClave(contrasenia);

    }

    /**
     * Edita el correo electrónico del Socio en el Sistema.
     *
     * @param sistema a utilizar.
     */
    private static void editarCorreo(Sistema sistema) {

        // TODO: implementar este método

        // Pido el nuevo correo electrónico.
        StdOut.println("Edite su correo electrónico: ");
        String correoElectronico = StdIn.readLine();

        // Cambio el correo electrónico.
        sistema.editarCorreo(correoElectronico);
    }
}
