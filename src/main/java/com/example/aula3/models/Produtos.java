package com.example.aula3.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @OneToMany(mappedBy = "categoriaCurso")
    private List<Categorias> cursos;

    public Produtos() {
    }

    public Produtos(int id, String nome) {
        this.id = id;
        this.nome = nome;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Categorias> getCursos() {
        return cursos;
    }

    public void setCursos(List<Categorias> cursos) {
        this.cursos = cursos;
    }
}
