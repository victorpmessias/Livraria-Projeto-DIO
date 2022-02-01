package me.dio.models;

public class GerenciadorLivros {

   private static final GerenciadorLivros INSTANCE = new GerenciadorLivros();

    private GerenciadorLivros() {
    }

    public static GerenciadorLivros getInstance() {
        return INSTANCE;
    }
 

    public Livro addLivro(String nome, Categoria autor, Categoria genero, int paginas){
        return new Livro(nome, autor, genero, paginas);
    }
    
    public Livro addLivro(String nome, Categoria autor, Categoria genero, int paginas, String descricao){
        return new Livro(nome, autor, genero, paginas, descricao);
    }
    
    public Livro addLivro(String nome, Autor autor, Genero genero, int paginas, String descricao){
        return new Livro(nome, autor, genero, paginas, descricao);
    }
    
}
