package com.literalura.catalogo_libros.service;

import com.literalura.catalogo_libros.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {
    @Autowired
    private AutorService autorService = new AutorService();

    public void guardarLibroConAutores(DatosGenerales datosGenerales){
        DatosLibro datosLibro = datosGenerales.resultados().get(0);
        DatosAutor datosAutor = datosLibro.autores().get(0);

        Autor autor = new Autor(datosAutor.nombre(), datosAutor.AnioDeNacimiento(), datosAutor.AnioDeMuerte());
        Libro libro = new Libro(datosLibro.titulo(), autor, datosLibro.idiomas().get(0), datosLibro.cantidadDescargas());

        autor.getLibros().add(libro);

        this.autorService.guardarAutor(autor);
    }
}
