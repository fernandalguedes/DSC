package com.exemplo.produto_aula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.produto_aula.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
}