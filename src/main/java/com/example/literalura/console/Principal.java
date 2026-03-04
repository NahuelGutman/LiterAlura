package com.example.literalura.console;

import com.example.literalura.menu.MenuOpciones;
import com.example.literalura.service.CatalogoService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {

    private final CatalogoService service;
    private final Scanner scanner = new Scanner(System.in);

    public Principal(CatalogoService service) {
        this.service = service;
    }

    public void iniciar() {
        MenuOpciones opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();

            if (opcion == null) {
                System.out.println("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case BUSCAR_LIBRO -> buscarLibroPorTitulo();
                case LISTAR_LIBROS -> listarLibros();
                case LISTAR_AUTORES -> listarAutores();
                case AUTORES_VIVOS -> listarAutoresVivos();
                case LIBROS_IDIOMA -> listarLibrosPorIdioma();
                case SALIR -> System.out.println("¡Hasta luego!");
            }

        } while (opcion != MenuOpciones.SALIR);
    }

    private void mostrarMenu() {
        System.out.println("\n============================");
        System.out.println("        LITER ALURA         ");
        System.out.println("============================");
        for (var op : MenuOpciones.values()) {
            System.out.printf("%d - %s%n", op.getCodigo(), op.getTexto());
        }
        System.out.print("Elegí una opción: ");
    }

    private MenuOpciones leerOpcion() {
        String input = scanner.nextLine().trim();
        int codigo;
        try {
            codigo = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
        return MenuOpciones.fromCodigo(codigo);
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingresá el título a buscar: ");
        String titulo = scanner.nextLine().trim();

        var libros = service.buscarYGuardarPorTitulo(titulo);

        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros.");
            return;
        }

        System.out.println("\nResultados guardados/encontrados:");
        libros.forEach(l -> {
            System.out.println("----------------------------");
            System.out.println("Título: " + l.getTitulo());
            System.out.println("Autor: " + (l.getAutor() != null ? l.getAutor().getNombre() : "Desconocido"));
            System.out.println("Idioma: " + l.getIdioma());
            System.out.println("Descargas: " + l.getDescargas());
        });
    }

    private void listarLibros() {
        var libros = service.listarLibrosRegistrados();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        System.out.println("\nLibros registrados:");
        libros.forEach(l -> {
            System.out.println("----------------------------");
            System.out.println("Título: " + l.getTitulo());
            System.out.println("Autor: " + (l.getAutor() != null ? l.getAutor().getNombre() : "Desconocido"));
            System.out.println("Idioma: " + l.getIdioma());
            System.out.println("Descargas: " + l.getDescargas());
        });
    }

    private void listarAutores() {
        var autores = service.listarAutoresRegistrados();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
            return;
        }

        System.out.println("\nAutores registrados:");
        autores.forEach(a -> {
            System.out.println("----------------------------");
            System.out.println("Autor: " + a.getNombre());
            System.out.println("Nacimiento: " + a.getNacimiento());
            System.out.println("Fallecimiento: " + a.getFallecimiento());
        });
    }

    private void listarAutoresVivos() {
        System.out.print("Ingresá el año: ");
        String input = scanner.nextLine().trim();

        int anio;
        try {
            anio = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Año inválido.");
            return;
        }

        var autores = service.listarAutoresVivosEn(anio);
        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en ese año.");
            return;
        }

        System.out.println("\nAutores vivos en " + anio + ":");
        autores.forEach(a -> {
            System.out.println("----------------------------");
            System.out.println("Autor: " + a.getNombre());
            System.out.println("Nacimiento: " + a.getNacimiento());
            System.out.println("Fallecimiento: " + a.getFallecimiento());
        });
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Ingresá el idioma (ej: en, es, fr, pt): ");
        String idioma = scanner.nextLine().trim();

        var libros = service.listarLibrosPorIdioma(idioma);
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en ese idioma.");
            return;
        }

        System.out.println("\nLibros en idioma '" + idioma + "':");
        libros.forEach(l -> {
            System.out.println("----------------------------");
            System.out.println("Título: " + l.getTitulo());
            System.out.println("Autor: " + (l.getAutor() != null ? l.getAutor().getNombre() : "Desconocido"));
            System.out.println("Descargas: " + l.getDescargas());
        });
    }
}