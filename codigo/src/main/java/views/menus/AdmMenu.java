package main.java.views.menus;

import main.java.models.Biblioteca;
import main.java.models.Usuario;
import main.java.models.itens.Item;
import main.java.services.ItemService;
import main.java.services.UsuarioService;
import main.java.utils.InputScannerUtil;
import main.java.views.inputs.AdmInput;
import main.java.views.inputs.ItemInput;

import java.util.Optional;

public class AdmMenu {

    public static void menuPrincipal(UsuarioService usuarioService, ItemService itemService, Biblioteca biblioteca) {

        while (true) {
            System.out.println("\nEscolha a operação desejada:");
            System.out.println("1. Gerenciar usuários");
            System.out.println("2. Gerenciar itens não emprestáveis");
            System.out.println("3. Gerenciar itens emprestáveis");
            System.out.println("4. Pesquisar itens da biblioteca");
            System.out.println("5. Imprimir relatório de usuário");
            System.out.println("6. Imprimir relatório de itens");
            System.out.println("7. Voltar ao menu principal");

            System.out.print("Opção: ");
            int escolha = InputScannerUtil.scanner.nextInt();
            InputScannerUtil.scanner.nextLine();

            if (escolha == 7) {
                System.out.println("Voltando ao menu principal...\n");
                break;
            }

            switch (escolha) {
                case 1:
                    menuUsuario(usuarioService);
                    break;
                case 2:
                    menuItensNaoEmprestaveis(itemService, biblioteca);
                    break;
                case 3:
                    // chamar método menuItensEmprestaveis
                    break;
                case 4:
                    try {
                        PesquisaMenu.pesquisa(usuarioService.getBiblioteca());
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                        System.out.println();
                    }
                    break;
                case 5:
                    Optional<Usuario> usuarioOptional = AdmInput.dadosDePesquisaDoUsuario(usuarioService);
                    usuarioOptional.ifPresent(biblioteca::imprimirRelatorioUsuario);
                    break;
                case 6:
                    try{
                        AdmInput.checkAdm(usuarioService);
                        biblioteca.imprimirRelatorioItem();
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.print("Pressione Enter para continuar...");
            InputScannerUtil.scanner.nextLine();
        }

    }

    public static void menuUsuario(UsuarioService usuarioService) {

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Pesquisar usuário"); // por id
            System.out.println("2. Deletar usuário"); // Por id
            System.out.println("3. Listar todos os usuários cadastrados");
            System.out.println("4. Voltar");
            System.out.print("Opção: ");

            int escolha = InputScannerUtil.scanner.nextInt();
            InputScannerUtil.scanner.nextLine();

            if (escolha == 4) {
                System.out.println("Voltando ao menu principal...\n");
                break;
            }

            switch (escolha) {
                case 1:
                    Optional<Usuario> usuarioOptional = AdmInput.dadosDePesquisaDoUsuario(usuarioService);
                    usuarioOptional.ifPresent(System.out::println);
                    break;
                case 2:
                    AdmInput.deletarUsuarioPorId(usuarioService);
                    break;
                case 3:
                    AdmInput.dadosDeTodosOsUsuarios(usuarioService);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.print("Pressione Enter para continuar...");
            InputScannerUtil.scanner.nextLine(); // Aguarda o usuário pressionar Enter
        }

    }

    public static void menuItensNaoEmprestaveis(ItemService itemService, Biblioteca biblioteca) {
        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Cadastrar item não emprestável");
            System.out.println("2. Atualizar Item não emprestável");
            System.out.println("3. Deletar Item não emprestável");
            System.out.println("4. Listar Item não emprestável");
            System.out.println("5. Voltar");
            System.out.print("Opção: ");

            int escolha = InputScannerUtil.scanner.nextInt();
            InputScannerUtil.scanner.nextLine();

            if (escolha == 5) {
                System.out.println("Voltando ao menu principal...\n");
                // InputScannerUtil.close();
                break;
            }

            switch (escolha) {
                case 1:
                    Item item = new Item();
                    ItemService itemService2 = new ItemService(item, biblioteca);
                    criarItemNaoEmprestavel(itemService2);
                    break;
                case 2:
                    atualizarItemNaoEmprestavel(itemService, biblioteca);
                    break;
                case 3:
                    ItemInput.excluirItem(itemService, biblioteca);;
                    break;
                case 4:
                    itemService.listar();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void criarItemNaoEmprestavel(ItemService itemService) {
        System.out.println("Escolha o tipo de item a ser criado:");
        System.out.println("1. Revista");
        System.out.println("2. Tese");

        int escolha = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();
        switch (escolha) {
            case 1:
                ItemInput.obterDadosDeRevista(itemService);
                break;
            case 2:
                ItemInput.obterDadosDeTese(itemService);
                break;
            default:
                System.out.println("Tipo de item inválido.");
        }
    }

    public static void atualizarItemNaoEmprestavel(ItemService itemService, Biblioteca biblioteca) {
        System.out.println("Escolha o tipo de item a ser atualizado:");
        System.out.println("1. Revista");
        System.out.println("2. Tese");

        int escolha = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();
        switch (escolha) {
            case 1:
                ItemInput.atualizarDadosDeRevista(itemService, biblioteca);
                break;
            case 2:
                ItemInput.atualizarDadosDeTese(itemService, biblioteca);
                break;
            default:
                System.out.println("Tipo de item inválido.");
        }
    }

    public static void opcoesRevista() {

        System.out.println("Opção:");
        System.out.println("1. Título");
        System.out.println("2. Data de Publicação");
        System.out.println("3. Classificação");
        System.out.println("4. Edição");
        System.out.println("5. Editora");
        System.out.println("6. Artigos");
    }

    public static void opcoesTese() {

        System.out.println("Opção:");
        System.out.println("1. Título");
        System.out.println("2. Data de Publicação");
        System.out.println("3. Classificação");
        System.out.println("4. Autor");
        System.out.println("5. Orientador");
        System.out.println("6. Data da defesa");
        System.out.println("7. Capitulos");
    }

    // coloque aqui o método de menu de itens não emprestáveis

}
