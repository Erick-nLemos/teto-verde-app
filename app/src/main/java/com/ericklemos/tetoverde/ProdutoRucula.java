package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ericklemos.tetoverde.controllers.QtdPrdt;

public class ProdutoRucula extends AppCompatActivity {

    QtdPrdt calcQtd = QtdPrdt.getInstance();
    TextView txtQtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtorucula);

        txtQtd = findViewById(R.id.txtQtdRuc);
        txtQtd.setText(String.format("%d", calcQtd.qtdRuc));
    }

    public void clickSomar(View view){
        calcQtd.qtdRuc = Integer.parseInt(txtQtd.getText().toString());
        calcQtd.qtdRuc++;
        txtQtd.setText(String.format("%d", calcQtd.qtdRuc));
    }

    public void clickSub(View view){
        calcQtd.qtdRuc = Integer.parseInt(txtQtd.getText().toString());
        calcQtd.qtdRuc--;
        txtQtd.setText(String.format("%d", calcQtd.qtdRuc));
    }

    public void clickCar(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Carrinho.class);
        startActivity(tela);
    }

    public void clickHome(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Market.class);
        startActivity(tela);
    }

    public void clickCarrinho(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Carrinho.class);
        startActivity(tela);
    }

    public void clickPerfil(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Perfil.class);
        startActivity(tela);
    }
}