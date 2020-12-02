package net.javaguides.springboot.util;


import net.javaguides.springboot.security.entity.Rol;
import net.javaguides.springboot.security.enums.RolNombre;
import net.javaguides.springboot.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {


    @Autowired
    RolService rolService;


    @Override
    public void run(String... args) throws Exception {
       /* Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
         Rol rolUser = new Rol(RolNombre.ROLE_USER);
         rolService.save(rolAdmin);
         rolService.save(rolUser);*/

    }
}
