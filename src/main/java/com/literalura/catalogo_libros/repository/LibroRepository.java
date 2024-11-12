package com.literalura.catalogo_libros.repository;

import com.literalura.catalogo_libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
