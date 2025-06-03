package com.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relacionamento.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
}
