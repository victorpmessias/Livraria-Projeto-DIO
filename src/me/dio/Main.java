package me.dio;

import me.dio.models.Categoria;
import me.dio.models.GerenciadorCategorias;
import me.dio.models.GerenciadorLivros;
import me.dio.models.Livro;
import me.dio.models.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario victor = new Usuario();
        victor.setNome("Victor");
        victor.setEmail("victor.p.messias@gmail.com");
        victor.setSenha("123456");
        GerenciadorCategorias categorias = new GerenciadorCategorias();
        GerenciadorLivros livros = new GerenciadorLivros();
        Categoria fantasiaCat = categorias.criarCategoria("genero", "Fantasia");
        Categoria terrorCat = categorias.criarCategoria("genero", "Terror");
        Categoria Jkautor = categorias.criarCategoria("autor", "J.K. Rowling");
        Categoria stephAutor = categorias.criarCategoria("autor", "Stephen King");
        Livro livro = livros.addLivro("Harry Potter", Jkautor, fantasiaCat, 500);
        Livro livro2 = livros.addLivro("Harry Potter 2", Jkautor, fantasiaCat, 500);
        Livro livro3 = livros.addLivro("IT: A Coisa", stephAutor, terrorCat, 600);
        Livro livro4 = livros.addLivro("A dança da morte", stephAutor, terrorCat, 380, "A Dança da Morte é um romance pós-apocalíptico de horror/fantasia");
        System.out.println("Livros por autor");
        Jkautor.listarLivro();
        stephAutor.listarLivro();

        System.out.println("Adicionando livros a lista de leitura");
        victor.addLivroALer(livro);
        victor.addLivroALer(livro2);
        victor.addLivroALer(livro3);
        victor.addLivroALer(livro4);
        System.out.println("Exibindo fila de leitura dos livros");
        victor.listarLivros();
        victor.listarLivros("ler");
        System.out.println("---------------");
        System.out.println("Atualizando status de leitura dos livros");
        victor.attStatusLeitura(livro, 500);
        victor.attStatusLeitura(livro2, 400);
        victor.attStatusLeitura(livro3, 50);
        System.out.println("Exibindo fila de leitura dos livros");
        victor.listarLivros("ler");
        victor.listarLivros("lendo");
        victor.listarLivros("lido");

    }
}
