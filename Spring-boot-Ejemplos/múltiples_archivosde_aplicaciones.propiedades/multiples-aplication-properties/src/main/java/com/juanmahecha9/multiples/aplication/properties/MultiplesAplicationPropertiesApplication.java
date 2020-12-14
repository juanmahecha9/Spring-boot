package com.juanmahecha9.multiples.aplication.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@SpringBootApplication
public class MultiplesAplicationPropertiesApplication {

    @RequestMapping("/")
    String home() {
        return "Juan David Mahecha Cruz";
    }


    public static void main(String[] args) {
        SpringApplication.run(MultiplesAplicationPropertiesApplication.class, args);
        System.out.println("  ____                              \n" +
                " |  _ \\   _   _   _ __              \n" +
                " | |_) | | | | | | '_ \\             \n" +
                " |  _ <  | |_| | | | | |  _   _   _ \n" +
                " |_| \\_\\  \\__,_| |_| |_| (_) (_) (_)\n" +
                "                                    ");
    }

}
