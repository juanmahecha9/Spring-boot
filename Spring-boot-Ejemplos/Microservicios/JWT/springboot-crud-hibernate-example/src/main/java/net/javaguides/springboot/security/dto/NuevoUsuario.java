package net.javaguides.springboot.security.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

//Clase para la creacion del nuevo usuario, is igual a la clase usuario
public class NuevoUsuario {

    @NotBlank // no puede ser un espacio vacio
    private String nombre;
    @NotBlank
    private String nombreUsuario;
    @Email // se afirma que es un email
    private String email;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();
    // Al ser una apirestse usa obj JSON, el tipo de cadenas de la informacion permite la informacion mas rapida, agiliza
    // comunicación

    //Cuantos menos datos se envian, mas fluido sera el trafico y la aplicacion sera mas eficiente

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
