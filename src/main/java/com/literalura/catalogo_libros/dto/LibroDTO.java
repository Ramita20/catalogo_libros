package com.literalura.catalogo_libros.dto;

import com.literalura.catalogo_libros.model.Autor;


public record LibroDTO(
        String titulo,
        Autor autor,
        String idioma,
        Integer cantidadDescargas) {
}
