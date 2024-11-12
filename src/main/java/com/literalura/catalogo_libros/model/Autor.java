package com.literalura.catalogo_libros.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate AnioDeNacimiento;
    private LocalDate AnioDeMuerte;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    public Autor(String nombre, LocalDate anioDeNacimiento, LocalDate anioDeMuerte) {
        this.nombre = nombre;
        AnioDeNacimiento = anioDeNacimiento;
        AnioDeMuerte = anioDeMuerte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getAnioDeNacimiento() {
        return AnioDeNacimiento;
    }

    public void setAnioDeNacimiento(LocalDate anioDeNacimiento) {
        AnioDeNacimiento = anioDeNacimiento;
    }

    public LocalDate getAnioDeMuerte() {
        return AnioDeMuerte;
    }

    public void setAnioDeMuerte(LocalDate anioDeMuerte) {
        AnioDeMuerte = anioDeMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
