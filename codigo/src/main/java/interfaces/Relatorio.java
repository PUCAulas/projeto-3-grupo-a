package main.java.interfaces;

import main.java.models.Usuario;
import main.java.models.itens.Emprestavel;
import main.java.models.itens.Item;

import java.util.List;

public interface Relatorio {
    List<Emprestavel> imprimirRelatorioUsuario(Usuario usuario);

    String imprimirRelatorioItem(Item item);
}
