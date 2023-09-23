package com.example.aula3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.aula3.models.Categorias;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categorias inserir(Categorias curso) {
        entityManager.merge(curso);
        return curso;
    }

    public List<Categorias> obterTodos() {
        return entityManager.createQuery("from Curso",
                Categorias.class).getResultList();
    }

    public List<Categorias> obterPorNome(String nome) {
        String jpql = " select c from Curso c where c.nome like :nome";
        TypedQuery<Categorias> query = entityManager.createQuery(jpql, Categorias.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

}
