package com.ericklemos.tetoverde.Services;

import android.util.Log;
import android.widget.Toast;

import com.ericklemos.tetoverde.Perfil;
import com.ericklemos.tetoverde.configSSL.IgnoreSSL;
import com.ericklemos.tetoverde.controllers.UserSession;
import com.ericklemos.tetoverde.dtos.ClienteDto;
import com.ericklemos.tetoverde.dtos.CriarClienteDto;
import com.ericklemos.tetoverde.dtos.EditarClienteDto;
import com.ericklemos.tetoverde.dtos.LoginClienteDto;
import com.ericklemos.tetoverde.dtos.RecupSenhaDto;
import com.ericklemos.tetoverde.dtos.RespostaApiDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.http.POST;

public class ApiService {
    UserSession session = UserSession.getInstance();
    
    private String getAutToken(){
        return session.getToken();
    }

    public ClienteDto getCliente(int id){
        HttpURLConnection connection = null;
        try{
            IgnoreSSL.ignorarCertificadosSSL();
            ClienteDto cliente = null;

            URL url = new URL("https://fazendaurbanaapi-asa4b2dvajd9b0cf.brazilsouth-01.azurewebsites.net/api/Cliente/ListarClientes/" + id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);
            String token = getAutToken();
            if(token != null){
                connection.setRequestProperty("Authorization", "Bearer "+ token);
            }

            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader leitor = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while((line = leitor.readLine()) != null){
                    response.append(line);
                }
                leitor.close();

                ObjectMapper mapper = new ObjectMapper();
                RespostaApiDto resposta = mapper.readValue(response.toString(), RespostaApiDto.class);
                cliente = resposta.getDados();
            }else{
                Log.e("ApiService", "Erro na requisição. Código de resposta: " + responseCode);
            }

            connection.disconnect();
            return cliente;
        }catch (Exception e){
            Log.e("ApiService", "Erro ao consumir a API: "+ e.getMessage(), e);
            return null;
        }
        finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }

    public RespostaApiDto loginValid(LoginClienteDto loginClienteDto){
        HttpURLConnection connection = null;
        try{
            IgnoreSSL.ignorarCertificadosSSL();

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(loginClienteDto);
            RespostaApiDto resposta = null;

            URL url = new URL("https://fazendaurbanaapi-asa4b2dvajd9b0cf.brazilsouth-01.azurewebsites.net/api/Cliente/Login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);

            try(BufferedOutputStream outputStream = new BufferedOutputStream(connection.getOutputStream())){
                outputStream.write(json.getBytes());
                outputStream.flush();
            }

            int responseCod = connection.getResponseCode();
            if(responseCod == HttpURLConnection.HTTP_OK){
                try(BufferedReader leitor = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = leitor.readLine()) != null){
                        response.append(line);
                    }
                    resposta = mapper.readValue(response.toString(), RespostaApiDto.class);
                    connection.disconnect();
                    return resposta;
                }
            }else{
                Log.e("ApiService", "Erro na API: Código de resposta " + responseCod);
            }
        }catch (Exception e){
            Log.e("ApiService", "Erro ao consumir a API: "+ e.getMessage(), e);
            return null;
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return null;
    }

    public RespostaApiDto emailValid(RecupSenhaDto recupSenhaDto){
        HttpURLConnection connection = null;
        try{
            IgnoreSSL.ignorarCertificadosSSL();

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(recupSenhaDto);
            RespostaApiDto resposta = null;

            URL url = new URL("https://fazendaurbanaapi-asa4b2dvajd9b0cf.brazilsouth-01.azurewebsites.net/api/Cliente/RecuperarSenha");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);

            try(BufferedOutputStream outputStream = new BufferedOutputStream(connection.getOutputStream())){
                outputStream.write(json.getBytes());
                outputStream.flush();
            }

            int responseCod = connection.getResponseCode();
            if(responseCod == HttpURLConnection.HTTP_OK){
                try(BufferedReader leitor = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = leitor.readLine()) != null){
                        response.append(line);
                    }
                    resposta = mapper.readValue(response.toString(), RespostaApiDto.class);
                    connection.disconnect();
                    return resposta;
                }
            }else{
                Log.e("ApiService", "Erro na API: Código de resposta " + responseCod);
            }
        }catch (Exception e){
            Log.e("ApiService", "Erro ao consumir a API: "+ e.getMessage(), e);
            return null;
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return null;
    }

    public ClienteDto editarCliente(int id, EditarClienteDto editarClienteDto){
        HttpURLConnection connection = null;
        ClienteDto cliente = null;
        try{
            IgnoreSSL.ignorarCertificadosSSL();

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(editarClienteDto);

            URL url = new URL("https://fazendaurbanaapi-asa4b2dvajd9b0cf.brazilsouth-01.azurewebsites.net/api/Cliente/EditarCliente/"+ id);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            String token = getAutToken();
            if(token != null){
                connection.setRequestProperty("Authorization", "Bearer "+ token);
            }
            connection.setDoOutput(true);
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);

            try(BufferedOutputStream outputStream = new BufferedOutputStream(connection.getOutputStream())){
                outputStream.write(json.getBytes());
                outputStream.flush();
            }

            int responseCod = connection.getResponseCode();
            if(responseCod == HttpURLConnection.HTTP_OK){
                try(BufferedReader leitor = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = leitor.readLine()) != null){
                        response.append(line);
                    }

                    Log.d("ApiService", "Resposta da API: " + response.toString());
                    RespostaApiDto resposta = mapper.readValue(response.toString(), RespostaApiDto.class);
                    Log.d("ApiService", "Dados da resposta: " + (resposta != null ? resposta.getDados() : "null"));

                    cliente = resposta.getDados();
                    connection.disconnect();
                    return cliente;
                }
            }
            else{
                Log.e("ApiService", "Erro na API: Código de resposta " + responseCod);
            }
        }catch (Exception e){
            Log.e("ApiService", "Erro ao consumir a API: "+ e.getMessage(), e);

            connection.disconnect();
            return cliente;
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return cliente;
    }

    public ClienteDto criarCliente(CriarClienteDto criarClienteDto){
        HttpURLConnection connection = null;
        ClienteDto cliente = null;
        try{
            IgnoreSSL.ignorarCertificadosSSL();

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(criarClienteDto);

            URL url = new URL("https://fazendaurbanaapi-asa4b2dvajd9b0cf.brazilsouth-01.azurewebsites.net/api/Cliente/CriarCliente");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            String token = getAutToken();
            if(token != null){
                connection.setRequestProperty("Authorization", "Bearer "+ token);
            }
            connection.setReadTimeout(20000);
            connection.setConnectTimeout(20000);

            try(BufferedOutputStream outputStream = new BufferedOutputStream(new BufferedOutputStream(connection.getOutputStream()))){
                outputStream.write(json.getBytes());
                outputStream.flush();
            }

            int responseCod = connection.getResponseCode();
            if(responseCod == HttpURLConnection.HTTP_OK){
                try(BufferedReader leitor = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = leitor.readLine()) != null){
                        response.append(line);
                    }

                    Log.d("ApiService", "Resposta da API: " + response.toString());
                    RespostaApiDto resposta = mapper.readValue(response.toString(), RespostaApiDto.class);
                    Log.d("ApiService", "Dados da resposta: " + (resposta != null ? resposta.getDados() : "null"));
                    cliente = resposta.getDados();
                    return  cliente;
                }
            }
            else{
                Log.e("ApiService", "Erro na API: Código de resposta " + responseCod);
            }

        }catch (Exception e){
            Log.e("ApiService", "Erro ao consumir a API: "+ e.getMessage(), e);
            connection.disconnect();
            return cliente;
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return cliente;
    }

}
