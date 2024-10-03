package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProdutoRucula extends AppCompatActivity {

    TextView txtQtd;
    int qtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtorucula);


        txtQtd = findViewById(R.id.txtQtdAlfC);
    }

    public void clickSomar(View view){
        qtd = Integer.parseInt(txtQtd.getText().toString());
        qtd++;
        txtQtd.setText(String.format("%d", qtd));
    }

    public void clickSub(View view){
        qtd = Integer.parseInt(txtQtd.getText().toString());
        qtd--;
        txtQtd.setText(String.format("%d", qtd));
    }

    public void clickCar(View view){
        Intent tela = new Intent(getApplicationContext(), Carrinho.class);
        startActivity(tela);
    }

    public void clickHome(View view){
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