package com.ericklemos.tetoverde.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteDto {
    @JsonProperty("idCodCliente")
    private int idCodCliente;

    @JsonProperty("fantasia")
    private String fantasia;

    @JsonProperty("cnpj")
    private String cnpj;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telCelCli")
    private String telefone;

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("rua")
    private String rua;

    @JsonProperty("numero")
    private int numero;

    @JsonProperty("bairro")
    private String bairro;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("senha")
    private String senha;

    public int getIdCodCliente() {
        return idCodCliente;
    }

    public void setIdCodCliente(int idCodCliente) {
        this.idCodCliente = idCodCliente;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                "idCodCliente=" + idCodCliente +
                ",\n fantasia='" + fantasia + '\'' +
                ",\n cnpj='" + cnpj + '\'' +
                ",\n email='" + email + '\'' +
                ",\n telefone='" + telefone + '\'' +
                ",\n cep='" + cep + '\'' +
                ",\n rua='" + rua + '\'' +
                ",\n numero=" + numero +
                ",\n bairro='" + bairro + '\'' +
                ",\n cidade='" + cidade + '\'' +
                ",\n uf='" + uf + '\'' +
                ",\n senha='" + senha + '\'' +
                '}';
    }
}
