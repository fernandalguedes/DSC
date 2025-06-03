package com.relacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relacionamento.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    
}
