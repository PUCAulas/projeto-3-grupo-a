package main.java.models.itens;

import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public final class CD extends Emprestavel {
    private String artista;
    private Duration duracao;
    private List<String> faixas;

    public CD() {
        super();
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

    public List<String> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<String> faixas) {
        this.faixas = faixas;
    }

    public String listarFaixas() {
        StringBuilder faixas = new StringBuilder();
        for (String faixa : this.getFaixas()) {
            faixas.append(faixa);
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
