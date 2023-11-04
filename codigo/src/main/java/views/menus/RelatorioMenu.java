package main.java.views.menus;

import main.java.models.Biblioteca;
import main.java.models.Usuario;
import main.java.utils.InputScannerUtil;

public class RelatorioMenu {

    public static void relatorio(Biblioteca biblioteca) {

        while (true) {
            System.out.println("\nEscolha o relatório:");
            System.out.println("1. Relatório de usuário");
            System.out.println("2. Relatório de itens");
            System.out.println("3. Sair");
            System.out.print("Opção: ");

            int escolha = InputScannerUtil.scanner.nextInt();
            InputScannerUtil.scanner.nextLine();

            if (escolha == 3) {
                System.out.println("Voltando...\n");
                break;
            }

            switch (escolha) {
                case 1:
                    biblioteca.imprimirRelatorioItem();
                    break;
                case 2:
                    Usuario usuario = getUserId(biblioteca);
                    biblioteca.imprimirRelatorioUsuario(usuario);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        }
    }

    private static Usuario getUserId(Biblioteca biblioteca) {

        System.out.println("Informe o ID do usuario: ");
        int id = InputScannerUtil.scanner.nextInt();

        return biblioteca.getUsuarios()
                .stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
