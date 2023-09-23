package com.example.aula3.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.aula3.models.Produtos;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produtos inserir(Produtos categoriaCurso) {
        entityManager.persist(categoriaCurso);
        return categoriaCurso;
    }

    public List<Produtos> obterTodos() {
        return entityManager
                .createQuery("from CategoriaCurso",
                        Produtos.class)
                .getResultList();
    }

}
