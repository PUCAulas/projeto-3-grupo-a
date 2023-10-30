package main.java;

import java.util.Scanner;

import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.utils.Cadastro;

public class Main {

    public static void main(String[] args) {

        // Objetos como Usuario e item (incluindo emprestimo) devem ser instanciado aqui com o construtor padrão.
        // Quem tem que setar os atributos é o método criar do serviço
        // Estoque também tem que ser instanciado pelo construtor padrão.

        Estoque estoque = new Estoque();
        Biblioteca biblioteca = new Biblioteca(estoque);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha a operação desejada:");
            System.out.println("1. Gerenciar usuários");
            System.out.println("5. Sair");

            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    Cadastro.gerenciarUsuarios(biblioteca);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }

    }
}
