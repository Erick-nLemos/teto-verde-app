package com.ericklemos.tetoverde.controllers;

import android.view.View;
import android.widget.TextView;

// Usando o metodo singleton
public class QtdPrdt {

    private static QtdPrdt instance;
    public int qtdAlfL, qtdAlfC, qtdRepV, qtdRuc;



    private QtdPrdt(){}

    public static QtdPrdt getInstance(){
        if (instance == null){
            instance = new QtdPrdt();
        }
        return instance;
    }


    public void somarQtdRuc(int qtd){

        this.qtdRuc = qtd++;
    }

    public void subtrairQtdRuc(int qtd){

        this.qtdRuc = qtd--;
    }

    public void somarQtdAlfC(int qtd){

        this.qtdAlfC = qtd++;
    }

    public void subtrairQtdAlfC(int qtd){

        this.qtdAlfC = qtd--;
    }

    public void somarQtdAlfL(int qtd){

        this.qtdAlfL = qtd++;
    }

    public void subtrairQtdAlfL(int qtd){

        this.qtdAlfL = qtd--;
    }

    public void somarQtdRepV(int qtd){

        this.qtdRepV = qtd++;
    }

    public void subtrairQtdRepV(int qtd){

        this.qtdRepV = qtd--;
    }

    // getters e setters ================================
    public int getQtdAlfL() {
        return qtdAlfL;
    }

    public void setQtdAlfL(int qtdAlfL) {
        this.qtdAlfL = qtdAlfL;
    }

    public int getQtdAlfC() {
        return qtdAlfC;
    }

    public void setQtdAlfC(int qtdAlfC) {
        this.qtdAlfC = qtdAlfC;
    }

    public int getQtdRepV() {
        return qtdRepV;
    }

    public void setQtdRepV(int qtdRepV) {
        this.qtdRepV = qtdRepV;
    }

    public int getQtdRuc() {
        return qtdRuc;
    }

    public void setQtdRuc(int qtdRuc) {
        this.qtdRuc = qtdRuc;
    }

}
