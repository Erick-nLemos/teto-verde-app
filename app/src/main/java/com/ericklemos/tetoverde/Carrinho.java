package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Carrinho extends AppCompatActivity {

    TextView txtQtdRuc, txtQtdAlfL, txtQtdAlfC, txtQtdRepV;
    ConstraintLayout container1, container2, container3, container4;
    ArrayList<Produto> listaProdutos = Market.listaProdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        txtQtdRuc = findViewById(R.id.txtQtdRuc);
        txtQtdAlfL = findViewById(R.id.txtQtdAlfL);
        txtQtdAlfC = findViewById(R.id.txtQtdAlfC);
        txtQtdRepV = findViewById(R.id.txtQtdRepV);
        container1 = findViewById(R.id.ContainerProdt1);
        container2 = findViewById(R.id.ContainerProdt2);
        container3 = findViewById(R.id.ContainerProdt3);
        container4 = findViewById(R.id.ContainerProdt4);

        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Rucula")) {
                txtQtdRuc.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Alface Lisa")) {
                txtQtdAlfL.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Alface Crespa")) {
                txtQtdAlfC.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Repolho Verde")) {
                txtQtdRepV.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }

        verificaProdt(container1, txtQtdAlfC);
        verificaProdt(container2, txtQtdAlfL);
        verificaProdt(container3, txtQtdRuc);
        verificaProdt(container4, txtQtdRepV);
    }

    public void verificaProdt(View container, TextView qtd){
        if ("0".equals(qtd.getText().toString())){
            container.setVisibility(View.GONE);
        }else{
            container.setVisibility(View.VISIBLE);
        }
    }

    /*public void verificarProdt1(){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Rucula")) {
                if(produto.getQtd() > 0){
                    container1.setVisibility(View.VISIBLE);
                }
                else {
                    container1.setVisibility(View.GONE);
                }
                break;
            }
        }
    }*/



    public void clickSomar1(View view){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Rucula")) {
                produto.setQtd(produto.getQtd() + 1);
                txtQtdRuc.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }

    public void clickSub1(View view){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Rucula")) {
                if(produto.getQtd() > 0){
                    produto.setQtd(produto.getQtd() - 1);
                    txtQtdRuc.setText(String.format("%d", produto.getQtd()));
                }
                break;
            }
        }
    }

    public void clickSomar2(View view){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Alface Lisa")) {
                produto.setQtd(produto.getQtd() + 1);
                txtQtdAlfL.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }

    public void clickSub2(View view){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Alface Lisa")) {
                if(produto.getQtd() > 0){
                    produto.setQtd(produto.getQtd() - 1);
                    txtQtdAlfL.setText(String.format("%d", produto.getQtd()));
                }
                break;
            }
        }
    }

    public void clickSomar3(View view){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Alface Crespa")) {
                produto.setQtd(produto.getQtd() - 1);
                txtQtdAlfC.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }

    public void clickSub3(View view){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Alface Crespa")) {
                if(produto.getQtd() > 0){
                    produto.setQtd(produto.getQtd() - 1);
                    txtQtdAlfC.setText(String.format("%d", produto.getQtd()));
                }
                break;
            }
        }
    }

    public void clickSomar4(View view){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Repolho Verde")) {
                produto.setQtd(produto.getQtd() + 1);
                txtQtdRepV.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }

    public void clickSub4(View view){
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals("Repolho Verde")) {
                if(produto.getQtd() > 0){
                    produto.setQtd(produto.getQtd() - 1);
                    txtQtdRepV.setText(String.format("%d", produto.getQtd()));
                }
                break;
            }
        }
    }
    public void clickComprar(View view){
        Intent tela = new Intent(getApplicationContext(), FinalizaCompra.class);
        startActivity(tela);
    }

    // Nav ===============================
    public void clickHome(View view){
        Intent tela = new Intent(getApplicationContext(), Market.class);
        startActivity(tela);
    }

    public void clickCarrinho(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Carrinho.class);
        startActivity(tela);
    }

    public void clickPerfil(View view){
        Intent tela = new Intent(getApplicationContext(), Perfil.class);
        startActivity(tela);
    }
}