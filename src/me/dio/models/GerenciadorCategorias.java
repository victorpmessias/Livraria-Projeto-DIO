package me.dio.models;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorCategorias {
    private static final GerenciadorCategorias INSTANCE = new GerenciadorCategorias();

    Map<String, Autor> autores = new HashMap<>();
    Map<String, Genero> generos = new HashMap<>();

    public static GerenciadorCategorias getInstance() {
        return INSTANCE;
    }
    private GerenciadorCategorias() {
    }

    
    public Categoria criarCategoria(String tipoCategoria, String nome){
        if(tipoCategoria.equalsIgnoreCase("autor")){
            Autor autor = new Autor(nome);
            autores.put(autor.getNome(), autor);
            return autor;
        }else if(tipoCategoria.equalsIgnoreCase("genero")){
            Genero genero = new Genero(nome);
            generos.put(genero.getNome(), genero);
;            return genero;
        }
        return null;

    }

    
}
