package net.javaguides.springboot.rutaInicial.controller;

import net.javaguides.springboot.rutaInicial.ModelRutaInicial;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RutaInicial {

    @Value("${server.port}")
    private int port;

    ModelRutaInicial modelRutaInicial = new ModelRutaInicial();

    @GetMapping(value = "/")
    public String Start() {

        modelRutaInicial.setAutor("Juan David Mahecha");
        modelRutaInicial.setProyecto("Proyecto Desarrollado con MySQL, H2, JWT, envio de coreos");

        String json = "{ \\n" +
                "'Autor': " + modelRutaInicial.getAutor() +
                "\\n 'Proyecto': " + modelRutaInicial.getProyecto() +
                "\\n 'Rutas': http://localhost:" + port + "/rutas" +
                "}";
        return json;
    }

    @GetMapping(value = "/rutas")
    public String Startx() {

        String json = " Las peticiones HTTP se realizan con el mismo URL, solo varia el verbo HTTP y dependiendo de el, se agrega una variable que sera el ID \n" +
                " CRUD de los productos: http://localhost:" + port + "/products \n " +
                " CRUD de los clientes: http://localhost:" + port + "/clients \n";


        return json;
    }

}
