package com.example.literalura.service;

import com.example.literalura.api.GutendexClient;
import com.example.literalura.api.dto.LibroDto;
import com.example.literalura.domain.model.Autor;
import com.example.literalura.domain.model.Libro;
import com.example.literalura.domain.repository.AutorRepository;
import com.example.literalura.domain.repository.LibroRepository;
import com.example.literalura.mapper.CatalogoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogoService {

    private final GutendexClient client;
    private final AutorRepository autorRepo;
    private final LibroRepository libroRepo;
    private final CatalogoMapper mapper;

    public CatalogoService(GutendexClient client,
                           AutorRepository autorRepo,
                           LibroRepository libroRepo,
                           CatalogoMapper mapper) {
        this.client = client;
        this.autorRepo = autorRepo;
        this.libroRepo = libroRepo;
        this.mapper = mapper;
    }

    @Transactional
    public List<Libro> buscarYGuardarPorTitulo(String titulo) {
        var resp = client.buscarLibros(titulo);
        if (resp == null || resp.results() == null || resp.results().isEmpty()) {
            return List.of();
        }

        return resp.results().stream()
                .map(this::guardarLibroDto)
                .toList();
    }

    private Libro guardarLibroDto(LibroDto dto) {
        // Evitar duplicado por apiId
        var existente = libroRepo.findByApiId(dto.id());
        if (existente.isPresent()) return existente.get();

        // Tomamos el primer autor (modelo simple: 1 libro -> 1 autor)
        Autor autor = null;
        if (dto.authors() != null && !dto.authors().isEmpty()) {
            var a = dto.authors().get(0);
            autor = autorRepo.findByNombre(a.name())
                    .orElseGet(() -> autorRepo.save(mapper.toAutor(a)));
        } else {
            // Autor desconocido: para no romper, creamos uno genérico
            autor = autorRepo.findByNombre("Desconocido")
                    .orElseGet(() -> autorRepo.save(new Autor("Desconocido", null, null)));
        }

        var libro = mapper.toLibro(dto, autor);
        return libroRepo.save(libro);
    }

    public List<Libro> listarLibrosRegistrados() {
        return libroRepo.findAll();
    }

    public List<Autor> listarAutoresRegistrados() {
        return autorRepo.findAll();
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepo.findByIdiomaIgnoreCase(idioma);
    }

    public List<Autor> listarAutoresVivosEn(int anio) {
        return autorRepo.autoresVivosEn(anio);
    }
}