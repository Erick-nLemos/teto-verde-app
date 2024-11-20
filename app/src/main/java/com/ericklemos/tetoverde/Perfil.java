package com.ericklemos.tetoverde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ericklemos.tetoverde.Services.ApiService;
import com.ericklemos.tetoverde.controllers.UserSession;
import com.ericklemos.tetoverde.dtos.ClienteDto;
import com.ericklemos.tetoverde.dtos.EditarClienteDto;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Perfil extends AppCompatActivity {

    private UserSession session = UserSession.getInstance();
    private ApiService apiService = new ApiService();
    private EditarClienteDto editarClienteDto = new EditarClienteDto();
    //private ClienteDto clienteDto;
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

        // chamada assincrona dos dados
        asyncClienteData();

    }

    public void asyncClienteData(){
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    final ClienteDto clienteDto = apiService.getCliente(session.getUserId());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(clienteDto != null){
                                Log.d("Perfil", "Cliente encontrado: " + clienteDto.getFantasia());
                                txtNome.setText(clienteDto.getFantasia());
                                txtEmail.setText(clienteDto.getEmail());
                                txtCnpj.setText(clienteDto.getCnpj());
                                txtTelefone.setText(clienteDto.getTelefone());
                                txtCep.setText(clienteDto.getCep());
                                txtLogradouro.setText(clienteDto.getRua());
                                txtNumero.setText(String.valueOf(clienteDto.getNumero()));
                                txtBairro.setText(clienteDto.getBairro());
                                txtCidade.setText(clienteDto.getCidade());
                                txtUf.setText(clienteDto.getUf());
                            }
                            else{
                                Log.e("Perfil", "Cliente não encontrado.");
                                runOnUiThread(() -> Toast.makeText(Perfil.this, "Erro ao buscar Cadastro", Toast.LENGTH_SHORT).show());
                            }
                        }
                    });
                }catch (Exception e){
                    Log.e("Perfil", "Erro ao buscar os dados do cliente: " + e.getMessage(), e);
                }
            }
        });
    }

   public void clickEditar(View view){
       txtNome.setEnabled(true);
       txtEmail.setEnabled(true);
       txtCnpj.setEnabled(true);
       txtTelefone.setEnabled(true);
       txtCep.setEnabled(true);
       txtLogradouro.setEnabled(true);
       txtNumero.setEnabled(true);
       txtBairro.setEnabled(true);
       txtCidade.setEnabled(true);
       txtUf.setEnabled(true);
   }

   public void salvarEdit(){

        editarClienteDto.setName(txtNome.getText().toString());
        editarClienteDto.setEmail(txtEmail.getText().toString());
        editarClienteDto.setCnpj(txtCnpj.getText().toString());
        editarClienteDto.setTelefone(txtTelefone.getText().toString());
        editarClienteDto.setCep(txtCep.getText().toString());
        editarClienteDto.setRua(txtLogradouro.getText().toString());
        editarClienteDto.setNumero(Integer.parseInt(txtNome.getText().toString()));
        editarClienteDto.setBairro(txtBairro.getText().toString());
        editarClienteDto.setCidade(txtCidade.getText().toString());
        editarClienteDto.setUf(txtUf.getText().toString());
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    final ClienteDto clienteDto = apiService.editarCliente(editarClienteDto);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(clienteDto != null ){
                                runOnUiThread(() -> Toast.makeText(Perfil.this, "Edição Salva com Sucesso!", Toast.LENGTH_SHORT).show());
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        asyncClienteData();
                                    }
                                });
                            }
                            else{
                                String mensagem = "Erro ao Salvar!";
                                runOnUiThread(() -> Toast.makeText(Perfil.this, mensagem, Toast.LENGTH_SHORT).show());
                            }
                        }
                    });
                }catch (Exception e){
                    Log.e("Perfil", "Erro ao buscar os dados do cliente: " + e.getMessage(), e);
                }
            }
        });
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