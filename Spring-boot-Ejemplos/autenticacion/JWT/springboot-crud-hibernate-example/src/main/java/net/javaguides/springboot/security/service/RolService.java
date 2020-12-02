package net.javaguides.springboot.security.service;


import net.javaguides.springboot.security.entity.Rol;
import net.javaguides.springboot.security.enums.RolNombre;
import net.javaguides.springboot.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        //Método para buscar si encuentra por el nombre del rol
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        //Guardar
        rolRepository.save(rol);
    }
}