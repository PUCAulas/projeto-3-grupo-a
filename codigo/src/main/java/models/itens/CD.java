package main.java.models.itens;

import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public final class CD extends Emprestimo{
    private String artista;
    private Duration duracao;
    private List<Faixa> faixas;

    public CD() {
        super();
    }

    private CD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
         StatusEmprestimo statusEmprestimo, String artista, Duration duracao, List<Faixa> faixas) {
        super(titulo, dataPublicacao, statusClassificacao, statusEmprestimo);
        this.artista = artista;
        this.duracao = duracao;
        this.faixas = faixas;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public List<Faixa> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<Faixa> faixas) {
        this.faixas = faixas;
    }

    public String listarFaixas() {
        StringBuilder faixas = new StringBuilder();
        for (Faixa faixa : this.getFaixas()) {
            faixas.append(faixa.toString());
            faixas.append("\n");
        }
        return faixas.toString();
    }

    @Override
    public String toString() {
        return super.toString()
             + "\nArtista: "
             + this.getArtista()
             + "\nDuração: "
             + this.getDuracao()
             + "\nTodas as faixas: \n"
             + listarFaixas();
    }



}
