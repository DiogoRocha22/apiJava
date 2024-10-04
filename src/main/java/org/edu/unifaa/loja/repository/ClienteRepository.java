package org.edu.unifaa.loja.repository;

import org.edu.unifaa.loja.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
