package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EsqueciSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);
    }

    public void clickSalvarAlt(View view){
        Intent tela = new Intent(getApplicationContext(), Login.class);
        startActivity(tela);
    }

    public void clickVoltar(View view){
        finish();
    }
}