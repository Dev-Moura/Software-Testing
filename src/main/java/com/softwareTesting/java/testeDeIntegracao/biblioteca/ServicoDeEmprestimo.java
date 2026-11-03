package com.softwareTesting.java.testeDeIntegracao.biblioteca;

public class ServicoDeEmprestimo {

    private RepositorioDeLivros repositorio;

    public ServicoDeEmprestimo(RepositorioDeLivros repositorio) {
        this.repositorio = repositorio;
    }

    public boolean emprestarLivros(String isbn) {
        if (repositorio.livroDisponivel(isbn)) {
            System.out.println("Livro Emprestado com sucesso: " + isbn);
            return true;
        } else {
            System.out.println("Livro não encontrado: " + isbn);
            return false;
        }
    }
}
