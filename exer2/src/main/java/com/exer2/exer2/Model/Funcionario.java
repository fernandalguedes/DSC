package com.exer2.exer2.Model;

public class Funcionario {
   
    private Long id;
    private String nome;
    private double salario;
    private boolean metaAlcancada;
    private int avaliacao;
    private double bonus;

    public Funcionario() {
    }


    public Funcionario(Long id, String nome, double salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
           
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isMetaAlcancada() {
        return this.metaAlcancada;
    }

    public boolean getMetaAlcancada() {
        return this.metaAlcancada;
    }

    public void setMetaAlcancada(boolean metaAlcancada) {
        this.metaAlcancada = metaAlcancada;
    }

    public int getAvaliacao() {
        return this.avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public double getBonus() {
        return this.bonus;
    }

    public double calculaBonus(int avaliacao, boolean metaAlcancada) {
        double bonus=0.0;
        if (avaliacao >= 8 && metaAlcancada) {
            bonus = salario * 0.20;
        } else if (avaliacao >= 5) {
            bonus = salario * 0.10;
        } else {
            bonus = 0;
        }
        this.bonus=bonus;
        this.avaliacao=avaliacao;
        this.metaAlcancada=metaAlcancada;
        return bonus;
    }

    
}