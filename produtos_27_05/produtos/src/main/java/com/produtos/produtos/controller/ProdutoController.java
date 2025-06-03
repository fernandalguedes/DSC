package com.produtos.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.produtos.entity.Produto;
import com.produtos.produtos.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("")
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    @PostMapping("/salvar")
    public Produto salvar(@RequestBody Produto produto) {

        return produtoService.salvar(produto);
    }

    @GetMapping("/buscar-por-nome")
    public List<Produto> buscarPorNome(@RequestParam String nome) {
        return produtoService.findByNome(nome);

    }

    @GetMapping("/preco-maior-que")
    public List<Produto> buscarPorPrecoMaiorQue(@RequestParam double preco) {
        return produtoService.findByPrecoGreaterThan(preco);
    }

}
