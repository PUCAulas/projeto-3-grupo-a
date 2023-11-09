package main.java.models.itens;

import main.java.enums.StatusEmprestimo;
import main.java.utils.DataUtil;

import java.time.LocalDate;

public class Emprestavel extends Item {

    private final int QTD_MAX_DIAS_EMPRESTIMO = 10;
    private StatusEmprestimo statusEmprestimo;
    private int qtdEmprestimo; // Quantos do item a pessoa pegou emprestado <<< talvez desnescessário
    private int diaEmprestimo; // Duração atual do empréstimo
    private int numEmprestimos;
    private LocalDate dataEmprestimo;

    /**
     * Construtor padrao de emprestavel
     */
    public Emprestavel() {
        super();
    }

    /**
     * Imprime informacos do Emprestavel
     *
     * @return informacoes do Emprestavel
     */
    @Override
    public String toString() {
        return super.toString()
                + "\n"
                + "Status do empréstimo: "
                + this.getStatusEmprestimo()
                + "\nNúmero de empréstimos: "
                + this.getNumEmprestimos()
                + this.auxToString();
    }

    /**
     * Funcao auxiliar que imprime informacos do Emprestavel
     *
     * @return informacoes do Emprestavel
     */
    public String auxToString() {
        if (this.getStatusEmprestimo() == StatusEmprestimo.EMPRESTADO) {
            return "\nQuantidade do item do empréstimo: "
                    + this.getQtdEmprestimo()
                    + "\nDias de empréstimo: "
                    + this.getDiaEmprestimo()
                    + "\nData do empréstimo: "
                    + this.getDataEmprestimo().format(DataUtil.fmt)
                    + "\nQuantidade de dias limite para o empréstimo: "
                    + this.getQTD_MAX_DIAS_EMPRESTIMO();
        }
        return " ";
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

    public int getNumEmprestimos() {
        return numEmprestimos;
    }

    public void setNumEmprestimos(int numEmprestimos) {
        this.numEmprestimos = numEmprestimos;
    }
}
