package com.juanamhecha9.Base_de_datos.Producto.Service;

import com.juanamhecha9.Base_de_datos.Producto.Model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {

    Producto getProdcutoById(int id);

    List<Producto>getAllProducto();

}
