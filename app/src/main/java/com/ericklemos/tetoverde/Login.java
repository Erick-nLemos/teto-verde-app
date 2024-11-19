package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.ericklemos.tetoverde.Services.ApiService;
import com.ericklemos.tetoverde.controllers.UserSession;
import com.ericklemos.tetoverde.dtos.LoginClienteDto;
import com.ericklemos.tetoverde.dtos.RespostaApiDto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Login extends AppCompatActivity {

    Intent tela;
    private UserSession session = UserSession.getInstance();
    private EditText nomeEdit, passwordEdit;
    private LoginClienteDto loginDto = new LoginClienteDto();
    private ApiService apiService = new ApiService();
    private ExecutorService executorService;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nomeEdit = findViewById(R.id.editNome);
        passwordEdit = findViewById(R.id.editPassword);

        executorService = Executors.newSingleThreadExecutor();
    }

    public void clickNewPass(View view){
        finish();
        setTheme(R.style.Base_Theme_TetoVerde);
        tela = new Intent(getApplicationContext(), EsqueciSenha.class);
        startActivity(tela);
    }

    public void clickAcessar(View view){
        if(nomeEdit.getText().toString().isEmpty()){
            nomeEdit.setError("Campo Obrigatório");
            nomeEdit.requestFocus();
            return;
        }
        if(passwordEdit.getText().toString().isEmpty()){
            passwordEdit.setError("Campo Obrigatório");
            return;
        }
        loginDto.setName(nomeEdit.getText().toString());
        loginDto.setSenha(passwordEdit.getText().toString());


        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    final RespostaApiDto login = apiService.loginValid(loginDto);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (login != null && login.isStatus()) {
                                session.setUserName(login.getDados().getFantasia());
                                session.setUserId(login.getDados().getIdCodCliente());
                                toast = Toast.makeText(Login.this, login.getMensagem(), Toast.LENGTH_SHORT);
                                toast.show();

                                finish();
                                setTheme(R.style.Base_Theme_TetoVerde);
                                tela = new Intent(getApplicationContext(), Market.class);
                                startActivity(tela);
                            } else {
                                String mensagem = login != null ? login.getMensagem() : "Erro no login!";
                                toast = Toast.makeText(Login.this, mensagem, Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                    });
                }catch(Exception e){
                    Log.e("Login", "Erro ao solicitar login: "+ e.getMessage(), e);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            toast = Toast.makeText(Login.this, "Erro inesperado. Tente novamente.", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    });
                }
            }
        });

    }

    public void clickCadastrar(View view){
        finish();
        setTheme(R.style.Base_Theme_TetoVerde);
        tela = new Intent(getApplicationContext(), Cadastro.class);
        startActivity(tela);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if(executorService != null && !executorService.isShutdown()){
            executorService.shutdown();
        }
    }
}