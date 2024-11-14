package com.literalura.catalogo_libros.repository;

import com.literalura.catalogo_libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    boolean existsLibroByTitulo(String titulo);
    List<Libro> findByIdioma(String idioma);
}
