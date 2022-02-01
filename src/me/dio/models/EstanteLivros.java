package me.dio.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstanteLivros {

    private static final EstanteLivros INSTANCE = new EstanteLivros();
    Map<String, Livro> livros = new HashMap<>();

    private EstanteLivros() {
    }

    public static EstanteLivros getInstance() {
        return INSTANCE;
    }

    public boolean addLivro(String nome, Categoria autor, Categoria genero, int paginas ) {
        if (!livros.containsKey(nome)) {
            Livro livro = GerenciadorLivros.getInstance().addLivro(nome, autor, genero, paginas);
            livros.put(livro.getNome(), livro);
            return true;
        }
        return false;
    }
    public boolean addLivro(String nome, Categoria autor, Categoria genero, int paginas, String descri ) {
        if (!livros.containsKey(nome)) {
            Livro livro = GerenciadorLivros.getInstance().addLivro(nome, autor, genero, paginas, descri);
            livros.put(livro.getNome(), livro);
            return true;
        }
        return false;
    }

    public boolean removeLivro(Livro livro) {
        if (livros.containsValue(livro)) {
            livros.remove(livro.getNome());
            return true;
        }
        return false;
    }

    public Map<String, Livro> getLivrosMap(){
        return livros;
    }

    public List<String> printarLivros(){
        List<String> livrosLista = new ArrayList<String>();

        for( Livro livro : livros.values()){
            System.out.println(livro.getNome());
        }
            return livrosLista;
    }


}
