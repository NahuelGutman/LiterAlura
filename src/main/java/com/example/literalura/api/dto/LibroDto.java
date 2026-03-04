package com.example.literalura.api.dto;

import java.util.List;

public record LibroDto(
        Long id,
        String title,
        List<AutorDto> authors,
        List<String> languages,
        Double download_count
) {}