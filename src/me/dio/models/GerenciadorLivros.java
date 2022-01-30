package me.dio.models;

public class GerenciadorLivros {


    public Livro addLivro(String nome, Categoria autor, Categoria genero, int paginas){
        return new Livro(nome, autor, genero, paginas);
    }
    
    public Livro addLivro(String nome, Categoria autor, Categoria genero, int paginas, String descricao){
        return new Livro(nome, autor, genero, paginas, descricao);
    }
    
}
