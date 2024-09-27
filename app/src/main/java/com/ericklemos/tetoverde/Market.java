package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Market extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }



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