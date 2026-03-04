package com.example.literalura.domain.repository;

import com.example.literalura.domain.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByApiId(Long apiId);

    List<Libro> findByIdiomaIgnoreCase(String idioma);
}