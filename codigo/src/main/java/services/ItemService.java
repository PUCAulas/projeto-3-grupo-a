package main.java.services;

import main.java.interfaces.GerenciarBiblioteca;
import main.java.models.Biblioteca;
import main.java.models.itens.Item;

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

    }

    public void atualizar() {

    }

    public void deletar() {

    }

    public void listar() {

    }


}
