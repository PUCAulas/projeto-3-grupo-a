package main.java;

import java.util.Scanner;

import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.utils.GerenciarBiblioteca;

public class Main {

    public static void main(String[] args) {


        Estoque estoque = new Estoque();
        Biblioteca biblioteca = new Biblioteca(estoque);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Gerenciar usuários");
            System.out.println("2. Gerenciar itens não emprestáveis");
            System.out.println("2. Gerenciar itens emprestáveis");
            System.out.println("5. Sair");

            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    GerenciarBiblioteca.gerenciarUsuario(biblioteca);
                    break;
                case 2:
                    GerenciarBiblioteca.gerenciarItemNaoEmprestavel(biblioteca);
                case 3:
                    GerenciarBiblioteca.gerenciarItemEmprestavel(biblioteca);
                case 4:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }



    }
}
