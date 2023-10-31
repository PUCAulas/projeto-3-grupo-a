package main.java.utils;

import main.java.models.Biblioteca;
import main.java.models.Usuario;
import main.java.models.itens.Emprestavel;
import main.java.models.itens.Item;
import main.java.services.ItemEmprestavelService;
import main.java.services.ItemService;
import main.java.services.UsuarioService;

import java.util.Scanner;

public class GerenciarBiblioteca {

    private static Scanner sc = new Scanner(System.in);

    public static void gerenciarUsuario(Biblioteca biblioteca) {
        UsuarioService usuarioService = new UsuarioService(biblioteca);

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Atualizar usuário");
            System.out.println("3. Deletar usuário");
            System.out.println("4. Listar usuários");
            System.out.println("5. Voltar");

            int escolha = sc.nextInt();
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
                case 5:
                    System.out.println("Voltando ao menu principal...\n");
                    return;
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

            int escolha = sc.nextInt();
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
                case 5:
                    System.out.println("Voltando ao menu principal...\n");
                    return;
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

            int escolha = sc.nextInt();
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
                case 5:
                    System.out.println("Voltando ao menu principal...\n");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }







}
