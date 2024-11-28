package com.ericklemos.tetoverde;

public class Produto {
    private String  nome;
    private double valor;
    private int qtd;

    public Produto(){}
    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }
    public void somarQtd(int qtd){

        this.qtd = qtd++;
    }

    public void subtrairQtd(int qtd) {

        this.qtd = qtd--;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
