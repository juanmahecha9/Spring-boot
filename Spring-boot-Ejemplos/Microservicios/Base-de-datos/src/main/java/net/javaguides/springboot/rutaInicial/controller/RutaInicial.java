package net.javaguides.springboot.rutaInicial.controller;

import net.javaguides.springboot.rutaInicial.ModelRutaInicial;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RutaInicial {

    //Toma la variable de entorno y la vuelve una variable en el código.
    @Value("${server.port}")
    private int port;

    ModelRutaInicial modelRutaInicial = new ModelRutaInicial();

    @GetMapping(value = "/")
    public String Start() {

        modelRutaInicial.setAutor("Juan David Mahecha");
        modelRutaInicial.setProyecto("Proyecto enfocado a los microservicos");

        String json = "{ \\n" +
                "'Autor': " + modelRutaInicial.getAutor() +
                "\\n 'Proyecto': " + modelRutaInicial.getProyecto() +
                "  \\n" +
                "_***-***-***-***_}";
        return json;
    }
}
