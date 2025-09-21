package org.example;
import java.util.Scanner;

public class Main {
    private static final Biblioteca biblioteca = new Biblioteca();
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE BIBLIOTECA ===");
        
        // Login inicial
        realizarLogin();
        
        // Menu principal em loop
        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = lerOpcao();
            
            switch (opcao) {
                case 1:
                    cadastrarItem();
                    break;
                case 2:
                    listarItens();
                    break;
                case 3:
                    buscarItem();
                    break;
                case 4:
                    removerItem();
                    break;
                case 5:
                    emprestarLivro();
                    break;
                case 6:
                    trocarUsuario();
                    break;
                case 0:
                    System.out.println("Obrigado por usar o sistema! Até logo!");
                    break;
                default:
                    System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
            
            if (opcao != 0) {
                pausar();
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }

    private static void realizarLogin() {
        System.out.println("\n=== LOGIN NO SISTEMA ===");
        System.out.println("Qual seu tipo de perfil?");
        System.out.println("1 - Administrador");
        System.out.println("2 - Bibliotecário");
        System.out.println("3 - Usuário Comum");
        System.out.print("Escolha sua opção: ");
        
        int opcao = lerOpcao();
        
        switch (opcao) {
            case 1:
                System.out.println("É administrador temporário? (1-Sim / 2-Não): ");
                int tipoAdm = lerOpcao();
                if (tipoAdm == 1) {
                    usuarioLogado = new AdministradorTemporario("Admin Temporário");
                    System.out.println("✅ Logado como Administrador Temporário");
                } else {
                    usuarioLogado = new Administrador("Administrador");
                    System.out.println("✅ Logado como Administrador");
                }
                break;
            case 2:
                usuarioLogado = new Bibliotecario("Bibliotecário");
                System.out.println("✅ Logado como Bibliotecário");
                break;
            case 3:
                usuarioLogado = new UsuarioComum("Usuário Comum");
                System.out.println("✅ Logado como Usuário Comum");
                break;
            default:
                System.out.println("⚠️ Opção inválida! Definindo como Usuário Comum.");
                usuarioLogado = new UsuarioComum("Usuário Comum");
        }
        
        System.out.println(usuarioLogado.gerarRelatorio());
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           MENU PRINCIPAL");
        System.out.println("=".repeat(40));
        System.out.println("Usuário: " + usuarioLogado.getNome());
        System.out.println("-".repeat(40));
        System.out.println("1  📚 Cadastrar Item");
        System.out.println("2  📋 Listar Todos os Itens");
        System.out.println("3  🔍 Buscar Item por Título");
        System.out.println("4  🗑️  Remover Item");
        System.out.println("5  📖 Pegar Livro Emprestado");
        System.out.println("6  👤 Trocar Usuário");
        System.out.println("0  🚪 Sair do Sistema");
        System.out.println("=".repeat(40));
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            return opcao;
        } catch (Exception e) {
            scanner.nextLine(); // Limpar buffer em caso de erro
            return -1;
        }
    }

    private static void cadastrarItem() {
        System.out.println("\n=== CADASTRAR ITEM ===");
        
        System.out.println("Tipo de item:");
        System.out.println("1 - Livro Físico");
        System.out.println("2 - Livro Digital");
        System.out.println("3 - Revista");
        System.out.print("Escolha o tipo: ");
        
        int tipo = lerOpcao();
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Categoria: ");
        String descricaoCategoria = scanner.nextLine();
        Categoria categoria = new Categoria(descricaoCategoria);
        
        try {
            switch (tipo) {
                case 1:
                    cadastrarLivroFisico(titulo, categoria);
                    break;
                case 2:
                    cadastrarLivroDigital(titulo, categoria);
                    break;
                case 3:
                    cadastrarRevista(titulo, categoria);
                    break;
                default:
                    System.out.println("⚠️ Tipo inválido!");
                    return;
            }
            System.out.println("✅ Item cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao cadastrar item: " + e.getMessage());
        }
    }

    private static void emprestarLivro() {
        System.out.println("\n=== PEGAR LIVRO EMPRESTADO ===");;
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        biblioteca.emprestarItem(titulo, usuarioLogado);
    }

    private static void cadastrarLivroFisico(String titulo, Categoria categoria) {
        System.out.print("Nome do autor: ");
        String nomeAutor = scanner.nextLine();
        Autor autor = new Autor(nomeAutor);
        System.out.print("Número de páginas: ");
        int paginas = lerOpcao();
        LivroFisico livro = new LivroFisico(titulo, autor, categoria, paginas, usuarioLogado);
        biblioteca.adicionarItem(livro);
    }

    private static void cadastrarLivroDigital(String titulo, Categoria categoria) {
        System.out.print("Nome do autor: ");
        String nomeAutor = scanner.nextLine();
        Autor autor = new Autor(nomeAutor);
        System.out.print("Tamanho do arquivo (MB): ");
        double tamanho = scanner.nextDouble();
        scanner.nextLine();
        LivroDigital livro = new LivroDigital(titulo, autor, categoria, tamanho, usuarioLogado);
        biblioteca.adicionarItem(livro);
    }

    private static void cadastrarRevista(String titulo, Categoria categoria) {
        System.out.print("Número da edição: ");
        int edicao = lerOpcao();
        
        Revista revista = new Revista(titulo, categoria, edicao);
        biblioteca.adicionarItem(revista);
    }

    private static void listarItens() {
        System.out.println("\n=== TODOS OS ITENS ===");
        biblioteca.listarItens();
    }

    private static void buscarItem() {
        System.out.println("\n=== BUSCAR ITEM ===");
        System.out.print("Digite o título do item: ");
        String titulo = scanner.nextLine();
        biblioteca.buscarPorTitulo(titulo);
    }

    private static void removerItem() {
        System.out.println("\n=== REMOVER ITEM ===");
        System.out.print("Digite o título do item para remover: ");
        String titulo = scanner.nextLine();
        biblioteca.removerItem(titulo);
    }

    private static void trocarUsuario() {
        System.out.println("\n=== TROCAR USUÁRIO ===");
        realizarLogin();
    }

    private static void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }
}
