package main.java.services;

import main.java.interfaces.GerenciarEmprestimo;
import main.java.models.Biblioteca;
import main.java.models.itens.Emprestavel;

public class EmprestavelService implements GerenciarEmprestimo {
    private Biblioteca biblioteca;
    private Emprestavel emprestavel;

    public EmprestavelService() {
    }

    public EmprestavelService(Emprestavel emprestavel, Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        this.emprestavel = emprestavel;
    }

    public EmprestavelService(Biblioteca biblioteca) {
        this.emprestavel = null;
        this.biblioteca = biblioteca;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Emprestavel getEmprestimo() {
        return emprestavel;
    }

    public void setEmprestimo(Emprestavel emprestavel) {
        this.emprestavel = emprestavel;
    }


    public void criar() {

    }

    public void atualizar() {

    }

    public void deletar() {

    }

    public void listar() {

    }

    public void emprestar(Emprestavel emprestavel) {

    }

    public void devolver(Emprestavel emprestavel) {

    }

    public void atualizarDiasDoEmprestimo(Emprestavel emprestavel) {

    }



}
