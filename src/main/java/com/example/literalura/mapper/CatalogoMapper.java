package com.example.literalura.mapper;

import com.example.literalura.api.dto.AutorDto;
import com.example.literalura.api.dto.LibroDto;
import com.example.literalura.domain.model.Autor;
import com.example.literalura.domain.model.Libro;
import org.springframework.stereotype.Component;

@Component
public class CatalogoMapper {

    public Autor toAutor(AutorDto dto) {
        return new Autor(dto.name(), dto.birth_year(), dto.death_year());
    }

    public Libro toLibro(LibroDto dto, Autor autor) {
        String idioma = (dto.languages() == null || dto.languages().isEmpty())
                ? null
                : dto.languages().get(0);

        return new Libro(
                dto.id(),
                dto.title(),
                idioma,
                dto.download_count(),
                autor
        );
    }
}