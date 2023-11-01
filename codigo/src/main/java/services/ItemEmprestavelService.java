package main.java.services;

import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;
import main.java.interfaces.GerenciarEmprestimo;
import main.java.models.Biblioteca;
import main.java.models.itens.*;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ItemEmprestavelService implements GerenciarEmprestimo {
    private Biblioteca biblioteca;
    private Emprestavel emprestavel;

    public ItemEmprestavelService() {
    }

    public ItemEmprestavelService(Emprestavel emprestavel, Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.emprestavel = emprestavel;
    }

    public ItemEmprestavelService(Biblioteca biblioteca) {
        this.emprestavel = null;
        this.biblioteca = biblioteca;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Emprestavel getEmprestimo() {
        return emprestavel;
    }

    public void setEmprestimo(Emprestavel emprestavel) {
        this.emprestavel = emprestavel;
    }


    public void criar() {

        System.out.println("Escolha o tipo de item a ser criado:");
        System.out.println("1. CD");
        System.out.println("2. DVD");
        System.out.println("3. Livro");

        int escolha = InputScannerUtil.getScanner().nextInt();
        InputScannerUtil.getScanner().nextLine();
        switch (escolha) {
            case 1:
                criarCD();
                break;
            case 2:
                criarDVD();
                break;
            case 3:
                criarLivro();
            default:
                System.out.println("Tipo de item inválido.");
        }
    }

    private void criarDVD() {
        Scanner scanner = new Scanner(System.in);
        DVD dvd = new DVD();

        System.out.println("Informe o titulo do DVD: ");
        dvd.setTitulo(scanner.nextLine());

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        dvd.setDataPublicacao(LocalDate.parse(scanner.nextLine(), DataUtil.fmt));

        System.out.println("Informe o status de classificação: ");
        StatusClassificacao statusClassificacao = escolherStatusClassificacao(scanner);
        if (statusClassificacao != null) {
            dvd.setStatusClassificacao(statusClassificacao);
        }

        System.out.println("Informe o status do empréstimo: ");
        StatusEmprestimo statusEmprestimo = escolherStatusEmprestimo(scanner);
        if (statusEmprestimo != null) {
            dvd.setStatusEmprestimo(statusEmprestimo);
        }

        System.out.println("Informe o diretor: ");
        dvd.setDiretor(scanner.nextLine());

        System.out.println("Informe a duração: ");
        dvd.setDuracao(Duration.ofSeconds(Long.parseLong(scanner.nextLine())));

        System.out.println("Informe o idioma: ");
        dvd.setIdioma(scanner.nextLine());

        System.out.println("Informe o sinopse: ");
        dvd.setSinopse(scanner.nextLine());

        System.out.println("Informe o gênero: ");
        dvd.setGenero(scanner.nextLine());

        biblioteca.getEstoque().addItem(dvd);
    }

    public void criarCD() {
        Scanner scanner = new Scanner(System.in);
        CD cd = new CD();

        System.out.println("Informe o titulo do CD: ");
        cd.setTitulo(scanner.nextLine());

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        cd.setDataPublicacao(LocalDate.parse(scanner.nextLine(), DataUtil.fmt));

        System.out.println("Informe o status de classificação: ");
        StatusClassificacao statusClassificacao = escolherStatusClassificacao(scanner);
        if (statusClassificacao != null) {
            cd.setStatusClassificacao(statusClassificacao);
        }

        System.out.println("Informe o status do empréstimo: ");
        StatusEmprestimo statusEmprestimo = escolherStatusEmprestimo(scanner);
        if (statusEmprestimo != null) {
            cd.setStatusEmprestimo(statusEmprestimo);
        }

        System.out.println("Informe o artista: ");
        cd.setArtista(scanner.nextLine());

        System.out.println("Informe a duração: ");
        cd.setDuracao(Duration.ofSeconds(Long.parseLong(scanner.nextLine())));

        biblioteca.getEstoque().addItem(cd);
    }


    public void criarLivro() {
        Scanner scanner = new Scanner(System.in);
        Livro livro = new Livro();

        System.out.println("Informe o titulo do Livro: ");
        livro.setTitulo(scanner.nextLine());

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        livro.setDataPublicacao(LocalDate.parse(scanner.nextLine(), DataUtil.fmt));

        System.out.println("Informe o status de classificação: ");
        StatusClassificacao statusClassificacao = escolherStatusClassificacao(scanner);
        if (statusClassificacao != null) {
            livro.setStatusClassificacao(statusClassificacao);
        }

        System.out.println("Informe o status do empréstimo: ");
        StatusEmprestimo statusEmprestimo = escolherStatusEmprestimo(scanner);
        if (statusEmprestimo != null) {
            livro.setStatusEmprestimo(statusEmprestimo);
        }

        System.out.println("Informe o autor: ");
        livro.setAutor(scanner.nextLine());

        System.out.println("Informe o número de páginas: ");
        livro.setNumeroPaginas(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Informe a editora da livro: ");
        livro.setEditora(scanner.nextLine());

        System.out.println("Informe a edição da livro: ");
        livro.setEdicao(scanner.nextLine());

        System.out.println("Informe o volume do livro: ");
        livro.setVolume(scanner.nextLine());

        System.out.println("Informe o idioma: ");
        livro.setIdioma(scanner.nextLine());

        System.out.println("Informe o gênero do livro: ");
        livro.setGenero(scanner.nextLine());

        System.out.println("Informe a sinopse do livro: ");
        livro.setSinopse(scanner.nextLine());


        biblioteca.getEstoque().addItem(livro);
    }







    public void atualizar() {

        System.out.println("Escolha o tipo de item a ser atualizado:");
        System.out.println("1. CD");
        System.out.println("2. DVD");

        int escolha = InputScannerUtil.getScanner().nextInt();
        InputScannerUtil.getScanner().nextLine();
        switch (escolha) {
            case 1:
                atualizarCD();
                break;
            case 2:
                atualizarDVD();
                break;
            default:
                System.out.println("Tipo de item inválido.");
        }
    }

    private void atualizarDVD() {

        System.out.print("Informe o ID do item a ser atualizado: ");
        int id = InputScannerUtil.getScanner().nextInt();
        InputScannerUtil.getScanner().nextLine();

        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id && item instanceof DVD) {
                System.out.println("Opção:");
                System.out.println("1. Título");
                System.out.println("2. Data de Publicação");
                System.out.println("3. Classificação");
                System.out.println("4. Status empréstimo");
                System.out.println("5. Diretor");
                System.out.println("6. Duração");
                System.out.println("7. Idioma");
                System.out.println("8. Sinopse");
                System.out.println("9. Genero");

                int escolha = InputScannerUtil.getScanner().nextInt();
                Scanner sc = InputScannerUtil.getScanner();
                InputScannerUtil.getScanner().nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o novo título: ");
                        item.setTitulo(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Informe a nova data de publicação (dd/MM/yyyy): ");
                        LocalDate novaData = LocalDate.parse(sc.nextLine(), DataUtil.fmt);
                        item.setDataPublicacao(novaData);
                        break;
                    case 3:
                        System.out.println("Informe a nova classificação: ");
                        StatusClassificacao novaClassificacao = escolherStatusClassificacao(sc);
                        if (novaClassificacao != null) {
                            item.setStatusClassificacao(novaClassificacao);
                        }
                        break;
                    case 4:
                        System.out.println("Informe o status do empréstimo: ");
                        StatusEmprestimo statusEmprestimo = escolherStatusEmprestimo(sc);
                        if (statusEmprestimo != null) {
                            ((DVD) item).setStatusEmprestimo(statusEmprestimo);
                        }
                        break;
                    case 5:
                        System.out.println("Informe o novo diretor");
                        ((DVD) item).setDiretor(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Informe a duração: ");
                        ((DVD) item).setDuracao(Duration.ofSeconds(Long.parseLong(sc.nextLine())));
                    case 7:
                        System.out.println("Informe o idioma: ");
                        ((DVD) item).setIdioma(sc.nextLine());
                    case 8:
                        System.out.println("Informe a sinopse ");
                        ((DVD) item).setSinopse(sc.nextLine());
                    case 9:
                        System.out.println("Informe o gênero ");
                        ((DVD) item).setGenero(sc.nextLine());
                    default:
                        System.out.println("Atributo inválido.");
                }

                System.out.println("Item atualizado!");
                return;
            }
        }
        System.out.println("Item não encontrado ou tipo de item incorreto!");
    }

    private void atualizarCD() {

        System.out.print("Informe o ID do item a ser atualizado: ");
        int id = InputScannerUtil.getScanner().nextInt();
        InputScannerUtil.getScanner().nextLine();

        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id && item instanceof CD) {
                System.out.println("Opção:");
                System.out.println("1. Título");
                System.out.println("2. Data de Publicação");
                System.out.println("3. Classificação");
                System.out.println("4. Status empréstimo");
                System.out.println("5. Artista");
                System.out.println("6. Duração");

                int escolha = InputScannerUtil.getScanner().nextInt();
                Scanner sc = InputScannerUtil.getScanner();
                InputScannerUtil.getScanner().nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o novo título: ");
                        item.setTitulo(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Informe a nova data de publicação (dd/MM/yyyy): ");
                        LocalDate novaData = LocalDate.parse(sc.nextLine(), DataUtil.fmt);
                        item.setDataPublicacao(novaData);
                        break;
                    case 3:
                        System.out.println("Informe a nova classificação: ");
                        StatusClassificacao novaClassificacao = escolherStatusClassificacao(sc);
                        if (novaClassificacao != null) {
                            item.setStatusClassificacao(novaClassificacao);
                        }
                        break;
                    case 4:
                        System.out.println("Informe o status do empréstimo: ");
                        StatusEmprestimo statusEmprestimo = escolherStatusEmprestimo(sc);
                        if (statusEmprestimo != null) {
                            ((CD) item).setStatusEmprestimo(statusEmprestimo);
                        }
                        break;
                    case 5:
                        System.out.println("Informe o novo artista");
                        ((CD) item).setArtista(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Informe a duração ");
                        ((CD) item).setDuracao(Duration.ofSeconds(Long.parseLong(sc.nextLine())));
                    default:
                        System.out.println("Atributo inválido.");
                }

                System.out.println("Item atualizado!");
                return;
            }
        }
        System.out.println("Item não encontrado ou tipo de item incorreto!");
    }


    private void atualizarLivro() {

        System.out.print("Informe o ID do livro a ser atualizado: ");
        int id = InputScannerUtil.getScanner().nextInt();
        InputScannerUtil.getScanner().nextLine();

        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id && item instanceof Livro) {
                System.out.println("Opção:");
                System.out.println("1. Título");
                System.out.println("2. Data de Publicação");
                System.out.println("3. Classificação");
                System.out.println("4. Status empréstimo");
                System.out.println("5. Autor");
                System.out.println("6. Edição");
                System.out.println("7. Idioma");
                System.out.println("8. Sinopse");
                System.out.println("9. Gênero");
                System.out.println("10. Volume");
                System.out.println("11. Número de páginas");

                int escolha = InputScannerUtil.getScanner().nextInt();
                Scanner sc = InputScannerUtil.getScanner();
                InputScannerUtil.getScanner().nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o novo título: ");
                        item.setTitulo(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Informe a nova data de publicação (dd/MM/yyyy): ");
                        LocalDate novaData = LocalDate.parse(sc.nextLine(), DataUtil.fmt);
                        item.setDataPublicacao(novaData);
                        break;
                    case 3:
                        System.out.println("Informe a nova classificação: ");
                        StatusClassificacao novaClassificacao = escolherStatusClassificacao(sc);
                        if (novaClassificacao != null) {
                            item.setStatusClassificacao(novaClassificacao);
                        }
                        break;
                    case 4:
                        System.out.println("Informe o status do empréstimo: ");
                        StatusEmprestimo statusEmprestimo = escolherStatusEmprestimo(sc);
                        if (statusEmprestimo != null) {
                            ((Livro) item).setStatusEmprestimo(statusEmprestimo);
                        }
                        break;
                    case 5:
                        System.out.println("Informe o novo autor: ");
                        ((Livro) item).setAutor(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Informe a edição: ");
                        ((Livro) item).setEdicao(sc.nextLine());
                    case 7:
                        System.out.println("Informe o idioma: ");
                        ((Livro) item).setIdioma(sc.nextLine());
                    case 8:
                        System.out.println("Informe a sinopse: ");
                        ((Livro) item).setSinopse(sc.nextLine());
                    case 9:
                        System.out.println("Informe o gênero: ");
                        ((Livro) item).setGenero(sc.nextLine());
                    case 10:
                        System.out.println("Informe o volume: ");
                        ((Livro) item).setVolume(sc.nextLine());
                    case 11:
                        System.out.println("Informe o Número de páginas: ");
                        ((Livro) item).setVolume(sc.nextLine());
                    default:
                        System.out.println("Atributo inválido.");
                }

                System.out.println("Item atualizado!");
                return;
            }
        }
        System.out.println("Item não encontrado ou tipo de item incorreto!");
    }


    public void deletar() {
        System.out.print("Informe o ID do item: ");
        int id = InputScannerUtil.getScanner().nextInt();

        Item deletar = null;
        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id) {
                deletar = item;
                break;
            }
        }
        if (deletar != null) {
            biblioteca.getEstoque().getItens().remove(deletar);
            System.out.println("Item deletado com sucesso!");
        } else {
            System.out.println("Item não encontrado!");
        }
    }

    public void listar() {
        List<Item> itens = biblioteca.getEstoque().getItens();

        if (itens != null) {
            for (Item i : itens) {
                System.out.println(i);
            }
        } else {
            System.out.println("Nenhum item encontrado no estoque.");
        }
    }

    public void emprestar(Emprestavel emprestavel) {

    }

    public void devolver(Emprestavel emprestavel) {

    }

    public void atualizarDiasDoEmprestimo(Emprestavel emprestavel) {

    }

    private StatusClassificacao escolherStatusClassificacao(Scanner sc) {

        for (StatusClassificacao status : StatusClassificacao.values()) {
            System.out.println(status.ordinal() + 1 + ". " + status.name());
        }

        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha >= 1 && escolha <= StatusClassificacao.values().length) {
            return StatusClassificacao.values()[escolha - 1];
        } else {
            System.out.println("Opção inválida.");
            return null;
        }
    }

    private StatusEmprestimo escolherStatusEmprestimo(Scanner sc) {

        for (StatusEmprestimo status : StatusEmprestimo.values()) {
            System.out.println(status.ordinal() + 1 + ". " + status.name());
        }

        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha >= 1 && escolha <= StatusEmprestimo.values().length) {
            return StatusEmprestimo.values()[escolha - 1];
        } else {
            System.out.println("Opção inválida.");
            return null;
        }
    }


}
