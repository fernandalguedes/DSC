package com.relacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.relacionamento.entity.Categoria;
import com.relacionamento.service.CategoriaService;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/web/categorias")
public class CategoriaWebController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public String listar(Model m) {
        List<Categoria> categorias=categoriaService.listarTodos();
        m.addAttribute("categorias", categorias);
        return "categorias";
    }
    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("categorias", new Categoria());
        return "form_categoria";
    }   
    @PostMapping("/novo")
    public String criar(@ModelAttribute Categoria categoria) {
        categoriaService.salvar(categoria);
        return"redirect:/web/categorias";

    }
}
