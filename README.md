# 📚 LiterAlura 

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-4.x-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

LiterAlura es una aplicación de consola desarrollada con **Java y Spring Boot** que permite consultar libros a través de la API pública **Gutendex**, almacenar la información en una base de datos **PostgreSQL** y realizar consultas sobre los datos guardados.

Este proyecto fue desarrollado como parte del **Challenge LiterAlura — Alura Latam / Oracle Next Education**.

---

## Tecnologías utilizadas

-  **Java 25**
-  **Spring Boot**
-  **Spring Data JPA**
-  **PostgreSQL**
-  **Maven**
-  **Gutendex API**

---

## Funcionalidades

La aplicación permite realizar las siguientes operaciones desde un menú en consola:

-  Buscar libros por título (consulta la API y guarda los resultados en la base de datos)
-  Listar libros registrados
-  Listar autores registrados
-  Listar autores vivos en un determinado año
-  Listar libros por idioma

---

##  API utilizada

La aplicación consume datos desde la API pública **Gutendex**, que proporciona información sobre libros del proyecto Gutenberg.

`https://gutendex.com/`

Ejemplo de consulta: `https://gutendex.com/books?search=don%20quijote`


---

## Base de datos

Se utiliza **PostgreSQL** para persistir la información.

Ejemplo de creación de base de datos:

``` 
SQL

CREATE DATABASE "LiterAlura"
```



## ️ Estructura del proyecto
src/main/java/com/example/literalura
- api
    - GutendexClient
    - dto
- console
    - Principal
- domain
    - model
        - Autor
        - Libro
    - repository
        - AutorRepository
        - LibroRepository
- mapper
    - CatalogoMapper
- menu
    - MenuOpciones
- service
    - CatalogoService
- LiterAluraApplication

## ️ Ejecución del proyecto

`Clonar repositorio git clone`
 `Ejecutar aplicación`

## Menú de la aplicación

============================ 
        LITER ALURA
============================


- 1 - Buscar libro por título
- 2 - Listar libros registrados
- 3 - Listar autores registrados
- 4 - Listar autores vivos en un determinado año
- 5 - Listar libros por idioma

- 0 - Salir



## Licencia
Proyecto desarrollado como parte del programa Oracle Next Education - Alura Latam.

Proyecto desarrollado con fines educativos.