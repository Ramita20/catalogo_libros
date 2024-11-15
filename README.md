# Catalogo de Libros - LiterAlura
Catalogo de libros con Spring Boot

<br>

Esta aplicación cumple la función de de un Catalogo de Libros, realizando solicitudes a la API https://gutendex.com/
<hr>
Al iniciar la aplicación tendremos el siguiente menú.
<br>
![Menú principal](https://github.com/user-attachments/assets/abeddf8c-df2b-43df-b028-b04a8ef85b5f)
<br>
Revisemos cada una de las opciones para ver que hace exactamente cada una.
<hr>

## Opción 1 - Buscar libro por titulo.

![Opción nro 1](https://github.com/user-attachments/assets/437da2ef-5655-4ce8-8df0-187a25456fb7)
<br>
Seleccionada la opción, nos solicitará el titulo del libro que deseamos buscar.
<br>
Como veran en el ejemplo, el titulo a buscar será Frankenstein.
<br>
Una vez colocado el titulo, la aplicación realizará una solicitud a la API https://gutendex.com/books/
<br>
y traerá el primer resultado que coincida con el titulo solicitado. Teniendo la respuesta a disposición, la aplicación procederá a
<br>
a almacenar el resultado en una base de datos local PostgreSQL.
<hr>

## Opción 2 - Listar los libros registrados.

![Opción nro 2](https://github.com/user-attachments/assets/7bb4e819-c98a-42e6-b40b-be9545440724)
<br>
Esta opción simplemente listará los libros almacenados en la base de datos en el orden en el que fueron solicitados inicialmente.
<br>
Como podemos ver, el resultado anteriormente buscado(Frankenstein), aparece listado, por lo que podemos notar que se realizó
<br>
correctamente la anterior solicitud.
<br>
En el resultado podemos ver datos como: Titulo, Autor, Idioma, entre otros.
<hr>

## Opción 3 - Listar autores registrados.

![Opción nro 3](https://github.com/user-attachments/assets/bc71eb1c-e071-41ac-a683-ea9adff7ebad)
<br>
Como su nombre lo indica, sirve para listar los autores registrados en la base de datos.
<br>
Podemos ver en el resultado tanto su nombre, como año de nacimiento y año de muerte.
<hr>

## Opción 4 - Listar autores vivos en un determinado año.

![Opción nro 4](https://github.com/user-attachments/assets/bd2b52f4-a57a-451a-a214-9caba2a07557)
Esta opción, una vez seleccionada, nos pedirá ingresar un año. Para este ejemplo se ingresó el año 1560.
<br>
Revisando el resultado podemos ver que, de los 4 autores listados anteriormente, el único que nos muestra es
<br>
Miguel de Cervantes Saavedra, que es el único autor que se encontraba vivo dicho año.
<hr>

## Opción 5 - Listar libros por idioma.

![Opción nro 5](https://github.com/user-attachments/assets/8fc12887-0325-4a11-8dae-8bc5a50d49a7)
<br>
Finalmente, tendremos esta opción donde nos listará los libros segun el idioma que le digamos.
<br>
Es importante recalcar que los idiomas estan registrados con la nomenclatura de 2 caracteres.
<br>
Si vemos en la imagén, nos da unos ejemplos sobre como podemos solicitar libros de uno de 3 idiomas(Aunque podrian ser de más idiomas que no se encuentren en los ejemplos).
<br>
Para este ejemplo se seleccionó listar los libro en idioma inglés(en). En el resultado podemos ver que de los 4 libros listados anteriormente en la opción 2, ahora solo
<br>
nos aparecen los libros que estan almacenados con el idioma inglés(en).
<hr>

Estas serian las opciones disponibles actualmente en mi aplicación.
<br>
Espero que les resulte util y puedan ver como esta compuesta en el código.
<br>
Muchas gracias por usar!!!
