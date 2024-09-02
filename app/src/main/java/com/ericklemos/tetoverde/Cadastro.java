package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class Cadastro extends AppCompatActivity {

    Intent tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void clickProx(View view){
        tela = new Intent(getApplicationContext(), Cadastro2.class);
        startActivity(tela);
    }

    public void clickVoltar(View view){
        finish();
    }
}