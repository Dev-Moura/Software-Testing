package com.softwareTesting.java.testeDeIntegracao.biblioteca;

public class Livro {
    private String title;
    private String Author;
    private String isbn;


    public Livro(String title, String Author, String isbn) {
        this.title = title;
        this.Author = Author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getIsbn() {
        return isbn;
    }
}
