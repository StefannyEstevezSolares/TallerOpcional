# Super Smash Bros. Tournament Manager

<p align="center">
  <img src="docs/images/personajes.png"
       alt="Personajes de Super Smash Bros."
       width="550">
</p>

## Introducción

Desarrollé este proyecto utilizando Java, Spring Boot, Spring Data JPA y MySQL. La temática está basada en los torneos de Super Smash Bros., donde diferentes personajes pueden participar en distintos torneos. Se eligió esta temática porque es un videojuego que podía aprovecharse de muchas maneras para poder cumplir con el objetivo del proyecto, las entidades y las relaciones requeridas.

El objetivo principal es representar una relación de muchos a muchos entre las entidades `Personaje` y `Torneo`, utilizando una tercera entidad llamada `Participacion` como tabla intermedia.

Esta entidad permite relacionar a los personajes con los torneos y almacenar información adicional, como la posición obtenida y los puntos alcanzados.

El proyecto fue realizado para poner en práctica el uso de las relaciones `@OneToMany` y `@ManyToOne` mediante JPA, así como la persistencia y consulta de información utilizando Spring Data JPA.

## Temática del proyecto

El sistema representa la participación de diferentes personajes en torneos de Super Smash Bros.

<p align="center">
  <img src="docs/images/torneo.jpg"
       alt="Torneo de Super Smash Bros."
       width="550">
</p>

Se utilizan dos entidades principales:

- **Personaje:** almacena el nombre, universo y tipo de cada personaje.
- **Torneo:** almacena el nombre, ubicación y fecha de cada torneo.

La entidad intermedia `Participacion` relaciona ambas entidades y registra la posición y los puntos obtenidos por cada personaje en un torneo.

<p align="center">
  <img src="docs/images/torneo.png" alt="Torneo de Super Smash Bros." width="550">
</p>

## Entidades y relaciones

El proyecto está compuesto por tres entidades:

### Personaje

Representa a los personajes que participan en los torneos.

Atributos:
- `id`
- `nombre`
- `universo`
- `tipo`

Utiliza `@OneToMany` para establecer la relación con `Participacion`, ya que un personaje puede tener varias participaciones.

### Torneo

Representa los torneos en los que compiten los personajes.

Atributos:
- `id`
- `nombre`
- `ubicacion`
- `fecha`

Utiliza `@OneToMany` para establecer la relación con `Participacion`, porque un torneo puede tener varios participantes.

### Participacion

Es la entidad intermedia que permite relacionar las dos entidades principales.

Atributos:
- `id`
- `personaje`
- `torneo`
- `posicion`
- `puntos`

Utiliza dos relaciones `@ManyToOne`: una con `Personaje` y otra con `Torneo`.

### Funcionamiento de las relaciones

La relación muchos a muchos se representa mediante la entidad intermedia `Participacion`, sin utilizar directamente la anotación `@ManyToMany`.

- Un personaje puede participar en varios torneos.
- Un torneo puede tener varios personajes.
- Cada registro de participación pertenece a un personaje y a un torneo.

Se utiliza `mappedBy` en las entidades `Personaje` y `Torneo` para indicar que la relación está administrada desde los atributos correspondientes de `Participacion`.

La entidad `Participacion` es el lado propietario de las relaciones, porque contiene las claves foráneas mediante `@JoinColumn`.

## Cómo ejecutar el proyecto

### Requisitos

- Java JDK 17.
- Maven.
- MySQL Server.
- MySQL Workbench.
- NetBeans u otro IDE compatible con proyectos Maven.

### 1. Crear la base de datos

Abrir MySQL Workbench y ejecutar:

```sql
CREATE DATABASE smash_bros_db;
```

### 2. Configurar la conexión a MySQL

Abrir el archivo `application.properties` y configurar el usuario y la contraseña de MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smash_bros_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

Reemplazar `TU_USUARIO` y `TU_CONTRASEÑA` por las credenciales de la instalación local de MySQL.

### 3. Ejecutar la aplicación

1. Abrir el proyecto en NetBeans.
2. Verificar que Maven haya descargado las dependencias.
3. Ejecutar la opción **Clean and Build**.
4. Si la compilación finaliza correctamente, ejecutar el proyecto desde NetBeans.

Los registros iniciales se crean únicamente cuando las tres tablas están vacías.

## Video explicativo

En el siguiente enlace se encuentra la carpeta de Google Drive donde están los videos de explicación y demostración del proyecto.

[Acceder a los videos del proyecto](https://drive.google.com/drive/folders/1KQnKf9UNrC6PQfR6LiD9jx94fykpjCD7?usp=sharing)

