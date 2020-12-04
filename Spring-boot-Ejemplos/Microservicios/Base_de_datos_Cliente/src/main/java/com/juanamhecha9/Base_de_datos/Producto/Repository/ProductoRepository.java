package com.juanamhecha9.Base_de_datos.Producto.Repository;

import com.juanamhecha9.Base_de_datos.Producto.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

}
