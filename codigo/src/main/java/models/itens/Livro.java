package main.java.models.itens;

import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;

import java.time.LocalDate;

public final class Livro extends Emprestimo{
    private String autor;
    private int numeroPaginas;

    private String editora;
    private String edicao;
    private String volume;
    private String idioma;
    private String sinopse;

    private String genero;

    public Livro() {
    }


    public Livro(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, StatusEmprestimo statusEmprestimo, String autor, int numeroPaginas, String editora, String edicao, String volume, String idioma, String sinopse, String genero) {
        super(titulo, dataPublicacao, statusClassificacao, statusEmprestimo);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.editora = editora;
        this.edicao = edicao;
        this.volume = volume;
        this.idioma = idioma;
        this.sinopse = sinopse;
        this.genero = genero;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
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
        return "";
    }


}
