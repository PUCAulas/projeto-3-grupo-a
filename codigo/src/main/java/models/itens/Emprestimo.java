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


    @Override
    public String toString() {
        return "Dados do item: \n"
                + super.toString()
                + "\n"
                + "Status do empréstimo: "
                + this.getStatusEmprestimo()
                + this.auxToString();
    }


    public String auxToString() {
        if(this.getStatusEmprestimo() == StatusEmprestimo.EMPRESTADO) {
            return "\nQuantidade do item do empréstimo: "
                 + this.getQtdEmprestimo()
                 + "\nDias de empréstimo: "
                 + this.getDiaEmprestimo()
                 + "\nData do empréstimo: "
                 + this.getDataEmprestimo()
                 + "\nQuantidade de dias limite para o empréstimo: "
                 + this.getQTD_MAX_DIAS_EMPRESTIMO();
        }
        return " ";
    }




}
