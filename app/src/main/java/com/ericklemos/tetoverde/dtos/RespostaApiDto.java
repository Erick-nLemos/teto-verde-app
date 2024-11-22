package com.ericklemos.tetoverde.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespostaApiDto {

    @JsonProperty("dados")
    private ClienteDto dados;

    @JsonProperty("mensagem")
    private String mensagem;

    @JsonProperty("status")
    private boolean status;

    @JsonProperty("token")
    private String token;

    // Getters e Setters
    public ClienteDto getDados() {
        return dados;
    }

    public void setDados(ClienteDto dados) {
        this.dados = dados;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "RespostaApiDto{" +
                "dados=" + dados +
                ", mensagem='" + mensagem + '\'' +
                ", status=" + status +
                ", token=" + token + '}';
    }
}
