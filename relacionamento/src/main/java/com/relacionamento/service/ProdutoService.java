package com.relacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relacionamento.entity.Produto;
import com.relacionamento.repository.ProdutoRepository;

import java.util.List;
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
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}

