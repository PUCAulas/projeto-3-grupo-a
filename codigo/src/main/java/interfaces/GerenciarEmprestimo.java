package main.java.interfaces;

import main.java.models.itens.Emprestavel;

public interface GerenciarEmprestimo{
    void emprestar(Emprestavel emprestavel);
    void devolver(Emprestavel emprestavel);
    void atualizarDiasDoEmprestimo(Emprestavel emprestavel);
}
