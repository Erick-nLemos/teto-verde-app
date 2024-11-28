package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ericklemos.tetoverde.controllers.UserSession;

import java.util.ArrayList;

public class Market extends AppCompatActivity {

    UserSession session = UserSession.getInstance();
    public static ArrayList<Produto> listaProdt = new ArrayList<>();
    TextView txtQtdRuc, txtQtdAlfL, txtQtdAlfC, txtQtdRepV, txtMarketTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        txtQtdRuc = findViewById(R.id.txtQtdRuc);
        txtQtdAlfL = findViewById(R.id.txtQtdAlfL);
        txtQtdAlfC = findViewById(R.id.txtQtdAlfC);
        txtQtdRepV = findViewById(R.id.txtQtdRepV);
        txtMarketTitulo = findViewById(R.id.txtMarketTitulo);

        listaProdt.add(new Produto("Rucula", 4.99));
        listaProdt.add(new Produto("Alface Lisa", 1.49));
        listaProdt.add(new Produto("Alface Crespa", 1.99));
        listaProdt.add(new Produto("Repolho Verde", 4.99));

        txtMarketTitulo.setText("Olá, "+ session.getUserName());
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Rucula")) {
                txtQtdRuc.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Alface Lisa")) {
                txtQtdAlfL.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Alface Crespa")) {
                txtQtdAlfC.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Repolho Verde")) {
                txtQtdRepV.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }


    public void clickSomar1(View view){
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Rucula")) {
                produto.setQtd(produto.getQtd() + 1);
                txtQtdRuc.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }

    public void clickSub1(View view){
        for (Produto produto : listaProdt) {
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
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Alface Lisa")) {
                produto.setQtd(produto.getQtd() + 1);
                txtQtdAlfL.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }

    public void clickSub2(View view){
        for (Produto produto : listaProdt) {
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
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Alface Crespa")) {
                produto.setQtd(produto.getQtd() + 1);
                txtQtdAlfC.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }

    public void clickSub3(View view){
        for (Produto produto : listaProdt) {
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
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Repolho Verde")) {
                produto.setQtd(produto.getQtd() + 1);
                txtQtdRepV.setText(String.format("%d", produto.getQtd()));
                break;
            }
        }
    }

    public void clickSub4(View view){
        for (Produto produto : listaProdt) {
            if (produto.getNome().equals("Repolho Verde")) {
                if(produto.getQtd() > 0){
                    produto.setQtd(produto.getQtd() - 1);
                    txtQtdRepV.setText(String.format("%d", produto.getQtd()));
                }
                break;
            }
        }
    }

    // chamando tela de descricao do prodt
    public void clickDescRuc(View view){
        Intent tela = new Intent(getApplicationContext(), ProdutoRucula.class);
        startActivity(tela);
    }

    public void clickDescAlfL(View view){
        Intent tela = new Intent(getApplicationContext(), ProdutoAlfaceLisa.class);
        startActivity(tela);
    }

    public void clickDescAlfC(View view){
        Intent tela = new Intent(getApplicationContext(), ProdutoAlfaceC.class);
        startActivity(tela);
    }

    public void clickDescRepV(View view){
        Intent tela = new Intent(getApplicationContext(), ProdutoRepolhoVerde.class);
        startActivity(tela);
    }

    // nav ========================================
    public void clickHome(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Market.class);
        startActivity(tela);
    }

    public void clickCarrinho(View view){
        Intent tela = new Intent(getApplicationContext(), Carrinho.class);
        startActivity(tela);
    }

    public void clickPerfil(View view){
        Intent tela = new Intent(getApplicationContext(), Perfil.class);
        startActivity(tela);
    }
}