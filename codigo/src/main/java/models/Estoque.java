package main.java.models;

import main.java.models.itens.Item;

import java.util.List;

public class Estoque {
    private List<Item> itens;

    public Estoque() {
    }

    public Estoque(List<Item> itens) {
        this.itens = itens;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void addItem(Item item) {
        this.getItens().add(item);
    }

    public void removeItem(Item item) {
        this.getItens().add(item);
    }


    public int qtdEmEstoque() {
        return this.getItens().size();
    }





}
