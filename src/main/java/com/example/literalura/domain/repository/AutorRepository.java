package com.example.literalura.domain.repository;

import com.example.literalura.domain.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query("""
        SELECT a FROM Autor a
        WHERE a.nacimiento IS NOT NULL
          AND a.nacimiento <= :anio
          AND (a.fallecimiento IS NULL OR a.fallecimiento >= :anio)
    """)
    List<Autor> autoresVivosEn(Integer anio);
}