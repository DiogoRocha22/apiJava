package org.edu.unifaa.loja.service;

import org.edu.unifaa.loja.model.Cliente;
import org.edu.unifaa.loja.model.Endereco;
import org.edu.unifaa.loja.model.excetion.ResourceBadRequestException;
import org.edu.unifaa.loja.model.excetion.ResourceNotFoundException;
import org.edu.unifaa.loja.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {
    
    @Autowired 
    private ClienteRepository clienteRepository;

    public Cliente adicionar(Cliente cliente){

        if(cliente.getNome().equals("")){
            throw new ResourceBadRequestException("O nome do cliente é obrigatorio.");
        }

        for (Endereco endereco : cliente.getEnderecos()) {
            endereco.setCliente(cliente);
        }

        cliente.setId(0);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obterTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obterPorId(long id){

        Optional<Cliente> clienteLocalizado = clienteRepository.findById(id);

        if(clienteLocalizado.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel encontrar o cliente com o id: " + id);
        }

        return clienteLocalizado;
    }

    public Cliente atualizar(long id, Cliente cliente){
        obterPorId(id);
        cliente.setId(id);

        if(cliente.getNome().equals("")){
            throw new ResourceBadRequestException("O nome do cliente é obrigatorio.");
        }

        return clienteRepository.save(cliente);
    }

    public void deletar(long id){
        obterPorId(id);
        clienteRepository.deleteById(id);
    }

}
