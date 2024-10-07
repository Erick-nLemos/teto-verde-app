package com.ericklemos.tetoverde.controllers;

import android.view.View;
import android.widget.TextView;

public class QtdPrdt {

    private int qtdPrdt;
    public void somarQtd(int qtd){

        this.qtdPrdt = qtd++;
    }

    public void subtrairQtd(int qtd){

        this.qtdPrdt = qtd--;
    }

    public int getQtdPrdt(){
        return qtdPrdt;
    }

    public void setQtdPrdt(int qtdPrdt){
        this.qtdPrdt = qtdPrdt;
    }
}
