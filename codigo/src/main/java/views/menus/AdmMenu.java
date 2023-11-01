//package main.java.views.menus;
//
//import main.java.models.Biblioteca;
//import main.java.utils.InputScannerUtil;
//
//public class AdmMenu {
//
//
//
//    public static void admSistema(Biblioteca biblioteca) {
//        while (true) {
//            System.out.println("Escolha a operação desejada:");
//            System.out.println("1. Gerenciar usuários");
//            System.out.println("2. Gerenciar itens não emprestáveis");
//            System.out.println("3. Gerenciar itens emprestáveis");
//            System.out.println("4. Pesquisar itens da biblioteca");
//            System.out.println("5. Voltar ao menu principal");
//
//            try {
//                System.out.print("Opção: ");
//                int escolha = InputScannerUtil.scanner.nextInt();
//
//                if (escolha == 5) {
//                    System.out.println("Voltando ao menu principal...\n");
//                    break;
//                }
//
//                switch (escolha) {
//                    case 1:
//                        GerenciarBibliotecaUtil.gerenciarUsuario(biblioteca);
//                        break;
//                    case 2:
//                        GerenciarBibliotecaUtil.gerenciarItemNaoEmprestavel(biblioteca);
//                        break;
//                    case 3:
//                        GerenciarBibliotecaUtil.gerenciarItemEmprestavel(biblioteca);
//                        break;
//                    case 4:
//                        try {
//                            GerenciarBibliotecaUtil.pesquisa(biblioteca);
//                        } catch (Exception e) {
//                            System.out.println("Erro: " + e.getMessage());
//                            System.out.println();
//                        }
//                        break;
//                    default:
//                        System.out.println("Opção inválida. Tente novamente.");
//                }
//            } catch (NoSuchElementException e) {
//                System.out.println("Entrada inválida.");
//                InputScannerUtil.getScanner().nextLine();
//            }
//
//            InputScannerUtil.close();
//
//        }
//    }
//
//}
