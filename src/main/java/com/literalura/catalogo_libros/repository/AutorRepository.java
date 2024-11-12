package com.literalura.catalogo_libros.repository;

import com.literalura.catalogo_libros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
