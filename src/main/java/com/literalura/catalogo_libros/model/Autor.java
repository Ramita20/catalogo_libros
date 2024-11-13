package com.literalura.catalogo_libros.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String AnioDeNacimiento;
    private String AnioDeMuerte;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> libros = new ArrayList<>();

    public Autor() {
    }

    public Autor(String nombre, String anioDeNacimiento, String anioDeMuerte) {
        this.nombre = nombre;
        AnioDeNacimiento = anioDeNacimiento;
        AnioDeMuerte = anioDeMuerte;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", AnioDeNacimiento=" + AnioDeNacimiento +
                ", AnioDeMuerte=" + AnioDeMuerte;
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

    public String getAnioDeNacimiento() {
        return AnioDeNacimiento;
    }

    public void setAnioDeNacimiento(String anioDeNacimiento) {
        AnioDeNacimiento = anioDeNacimiento;
    }

    public String getAnioDeMuerte() {
        return AnioDeMuerte;
    }

    public void setAnioDeMuerte(String anioDeMuerte) {
        AnioDeMuerte = anioDeMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
