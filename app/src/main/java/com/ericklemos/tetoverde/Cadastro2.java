package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Cadastro2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TetoVerde);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);
    }
    

    public void clickVoltar(View view){
        finish();
    }
}