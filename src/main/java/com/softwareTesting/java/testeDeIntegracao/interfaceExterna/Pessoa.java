package com.softwareTesting.java.testeDeIntegracao.interfaceExterna;

public class Pessoa {

    public int id;
    public String nome;
    public String email;

    public Pessoa() {}

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Pessoa(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome=" + nome + ", email=" + email + '}';
    }
}

