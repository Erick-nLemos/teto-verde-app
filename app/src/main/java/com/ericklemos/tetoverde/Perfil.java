package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ericklemos.tetoverde.Services.ApiService;
import com.ericklemos.tetoverde.controllers.UserSession;
import com.ericklemos.tetoverde.dtos.ClienteDto;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Perfil extends AppCompatActivity {

    private UserSession session = UserSession.getInstance();
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

        clienteDto = apiService.getCliente(session.getUserId());
        txtNome.setText(clienteDto.getFantasia());
        txtEmail.setText(clienteDto.getEmail());
        txtCnpj.setText(clienteDto.getCnpj());
        txtTelefone.setText(clienteDto.getTelefone());
        txtCep.setText(clienteDto.getCep());
        txtLogradouro.setText(clienteDto.getRua());
        txtNumero.setText(clienteDto.getNumero());
        txtBairro.setText(clienteDto.getBairro());
        txtCidade.setText(clienteDto.getCidade());
        txtUf.setText(clienteDto.getUf());
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