package com.example.rastreamento.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bairro;
    private String cidade;
    private String nome;
    private Long numero_logradouro;
    private String rua;
    private String telefone;

    public Clientes(){

    }

    public Clientes(Long id, String bairro, String cidade, String nome, Long numero_logradouro, String rua, String telefone){
        this.id = id;
        this.bairro = bairro;
        this.cidade = cidade;
        this.nome = nome;
        this.numero_logradouro = numero_logradouro;
        this.rua = rua;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getNumero_logradouro() {
        return numero_logradouro;
    }

    public void setNumero_logradouro(Long numero_logradouro) {
        this.numero_logradouro = numero_logradouro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}