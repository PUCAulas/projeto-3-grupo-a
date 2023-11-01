package main.java.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.enums.StatusClassificacao;
import main.java.interfaces.GerenciarBiblioteca;
import main.java.models.Biblioteca;
import main.java.models.itens.Item;
import main.java.models.itens.Revista;
import main.java.models.itens.Tese;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;

public class ItemService implements GerenciarBiblioteca {
    public Biblioteca biblioteca;
    public Item item;

    public ItemService() {
    }

    public ItemService(Item item, Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.item = item;
    }

    public ItemService(Biblioteca biblioteca) {
        this.item = null;
        this.biblioteca = biblioteca;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void criar() {
        Scanner sc = new Scanner(System.in);
        if (item instanceof Revista) {
            criarRevista(sc);
        } else if (item instanceof Tese) {
            criarTese(sc);
        } else {
            System.out.println("item inválido.");
        }
    }

    private void criarRevista(Scanner sc) {
        Revista revista = (Revista) item;

        System.out.println("Informe o título da Revista: ");
        revista.setTitulo(sc.nextLine());

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        revista.setDataPublicacao(LocalDate.parse(sc.nextLine(), DataUtil.fmt));

        System.out.println("Informe o status de classificação da Revista:");
        StatusClassificacao statusClassificacao = escolherStatusClassificacao(sc);
        if (statusClassificacao != null) {
            revista.setStatusClassificacao(statusClassificacao);
        }

        System.out.println("Informe a editora da Revista: ");
        revista.setEditora(sc.nextLine());

        System.out.println("Informe a edição da Revista: ");
        revista.setEdicao(sc.nextLine());

        List<String> artigos = new ArrayList<>();

        System.out.println("Informe os artigos da revista (digite 'FIM' para sair): ");
        inserirArtigos(sc, artigos);
        revista.setArtigos(artigos);

        biblioteca.getEstoque().addItem(revista);
    }

    private void inserirArtigos(Scanner sc, List<String> artigos) {
        while (true) {
            String artigo = sc.nextLine();
            if ("FIM".equalsIgnoreCase(artigo)) {
                break;
            }
            artigos.add(artigo);
        }
    }

    private void criarTese(Scanner sc) {
        Tese tese = (Tese) item;

        System.out.println("Informe o título da tese: ");
        tese.setTitulo(sc.nextLine());

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        tese.setDataPublicacao(LocalDate.parse(sc.nextLine(), DataUtil.fmt));

        System.out.println("Informe o status de classificação da tese:");
        StatusClassificacao statusClassificacao = escolherStatusClassificacao(sc);
        if (statusClassificacao != null) {
            tese.setStatusClassificacao(statusClassificacao);
        }

        System.out.println("Informe o autor da tese: ");
        tese.setAutor(sc.nextLine());

        System.out.println("Informe o orientador da tese: ");
        tese.setOrientador(sc.nextLine());

        System.out.println("Informe a data de defesa da tese: ");
        tese.setDataDefesa(LocalDate.parse(sc.nextLine(), DataUtil.fmt));

        List<String> capitulos = new ArrayList<>();

        System.out.println("Informe os capítulos da tese (digite 'FIM' para sair): ");
        inserirCapitulos(sc, capitulos);
        tese.setCapitulos(capitulos);

        biblioteca.getEstoque().addItem(tese);
    }

    private void inserirCapitulos(Scanner sc, List<String> capitulos) {
        while (true) {
            String capitulo = sc.nextLine();
            if ("FIM".equalsIgnoreCase(capitulo)) {
                break;
            }
            capitulos.add(capitulo);
        }
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

    public void atualizar() {

        System.out.println("Escolha o tipo de item a ser atualizado:");
        System.out.println("1. Revista");
        System.out.println("2. Tese");

        int escolha = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();
        switch (escolha) {
            case 1:
                atualizarRevista();
                break;
            case 2:
                atualizarTese();
                break;
            default:
                System.out.println("Tipo de item inválido.");
        }
    }

    private void atualizarRevista() {

        System.out.print("Informe o ID do item a ser atualizado: ");
        int id = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();

        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id && item instanceof Revista) {
                System.out.println("Opção:");
                System.out.println("1. Título");
                System.out.println("2. Data de Publicação");
                System.out.println("3. Classificação");
                System.out.println("4. Edição");
                System.out.println("5. Editora");
                System.out.println("6. Artigos");

                int escolha = InputScannerUtil.scanner.nextInt();
                Scanner sc = InputScannerUtil.scanner;
                InputScannerUtil.scanner.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o novo título: ");
                        ((Revista) item).setTitulo(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Informe a nova data de publicação (dd/MM/yyyy): ");
                        LocalDate novaData = LocalDate.parse(sc.nextLine(), DataUtil.fmt);
                        ((Revista) item).setDataPublicacao(novaData);
                        break;
                    case 3:
                        System.out.println("Informe a nova classificação: ");
                        StatusClassificacao novaClassificacao = escolherStatusClassificacao(sc);
                        if (novaClassificacao != null) {
                            ((Revista) item).setStatusClassificacao(novaClassificacao);
                        }
                        break;
                    case 4:
                        System.out.println("Informe a nova edição: ");
                        ((Revista) item).setEdicao(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Informe a nova editora");
                        ((Revista) item).setEditora(sc.nextLine());
                        break;
                    case 6:
                        List<String> artigos = new ArrayList<>();
                        System.out.println("Informe os artigos (FIM para sair): ");
                        inserirArtigos(sc, artigos);
                        ((Revista) item).setArtigos(artigos);
                    default:
                        System.out.println("Atributo inválido.");
                }

                System.out.println("Item atualizado!");
                return;
            }
        }
        System.out.println("Item não encontrado ou tipo de item incorreto!");
    }

    private void atualizarTese() {

        System.out.print("Informe o ID do item a ser atualizado: ");
        int id = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();

        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id && item instanceof Tese) {
                System.out.println("Opção:");
                System.out.println("1. Título");
                System.out.println("2. Data de Publicação");
                System.out.println("3. Classificação");
                System.out.println("4. Autor");
                System.out.println("5. Orientador");
                System.out.println("6. Data da defesa");
                System.out.println("7. Capitulos");

                int escolha = InputScannerUtil.scanner.nextInt();
                Scanner sc = InputScannerUtil.scanner;
                InputScannerUtil.scanner.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o novo título: ");
                        ((Tese) item).setTitulo(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Informe a nova data de publicação (dd/MM/yyyy): ");
                        LocalDate novaData = LocalDate.parse(sc.nextLine(), DataUtil.fmt);
                        ((Tese) item).setDataPublicacao(novaData);
                        break;
                    case 3:
                        System.out.println("Informe a nova classificação: ");
                        StatusClassificacao novaClassificacao = escolherStatusClassificacao(sc);
                        if (novaClassificacao != null) {
                            ((Tese) item).setStatusClassificacao(novaClassificacao);
                        }
                        break;
                    case 4:
                        System.out.println("Informe o novo autor: ");
                        ((Tese) item).setAutor(sc.nextLine());
                        break;
                    case 5:
                        System.out.println("Informe o novo orientador");
                        ((Tese) item).setOrientador(sc.nextLine());
                        break;
                    case 6:
                        System.out.println("Informe a nova data de defesa");
                        LocalDate novaDataDefesa = LocalDate.parse(sc.nextLine(), DataUtil.fmt);
                        ((Tese) item).setDataDefesa(novaDataDefesa);
                    case 7:
                        List<String> capitulos = new ArrayList<>();
                        System.out.println("Informe os capítulos ('FIM' para sair): ");
                        inserirCapitulos(sc, capitulos);
                        ((Tese) item).setCapitulos(capitulos);

                    default:
                        System.out.println("Atributo inválido.");
                }

                System.out.println("Item atualizado!");
                return;
            }
        }
        System.out.println("Item não encontrado ou tipo de item incorreto");
    }

    public void deletar() {
        System.out.print("Informe o ID do item: ");
        int id = InputScannerUtil.scanner.nextInt();

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
}
