package main.java.models.itens;

import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;

import java.time.LocalDate;

public class Emprestimo extends Item{
    private StatusEmprestimo statusEmprestimo;
    private int qtdEmprestimo;
    private int diaEmprestimo;

    private LocalDate dataEmprestimo;
    private final int QTD_MAX_DIAS_EMPRESTIMO = 10;


    public Emprestimo() {
        super();
    }


    public Emprestimo(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, StatusEmprestimo statusEmprestimo) {
        super(titulo, dataPublicacao, statusClassificacao);
        this.statusEmprestimo = statusEmprestimo;
        this.qtdEmprestimo = 0;
        this.dataEmprestimo = null;
        this.diaEmprestimo = 0;
    }


    public StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setStatusEmprestimo(StatusEmprestimo statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }

    public int getQtdEmprestimo() {
        return qtdEmprestimo;
    }

    public void setQtdEmprestimo(int qtdEmprestimo) {
        this.qtdEmprestimo = qtdEmprestimo;
    }

    public int getDiaEmprestimo() {
        return diaEmprestimo;
    }

    public void setDiaEmprestimo(int diaEmprestimo) {
        this.diaEmprestimo = diaEmprestimo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getQTD_MAX_DIAS_EMPRESTIMO() {
        return QTD_MAX_DIAS_EMPRESTIMO;
    }





}
