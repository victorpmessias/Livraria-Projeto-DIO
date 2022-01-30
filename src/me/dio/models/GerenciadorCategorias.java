package me.dio.models;

public class GerenciadorCategorias {

    public  GerenciadorCategorias() {
    }

    
    public Categoria criarCategoria(String tipoCategoria, String nome){
        if(tipoCategoria.equalsIgnoreCase("autor")){
            Autor categoria = new Autor(nome);
            return categoria;
        }else if(tipoCategoria.equalsIgnoreCase("genero")){
            Genero categoria = new Genero(nome);
            return categoria;
        }
        return null;

    }

    
}
