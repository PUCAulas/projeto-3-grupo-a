package main.java.models.itens;

import main.java.enums.StatusClassificacao;

import java.time.LocalDate;
import java.util.List;

public final class Revista extends Item{
    private String editora;
    private String edicao;
    private List<String> artigos;

    public Revista() {
        super();
    }

    public Revista(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, String editora, String edicao, List<String> artigos) {
        super(titulo, dataPublicacao, statusClassificacao);
        this.editora = editora;
        this.edicao = edicao;
        this.artigos = artigos;
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

    public List<String> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<String> artigos) {
        this.artigos = artigos;
    }

    @Override
    public String toString() {
        return " ";
    }


}
