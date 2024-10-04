package org.edu.unifaa.loja.controller;

import org.edu.unifaa.loja.model.Cliente;
import org.edu.unifaa.loja.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping   
    public ResponseEntity<List<Cliente>> obterTodos(){
        return ResponseEntity.ok(clienteService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> obterPorId(@PathVariable long id){
        return ResponseEntity.ok(clienteService.obterPorId(id));
    }

    @PostMapping    
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente){
        var clienteCriado = clienteService.adicionar(cliente);
        return new ResponseEntity<>(clienteCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable long id, @RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.atualizar(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id){
        clienteService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

