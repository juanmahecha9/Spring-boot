package net.javaguides.springboot.rutaInicial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RutaInicial {


    private int port = 8080;

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

        String json = " CRUD de los productos: http://localhost:" + port + "/products";

        return json;
    }

}
