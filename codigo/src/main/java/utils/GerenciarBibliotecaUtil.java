//package main.java.utils;
//
//import main.java.enums.FiltroPesquisa;
//import main.java.models.Biblioteca;
//import main.java.models.Usuario;
//import main.java.models.itens.Emprestavel;
//import main.java.models.itens.Item;
//import main.java.models.itens.Revista;
//import main.java.models.itens.Tese;
//import main.java.services.ItemEmprestavelService;
//import main.java.services.ItemService;
//import main.java.services.UsuarioService;
//
//public class GerenciarBibliotecaUtil {
//
//    public static void gerenciarUsuario(Biblioteca biblioteca) {
//        UsuarioService usuarioService = new UsuarioService(biblioteca);
//
//        while (true) {
//            System.out.println("Escolha a operação desejada:");
//            System.out.println("1. Cadastrar usuário");
//            System.out.println("2. Atualizar usuário");
//            System.out.println("3. Deletar usuário");
//            System.out.println("4. Listar usuários");
//            System.out.println("5. Voltar");
//            System.out.print("Opção: ");
//
//            int escolha = InputScannerUtil.getScanner().nextInt();
//            InputScannerUtil.getScanner().nextLine();
//
//            if (escolha == 5) {
//                System.out.println("Voltando ao menu principal...\n");
//                break;
//            }
//
//            switch (escolha) {
//                case 1:
//                    Usuario usuario = new Usuario();
//                    UsuarioService usuarioService2 = new UsuarioService(usuario, biblioteca);
//                    //usuarioService2.criar();
//                    break;
//                case 2:
//                    usuarioService.atualizar();
//                    break;
//                case 3:
//                    usuarioService.deletar();
//                    break;
//                case 4:
//                    usuarioService.listar();
//                    break;
//                default:
//                    System.out.println("Opção inválida. Tente novamente.");
//            }
//        }
//    }
//
//    public static void gerenciarItemNaoEmprestavel(Biblioteca biblioteca) {
//        ItemService itemService = new ItemService(biblioteca);
//
//        while (true) {
//            System.out.println("Escolha a operação desejada:");
//            System.out.println("1. Cadastrar Revista");
//            System.out.println("2. Cadastrar Tese");
//            System.out.println("3. Atualizar Item não emprestável");
//            System.out.println("4. Deletar Item não emprestável");
//            System.out.println("5. Listar Item não emprestável");
//            System.out.println("6. Voltar");
//            System.out.print("Opção: ");
//
//            int escolha = InputScannerUtil.getScanner().nextInt();
//            InputScannerUtil.getScanner().nextLine();
//
//            if (escolha == 6) {
//                System.out.println("Voltando ao menu principal...\n");
//                //InputScannerUtil.close();
//                break;
//            }
//
//            Item novoItem = null;
//
//            switch (escolha) {
//                case 1:
//                    novoItem = new Revista();
//                    itemService = new ItemService(novoItem, biblioteca);
//                    itemService.criar();
//                    break;
//                case 2:
//                    novoItem = new Tese();
//                    itemService = new ItemService(novoItem, biblioteca);
//                    itemService.criar();
//                    break;
//                case 3:
//                    itemService.atualizar();
//                    break;
//                case 4:
//                    itemService.deletar();
//                    break;
//                case 5:
//                    itemService.listar();
//                    break;
//                default:
//                    System.out.println("Opção inválida. Tente novamente.");
//            }
//        }
//    }
//
//    public static void gerenciarItemEmprestavel(Biblioteca biblioteca) {
//        ItemEmprestavelService itemEmprestavelService = new ItemEmprestavelService(biblioteca);
//
//        while (true) {
//            System.out.println("Escolha a operação desejada:");
//            System.out.println("1. Cadastrar Item emprestável");
//            System.out.println("2. Atualizar Item emprestável");
//            System.out.println("3. Deletar Item emprestável");
//            System.out.println("4. Listar Item emprestável");
//            System.out.println("5. Voltar");
//            System.out.print("Opção: ");
//
//            int escolha = InputScannerUtil.getScanner().nextInt();
//            InputScannerUtil.getScanner().nextLine();
//
//            if (escolha == 5) {
//                System.out.println("Voltando ao menu principal...\n");
//                break;
//            }
//
//            switch (escolha) {
//                case 1:
//                    Emprestavel emprestavel = new Emprestavel();
//                    ItemEmprestavelService itemEmprestavelService1 = new ItemEmprestavelService(emprestavel,
//                            biblioteca);
//                    itemEmprestavelService1.criar();
//                    break;
//                case 2:
//                    itemEmprestavelService.atualizar();
//                    break;
//                case 3:
//                    itemEmprestavelService.deletar();
//                    break;
//                case 4:
//                    itemEmprestavelService.listar();
//                    break;
//                default:
//                    System.out.println("Opção inválida. Tente novamente.");
//            }
//        }
//    }


//}
