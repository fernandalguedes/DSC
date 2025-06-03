package com.relacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relacionamento.entity.Categoria;
import com.relacionamento.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }
    public void excluir(Long id) {
        categoriaRepository.deleteById(id);
    }
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
}
