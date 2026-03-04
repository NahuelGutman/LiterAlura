package com.example.literalura;

import com.example.literalura.api.GutendexClient;
import com.example.literalura.console.Principal;
import com.example.literalura.domain.model.Autor;
import com.example.literalura.domain.model.Libro;
import com.example.literalura.domain.repository.AutorRepository;
import com.example.literalura.domain.repository.LibroRepository;
import com.example.literalura.service.CatalogoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiterAluraApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Bean
    CommandLineRunner iniciarMenu(Principal principal) {
        return args -> principal.iniciar();
    }
}