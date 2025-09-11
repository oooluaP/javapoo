package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Scanner scanner = new Scanner(System.in);

        // Adicionar itens pelo usuário
        System.out.print("Quantos itens deseja cadastrar? ");
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
