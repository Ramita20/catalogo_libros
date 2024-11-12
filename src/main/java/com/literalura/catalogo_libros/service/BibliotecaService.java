package com.literalura.catalogo_libros.service;

import com.literalura.catalogo_libros.model.Autor;
import com.literalura.catalogo_libros.model.DatosLibro;
import com.literalura.catalogo_libros.model.Libro;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BibliotecaService {
    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @Transactional
    public void guardarLibroConAutores(DatosLibro datosLibro){
        List<Autor> autores = datosLibro.autores().stream()
                .map(a -> new Autor(a.nombre(), a.AnioDeNacimiento(), a.AnioDeMuerte()))
                .collect(Collectors.toList());

        Libro libro = new Libro(datosLibro.titulo(), autores, datosLibro.idiomas().get(0), datosLibro.cantidadDescargas());

        autores.forEach(autor -> {
            if(autor.getLibros() == null){
                autor.setLibros(List.of(libro));
            } else {
                autor.getLibros().add(libro);
            }
        });

        autores.forEach(this.autorService::guardarAutor);
        this.libroService.guardarLibro(libro);
    }
}
