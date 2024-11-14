package com.literalura.catalogo_libros.principal;

import com.literalura.catalogo_libros.dto.AutorDTO;
import com.literalura.catalogo_libros.dto.LibroDTO;
import com.literalura.catalogo_libros.model.DatosGenerales;
import com.literalura.catalogo_libros.repository.AutorRepository;
import com.literalura.catalogo_libros.repository.LibroRepository;
import com.literalura.catalogo_libros.service.BibliotecaService;
import com.literalura.catalogo_libros.service.ConexionAPI;
import com.literalura.catalogo_libros.service.ConversorJSON;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private static String URL = "https://gutendex.com/books/";
    private Scanner teclado = new Scanner(System.in);
    ConexionAPI conexion = new ConexionAPI();
    ConversorJSON conversor = new ConversorJSON();
    private BibliotecaService bibliotecaService;
    private Integer opcion;

    public Principal(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.bibliotecaService = new BibliotecaService(autorRepository, libroRepository);
    }

    public void mostrarMenu(){
        System.out.println("\n¡BIENVENIDO A LITER ALURA!");
        do {
            System.out.println("""
                
                1. Buscar un libro por título.
                2. Listar los libros registrados.
                3. Listar los autores registrados.
                4. Listar autores vivos en un determinado año.
                5. Listar libros por idioma.
                
                0. Salir.
                
                Seleccione una opción:
                """);
            this.opcion = this.teclado.nextInt();
            this.teclado.nextLine();

            switch (this.opcion) {
                case 1:{
                    this.buscarLibroPorTitulo();
                    break;
                }
                case 2:{
                    this.listarLibrosRegistrados();
                    break;
                }
                case 3:{
                    this.listarAutoresRegistrados();
                    break;
                }
                case 4:{
                    this.listarAutoresVivosPorAnio();
                    break;
                }
                case 5:{
                    this.listarLibrosPorIdioma();
                    break;
                }
                case 0:{
                    System.out.println("Finalizando programa...");
                    break;
                }
                default:{
                    System.out.println("¡Opción inválida!");
                }
            }
        } while (this.opcion != 0);
        System.out.println("¡MUCHAS GRACIAS POR USAR!");
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el titulo del libro:");
        String titulo = this.teclado.nextLine();
        String json = this.conexion.obtenerDatos(
                URL + "?search=" + titulo.replace(" ", "+").toLowerCase());
        DatosGenerales datosGenerales = this.conversor.convertirDesdeJSON(json, DatosGenerales.class);
        if(datosGenerales.resultados().isEmpty()){
            System.out.println("No se encontró el libro buscado.");
            return;
        }
        this.bibliotecaService.guardarLibroConAutores(datosGenerales);
    }

    private void listarLibrosRegistrados() {
        List<LibroDTO> libros = this.bibliotecaService.librosRegistrados();
        libros.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<AutorDTO> autores = this.bibliotecaService.autoresRegistrados();
        autores.forEach(System.out::println);
    }

    private void listarAutoresVivosPorAnio() {
        System.out.println("Ingrese el año deseado:");
        String anio = this.teclado.nextLine();
        List<AutorDTO> autores = this.bibliotecaService.autoresVivosPorAnio(anio);
        autores.forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
        System.out.println("""
                
                Ejemplos:
                Inglés - en
                Español - en
                Frances - fr
                
                Ingrese el idioma deseado:
                """);
        String idioma = this.teclado.nextLine();
        List<LibroDTO> libros = this.bibliotecaService.librosPorIdioma(idioma);
        libros.forEach(System.out::println);
    }
}
