package org.edu.unifaa.loja.service;

import org.edu.unifaa.loja.model.Categoria;
import org.edu.unifaa.loja.model.excetion.ResourceBadRequestException;
import org.edu.unifaa.loja.model.excetion.ResourceNotFoundException;
import org.edu.unifaa.loja.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria){

        if(categoria.getNome().equals("")){
            throw new ResourceBadRequestException("O nome da Categoria é obrigatorio.");
        }

       

        categoria.setId(0);
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> obterTodos(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> obterPorId(long id){

        Optional<Categoria> categoriaLocalizada = categoriaRepository.findById(id);

        if(categoriaLocalizada.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar um ingrediente com o id: " + id);
        }

        return categoriaLocalizada;
    }

    public Categoria atualizar(long id, Categoria categoria){

        obterPorId(id);
        categoria.setId(id);

        if(categoria.getNome().equals("")){
            throw new ResourceBadRequestException("O nome da categoria é obrigatorio.");
        }

        return categoriaRepository.save(categoria);
    }

    public void deletar(long id){
        obterPorId(id);
        categoriaRepository.deleteById(id);
    }

}
