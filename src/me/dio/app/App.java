package me.dio.app;

import java.util.Scanner;

import me.dio.models.Categoria;
import me.dio.models.EstanteLivros;
import me.dio.models.GerenciadorCategorias;
import me.dio.models.Livro;
import me.dio.models.Usuario;

public class App {
    Scanner sc = new Scanner(System.in);
    Usuario usuario;
    EstanteLivros estanteLivros = EstanteLivros.getInstance();
    GerenciadorCategorias categorias = GerenciadorCategorias.getInstance();

    public void init() {
        Boolean t = true;
        System.out.println("Ola Seja bem vindo ao seu marcador de livros.");
        System.out.println("Entre com seu cadastro ou registre um novo usuario.");
        System.out.println("------------------------------------------------");
        do {
            System.out.println("[1]Logar");
            System.out.println("[2]Registrar");
            int r = sc.nextInt();

            switch (r) {
                case 1:
                    usuario = logar();
                    initMenu(usuario);
                    t = false;
                    break;

                case 2:
                    usuario = registrar();
                    initMenu(usuario);
                    t = false;
                    break;

                default:
                    System.out.println("Digite 1 ou 2 para escoher uma opção.");
                    break;
            }
        } while (t);
    }

    private Usuario registrar() {
        System.out.println("---------------------------------");
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Email: ");
        String email = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        Usuario usuario = new Usuario(nome, email, senha);
        return usuario;
    }

    private Usuario logar() {
        System.out.println("---------------------------------");
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        Usuario usuario = new Usuario(nome, senha);
        return usuario;

    }

    private void initMenu(Usuario usuario) {
        String livro;
        String gen;
        String aut;
        int qntdPags;
        int descResp;
        Categoria genero;
        Categoria autor;
        System.out.println("\033[H\033[2J");
        boolean rodar = true;
        do {
            System.out.println("Ola " + usuario.getNome());
            System.out.println("------------------------------------");
            System.out.println("[0]Listar livros cadastrados no app");
            System.out.println("[1]Adicionar livro a lista de leitura");
            System.out.println("[2]Atualizar estado de leitura");
            System.out.println("[3]Remover livro.");
            System.out.println("------------------------------------");
            System.out.println("[4]Mostrar minha fila de leitura");
            System.out.println("[5]Mostrar minhas leituras em andamento");
            System.out.println("[6]Mostrar minhas leituras finalizadas");
            System.out.println("[7]Mostrar todos meus livros.");
            System.out.println("------------------------------------");
            System.out.println("[8]Cadastrar Livros");
            System.out.println("[9]Sair");
            System.out.println("------------------------------------");

            System.out.print("O que deseaja fazer ? ");
            int r = sc.nextInt();

            switch (r) {
                case 0:
                    System.out.println("\033[H\033[2J");
                    System.out.println("------------------------------------");
                    System.out.println("Livros cadastrados no app:");
                    if (estanteLivros.getLivrosMap().size() == 0) {
                        System.out.println("Não há livros cadastradatos, utiliza a opção 8 para cadastradar.");
                    } else {
                        estanteLivros.printarLivros();
                    }
                    System.out.println("------------------------------------");
                    break;
                case 1:
                    System.out.println("------------------------------------");
                    System.out.println("Digite o nome do livro que deseja adiciona a lista de leitura: ");
                    livro = sc.next();
                    if (estanteLivros.getLivrosMap().containsKey(livro)) {
                        Livro newLivro = estanteLivros.getLivrosMap().get(livro);
                        usuario.addLivroALer(newLivro);
                    } else {
                        System.out.println("\033[H\033[2J");

                        System.out.println("------------------------------------");

                        System.out.println("Livro não encontrado");
                        System.out.println("------------------------------------");

                    }
                    System.out.println("\033[H\033[2J");

                    break;

                case 2:
                    System.out.println("------------------------------------");
                    System.out.println("Digite o nome do livro que deseja atualizar o estado de leitura: ");
                    livro = sc.next();
                    if (estanteLivros.getLivrosMap().containsKey(livro)) {
                        Livro newLivro = estanteLivros.getLivrosMap().get(livro);
                        System.out.print(("Qual ultima pagina lida ? "));
                        int pag = sc.nextInt();
                        usuario.attStatusLeitura(newLivro, pag);
                    } else {
                        System.out.println("\033[H\033[2J");

                        System.out.println("------------------------------------");

                        System.out.println("Livro não encontrado");
                        System.out.println("------------------------------------");

                    }

                    System.out.println("\033[H\033[2J");
                    break;

                case 3:
                    System.out.println("------------------------------------");
                    System.out.println("Digite o nome do livro que deseja remover da lista de leitura: ");
                    livro = sc.next();
                    if (estanteLivros.getLivrosMap().containsKey(livro)) {
                        Livro newLivro = estanteLivros.getLivrosMap().get(livro);
                        usuario.removerLivro(newLivro);
                    } else {
                        System.out.println("\033[H\033[2J");
                        System.out.println("------------------------------------");
                        System.out.println("Livro não encontrado");
                        System.out.println("------------------------------------");

                    }
                    System.out.println("\033[H\033[2J");
                    break;
                case 4:
                    System.out.println("\033[H\033[2J");
                    System.out.println("------------------------------------");
                    usuario.listarLivros("ler");
                    System.out.println("------------------------------------");

                    break;
                case 5:
                    System.out.println("\033[H\033[2J");
                    System.out.println("------------------------------------");
                    usuario.listarLivros("lendo");
                    System.out.println("------------------------------------");
                    break;

                case 6:

                    System.out.println("\033[H\033[2J");
                    System.out.println("------------------------------------");
                    usuario.listarLivros("lido");
                    System.out.println("------------------------------------");

                    break;
                case 7:
                    System.out.println("\033[H\033[2J");
                    System.out.println("------------------------------------");
                    usuario.listarLivros();
                    System.out.println("------------------------------------");

                    break;
                case 8:
                    System.out.println("\033[H\033[2J");
                    System.out.println("------------------------------------");
                    System.out.println("Digite o nome do livro que deseja cadastrar na estante: ");
                    livro = sc.next();
                    if (!estanteLivros.getLivrosMap().containsKey(livro)) {
                        System.out.println("Digite o genero do livro :  ");
                        gen = sc.next();
                        genero = categorias.criarCategoria("genero", gen);
                        System.out.println("Digite o autor do livro : ");
                        aut = sc.next();
                        autor = categorias.criarCategoria("autor", aut);
                        System.out.print("Digite quantas paginas tem o livro : ");
                        qntdPags = sc.nextInt();
                        System.out.println("Deseja adicionar uma descrição ? ");
                        System.out.println("[1] para sim");
                        System.out.println("[2] para não");
                        descResp = sc.nextInt();
                        if (descResp == 1) {
                            System.out.println("Digite o descricao do livro : ");
                            String desc = sc.next();
                            estanteLivros.addLivro(livro, autor, genero, qntdPags, desc);
                        }
                        estanteLivros.addLivro(livro, autor, genero, qntdPags);
                        System.out.println("\033[H\033[2J");
                        System.out.println("------------------------------------");
                        System.out.println("Livro  cadastrado com sucesso.");
                        System.out.println("------------------------------------");
                    } else {
                        System.out.println("\033[H\033[2J");
                        System.out.println("------------------------------------");
                        System.out.println("Livro ja cadastrado");
                        System.out.println("------------------------------------");
                    }
                    break;
                case 9:
                    rodar = false;
            }

        } while (rodar == true);
    }

}
