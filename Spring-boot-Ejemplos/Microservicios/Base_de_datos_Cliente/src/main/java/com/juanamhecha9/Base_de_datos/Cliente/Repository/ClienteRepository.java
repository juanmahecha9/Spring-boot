package com.juanamhecha9.Base_de_datos.Cliente.Repository;

import com.juanamhecha9.Base_de_datos.Cliente.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
