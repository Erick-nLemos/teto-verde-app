package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ericklemos.tetoverde.controllers.QtdPrdt;

public class ProdutoAlfaceLisa extends AppCompatActivity {

    QtdPrdt calcQtd = QtdPrdt.getInstance();
    TextView txtQtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtoalfacelisa);

        txtQtd = findViewById(R.id.txtQtdAlfL);
        txtQtd.setText(String.format("%d", calcQtd.qtdAlfL));
    }

    public void clickSomar(View view){
        calcQtd.qtdAlfL = Integer.parseInt(txtQtd.getText().toString());
        calcQtd.qtdAlfL++;
        txtQtd.setText(String.format("%d", calcQtd.qtdAlfL));
    }

    public void clickSub(View view){
        calcQtd.qtdAlfL = Integer.parseInt(txtQtd.getText().toString());
        calcQtd.qtdAlfL--;
        txtQtd.setText(String.format("%d", calcQtd.qtdAlfL));
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