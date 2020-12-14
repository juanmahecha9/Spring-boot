package com.juanmahecha9.multiples.aplication.properties.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ControllerInit {

    @Value("${server.port}")
    private int port;
    @Value("${perfil}")
    private String perfil;

    @GetMapping
    String home() {
        return "Juan David Mahecha Cruz \n Aplicación ejecutada en el puerto: " + port + "\n Apliación en modo: " + perfil;
    }

}



