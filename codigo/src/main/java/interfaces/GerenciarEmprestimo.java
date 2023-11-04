package main.java.interfaces;

import main.java.models.itens.Emprestavel;

public interface GerenciarEmprestimo {

    /**
     * Empresta um item emprestavel a um usuario
     *
     * @param emprestavel item emprestavel
     */
    void emprestar(Emprestavel emprestavel);

    /**
     * Devolve um item previamente emprestado a um usuario
     *
     * @param emprestavel item emprestavel
     */
    void devolver(Emprestavel emprestavel);

    /**
     * Atualizar a quantidade de dias de emprestimo
     *
     * @param emprestavel item emprestavel
     */
    void atualizarDiasDoEmprestimo(Emprestavel emprestavel);
}
