package com.softwareTesting.java.mockito.pedidos;

public class ServicoDePedidos {

    private final RepositorioDePedidos repositorio;

    public ServicoDePedidos(RepositorioDePedidos repositorio) {
        this.repositorio = repositorio;
    }

    public String obterDecricaoDOPedido(int id) {
        Pedidos pedido = repositorio.buscarPorId(id);
        return pedido != null ? pedido.getDescricao() : "edido Não Encontrado!";
    }
}
