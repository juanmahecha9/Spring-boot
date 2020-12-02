# CRUD Spring Boot con H2

## Dependencias usadas en este proyecto:
Spring Web, H2 Database y Spring Data JPA

# Pasos del proyecto:
1. Crear el modelo de datos
2. Crear el archivo XService, donde se crean los metodos de los verbos HTTP, archivo en forma de interface
3. Crear archivo Xreposotory
4. Crear el Xcontrolador
5. Crear las excepciones
6. Crear un Xservicio que implemente todos los metodos del servicio anterior.

# ¿Como ejecutar el programa?
1. Dirigirse hacia la carpeta que contiene el programa: `cd {ruta}/{carpeta}`
2. Instalar el programa inicializandolo como maven: `mvn clean install`
    -Si al finalizar la ejecución del archivo pararece
        [INFO] -----------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] -----------------------------------------------------------
    El archivo ha compilado de manera satisfactoria y se puede proceder al siguiente paso, de lo contrario se revisa que error se esta presentando.
3. Al ejecutar el comando pasado, se crea una carpera denomidada target, a la cual se navegara con `cd target`
4. Dentro de esta carpeta se encontrará un archivo con el nombre: `[{nmbre del programa}]-0.0.1-SNAPSHOT.jar`, este se procede a ejecutar con el comando: `java - jar [{nmbre del programa}]-0.0.1-SNAPSHOT.jar`, el cual ejecutara el ambiente de java y correra los servicios enel puerto seleccionado, en este caso el puerto 8080


# ¿Cómo probar el microservicio con postman o insomnia?
        Nota: Postman o insomnia son entornos de desarrollo de APIs que permite diseñar, probar y monitorizar servicios de tipo REST.

1. Abrir cualquiera de los porgramas.
2. Seleccionar el metodo o verbo HTTP a usar 
    -GET
    -POST
    -PUT
    -DELETE
        Que son los mas populares
    -PATCH
    -COPY
    -HEAD
    etc...
3. Enrutar la dirección del servicio: en este caso 'http://localhost:8080/clients'  o 'http://localhost:8080/products'


# ¿Qué es H2 DataBase?
Es un motor de base de datos Open Source escrito en su totalidad en Java.
 Puede ser incorporado en aplicaciones Java o ejecutarse de modo cliente-servidor. Una de las características más importantes de H2 es que se puede integrar completamente en aplicaciones Java y acceder a la base de datos lanzando SQL directamente, sin tener que pasar por una conexión a través de sockets.