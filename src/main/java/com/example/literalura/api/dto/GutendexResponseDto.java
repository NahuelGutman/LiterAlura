package com.example.literalura.api.dto;

import java.util.List;

public record GutendexResponseDto(
        Integer count,
        String next,
        String previous,
        List<LibroDto> results
) {}