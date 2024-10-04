package org.edu.unifaa.loja.service;

import org.edu.unifaa.loja.model.Categoria;
import org.edu.unifaa.loja.model.Produto;
import org.edu.unifaa.loja.model.excetion.ResourceBadRequestException;
import org.edu.unifaa.loja.model.excetion.ResourceNotFoundException;
import org.edu.unifaa.loja.repository.CategoriaRepository;
import org.edu.unifaa.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto adicionar(Produto produto){
        validarProduto(produto);

        Categoria categoria = categoriaRepository.findById(produto.getCategoria().getId())
        .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        produto.setCategoria(categoria);
            
        produto.setId(0);
        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(long id){

        Optional<Produto> produtoLocalizado = produtoRepository.findById(id);

        if(produtoLocalizado.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar um ingrediente com o id: " + id);
        }

        return produtoLocalizado;
    }

    public Produto atualizar(long id, Produto produto){

        obterPorId(id);
        produto.setId(id);

        if(produto.getNome().equals("")){
            throw new ResourceBadRequestException("O nome da produto é obrigatorio.");
        }

        return produtoRepository.save(produto);
    }

    public void deletar(long id){
        obterPorId(id);
        produtoRepository.deleteById(id);
    }

    private void validarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new ResourceBadRequestException("Nome do produto é obrigatório.");
        }
        if (produto.getPreco() <= 0) {
            throw new ResourceBadRequestException("Preço é obrigatório.");
        }
    }
}
