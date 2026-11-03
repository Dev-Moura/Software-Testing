package com.softwareTesting.java.testeDeIntegracao.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeLivros {
    private List<Livro> livros = new ArrayList<>();

    public void adicionar(Livro livro) {
        livros.add(livro);
    }

    public Livro buscarPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public  boolean livroDisponivel(String isbn) {
        return buscarPorIsbn(isbn) != null;
    }
}
