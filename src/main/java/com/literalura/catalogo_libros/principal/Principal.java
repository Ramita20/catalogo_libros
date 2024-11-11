package com.literalura.catalogo_libros.principal;

import com.literalura.catalogo_libros.model.DatosLibro;
import com.literalura.catalogo_libros.service.ConexionAPI;
import com.literalura.catalogo_libros.service.ConversorJSON;

import java.util.Scanner;

public class Principal {
    private static String URL = "https://gutendex.com/books/";
    private Scanner teclado = new Scanner(System.in);
    ConexionAPI conexion = new ConexionAPI();
    ConversorJSON conversor = new ConversorJSON();
    private Integer opcion;

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
                default:{
                    System.out.println("¡Opción inválida!");
                    continue;
                }
            }
        } while (this.opcion != 0);
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el titulo del libro:");
        String titulo = this.teclado.nextLine();
        String json = this.conexion.obtenerDatos(
                URL + "?search=" + titulo.replace(" ", "+").toLowerCase());
        DatosLibro datosLibro = this.conversor.convertirDesdeJSON(json, DatosLibro.class);
        System.out.println(datosLibro);
    }
}
