package org.edu.unifaa.loja.service;

import org.edu.unifaa.loja.model.Endereco;
import org.edu.unifaa.loja.model.excetion.ResourceBadRequestException;
import org.edu.unifaa.loja.model.excetion.ResourceNotFoundException;
import org.edu.unifaa.loja.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco adicionar(Endereco endereco) {
        validarEndereco(endereco);
        endereco.setId(0L); 
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> obterTodos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> obterPorId(long id) {
        Optional<Endereco> enderecoLocalizado = enderecoRepository.findById(id);

        if (enderecoLocalizado.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possível encontrar um endereço com o id: " + id);
        }

        return enderecoLocalizado;
    }

    public Endereco atualizar(long id, Endereco endereco) {
        obterPorId(id);
        validarEndereco(endereco);
        endereco.setId(id);

        return enderecoRepository.save(endereco);
    }

    public void deletar(long id) {
        obterPorId(id);
        enderecoRepository.deleteById(id);
    }

    private void validarEndereco(Endereco endereco) {
        if (endereco.getRua() == null || endereco.getRua().isEmpty()) {
            throw new ResourceBadRequestException("Rua é obrigatória.");
        }
        if (endereco.getCidade() == null || endereco.getCidade().isEmpty()) {
            throw new ResourceBadRequestException("Cidade é obrigatória.");
        }
        if (endereco.getEstado() == null || endereco.getEstado().isEmpty()) {
            throw new ResourceBadRequestException("Estado é obrigatório.");
        }
        if (endereco.getCep() == null || endereco.getCep().isEmpty()) {
            throw new ResourceBadRequestException("CEP é obrigatório.");
        }
    }
}
