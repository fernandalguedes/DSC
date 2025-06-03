package com.produtos.produtos.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.produtos.entity.Produto;
import com.produtos.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }   
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();

    }
    public List<Produto> findByNome(String nome){
        return produtoRepository.findByNome(nome);
    } 
    public List<Produto> findByPrecoGreaterThan(double preco){
        return produtoRepository.findByPrecoGreaterThan(preco);
    } 
}


