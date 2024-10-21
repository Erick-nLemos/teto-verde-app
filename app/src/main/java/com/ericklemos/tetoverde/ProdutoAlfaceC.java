package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ericklemos.tetoverde.controllers.QtdPrdt;

public class ProdutoAlfaceC extends AppCompatActivity {

    QtdPrdt calcQtd = QtdPrdt.getInstance();
    TextView txtQtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtoalfacec);


        txtQtd = findViewById(R.id.txtQtdAlfC);
        txtQtd.setText(String.format("%d", calcQtd.qtdAlfC));
    }

    public void clickSomar(View view){
        calcQtd.qtdAlfC = Integer.parseInt(txtQtd.getText().toString());
        calcQtd.qtdAlfC++;
        txtQtd.setText(String.format("%d", calcQtd.qtdAlfC));
    }

    public void clickSub(View view){
        calcQtd.qtdAlfC = Integer.parseInt(txtQtd.getText().toString());
        calcQtd.qtdAlfC--;
        txtQtd.setText(String.format("%d", calcQtd.qtdAlfC));
    }


    // nav
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