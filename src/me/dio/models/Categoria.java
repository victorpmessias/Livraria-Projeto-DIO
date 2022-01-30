package me.dio.models;

import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Categoria {
    protected String nome;
    protected Set<Livro> livrosLista = new LinkedHashSet<>();
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public  void addLivro(Livro livro){
        livrosLista.add(livro);
    }

    public  void listarLivro(){        
        String livros = "";
        for(Livro livro : livrosLista){
            livros +=livro.getNome()+ ", " ;
        }
        System.out.println(getNome()+": "+livros);
    }
}
