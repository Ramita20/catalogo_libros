package com.literalura.catalogo_libros.service;

import com.literalura.catalogo_libros.dto.LibroDTO;
import com.literalura.catalogo_libros.model.Libro;
import com.literalura.catalogo_libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public boolean existeLibroPorTitulo(String titulo) {
        return this.libroRepository.existsLibroByTitulo(titulo);
    }

    public List<LibroDTO> LibrosRegistrados() {
        return this.convertirALibroDTO(this.libroRepository.findAll());
    }

    public List<LibroDTO> librosPorIdioma(String idioma) {
        return this.convertirALibroDTO(this.libroRepository.findByIdioma(idioma));
    }

    private List<LibroDTO> convertirALibroDTO(List<Libro> libros) {
        return libros.stream()
                .map(l -> new LibroDTO(l.getTitulo(), l.getAutor(), l.getIdioma(), l.getCantidadDescargas()))
                .collect(Collectors.toList());
    }
}