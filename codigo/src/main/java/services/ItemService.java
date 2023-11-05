package main.java.services;

import java.time.LocalDate;
import java.util.List;
import main.java.enums.StatusClassificacao;
import main.java.models.Biblioteca;
import main.java.models.itens.Item;
import main.java.models.itens.Revista;
import main.java.models.itens.Tese;
import main.java.utils.InputScannerUtil;

public class ItemService {
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

    public void criarRevista(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
            String editora, String edicao, List<String> artigos) {
        Revista revista = (Revista) item;

        revista.setTitulo(titulo);
        revista.setDataPublicacao(dataPublicacao);
        revista.setStatusClassificacao(statusClassificacao);
        revista.setEditora(editora);
        revista.setEdicao(edicao);
        revista.setArtigos(artigos);

        biblioteca.getEstoque().addItem(revista);
    }

    public void criarTese(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
            String autor, String orientador, LocalDate dataDefesa, List<String> capitulos) {
        Tese tese = (Tese) item;

        tese.setTitulo(titulo);
        tese.setDataPublicacao(dataPublicacao);
        tese.setStatusClassificacao(statusClassificacao);
        tese.setAutor(autor);
        tese.setOrientador(orientador);
        tese.setDataDefesa(dataDefesa);
        tese.setCapitulos(capitulos);

        biblioteca.getEstoque().addItem(tese);
    }

    public void atualizarRevista(String titulo, LocalDate novaData, StatusClassificacao novaClassificacao,
            String edicao, String editora, List<String> artigos) {

        ((Revista) item).setTitulo(titulo);
        ((Revista) item).setDataPublicacao(novaData);
        ((Revista) item).setStatusClassificacao(novaClassificacao);
        ((Revista) item).setEditora(editora);
        ((Revista) item).setEdicao(edicao);
        ((Revista) item).setArtigos(artigos);
    }

    public void atualizarTese(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
            String autor, String orientador, LocalDate dataDefesa, List<String> capitulos) {

        ((Tese) item).setTitulo(titulo);
        ((Tese) item).setDataPublicacao(dataPublicacao);
        ((Tese) item).setStatusClassificacao(statusClassificacao);
        ((Tese) item).setAutor(autor);
        ((Tese) item).setOrientador(orientador);
        ((Tese) item).setDataDefesa(dataDefesa);
        ((Tese) item).setCapitulos(capitulos);
    }

    public void deletar() {
        System.out.print("Informe o ID do item: ");
        int id = InputScannerUtil.scanner.nextInt();

        Item itemDeletado = null;
        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id) {
                itemDeletado = item;
                break;
            }
        }
        if (itemDeletado != null) {
            biblioteca.getEstoque().getItens().remove(itemDeletado);
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
