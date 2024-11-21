package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ericklemos.tetoverde.Services.ApiService;
import com.ericklemos.tetoverde.dtos.ClienteDto;
import com.ericklemos.tetoverde.dtos.CriarClienteDto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cadastro2 extends AppCompatActivity {

    EditText txtEditEmail, txtEditPass, txtEditConfirmPass;
    CriarClienteDto criarClienteDto;
    ApiService apiService = new ApiService();
    ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TetoVerde);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);

        txtEditEmail = findViewById(R.id.editEmail);
        txtEditPass = findViewById(R.id.editPass);
        txtEditConfirmPass = findViewById(R.id.editConfirmPass);
        executorService = Executors.newSingleThreadExecutor();

        criarClienteDto = (CriarClienteDto) getIntent().getSerializableExtra("criarClienteDto"); // recebendo o bojeto da tela anterior
        if (criarClienteDto == null) {
            Toast.makeText(this, "Erro ao carregar os dados do cliente.", Toast.LENGTH_LONG).show();
            finish(); // Finaliza a activity se não houver dados
        }

    }
    
    public void clickSalvar(View view){
        if(txtEditEmail.getText().toString().isEmpty()){
            txtEditEmail.setError("Campo Obrigatório");
            txtEditEmail.requestFocus();
            return;
        }
        if(txtEditPass.getText().toString().isEmpty()){
            txtEditPass.setError("Campo Obrigatório");
            txtEditPass.requestFocus();
            return;
        }
        if(txtEditConfirmPass.getText().toString().isEmpty()){
            txtEditConfirmPass.setError("Campo Obrigatório");
            txtEditConfirmPass.requestFocus();
            return;
        }
        if(!txtEditPass.getText().toString().equals(txtEditConfirmPass.getText().toString())){
            txtEditConfirmPass.setError("As Senhas Precisam ser Iguais.");
            return;
        }
        criarClienteDto.setEmail(txtEditEmail.getText().toString());
        criarClienteDto.setSenha(txtEditPass.getText().toString());
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    final ClienteDto clienteDto = apiService.criarCliente(criarClienteDto);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(clienteDto != null){
                                Toast.makeText(Cadastro2.this, "Cadastro Salvo!", Toast.LENGTH_SHORT).show();
                                finish();
                                Intent tela = new Intent(getApplicationContext(), Login.class);
                                startActivity(tela);
                            }
                            else{
                                String mensagem = "Erro ao Salvar!";
                                Toast.makeText(Cadastro2.this, mensagem, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }catch (Exception e){
                    runOnUiThread(() -> Toast.makeText(Cadastro2.this, "Erro inesperado. Tente novamente.", Toast.LENGTH_SHORT).show());
                }
            }
        });
    }

    public void clickVoltar(View view){
        finish();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(executorService != null && !executorService.isShutdown()){
            executorService.shutdown();
        }
    }
}