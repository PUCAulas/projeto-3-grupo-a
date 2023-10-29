package main.java.services;

import main.java.interfaces.GerenciarEmprestimo;
import main.java.models.Biblioteca;
import main.java.models.itens.Emprestimo;

public class ItemEmprestadoService implements GerenciarEmprestimo {
    private Biblioteca biblioteca;
    private Emprestimo emprestimo;

    public ItemEmprestadoService() {
    }

    public ItemEmprestadoService(Biblioteca biblioteca, Emprestimo emprestimo) {
        this.biblioteca = biblioteca;
        this.emprestimo = emprestimo;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }


    public void criar() {

    }

    public void atualizar() {

    }

    public void deletar() {

    }

    public void listar() {

    }

    public void emprestar(Emprestimo emprestimo) {

    }

    public void devolver(Emprestimo emprestimo) {

    }

    public void atualizarDiasDoEmprestimo(Emprestimo emprestimo) {

    }



}
