package main.java;

import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.utils.GerenciarBibliotecaUtil;
import main.java.utils.InputScannerUtil;

public class Main {

    public static void main(String[] args) {


        Estoque estoque = new Estoque();
        Biblioteca biblioteca = new Biblioteca(estoque);


        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Gerenciar usuários");
            System.out.println("2. Gerenciar itens não emprestáveis");
            System.out.println("3. Gerenciar itens emprestáveis");
            System.out.println("4. Pesquisar itens da biblioteca");
            System.out.println("5. Sair");

            System.out.print("Opção: ");
            int escolha = InputScannerUtil.getScanner().nextInt();

            switch (escolha) {
                case 1:
                    GerenciarBibliotecaUtil.gerenciarUsuario(biblioteca);
                    break;
                case 2:
                    GerenciarBibliotecaUtil.gerenciarItemNaoEmprestavel(biblioteca);
                    break;
                case 3:
                    GerenciarBibliotecaUtil.gerenciarItemEmprestavel(biblioteca);
                    break;
                case 4:
                    try{
                        GerenciarBibliotecaUtil.pesquisa(biblioteca);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    InputScannerUtil.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }



    }
}
