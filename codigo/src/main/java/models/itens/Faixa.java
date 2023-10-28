package main.java.models.itens;

import java.time.Duration;

public class Faixa {
    private int numeroFaixa;
    private String titulo;
    private String compositor;
    private Duration duracao;

    public Faixa(int numeroFaixa, String titulo, String compositor, Duration duracao) {
        this.numeroFaixa = numeroFaixa;
        this.titulo = titulo;
        this.compositor = compositor;
        this.duracao = duracao;
    }

    public int getNumeroFaixa() {
        return numeroFaixa;
    }

    public void setNumeroFaixa(int numeroFaixa) {
        this.numeroFaixa = numeroFaixa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }
}
