package main.java.views.menus;

import main.java.services.UsuarioService;
import main.java.utils.InputScannerUtil;
import main.java.views.inputs.UsuarioInput;

public class UsuarioMenu {

    public static void usuarioConta(UsuarioService usuarioService) {


        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Atualizar usuário");
            System.out.println("3. Deletar usuário");
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
                    UsuarioInput.obterDadosDeCadastro(usuarioService);
                    break;
                case 2:
                    UsuarioInput.obterDadosDeAtualizacao(usuarioService);
                    break;
                case 3:
                    UsuarioInput.obterDadosDeExclusao(usuarioService);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
