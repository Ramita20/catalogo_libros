package com.literalura.catalogo_libros.service;

import com.literalura.catalogo_libros.model.Autor;
import com.literalura.catalogo_libros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public void guardarAutor(Autor autor) {
        this.autorRepository.save(autor);
    }
}
