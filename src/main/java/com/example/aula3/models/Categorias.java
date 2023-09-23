package com.example.aula3.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(nullable = false)
    private int descricao;
    @ManyToOne
    @JoinColumn(name = "categoriaProduto_id")
    private Produtos categoriaProdutos;

    public Categorias(Long id, String nome, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categorias() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int descricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Categoria [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
    }

    public Produtos getCategoriaProdutos() {
        return categoriaProdutos;
    }

    public void setCategoriaProdutos(Produtos categoriaCurso) {
        this.categoriaProdutos = categoriaProdutos;
    }

}
