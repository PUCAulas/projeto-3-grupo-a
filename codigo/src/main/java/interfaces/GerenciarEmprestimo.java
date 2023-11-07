package main.java.interfaces;

import main.java.models.Usuario;
import main.java.models.itens.Emprestavel;

public interface GerenciarEmprestimo {

    /**
     * Empresta um item emprestavel a um usuario
     *
     * @param emprestavel item emprestavel
     */
    void emprestar(int idItem, Usuario usuario);

    /**
     * Devolve um item previamente emprestado a um usuario
     *
     * @param emprestavel item emprestavel
     */
    void devolver(int id, Usuario usuario);

    /**
     * Atualizar a quantidade de dias de emprestimo
     *
     * @param emprestavel item emprestavel
     */
    void atualizarDiasDoEmprestimo(int id, Usuario usuario);
}
