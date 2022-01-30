package me.dio.models;

import java.time.LocalDate;

public class Livro {
    private String nome;
    private Categoria autor;
    private Categoria genero;
    public final LocalDate dataCriacao = LocalDate.now();
    private int paginas;
    private String descricao;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Categoria getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public Categoria getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Livro(String nome, Categoria autor, Categoria genero, int paginas) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
        autor.addLivro(this);
    }
    public Livro(String nome, Categoria autor, Categoria genero, int paginas, String descricao) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
        this.descricao = descricao;
        autor.addLivro(this);
    }
    @Override
    public String toString() {
        return "Livro ["
                    + "nome=" + nome 
                    + ", autor=" + autor.getNome()
                    + ", dataCriacao=" + dataCriacao 
                    + ", descricao=" + descricao 
                    + ", genero=" + genero.getNome()
                    + ", paginas=" + paginas + "]";
    }

}
