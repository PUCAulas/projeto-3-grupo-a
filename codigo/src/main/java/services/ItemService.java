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
        while (true) {
            String artigo = sc.nextLine();

            if ("FIM".equalsIgnoreCase(artigo)) {
                break;
            }

            artigos.add(artigo);
        }

        revista.setArtigos(artigos);

        biblioteca.getEstoque().addItem(revista);
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
        while (true) {
            String capitulo = sc.nextLine();

            if ("FIM".equalsIgnoreCase(capitulo)) {
                break;
            }

            capitulos.add(capitulo);
        }

        tese.setCapitulos(capitulos);

        biblioteca.getEstoque().addItem(tese);
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

    }

    public void deletar() {

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
