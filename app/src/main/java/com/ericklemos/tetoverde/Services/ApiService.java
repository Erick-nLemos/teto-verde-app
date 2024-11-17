package com.ericklemos.tetoverde.Services;

import android.util.Log;

import com.ericklemos.tetoverde.configSSL.IgnoreSSL;
import com.ericklemos.tetoverde.dtos.ClienteDto;
import com.ericklemos.tetoverde.dtos.RespostaApiDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    public ClienteDto getCliente(int id){
        try{
            IgnoreSSL.ignorarCertificadosSSL();
            ClienteDto cliente = null;

            URL url = new URL("https://192.168.43.98:7144/api/Cliente/ListarClientes/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(20000);

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
    }

}
