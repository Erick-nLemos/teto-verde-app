package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Market extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }
    TextView txtQtdRuc, txtQtdAlfL, txtQtdAlfC, txtQtdRepV;
    int qtdRuc, qtdAlfL, qtdAlfC, qtdRepV;
    public void clickSomar1(View view){
        qtdRuc = Integer.parseInt(txtQtdRuc.getText().toString());
        qtdRuc++;

        txtQtdRuc.setText(String.format("%d", qtdRuc));
    }

    public void clickSub1(View view){
        qtdRuc = Integer.parseInt(txtQtdRuc.getText().toString());
        qtdRuc--;
        txtQtdRuc.setText(String.format("%d", qtdRuc));
    }

    public void clickSomar2(View view){
        qtdAlfL = Integer.parseInt(txtQtdAlfL.getText().toString());
        qtdAlfL++;

        txtQtdAlfL.setText(String.format("%d", qtdAlfL));
    }

    public void clickSub2(View view){
        qtdAlfL = Integer.parseInt(txtQtdAlfL.getText().toString());
        qtdAlfL--;
        txtQtdAlfL.setText(String.format("%d", qtdAlfL));
    }

    public void clickSomar3(View view){
        qtdAlfC = Integer.parseInt(txtQtdAlfC.getText().toString());
        qtdAlfC++;

        txtQtdAlfC.setText(String.format("%d", qtdAlfC));
    }

    public void clickSub3(View view){
        qtdAlfC = Integer.parseInt(txtQtdAlfC.getText().toString());
        qtdAlfC--;
        txtQtdAlfC.setText(String.format("%d", qtdAlfC));
    }

    public void clickSomar4(View view){
        qtdRepV = Integer.parseInt(txtQtdRepV.getText().toString());
        qtdRepV++;

        txtQtdRuc.setText(String.format("%d", qtdRepV));
    }

    public void clickSub4(View view){
        qtdRepV = Integer.parseInt(txtQtdRepV.getText().toString());
        qtdRepV--;
        txtQtdRepV.setText(String.format("%d", qtdRepV));
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