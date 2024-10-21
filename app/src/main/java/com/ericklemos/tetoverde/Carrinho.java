package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.ericklemos.tetoverde.controllers.QtdPrdt;

public class Carrinho extends AppCompatActivity {

    QtdPrdt calcQtd = QtdPrdt.getInstance();
    TextView txtQtdRuc, txtQtdAlfL, txtQtdAlfC, txtQtdRepV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        txtQtdRuc = findViewById(R.id.txtQtdRuc);
        txtQtdAlfL = findViewById(R.id.txtQtdAlfL);
        txtQtdAlfC = findViewById(R.id.txtQtdAlfC);
        txtQtdRepV = findViewById(R.id.txtQtdRepV);

        txtQtdRuc.setText(String.format("%d", calcQtd.qtdRuc));
        txtQtdAlfL.setText(String.format("%d", calcQtd.qtdAlfL));
        txtQtdAlfC.setText(String.format("%d", calcQtd.qtdAlfC));
        txtQtdRepV.setText(String.format("%d", calcQtd.qtdRepV));
    }

    public void clickSomar1(View view){
        calcQtd.qtdRuc = Integer.parseInt(txtQtdRuc.getText().toString());
        calcQtd.qtdRuc++;
        txtQtdRuc.setText(String.format("%d", calcQtd.qtdRuc));
    }

    public void clickSub1(View view){
        calcQtd.qtdRuc = Integer.parseInt(txtQtdRuc.getText().toString());
        calcQtd.qtdRuc--;
        txtQtdRuc.setText(String.format("%d", calcQtd.qtdRuc));
    }

    public void clickSomar2(View view){
        calcQtd.qtdAlfL = Integer.parseInt(txtQtdAlfL.getText().toString());
        calcQtd.qtdAlfL++;
        txtQtdAlfL.setText(String.format("%d", calcQtd.qtdAlfL));
    }

    public void clickSub2(View view){
        calcQtd.qtdAlfL = Integer.parseInt(txtQtdAlfL.getText().toString());
        calcQtd.qtdAlfL--;
        txtQtdAlfL.setText(String.format("%d", calcQtd.qtdAlfL));
    }

    public void clickSomar3(View view){
        calcQtd.qtdAlfC = Integer.parseInt(txtQtdAlfC.getText().toString());
        calcQtd.qtdAlfC++;
        txtQtdAlfC.setText(String.format("%d", calcQtd.qtdAlfC));
    }

    public void clickSub3(View view){
        calcQtd.qtdAlfC = Integer.parseInt(txtQtdAlfC.getText().toString());
        calcQtd.qtdAlfC--;
        txtQtdAlfC.setText(String.format("%d", calcQtd.qtdAlfC));
    }

    public void clickSomar4(View view){
        calcQtd.qtdRepV = Integer.parseInt(txtQtdRepV.getText().toString());
        calcQtd.qtdRepV++;
        txtQtdRepV.setText(String.format("%d", calcQtd.qtdRepV));
    }

    public void clickSub4(View view){
        calcQtd.qtdRepV = Integer.parseInt(txtQtdRepV.getText().toString());
        calcQtd.qtdRepV--;
        txtQtdRepV.setText(String.format("%d", calcQtd.qtdRepV));
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