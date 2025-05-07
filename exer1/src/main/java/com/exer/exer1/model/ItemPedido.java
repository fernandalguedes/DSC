package com.exer.exer1.model;

public class ItemPedido {
    private Produto produto;
    private int qtidade;

    public ItemPedido() {
    }

    public ItemPedido(Produto produto, int qtidade) {
        this.produto = produto;
        this.qtidade = qtidade;
    }


    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtidade() {
        return this.qtidade;
    }

    public void setQtidade(int qtidade) {
        this.qtidade = qtidade;
    }

}
