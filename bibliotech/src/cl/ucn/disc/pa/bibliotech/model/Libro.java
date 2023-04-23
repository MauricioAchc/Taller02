/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.pa.bibliotech.model;

/**
 * Clase que representa un Libro.
 *
 * @author Programacion Avanzada.
 */
public final class Libro {

    /**
     * The ISBN.
     */
    private String isbn;

    /**
     * The Titulo.
     */
    private String titulo;

    /**
     * The Author.
     */
    private String autor;

    /**
     * The Categoría
     */
    private String categoria;

    // TODO: Agregar la calificación.
    private boolean calificación;


    /**
     * The Constructor.
     *
     * @param isbn      del libro.
     * @param titulo    del libro.
     * @param autor     del libro
     * @param categoria del libro.
     */
    public Libro(final String isbn, final String titulo, final String autor, final String categoria) {

        // TODO: agregar validación de ISBN
        if (isbn == null || isbn.length() == 0) {
            throw new IllegalArgumentException("Isbn no valido!");
        }
        this.isbn = isbn;

        // validación del título
        if (titulo == null || titulo.length() == 0) {
            throw new IllegalArgumentException("Título no valido!");
        }
        this.titulo = titulo;

        // TODO: Agregar validación
        if (autor == null || autor.length() == 0) {
            throw new IllegalArgumentException("Autor no valido!");
        }
        this.autor = autor;

        // TODO: Agregar validación
        if (categoria == null || categoria.length() == 0) {
            throw new IllegalArgumentException("Categoría no valida!");
        }
        this.categoria = categoria;
    }

    /**
     * @return the ISBN.
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * @return the titulo.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * @return the autor.
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * @return the categoría.
     */
    public String getCategoria() {
        return this.categoria;
    }
}
