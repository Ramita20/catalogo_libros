package com.literalura.catalogo_libros;

import com.literalura.catalogo_libros.principal.Principal;
import com.literalura.catalogo_libros.repository.AutorRepository;
import com.literalura.catalogo_libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoLibrosApplication implements CommandLineRunner {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(CatalogoLibrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(this.autorRepository, this.libroRepository);
		principal.mostrarMenu();
	}
}
