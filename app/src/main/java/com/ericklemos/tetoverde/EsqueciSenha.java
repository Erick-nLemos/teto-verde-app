package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ericklemos.tetoverde.Services.ApiService;
import com.ericklemos.tetoverde.dtos.RecupSenhaDto;
import com.ericklemos.tetoverde.dtos.RespostaApiDto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EsqueciSenha extends AppCompatActivity {

    EditText editEmailEsq;
    private ExecutorService executorService;
    private ApiService apiService = new ApiService();
    private RecupSenhaDto recupSenhaDto = new RecupSenhaDto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);

        editEmailEsq = findViewById(R.id.editTxtEmailEsq);

        executorService = Executors.newSingleThreadExecutor();
    }

    public void clickSalvarAlt(View view){
        if(editEmailEsq.getText().toString().isEmpty()){
            editEmailEsq.setError("Campo Obrigatório");
            editEmailEsq.requestFocus();
            return;
        }else if(!editEmailEsq.getText().toString().contains("@")){
            editEmailEsq.setError("E-mail Inválido!");
            editEmailEsq.requestFocus();
            return;
        }
        recupSenhaDto.setEmail(editEmailEsq.getText().toString());

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    final RespostaApiDto emailValidado = apiService.emailValid(recupSenhaDto);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(emailValidado != null && emailValidado.isStatus()){
                                Toast.makeText(EsqueciSenha.this, emailValidado.getMensagem(), Toast.LENGTH_SHORT).show();

                                finish();
                                Intent tela = new Intent(getApplicationContext(), Login.class);
                                startActivity(tela);
                            }else{

                            }
                        }
                    });
                }catch (Exception e){
                    Log.e("Login", "Erro ao solicitar validação de email: "+ e.getMessage(), e);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(EsqueciSenha.this, "Erro inesperado. Tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    });
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

