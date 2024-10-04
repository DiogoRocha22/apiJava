package org.edu.unifaa.loja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduto")
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private boolean ativo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    public Produto(String nome, Categoria categoria, boolean ativo, String descricao, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.ativo = ativo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto() {
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

}
