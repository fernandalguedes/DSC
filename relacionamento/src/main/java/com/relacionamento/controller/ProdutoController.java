package com.relacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.relacionamento.entity.Produto;
import com.relacionamento.service.ProdutoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

   @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoService.salvar(produto);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.excluir(id);
    }
}
