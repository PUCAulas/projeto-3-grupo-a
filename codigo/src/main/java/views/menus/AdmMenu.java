package main.java.views.menus;

import main.java.models.Usuario;
import main.java.services.UsuarioService;
import main.java.utils.InputScannerUtil;
import main.java.views.inputs.AdmInput;

import java.util.Optional;

public class AdmMenu {



    public static void menuPrincipal(UsuarioService usuarioService) {

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Gerenciar usuários");
            System.out.println("2. Gerenciar itens não emprestáveis");
            System.out.println("3. Gerenciar itens emprestáveis");
            System.out.println("4. Pesquisar itens da biblioteca");
            System.out.println("5. Voltar ao menu principal");

                System.out.print("Opção: ");
                int escolha = InputScannerUtil.scanner.nextInt();

                if (escolha == 5) {
                    System.out.println("Voltando ao menu principal...\n");
                    break;
                }

                switch (escolha) {
                    case 1:
                        menuUsuario(usuarioService);
                        break;
                    case 2:
                        //chamar método gerenciarItensNaoEmprestaveis
                        break;
                    case 3:
                        //chamar método gerenciarItensEmprestaveis
                        break;
                    case 4:
                        try {
                           PesquisaMenu.pesquisa(usuarioService.getBiblioteca());
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                            System.out.println();
                        }
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

        }

    }


    public static void menuUsuario(UsuarioService usuarioService) {

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Pesquisar usuário"); //por id
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
        }


        // Coloque aqui o método de menu de itens emprestáveis


        // coloque aqui o método de menu de itens não emprestáveis


    }



















}





