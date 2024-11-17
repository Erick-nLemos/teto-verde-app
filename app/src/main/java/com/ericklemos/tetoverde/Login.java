package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.ericklemos.tetoverde.Services.ApiService;
import com.ericklemos.tetoverde.controllers.UserSession;
import com.ericklemos.tetoverde.dtos.LoginClienteDto;
import com.ericklemos.tetoverde.dtos.RespostaApiDto;

public class Login extends AppCompatActivity {

    Intent tela;
    private UserSession session = UserSession.getInstance();
    private EditText nomeEdit, passwordEdit;
    private LoginClienteDto loginDto = new LoginClienteDto();
    private ApiService apiService = new ApiService();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nomeEdit = findViewById(R.id.editNome);
        passwordEdit = findViewById(R.id.editPassword);


    }

    public void clickNewPass(View view){
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
        RespostaApiDto login = apiService.loginValid(loginDto);

        if(login.isStatus()) {
            session.setUserName(login.getDados().getFantasia());
            session.setUserId(login.getDados().getIdCodCliente());
            Toast toast = Toast.makeText(Login.this, login.getMensagem(), Toast.LENGTH_SHORT);
            toast.show();
            setTheme(R.style.Base_Theme_TetoVerde);
            tela = new Intent(getApplicationContext(), Market.class);
            startActivity(tela);
        }
        else{
            Toast toast = Toast.makeText(Login.this, login.getMensagem(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void clickCadastrar(View view){
        setTheme(R.style.Base_Theme_TetoVerde);
        tela = new Intent(getApplicationContext(), Cadastro.class);
        startActivity(tela);
    }
}