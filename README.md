Projeto Dio - Explorando Padrões de projetos na Prática com Java
DESCRIÇÃO:
Agora é a sua hora de brilhar! Crie uma solução que explore o conceito de Padrões de Projeto na prática. Para isso, você pode reproduzir um dos projetos que criamos durante as aulas ou, caso se sinta preparado, desenvolver uma nova ideia do zero.

-------------------------------------------------------
Este projeto simula um sistema de marcador de leitura de livros, onde um usuario pode adicionar livros e atualizar seu estado de leitura para a ler, lendo ou lidos. O controle da classe de livros é feito pela classe GerenciadoLivros que atraves de factory methods cria um objeto responsavel por instaciar os livros. Cada livro recebe um objeto generico de Categoria para autor e genero. A classe GerenciadorCategoria é responsavel por criar os objetos Categoria para Autor ou Genero. Ja a classe Usuario pode ser diretamente instaciada.
-------------------------------------------------------
 Este projeto tem com objetivo por em praticas conhecimentos adquiridos durante o bootcamp DIO GFT Start #3 Java, explorando conceitos de POO e Desgin Patterns aplicados a Java.
-------------------------------------------------------
1/02/2022:
Foi adicionado interação via console, onde é possivel incluir livros no app, adiciona-los a sua fila de leitura e atualizar o status de leitura, devido a natureza do projeto não foi incluido uma base de dados para salvar os dados. Nenhum dos dados inseridos são salvos, este projeto é somente uma demonstração.
Tambem houve algumas alteração na estrutura do projeto, foi adicionado um "gerenciador" para as classes Livro, e classes que implementam Categoria, estes gereciandor implementam o padrão Singleton.
Ha exceções que não foram tratadas, por isso pode haver erros de execução.
-------------------------------------------------------


 Victor Pereira Messias
 30-01-2022