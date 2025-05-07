package com.exemplo.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.exemplo.produto.model.Produto;
import com.exemplo.produto.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/web")
public class ProdutoWebController {

    @Autowired
    private ProdutoService produtoServiceWeb;  
   
    @GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("produtos",produtoServiceWeb.listarTodos());
        //model.addAttribute("x","teste");
        return "produtos";
    }
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("produto",new Produto());
        
        return "formProduto";
    }
    @PostMapping("/novoPost")
    public String salvar(@ModelAttribute Produto produto) {
        produtoServiceWeb.salvar(produto);
        return "redirect:/web";
    }
    

    
    
    
    
}
