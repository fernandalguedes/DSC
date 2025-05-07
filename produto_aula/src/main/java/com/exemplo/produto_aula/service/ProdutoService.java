package com.exemplo.produto_aula.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.produto_aula.model.Produto;
import com.exemplo.produto_aula.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    /*public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository=produtoRepository;
    }*/
    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }
    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }
    /////////
  
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
   
    public Produto atualizar(Long id, Produto novo) {
        Produto produto = buscarPorId(id);
        produto.setNome(novo.getNome());
        produto.setPreco(novo.getPreco());
        return produtoRepository.save(produto);
    }
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

}
