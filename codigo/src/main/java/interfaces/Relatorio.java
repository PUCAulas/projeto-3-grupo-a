package main.java.interfaces;

import main.java.models.Usuario;
import main.java.models.itens.Emprestavel;

import java.util.List;

public interface Relatorio {

    /**
     * Imprime o relatorio de um usuario
     *
     * @param usuario usuario de referencia
     */
    void imprimirRelatorioUsuario(Usuario usuario);

    /**
     * Imprime relatorio dos itens
     */
    void imprimirRelatorioItem();
}
