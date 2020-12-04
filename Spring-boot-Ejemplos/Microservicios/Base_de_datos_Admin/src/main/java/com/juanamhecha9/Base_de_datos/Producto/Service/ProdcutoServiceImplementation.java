package com.juanamhecha9.Base_de_datos.Producto.Service;

import com.juanamhecha9.Base_de_datos.Exception.ResourceNotFoundException;
import com.juanamhecha9.Base_de_datos.Producto.Model.Producto;
import com.juanamhecha9.Base_de_datos.Producto.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdcutoServiceImplementation implements ProductoService {

    @Autowired
    ProductoRepository clienteRepository;


    @Override
    public Producto getProdcutoById(int id) {
        Optional<Producto> productodb = this.clienteRepository.findById(id);

        if(productodb.isPresent()){
            return productodb.get();
        } else {
            throw new ResourceNotFoundException("Registro no exixtente");
        }
    }

    @Override
    public List<Producto> getAllProducto() {
        return this.clienteRepository.findAll();
    }
}
