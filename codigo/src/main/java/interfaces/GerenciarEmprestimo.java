package main.java.interfaces;

import main.java.models.itens.Emprestimo;

public interface GerenciarEmprestimo extends GerenciarBiblioteca{
    void emprestar(Emprestimo emprestimo);
    void devolver(Emprestimo emprestimo);
    void atualizarDiasDoEmprestimo(Emprestimo emprestimo);
}
