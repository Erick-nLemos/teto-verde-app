package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class Login extends AppCompatActivity {

    Intent tela;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void clickNewPass(View view){
        setTheme(R.style.Base_Theme_TetoVerde);
        tela = new Intent(getApplicationContext(), EsqueciSenha.class);
        startActivity(tela);
    }

    public void clickAcessar(View view){
        setTheme(R.style.Base_Theme_TetoVerde);
        tela = new Intent(getApplicationContext(), Market.class);
        startActivity(tela);
    }

    public void clickCadastrar(View view){
        setTheme(R.style.Base_Theme_TetoVerde);
        tela = new Intent(getApplicationContext(), Cadastro.class);
        startActivity(tela);
    }
}