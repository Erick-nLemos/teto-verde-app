package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ericklemos.tetoverde.controllers.QtdPrdt;

public class ProdutoRepolhoVerde extends AppCompatActivity {

    QtdPrdt calcQtd = QtdPrdt.getInstance();
    TextView txtQtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtorepolhoverde);

        txtQtd = findViewById(R.id.txtQtdRepV);
        txtQtd.setText(String.format("%d", calcQtd.qtdRepV));
    }

    public void clickSomar(View view){
        calcQtd.qtdRepV = Integer.parseInt(txtQtd.getText().toString());
        calcQtd.qtdRepV++;
        txtQtd.setText(String.format("%d", calcQtd.qtdRepV));
    }

    public void clickSub(View view){
        calcQtd.qtdRepV = Integer.parseInt(txtQtd.getText().toString());
        calcQtd.qtdRepV--;
        txtQtd.setText(String.format("%d", calcQtd.qtdRepV));
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