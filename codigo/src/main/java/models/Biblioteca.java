package main.java.models;

import main.java.enums.FiltroPesquisa;
import main.java.interfaces.Relatorio;
import main.java.models.itens.Emprestimo;
import main.java.models.itens.Item;

import java.util.List;

public class Biblioteca implements Relatorio {
    private List<Usuario> usuarios;

    private Estoque estoque;

    public Biblioteca() {
    }

    public Biblioteca(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }


    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }


    public void addUsuario(Usuario usuario) {
        this.getUsuarios().add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        this.getUsuarios().remove(usuario);
    }


    public String pesquisar(FiltroPesquisa filtroPesquisa) {
        return "";
    }

    public List<Emprestimo> imprimirRelatorioUsuario(Usuario usuario) {
        return null;
    }

    public String imprimirRelatorioItem(Item item) {
        return "";
    }



}
