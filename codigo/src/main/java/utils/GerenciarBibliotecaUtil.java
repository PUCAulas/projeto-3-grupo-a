package main.java.utils;

import main.java.enums.FiltroPesquisa;
import main.java.models.Biblioteca;
import main.java.models.Usuario;
import main.java.models.itens.Emprestavel;
import main.java.models.itens.Item;
import main.java.services.ItemEmprestavelService;
import main.java.services.ItemService;
import main.java.services.UsuarioService;


public class GerenciarBibliotecaUtil {

    public static void gerenciarUsuario(Biblioteca biblioteca) {
        UsuarioService usuarioService = new UsuarioService(biblioteca);

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Atualizar usuário");
            System.out.println("3. Deletar usuário");
            System.out.println("4. Listar usuários");
            System.out.println("5. Voltar");
            System.out.print("Opção: ");

            int escolha = InputScannerUtil.getScanner().nextInt();
            InputScannerUtil.getScanner().nextLine();

            if (escolha == 5) {
                System.out.println("Voltando ao menu principal...\n");
                InputScannerUtil.close();
                break;
            }

            switch (escolha) {
                case 1:
                    Usuario usuario = new Usuario();
                    UsuarioService usuarioService2 = new UsuarioService(usuario, biblioteca);
                    usuarioService2.criar();
                    break;
                case 2:
                    usuarioService.atualizar();
                    break;
                case 3:
                    usuarioService.deletar();
                    break;
                case 4:
                    usuarioService.listar();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



    public static void gerenciarItemNaoEmprestavel(Biblioteca biblioteca) {
        ItemService itemService = new ItemService(biblioteca);

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Cadastrar Item não emprestável");
            System.out.println("2. Atualizar Item não emprestável");
            System.out.println("3. Deletar Item não emprestável");
            System.out.println("4. Listar Item não emprestável");
            System.out.println("5. Voltar");
            System.out.print("Opção: ");

            int escolha = InputScannerUtil.getScanner().nextInt();
            InputScannerUtil.getScanner().nextLine();

            if (escolha == 5) {
                System.out.println("Voltando ao menu principal...\n");
                InputScannerUtil.close();
                break;
            }

            switch (escolha) {
                case 1:
                    Item item = new Item();
                    ItemService itemService2 = new ItemService(item, biblioteca);
                    itemService2.criar();
                    break;
                case 2:
                    itemService.atualizar();
                    break;
                case 3:
                    itemService.deletar();
                    break;
                case 4:
                   itemService.listar();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    public static void gerenciarItemEmprestavel(Biblioteca biblioteca) {
        ItemEmprestavelService itemEmprestavelService = new ItemEmprestavelService(biblioteca);

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Cadastrar Item emprestável");
            System.out.println("2. Atualizar Item emprestável");
            System.out.println("3. Deletar Item emprestável");
            System.out.println("4. Listar Item emprestável");
            System.out.println("5. Voltar");
            System.out.print("Opção: ");

            int escolha = InputScannerUtil.getScanner().nextInt();
            InputScannerUtil.getScanner().nextLine();

            if (escolha == 5) {
                System.out.println("Voltando ao menu principal...\n");
                InputScannerUtil.close();
                break;
            }

            switch (escolha) {
                case 1:
                    Emprestavel emprestavel = new Emprestavel();
                    ItemEmprestavelService itemEmprestavelService1 = new ItemEmprestavelService(emprestavel, biblioteca);
                    itemEmprestavelService1.criar();
                    break;
                case 2:
                    itemEmprestavelService.atualizar();
                    break;
                case 3:
                    itemEmprestavelService.deletar();
                    break;
                case 4:
                    itemEmprestavelService.listar();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }




    public static void pesquisa(Biblioteca biblioteca) throws Exception {

        while (true) {
            System.out.println("Escolha um filtro de pesquisa:");
            System.out.println("1. Por Título");
            System.out.println("2. Por Ano");
            System.out.println("3. Por Autor");
            System.out.println("4. Por Tipo de Item");
            System.out.println("5. Sair");
            System.out.print("Opção: ");

            int escolha = InputScannerUtil.getScanner().nextInt();
            InputScannerUtil.getScanner().nextLine();

            if (escolha == 5) {
                System.out.println("Voltando ao menu principal...\n");
                InputScannerUtil.close();
                break;
            }

            FiltroPesquisa filtro = null;

            if (escolha == 4) {
                System.out.print("Digite o tipo de item (livro, revista, tese, DVD, CD): ");
                String tipoItem = InputScannerUtil.getScanner().nextLine();
                try {
                    filtro = FiltroPesquisa.valueOf(tipoItem.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo de item inválido. Certifique-se de usar um dos valores válidos (livro, revista, tese, DVD, CD).");
                    continue;
                }
            } else {
                switch (escolha) {
                    case 1:
                        filtro = FiltroPesquisa.TITULO;
                        break;
                    case 2:
                        filtro = FiltroPesquisa.ANO;
                        break;
                    case 3:
                        filtro = FiltroPesquisa.AUTOR;
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            }

            if (filtro != null) {
                biblioteca.pesquisar(filtro);
            }

        }
    }











}
