package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();


        Scanner scanner = new Scanner(System.in);

        // Identificação
        System.out.print("Qual seu tipo de perfil? 1 - ADM/2 - Bibliotecario/3 - Usuario Comum");
        int Opcao = scanner.nextInt();

        switch (Opcao) {
            case 3:
                System.out.println("Então voce é Usuario comum.");
                Usuario usrc = new UsuarioComum("Joao usuario comum");
                System.out.println(usrc.gerarRelatorio());



            case 2:
                System.out.println("Então voce é bibliotecario.");
                Usuario b1 = new Bibliotecario("Maria bibliotecaria");
                System.out.println(b1.gerarRelatorio());
                break;

            case 1:
                System.out.println("Vocé é ADM. É adm temporario? Digite 1 pra sim e 2 pra não.");
                int Opcaoadm = scanner.nextInt();

                if (Opcaoadm == 2) {
                    System.out.println("Então voce é ADM apenas.");
                    Usuario adm = new Administrador("Jair ADM");
                    System.out.println(adm.gerarRelatorio());

                }else if (Opcaoadm == 1){
                    System.out.println("Então voce é ADM temporario apenas.");
                    Usuario admTemp = new AdministradorTemporario("Luiz ADM temp");
                    System.out.println(admTemp.gerarRelatorio());

                }
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }




        System.out.println("Quantos livros deseja cadastrar?");

        int qtd = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        for (int i = 0; i < qtd; i++) {
            System.out.println("\nCadastro do item " + (i + 1));

            System.out.print("Tipo (1 - Livro Físico | 2 - Livro Digital | 3 - Revista): ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            System.out.print("Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Categoria: ");
            String descricaoCat = scanner.nextLine();
            Categoria categoria = new Categoria(descricaoCat);

            if (tipo == 1) {
                System.out.print("Autor: ");
                String nomeAutor = scanner.nextLine();
                Autor autor = new Autor(nomeAutor);

                System.out.print("Número de páginas: ");
                int paginas = scanner.nextInt();
                scanner.nextLine();

                Livro livroFisico = new LivroFisico(titulo, autor, categoria, paginas);
                biblioteca.adicionarItem(livroFisico);

            } else if (tipo == 2) {
                System.out.print("Autor: ");
                String nomeAutor = scanner.nextLine();
                Autor autor = new Autor(nomeAutor);

                System.out.print("Tamanho do arquivo (MB): ");
                double tamanho = scanner.nextDouble();
                scanner.nextLine();

                Livro livroDigital = new LivroDigital(titulo, autor, categoria, tamanho);
                biblioteca.adicionarItem(livroDigital);

            } else if (tipo == 3) {
                System.out.print("Edição: ");
                int edicao = scanner.nextInt();
                scanner.nextLine();

                Revista revista = new Revista(titulo, categoria, edicao);
                biblioteca.adicionarItem(revista);

            } else {
                System.out.println("Tipo inválido, ignorando cadastro.");
            }
        }

        // Listar itens cadastrados
        biblioteca.listarItens();

        // Buscar item
        System.out.print("\nDigite o título do item que deseja buscar: ");
        String tituloBuscar = scanner.nextLine();
        biblioteca.buscarPorTitulo(tituloBuscar);


        // Remover item
        System.out.print("\nDigite o título do item que deseja remover: ");
        String tituloRemover = scanner.nextLine();
        biblioteca.removerItem(tituloRemover);

        // Listar novamente
        biblioteca.listarItens();


    }
}
