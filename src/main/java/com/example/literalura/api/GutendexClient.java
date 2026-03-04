package com.example.literalura.api;

import com.example.literalura.api.dto.GutendexResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
public class GutendexClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://gutendex.com/books?search=%s";

    public GutendexResponseDto buscarLibros(String texto) {
        String q = URLEncoder.encode(texto, StandardCharsets.UTF_8);
        String url = String.format(BASE_URL, q);
        return restTemplate.getForObject(url, GutendexResponseDto.class);
    }

    public String buscarCrudo(String texto) {
        String q = URLEncoder.encode(texto, StandardCharsets.UTF_8);
        String url = String.format(BASE_URL, q);
        return restTemplate.getForObject(url, String.class);
    }
}