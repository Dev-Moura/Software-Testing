package com.softwareTesting.java.mockito.pedidos;

public class Pedidos {

    private final int id;
    private final String descricao;

    public Pedidos(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
