package com.literalura.catalogo_libros.service;

import com.literalura.catalogo_libros.model.Libro;
import com.literalura.catalogo_libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repositorio;

    public void guardarLibro(Libro libro){
        this.repositorio.save(libro);
    }
}
