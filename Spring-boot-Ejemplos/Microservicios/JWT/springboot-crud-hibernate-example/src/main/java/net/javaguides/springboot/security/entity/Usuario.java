package net.javaguides.springboot.security.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "U_ID")
    private int id;

    @NotNull
    @Column(name = "U_NOMBRE")
    private String nombre;

    @NotNull
    @Column(name = "U_USUARIO_NOMBRE",unique = true)
    private String nombreUsuario;

    @NotNull
    @Column(name = "U_MAIL")
    private String email;

    @NotNull
    @Column(name = "U_PASSWORD")
    private String password;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    //Un usuario puede tener varios roles y un rol puede tener muchos usuario
    //Para esto se crean tablas intermedias
    //fetch -> ir a buscar
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    /* Antes de iniciar a explicar el código, tengo que señalar que tanto la clase HashSet como
    la clase HashMap tienen una ventaja la cual es, que los valores que se van insertando en la
    colección internamente no tendrán un orden especifico, esto se debe a que estas clases realizan
    un ordenamiento interno mediante el hashcode de el elemento(Objeto), por lo cual no sabremos que
    elemento traerá. */

    //Creación fecha
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Usuario() {
    }

    public Usuario(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
