package org.edu.unifaa.loja.repository;

import org.edu.unifaa.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
