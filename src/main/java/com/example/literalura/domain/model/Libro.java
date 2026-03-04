package com.example.literalura.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_id", nullable = false, unique = true)
    private Long apiId;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 10)
    private String idioma;

    private Double descargas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {}

    public Libro(Long apiId, String titulo, String idioma, Double descargas, Autor autor) {
        this.apiId = apiId;
        this.titulo = titulo;
        this.idioma = idioma;
        this.descargas = descargas;
        this.autor = autor;
    }

    public Long getId() { return id; }
    public Long getApiId() { return apiId; }
    public String getTitulo() { return titulo; }
    public String getIdioma() { return idioma; }
    public Double getDescargas() { return descargas; }
    public Autor getAutor() { return autor; }

    public void setApiId(Long apiId) { this.apiId = apiId; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public void setDescargas(Double descargas) { this.descargas = descargas; }
    public void setAutor(Autor autor) { this.autor = autor; }
}