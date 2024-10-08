package org.edu.unifaa.loja.controller;

import org.edu.unifaa.loja.model.Endereco;
import org.edu.unifaa.loja.service.EnderecoService;
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
@RequestMapping("/api/enderecos")
public class EnderecoController {
    
  @Autowired
  private EnderecoService enderecoService;

  @GetMapping   
  public ResponseEntity<List<Endereco>> obterTodos(){
    return ResponseEntity.ok(enderecoService.obterTodos());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Endereco>> obterPorId(@PathVariable long id){
    return ResponseEntity.ok(enderecoService.obterPorId(id));
  }

  @PostMapping    
  public ResponseEntity<Endereco> adicionar(@RequestBody Endereco endereco){
    var enderecoCriado = enderecoService.adicionar(endereco);
    return new ResponseEntity<>(enderecoCriado, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Endereco> atualizar(@PathVariable long id, @RequestBody Endereco endereco){
    return ResponseEntity.ok(enderecoService.atualizar(id, endereco));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deletar(@PathVariable long id){
    enderecoService.deletar(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}

