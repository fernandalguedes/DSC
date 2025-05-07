package com.exer.exer1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exer.exer1.model.ItemPedido;
import com.exer.exer1.model.Pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/exer1")
public class PedidoController {

    private List<Pedido> pedidos =new ArrayList<>();
    private List<ItemPedido> itens=new ArrayList<>();
    double valorTotal;
    double desconto;
    @PostMapping("/pedidos")
    public ResponseEntity<?> criarPedido(@RequestBody Pedido pedido) {
        itens=pedido.getItens();      
        for (ItemPedido item : itens) {
            valorTotal += item.getProduto().getPreco() * item.getQtidade();
        }
       
        if (valorTotal > 1000) {
            desconto = valorTotal * 0.15;
        } else if (valorTotal > 500) {
            desconto = valorTotal * 0.10;
        } else {
            desconto = 0;
        }
        pedido.setValorTotal(valorTotal-desconto);
        pedido.setDesconto(desconto);
       
        pedidos.add(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido adicionado com sucesso!");
    }
    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> buscarPedidos(@PathVariable Long id) {
        for(Pedido pedido:pedidos){

            if (pedido.getId().equals(id)) {
                return ResponseEntity.ok(pedido);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    
}
