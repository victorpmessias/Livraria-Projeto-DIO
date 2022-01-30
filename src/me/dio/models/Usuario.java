package me.dio.models;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private Map<Livro, String> livrosLendo = new LinkedHashMap<>();
    private Set<Livro> livrosALer = new LinkedHashSet<>();
    private Set<Livro> livrosLidos = new LinkedHashSet<>();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((livrosALer == null) ? 0 : livrosALer.hashCode());
        result = prime * result + ((livrosLendo == null) ? 0 : livrosLendo.hashCode());
        result = prime * result + ((livrosLidos == null) ? 0 : livrosLidos.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (livrosALer == null) {
            if (other.livrosALer != null)
                return false;
        } else if (!livrosALer.equals(other.livrosALer))
            return false;
        if (livrosLendo == null) {
            if (other.livrosLendo != null)
                return false;
        } else if (!livrosLendo.equals(other.livrosLendo))
            return false;
        if (livrosLidos == null) {
            if (other.livrosLidos != null)
                return false;
        } else if (!livrosLidos.equals(other.livrosLidos))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        return true;
    }

    public void addLivroALer(Livro livro){
        if (livrosLendo.containsKey(livro)){
            livrosLendo.remove(livro);
        } else if (livrosLidos.contains(livro)){
            livrosLidos.remove(livro);
        }
        System.out.println("Livro adicionado a fila de leitura.");
        livrosALer.add(livro);
    }

    public void lerLivro(Livro livro){
        if (livrosALer.contains(livro)){
            livrosALer.remove(livro);
        } else if (livrosLidos.contains(livro)){
            livrosLidos.remove(livro);
        }
        System.out.println("Livro adicionado a sua lista de leitura.");
        livrosLendo.put(livro, "Ultima Pagina Lida: " + "" + 0);
    }

    public void attStatusLeitura(Livro livro, int ultimaPaginaLida){
        int paginasLivro = livro.getPaginas();
        if (!livrosLendo.containsKey(livro)){
            lerLivro(livro);
        }
        if(paginasLivro == ultimaPaginaLida){
            livrosLidos.add(livro);
            livrosLendo.remove(livro);
            System.out.println("Livro finalizado adicionado a lista de livros lidos.");
        } else if (ultimaPaginaLida > paginasLivro){
            System.out.println("Numero de pagina invalida, este livro contem " + paginasLivro);
        }else if (ultimaPaginaLida < paginasLivro){

                livrosLendo.put(livro, "Ultima Pagina Lida: " + "" + ultimaPaginaLida);
            
        }

    }

    public void removerLivro(Livro livro){
        if (livrosALer.contains(livro)){
            livrosALer.remove(livro);
        } else if(livrosLendo.containsKey(livro)){
            livrosLendo.remove(livro);
        }else if(livrosLidos.contains(livro)){
            livrosLidos.remove(livro);
        }
    }

    public void listarLivros(){
        String livros = "";
        for(Livro livro : livrosALer){
            livros += livro.getNome()+ ", " ;
        }
        for(Livro livro : livrosLendo.keySet()){
            livros += livro.getNome()+ ", " ;
        }
        for(Livro livro : livrosLidos){
            livros += livro.getNome()+ ", " ;
        }
        if(livros==""){
            System.out.println("Sua lista de livros esta vazia.");
        }else{
        System.out.println("Todos os livros: " + livros);}
    }

    public void listarLivros(String estado){
        String livros = "";
        if(estado.equalsIgnoreCase("ler")){
            for(Livro livro : livrosALer){
                livros += livro.getNome()+ ", " ;
            }
            System.out.println("Livros a ler: " + livros);
        }else if(estado.equalsIgnoreCase("lendo")){
            for(Livro livro : livrosLendo.keySet()){
                livros += livro.getNome()+ ", " ;
            }
            System.out.println("Leituras em andamento: " + livros);
        }else if(estado.equalsIgnoreCase("lido")){
            for(Livro livro : livrosLidos){
                livros += livro.getNome()+ ", " ;
            }
            System.out.println("Livros a terminados: " + livros);
        } else {
            throw new IllegalArgumentException("Estado de leitura invalido.");
        }
    }

    public void listaLivroCategoria(Categoria categoria){
        String livros = "";
        for(Livro livro : livrosALer){
            if(livro.getGenero() == categoria){
                livros +=  livro.getNome()+ ", " ;
            }
        }
        for(Livro livro : livrosLendo.keySet()){
            if(livro.getGenero() == categoria){
                livros += livro.getNome()+ ", " ;
            }
        }
        for(Livro livro : livrosLidos){
            if(livro.getGenero() == categoria){
                livros += livro.getNome()+ ", " ;
            }
        }
        System.out.println("Livros por genero "+ categoria.getNome().toUpperCase() + ": " +livros);

    }
    public void listaLivroCategoria(Categoria categoria, String estado ){
        String livros = "";
        if(estado.equalsIgnoreCase("ler")){
            for(Livro livro : livrosALer){
                if(livro.getGenero() == categoria){
                    livros += livro.getNome() + ", " ;
                }
            }
         }  
         if(estado.equalsIgnoreCase("lendo")){ 
            for(Livro livro : livrosLendo.keySet()){
                if(livro.getGenero() == categoria){
                    livros +=  livro.getNome()+ ", " ;
                }
            }
        }
        if(estado.equalsIgnoreCase("lido")){
            for(Livro livro : livrosLidos){
                if(livro.getGenero() == categoria){
                    livros += livro.getNome()+ ", " ;
                }
            }
        }
        System.out.println("Livros"+ estado.toUpperCase()+"por genero "+ categoria.getNome().toUpperCase() + ": " + livros);

    }
    public void getEstadoLeitura(Livro livro){
        if(livrosLendo.containsKey(livro)){
            System.out.println(livro.getNome() +": " + livrosLendo.get(livro));
        }else{
        System.out.println("Livro não encontrado na lista de leitura!");
    }
    }

}
