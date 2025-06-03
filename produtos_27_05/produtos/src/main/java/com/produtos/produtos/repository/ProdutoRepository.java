package com.produtos.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.produtos.produtos.entity.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    List<Produto> findByNome(String nome); // WHERE nome = ?
    List<Produto> findByPrecoGreaterThan(Double preco); // WHERE preco >
}
