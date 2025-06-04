package com.relacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.relacionamento.entity.Produto;
import com.relacionamento.service.CategoriaService;
import com.relacionamento.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/web/produtos")
public class ProdutoWebController {
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listar(Model m) {
        List<Produto> produtos=produtoService.listarTodos();
        m.addAttribute("produtos", produtos);
        return "produtos";
    }
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("produtos", new Produto());
        model.addAttribute("categorias", categoriaService.listarTodos());
        return "form_produto";
      
    }   
    @PostMapping("/novo")
    public String criar(@ModelAttribute Produto produto) {
        produtoService.salvar(produto);
        return"redirect:/web/produtos";

    }
}

