package com.exemplo.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exemplo.produto.model.Produto;
import com.exemplo.produto.service.ProdutoService;


@Controller
@RequestMapping("/produtos")
public class ProdutoWebController {
    @Autowired
    private ProdutoService service;
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", service.listarTodos());
        return "produtos";
    }
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("produto", new Produto());
        return "formProduto";
    }
    @PostMapping
    public String salvar(@ModelAttribute Produto produto) {
        service.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("produto", service.buscarPorId(id));
        return "formProduto";
    }
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute Produto produto) {
        service.atualizar(id, produto);
        return "redirect:/produtos";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/produtos";
    }

}
