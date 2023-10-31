package main.java.interfaces;

import main.java.models.itens.Emprestavel;

public interface GerenciarEmprestimo extends GerenciarBiblioteca{
    void emprestar(Emprestavel emprestavel);
    void devolver(Emprestavel emprestavel);
    void atualizarDiasDoEmprestimo(Emprestavel emprestavel);
}
