package main.java.utils;

import java.util.Scanner;

import main.java.models.Biblioteca;
import main.java.services.UsuarioService;

public class Cadastro {
     public static void gerenciarUsuarios(Biblioteca biblioteca) {
        Scanner sc = new Scanner(System.in);
        UsuarioService usuarioService = new UsuarioService(biblioteca);

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Criar usuário");
            System.out.println("2. Atualizar usuário");
            System.out.println("3. Deletar usuário");
            System.out.println("4. Listar usuários");
            System.out.println("5. Voltar");

            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    usuarioService.criar();
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
}
