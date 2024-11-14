package com.literalura.catalogo_libros.service;

import com.literalura.catalogo_libros.dto.AutorDTO;
import com.literalura.catalogo_libros.dto.LibroDTO;
import com.literalura.catalogo_libros.model.*;
import com.literalura.catalogo_libros.repository.AutorRepository;
import com.literalura.catalogo_libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {
    @Autowired
    private AutorService autorService;

    @Autowired
    private LibroService libroService;

    public BibliotecaService(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorService = new AutorService(autorRepository);
        this.libroService = new LibroService(libroRepository);
    }

    public void guardarLibroConAutores(DatosGenerales datosGenerales){
        DatosLibro datosLibro = datosGenerales.resultados().get(0);
        if(this.libroService.existeLibroPorTitulo(datosLibro.titulo())) {
            System.out.println("El libro buscado ya existe en el catalogo.");
            return;
        }
        DatosAutor datosAutor = datosLibro.autores().get(0);

        Autor autor = new Autor(datosAutor.nombre(), datosAutor.AnioDeNacimiento(), datosAutor.AnioDeMuerte());
        Libro libro = new Libro(datosLibro.titulo(), autor, datosLibro.idiomas().get(0), datosLibro.cantidadDescargas());

        autor.getLibros().add(libro);

        this.autorService.guardarAutor(autor);
    }

    public List<LibroDTO> librosRegistrados() {
        return this.libroService.LibrosRegistrados();
    }

    public List<AutorDTO> autoresRegistrados() {
        return this.autorService.autoresRegistrados();
    }

    public List<AutorDTO> autoresVivosPorAnio(String anio) {
        return this.autorService.autoresVivosPorAnio(anio);
    }

    public List<LibroDTO> librosPorIdioma(String idioma) {
        return this.libroService.librosPorIdioma(idioma);
    }
}
