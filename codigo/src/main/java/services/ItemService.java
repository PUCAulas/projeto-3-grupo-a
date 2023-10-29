package main.java.services;

import main.java.interfaces.GerenciarBiblioteca;
import main.java.models.Biblioteca;
import main.java.models.itens.Item;

public class ItemService implements GerenciarBiblioteca {
    public Biblioteca biblioteca;
    public Item item;

    public ItemService() {
    }

    public ItemService(Biblioteca biblioteca, Item item) {
        this.biblioteca = biblioteca;
        this.item = item;
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

    }

    public void atualizar() {

    }

    public void deletar() {

    }

    public void listar() {

    }


}
