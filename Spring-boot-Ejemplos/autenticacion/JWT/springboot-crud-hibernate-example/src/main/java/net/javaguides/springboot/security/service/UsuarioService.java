package net.javaguides.springboot.security.service;

import net.javaguides.springboot.security.entity.Usuario;
import net.javaguides.springboot.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    //inyectar el usuario repositirio
    @Autowired
    UsuarioRepository usuarioRepository;

    //MÉTODOS
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        //Obtener por nombre de usuario
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario){
        //verificar si existe el nombre de usuario
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        //Verificar si existe el correo
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        //Crear nuevo usuario (GUARDAR)
        usuarioRepository.save(usuario);
    }
}