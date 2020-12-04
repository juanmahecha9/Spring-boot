package com.juanamhecha9.Base_de_datos.Cliente.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "T_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "C_NOMBRE", length = 1024)
    private String nombre;

    @NotNull
    @Column(name = "C_IDENTIFICACION", unique = true)
    private int identificacion;

    @NotNull
    @Column(name = "C_CORREO", length = 1024)
    private String correo;

    @Column(name = "C_COMENTARIO")
    private  String comentario;

    public Cliente(){

    }

    public Cliente(String nombre, int identificacion, String correo, String comentario) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.comentario = comentario;
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

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
