package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cadastro2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TetoVerde);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);
    }
    
    public void clickSalvar(View view){
        Intent tela = new Intent(getApplicationContext(), Produtos01.class);
        startActivity(tela);
    }

    public void clickVoltar(View view){
        finish();
    }
}