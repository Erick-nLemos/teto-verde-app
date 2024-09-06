package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProdutoAlfaceLisa extends AppCompatActivity {

    TextView txtSomar, txtSubtrair, txtQtd;
    int qtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtoalfacelisa);

        txtQtd = findViewById(R.id.txtQtd);
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

    public void clickHome(View view){

    }

    public void clickCarrinho(View view){

    }

    public void clickPerfil(View view){
        Intent tela = new Intent(getApplicationContext(), Perfil.class);
        startActivity(tela);
    }
}