package main.java.models.itens;

import main.java.enums.StatusClassificacao;

import java.time.LocalDate;
import java.util.List;

public final class Tese extends Item{
    private String autor;
    private String orientador;
    private LocalDate dataDefesa;
    private List<String> capitulos;

    public Tese() {
        super();
    }

    private Tese(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, String autor,
           String orientador, LocalDate dataDefesa, List<String> capitulos) {
        super(titulo, dataPublicacao, statusClassificacao);
        this.autor = autor;
        this.orientador = orientador;
        this.dataDefesa = dataDefesa;
        this.capitulos = capitulos;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public LocalDate getDataDefesa() {
        return dataDefesa;
    }

    public void setDataDefesa(LocalDate dataDefesa) {
        this.dataDefesa = dataDefesa;
    }

    public List<String> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<String> capitulos) {
        this.capitulos = capitulos;
    }


    public String listarArtigos() {
        StringBuilder capitulos = new StringBuilder();
        for (String capitulo : this.getCapitulos()) {
            capitulos.append(capitulo);
            capitulos.append("\n");
        }
        return capitulos.toString();
    }

    @Override
    public String toString() {
        return super.toString()
             + "\nAutor: "
             + this.getAutor()
             + "\nOrientador: "
             + this.getOrientador()
             + "\nData da defesa de tese: "
             + this.getDataDefesa()
             + "\nACapitulos: \n"
             + this.listarArtigos();

    }
}
