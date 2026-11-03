package com.softwareTesting.java.testeDeIntegracao.interfaceExterna;

import java.util.List;

public interface RepositorioDePessoas {
    void salvar(Pessoa pessoa);
    Pessoa buscarPorId(int id);
    List<Pessoa> listarTodas();
    void removerTodas();
}
