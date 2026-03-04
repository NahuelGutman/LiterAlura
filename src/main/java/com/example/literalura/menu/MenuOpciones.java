package com.example.literalura.menu;

public enum MenuOpciones {
    BUSCAR_LIBRO(1, "Buscar libro por título"),
    LISTAR_LIBROS(2, "Listar libros registrados"),
    LISTAR_AUTORES(3, "Listar autores registrados"),
    AUTORES_VIVOS(4, "Listar autores vivos en un determinado año"),
    LIBROS_IDIOMA(5, "Listar libros por idioma"),
    SALIR(0, "Salir");

    private final int codigo;
    private final String texto;

    MenuOpciones(int codigo, String texto) {
        this.codigo = codigo;
        this.texto = texto;
    }

    public int getCodigo() { return codigo; }
    public String getTexto() { return texto; }

    public static MenuOpciones fromCodigo(int codigo) {
        for (var op : values()) {
            if (op.codigo == codigo) return op;
        }
        return null;
    }
}