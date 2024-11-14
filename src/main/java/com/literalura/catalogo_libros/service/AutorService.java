package com.literalura.catalogo_libros.service;

import com.literalura.catalogo_libros.dto.AutorDTO;
import com.literalura.catalogo_libros.model.Autor;
import com.literalura.catalogo_libros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public void guardarAutor(Autor autor) {
        this.autorRepository.save(autor);
    }

    public List<AutorDTO> autoresRegistrados() {
        return this.convertirAListaDTO(this.autorRepository.findAll());
    }

    public List<AutorDTO> autoresVivosPorAnio(String anio) {
        return this.convertirAListaDTO(this.autorRepository.buscarAutoresEntreAnios(anio));
    }

    private List<AutorDTO> convertirAListaDTO(List<Autor> autores) {
        return autores.stream()
                .map(a -> new AutorDTO(a.getNombre(), a.getAnioDeNacimiento(), a.getAnioDeMuerte()))
                .collect(Collectors.toList());
    }
}
