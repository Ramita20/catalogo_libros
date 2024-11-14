package com.literalura.catalogo_libros.repository;

import com.literalura.catalogo_libros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE CAST(:anio AS int) BETWEEN CAST(a.AnioDeNacimiento AS int) AND CAST(a.AnioDeMuerte AS int)")
    List<Autor> buscarAutoresEntreAnios(String anio);
}
