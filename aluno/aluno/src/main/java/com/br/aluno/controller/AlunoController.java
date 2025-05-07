package com.br.aluno.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.aluno.model.Aluno;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    
    private List<Aluno> alunos = new ArrayList<>();
    @PostMapping
    public ResponseEntity<String> adicionarAluno(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body("Aluno adicionado com sucesso!");
    }
    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        return ResponseEntity.ok(alunos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAluno(@PathVariable Long id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return ResponseEntity.ok(aluno);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                aluno.setNome(alunoAtualizado.getNome());
                aluno.setIdade(alunoAtualizado.getIdade());
                return ResponseEntity.ok("Aluno atualizado com sucesso!");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
    }
    /*@DeleteMapping("/{id}")
    public ResponseEntity<String> removerAluno(@PathVariable Long id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                alunos.remove(aluno);
                return ResponseEntity.ok("Aluno removido com sucesso!"+aluno);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerAluno(@PathVariable Long id) {
        Iterator<Aluno> iterator = alunos.iterator();
        
        while (iterator.hasNext()) {
            Aluno aluno = iterator.next();
            if (aluno.getId().equals(id)) {
                iterator.remove(); // Remove o aluno da lista
                return ResponseEntity.ok("Aluno removido com sucesso: " + aluno.getNome());
            }
        }
    
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
    }
}

