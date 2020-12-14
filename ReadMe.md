# Link de libros 
-https://riptutorial.com/Download/spring-boot-es.pdf

# SpringBoot

Spring Boot proporciona un excelente soporte para crear e incorporar fuentes de datos en todas las bases de datos SQL o NoSQL que queramos. Por lo tanto, no necesitas escribir ningún código para crear una nueva fuente de datos, sino, simplemente, añadir las correspondientes dependencias y datos de configuración.

Nos permite compilar nuestras aplicaciones Web como un archivo .jar que podemos ejecutar como una aplicación Java normal (como alternativa a un archivo .war , que desplegaríamos en un servidor de aplicaciones como Tomcat). Esto lo consigue integrando el servidor de aplicaciones en el propio.

Aunque no sea una característica única de Spring, el uso de inyección de dependencias facilita la programación contra interfaz, permitiendo a los distintos componentes depender únicamente de interfaces y produciendo así un código menos acoplado. No solo eso, también permite implementar el patrón singleton de una forma extremadamente sencilla (por defecto, las dependencias que inyectamos son singletons).

Hay cientos de tecnologías que Spring permite integrar. Desde bibliotecas que implementan opentracing hasta las que nos generan métricas para nuestra aplicación, pasando por serialización/deserialización a JSON y XML, seguridad con OAuth2 o programación reactiva entre otras.

# MySQL

MySQL es un sistema de gestión de bases de datos relacional desarrollado bajo licencia dual: Licencia pública general/Licencia comercial por Oracle Corporation y está considerada como la base de datos de código abierto más popular del mundo y una de las más populares en general junto a Oracle y Microsoft SQL Server, todo para entornos de desarrollo web.

# Archivos ojdbc.x

Java Database Connectivity (en español: Conectividad a bases de datos de Java), más conocida por sus siglas JDBC,1​2​ es una API que permite la ejecución de operaciones sobre bases de datos desde el lenguaje de programación Java, independientemente del sistema operativo donde se ejecute o de la base de datos a la cual se accede, utilizando el dialecto SQL del modelo de base de datos que se utilice.

OJDBC.x es Conectividad a bases de datos de Java a Oracle

~~ # ¿Qué contiene el repositorio? ~~

## ¿Qué contiene este repositorio?
En este repositorio se tendran ejemplos realizados para comprender el uso basico de spring boot.

# Como ejecutar un programa spring boot
Para poder ejecutar un programa de spring boot, se tiene que contar con los servicos de java en la maquina local, donde, es importante tener:
    -Open JDK11
    -Java SE Development Kit 8u271
    -Maven

## ¿Como ejecutar el programa?
1. Dirigirse hacia la carpeta que contiene el programa: `cd {ruta}/{carpeta}`
2. Instalar el programa inicializandolo como maven: `mvn clean install`
    -Si al finalizar la ejecución del archivo pararece
        [INFO] -----------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] -----------------------------------------------------------
    El archivo ha compilado de manera satisfactoria y se puede proceder al siguiente paso, de lo contrario se revisa que error se esta presentando.
3. Al ejecutar el comando pasado, se crea una carpera denomidada target, a la cual se navegara con `cd target`
4. Dentro de esta carpeta se encontrará un archivo con el nombre: `[{nmbre del programa}]-0.0.1-SNAPSHOT.jar`, este se procede a ejecutar con el comando: `java - jar [{nmbre del programa}]-0.0.1-SNAPSHOT.jar`, el cual ejecutara el ambiente de java y correra los servicios enel puerto seleccionado, en este caso el puerto 8080


# Para instalar el controlador de Oracle
el archivo ojdbc7.jar, es el controlador de oracle, para agregar un controlador JDBC de Oracle en su repositorio local de Maven, y también cómo hacer referencia a él en pom.xml

1. Cargue o instale lo descargado ojdbc.jaren el repositorio local de Maven.
- version 8
`mvn install:install-file -Dfile={path}/ojdbc[8].jar DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=19.3 -Dpackaging=jar`

- version 7
`mvn install:install-file -Dfile={path}/ojdbc7.jar -DgroupId=com.oracle  -DartifactId=ojdbc7 -Dversion=12.2.0.1 -Dpackaging=jar`

2. En el archivo pom.xml se puede definir la dependencia del controlador Oracle JDBC de esta manera:
- Verion 8
    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc8</artifactId>
        <version>19.3</version>
    </dependency>

- Version 7
    <!-- ojdbc7.jar -->
    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc7</artifactId>
        <version>12.2.0.1</version>
    </dependency>

3. Ruta del sistema, Alternativamente, podemos simplemente descargar el .jary decirle al proyecto que lo busque .jaren la ruta del sistema de esta manera:
    <dependency>
        <groupId>com.oracle</groupId>
        <artifactId>ojdbc</artifactId>
        <version>8 - 7 - 6 - old</version>
        <scope>system</scope>
        <systemPath>{path}/ojdbc[8 - 7 - 6 - old].jar</systemPath>
    </dependency>

    
