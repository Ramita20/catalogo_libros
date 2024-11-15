# catalogo_libros
Catalogo de libros con Spring Boot

<br>

Esta aplicación cumple la función de de un Catalogo de Libros, realizando solicitudes a la API https://gutendex.com/
<hr>
Al iniciar la aplicación tendremos el siguiente menú.
<br>
![Menú principal](https://github.com/user-attachments/assets/ca17f5dc-d3db-42d9-8edf-c50980e59ec0)
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
