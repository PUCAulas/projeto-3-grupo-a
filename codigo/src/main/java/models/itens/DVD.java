package main.java.models.itens;

import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;

import java.time.Duration;
import java.time.LocalDate;

public final class DVD extends Emprestavel {
    private String diretor;
    private Duration duracao;
    private String idioma;
    private String sinopse;
    private String genero;

    public DVD() {

        super();
    }


    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString()
             + "\nDiretor: "
             + this.getDiretor()
             + "\nDuração: "
             + this.getDuracao()
             + "\nIdioma: "
             + this.getIdioma()
             + "\nGênero: "
             + this.getGenero()
             + "\nSinopse: \n"
             + this.getSinopse();
    }
}
