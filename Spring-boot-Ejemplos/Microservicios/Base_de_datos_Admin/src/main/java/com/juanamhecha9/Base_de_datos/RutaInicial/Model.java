package com.juanamhecha9.Base_de_datos.RutaInicial;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "T_AUTOR")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "D_NOMBRE")
    private String autor;
    @NotNull
    @Column(name = "D_PROYECTO")
    private String proyecto;
    @NotNull
    @Column(name = "D_FECHA")
    private String fecha;

    public Model(String autor, String proyecto, String fecha) {
        this.autor = autor;
        this.proyecto = proyecto;
        this.fecha = fecha;
    }

    public Model() {

    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
