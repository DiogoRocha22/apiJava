package org.edu.unifaa.loja.repository;

import org.edu.unifaa.loja.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}