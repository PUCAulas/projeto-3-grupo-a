package main.java.models;

import main.java.enums.FiltroPesquisa;
import main.java.interfaces.AutorFiltro;
import main.java.interfaces.Relatorio;
import main.java.models.itens.*;
import main.java.utils.InputScannerUtil;

import java.util.*;

public class Biblioteca implements Relatorio{
    private List<Usuario> usuarios;

    private Estoque estoque;


    public Biblioteca() {
        this.usuarios = new ArrayList<>();
    }

    public Biblioteca(Estoque estoque) {
        this();
        this.estoque = estoque;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public void addUsuario(Usuario usuario) {
        this.getUsuarios().add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        this.getUsuarios().remove(usuario);
    }

    public List<Emprestavel> imprimirRelatorioUsuario(Usuario usuario) {
        return null;
    }

    public String imprimirRelatorioItem(Item item) {
        return "";
    }

    public void pesquisar(FiltroPesquisa tipo) throws Exception {
        List<String> valoresAtributo = new ArrayList<>();

        if (this.getEstoque().getItens() == null) {
            throw new Exception("Não existe nenhum item cadastrado no estoque!");
        }

        for (Item item : this.getEstoque().getItens()) {
            String valor = obterValorParaTipo(item, tipo);

            if (valor != null) {
                valoresAtributo.add(valor);
            }
        }

        if (valoresAtributo.isEmpty()) {
            throw new Exception("Nenhum resultado encontrado!");
        }

        String option = choice(valoresAtributo);

        if (tipo == FiltroPesquisa.ANO) {
            this.anoPublicacao(option);
        } else {
            System.out.println(encontrarItemCorrespondente(tipo, option));
        }
    }

    /**
     *
     * @param itens
     * @return
     */
    public String choice(List<String> itens) {
        Collections.sort(itens, String.CASE_INSENSITIVE_ORDER);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < itens.size(); i++) {
            result.append((i + 1))
                    .append(" - ")
                    .append(itens.get(i))
                    .append("\n");
        }
        System.out.println(" ");
        System.out.println(result);
        System.out.print("Escolha o número: ");
        int option = InputScannerUtil.scanner.nextInt();

        return itens.get(option - 1);
    }

    private void anoPublicacao(String result) {
        for (Item item : this.getEstoque().getItens()) {
            if (Integer.toString(item.getDataPublicacao().getYear()).equals(result)) {
                System.out.println(item);
                System.out.println("\n");
            }
        }
    }

    public Item encontrarItemCorrespondente(FiltroPesquisa tipo, String result) {

        Optional<Item> item = this.getEstoque().getItens().stream().filter(x -> {
            String valor = obterValorParaTipo(x, tipo);
            return valor != null && valor.equals(result);
        }).findFirst();

        return item.orElse(null);
    }

    private String obterValorParaTipo(Item item, FiltroPesquisa tipo) {
        switch (tipo) {
            case TITULO:
                return item.getTitulo();
            case ANO:
                return Integer.toString(item.getDataPublicacao().getYear());
            case AUTOR:
                if (item instanceof AutorFiltro) {
                    return ((AutorFiltro) item).getAutor();
                }
                break;
            case LIVRO:
                if (item instanceof Livro) {
                    return item.getTitulo();
                }
                break;
            case REVISTA:
                if (item instanceof Revista) {
                    return item.getTitulo();
                }
                break;
            case TESE:
                if (item instanceof Tese) {
                    return item.getTitulo();
                }
                break;
            case CD:
                if (item instanceof CD) {
                    return item.getTitulo();
                }
                break;
            case DVD:
                if (item instanceof DVD) {
                    return item.getTitulo();
                }
                break;
        }
        return null;
    }
}
