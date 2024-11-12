package com.literalura.catalogo_libros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") LocalDate AnioDeNacimiento,
        @JsonAlias("death_year") LocalDate AnioDeMuerte) {
}
