package com.relacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relacionamento.entity.Categoria;
import com.relacionamento.service.CategoriaService;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    

    @Autowired
    private CategoriaService categoriaService;
    public List<Categoria> listar() {
        return categoriaService.listarTodos();
    }
    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }
    
}
