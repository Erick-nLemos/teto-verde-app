package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ericklemos.tetoverde.Services.ApiService;
import com.ericklemos.tetoverde.dtos.ClienteDto;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Perfil extends AppCompatActivity {

    private ApiService apiService = new ApiService();
    private ClienteDto clienteDto;
    private EditText txtNome, txtEmail, txtCnpj, txtTelefone, txtCep, txtLogradouro, txtNumero, txtBairro, txtCidade, txtUf;
    private ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txtNome = findViewById(R.id.editTxtNome);
        txtEmail = findViewById(R.id.editTxtEmail);
        txtCnpj = findViewById(R.id.editTxtCnpj);
        txtTelefone = findViewById(R.id.editTxtTel);
        txtCep = findViewById(R.id.editTxtCep);
        txtLogradouro = findViewById(R.id.editTxtRua);
        txtNumero = findViewById(R.id.editTxtNum);
        txtBairro = findViewById(R.id.editTxtBairro);
        txtCidade = findViewById(R.id.editTxtCidade);
        txtUf = findViewById(R.id.editTxtUf);

        executorService = Executors.newSingleThreadExecutor();

        clienteDto = apiService.getCliente(2);
        txtNome.setText(clienteDto.getFantasia());
    }

    public void clickHome(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Market.class);
        startActivity(tela);
    }

    public void clickCarrinho(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Carrinho.class);
        startActivity(tela);
    }

    public void clickPerfil(View view){
        finish();
        Intent tela = new Intent(getApplicationContext(), Perfil.class);
        startActivity(tela);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(executorService != null && !executorService.isShutdown()){
            executorService.shutdown();
        }
    }

}