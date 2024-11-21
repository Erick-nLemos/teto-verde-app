package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

import com.ericklemos.tetoverde.dtos.CriarClienteDto;

public class Cadastro extends AppCompatActivity {

    Intent tela;
    CriarClienteDto criarClienteDto = new CriarClienteDto();
    EditText txtEditCadNome, txtEditCNPJ, txtEditTel, txtEditCep, txtEditRua, txtEditNum, txtEditBairro, txtEditCidade, txtEditUf, txtEditComp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtEditCadNome = findViewById(R.id.editCadNome);
        txtEditCNPJ = findViewById(R.id.editCNPJ);
        txtEditTel = findViewById(R.id.editTel);
        txtEditCep = findViewById(R.id.editCEP);
        txtEditRua = findViewById(R.id.editRua);
        txtEditNum = findViewById(R.id.editNum);
        txtEditBairro = findViewById(R.id.editBairro);
        txtEditCidade = findViewById(R.id.editCidade);
        txtEditUf = findViewById(R.id.editUF);
        txtEditComp = findViewById(R.id.editComp);

    }

    public void clickProx(View view){

        if(txtEditCadNome.getText().toString().isEmpty()){
            txtEditCadNome.setError("Campo Obrigatório");
            txtEditCadNome.requestFocus();
            return;
        }
        criarClienteDto.setName(txtEditCadNome.getText().toString());

        if(txtEditCNPJ.getText().toString().isEmpty()){
            txtEditCNPJ.setError("Campo Obrigatório");
            txtEditCNPJ.requestFocus();
            return;
        }
        criarClienteDto.setCnpj(txtEditCNPJ.getText().toString());

        if(txtEditTel.getText().toString().isEmpty()){
            txtEditTel.setError("Campo Obrigatório");
            txtEditTel.requestFocus();
            return;
        }
        criarClienteDto.setTelefone(txtEditTel.getText().toString());

        if(txtEditCep.getText().toString().isEmpty()){
            txtEditCep.setError("Campo Obrigatório");
            txtEditCep.requestFocus();
            return;
        }
        criarClienteDto.setCep(txtEditCep.getText().toString());

        if(txtEditRua.getText().toString().isEmpty()){
            txtEditRua.setError("Campo Obrigatório");
            txtEditRua.requestFocus();
            return;
        }
        criarClienteDto.setRua(txtEditRua.getText().toString());

        if(txtEditNum.getText().toString().isEmpty()){
            txtEditNum.setError("Campo Obrigatório");
            txtEditNum.requestFocus();
            return;
        }
        criarClienteDto.setNumero(Integer.parseInt(txtEditNum.getText().toString()));

        if(txtEditBairro.getText().toString().isEmpty()){
            txtEditBairro.setError("Campo Obrigatório");
            txtEditBairro.requestFocus();
            return;
        }
        criarClienteDto.setBairro(txtEditBairro.getText().toString());

        if(txtEditCidade.getText().toString().isEmpty()){
            txtEditCidade.setError("Campo Obrigatório");
            txtEditCidade.requestFocus();
            return;
        }
        criarClienteDto.setCidade(txtEditCidade.getText().toString());

        if(txtEditUf.getText().toString().isEmpty()){
            txtEditUf.setError("Campo Obrigatório");
            txtEditUf.requestFocus();
            return;
        }
        criarClienteDto.setUf(txtEditUf.getText().toString());

        setTheme(R.style.Base_Theme_TetoVerde);
        tela = new Intent(getApplicationContext(), Cadastro2.class);
        tela.putExtra("criarClienteDto", criarClienteDto);
        startActivity(tela);
    }

    public void clickVoltar(View view){
        finish();
    }
}