package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    Intent tela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TetoVerde);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickComecar(View view){
        tela = new Intent(getApplicationContext(), Cadastro.class);
        startActivity(tela);
    }



}