package main.java.services;

import main.java.enums.FiltroPesquisa;
import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;
import main.java.interfaces.GerenciarEmprestimo;
import main.java.models.Biblioteca;
import main.java.models.Usuario;
import main.java.models.itens.*;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemEmprestavelService implements GerenciarEmprestimo {

    private Biblioteca biblioteca;
    private Emprestavel emprestavel;

    /**
     * Construtor padrao de ItemEmprestavelService
     */
    public ItemEmprestavelService() {
    }

    /**
     * Construtor padrao de ItemEmprestavelService, com emprestavel e biblioteca
     */
    // public ItemEmprestavelService(Emprestavel emprestavel, Biblioteca biblioteca) {
    //     this.biblioteca = biblioteca;
    //     this.emprestavel = emprestavel;
    // }

    /**
     * Construtor padrao de ItemEmprestavelService, com biblioteca
     */
    public ItemEmprestavelService(Biblioteca biblioteca) {
        this.emprestavel = null;
        this.biblioteca = biblioteca;
    }

    /**
     * Cria um novo DVD
     */
    public void criarDVD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, StatusEmprestimo statusEmprestimo, String diretor, Duration duracao, String idioma, String sinopse, String genero) {
        
        DVD dvd = (DVD) emprestavel;

        dvd.setTitulo(titulo);
        dvd.setDataPublicacao(dataPublicacao);
        dvd.setStatusClassificacao(statusClassificacao);
        dvd.setStatusEmprestimo(statusEmprestimo);
        dvd.setDiretor(diretor);
        dvd.setDuracao(duracao);
        dvd.setIdioma(idioma);
        dvd.setSinopse(sinopse);
        dvd.setGenero(genero);

        biblioteca.getEstoque().addItem(dvd);
    }

    /**
     * Cria um novo CD
     */
    public void criarCD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, StatusEmprestimo statusEmprestimo, String artista, Duration duracao, List<String> faixas, CD cd) {
        
        cd.setTitulo(titulo);
        cd.setDataPublicacao(dataPublicacao);
        cd.setStatusClassificacao(statusClassificacao);
        cd.setStatusEmprestimo(statusEmprestimo);
        cd.setArtista(artista);
        cd.setDuracao(duracao);
        cd.setFaixas(faixas);

        biblioteca.getEstoque().addItem(cd);
    }

    /**
     * Cria um novo livro
     */
    public void criarLivro(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, StatusEmprestimo statusEmprestimo, String autor,
    int numeroPaginas, String editora, String edicao, String volume, String idioma, String genero, String sinopse, Livro livro) {

        livro.setTitulo(titulo);
        livro.setDataPublicacao(dataPublicacao);
        livro.setStatusClassificacao(statusClassificacao);
        livro.setStatusEmprestimo(statusEmprestimo);
        livro.setAutor(autor);
        livro.setNumeroPaginas(numeroPaginas);
        livro.setEditora(editora);
        livro.setEdicao(edicao);
        livro.setVolume(volume);
        livro.setIdioma(idioma);
        livro.setGenero(genero);
        livro.setSinopse(sinopse);

        biblioteca.getEstoque().addItem(livro);
    }

    /**
     * Atualiza um DVD
     */
    public void atualizarDVD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, StatusEmprestimo statusEmprestimo, String diretor, Duration duracao, String idioma, String sinopse, String genero) {

        ((DVD) emprestavel).setTitulo(titulo);
        ((DVD) emprestavel).setDataPublicacao(dataPublicacao);
        ((DVD) emprestavel).setStatusClassificacao(statusClassificacao);
        ((DVD) emprestavel).setStatusEmprestimo(statusEmprestimo);
        ((DVD) emprestavel).setDiretor(diretor);
        ((DVD) emprestavel).setDuracao(duracao);
        ((DVD) emprestavel).setIdioma(idioma);
        ((DVD) emprestavel).setSinopse(sinopse);
        ((DVD) emprestavel).setGenero(genero);      
    }

    /**
     * Atualiza um CD
     */
    public void atualizarCD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, StatusEmprestimo statusEmprestimo, String artista, Duration duracao, List<String> faixas) {

        ((CD) emprestavel).setTitulo(titulo);
        ((CD) emprestavel).setDataPublicacao(dataPublicacao);
        ((CD) emprestavel).setStatusClassificacao(statusClassificacao);
        ((CD) emprestavel).setStatusEmprestimo(statusEmprestimo);
        ((CD) emprestavel).setArtista(artista);
        ((CD) emprestavel).setDuracao(duracao);
        ((CD) emprestavel).setFaixas(faixas);
    }

    /**
     * Atualiza um Livro
     */
    public void atualizarLivro(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao, StatusEmprestimo statusEmprestimo, String autor, String editora, String edicao, String volume, String idioma, String genero, String sinopse, int numeroPaginas) {

        ((Livro) emprestavel).setTitulo(titulo);
        ((Livro) emprestavel).setDataPublicacao(dataPublicacao);
        ((Livro) emprestavel).setStatusClassificacao(statusClassificacao);
        ((Livro) emprestavel).setStatusEmprestimo(statusEmprestimo);
        ((Livro) emprestavel).setAutor(autor);
        ((Livro) emprestavel).setEditora(editora);
        ((Livro) emprestavel).setEdicao(edicao);
        ((Livro) emprestavel).setVolume(volume);
        ((Livro) emprestavel).setIdioma(idioma);
        ((Livro) emprestavel).setGenero(genero);
        ((Livro) emprestavel).setSinopse(sinopse);
        ((Livro) emprestavel).setNumeroPaginas(numeroPaginas);
    }

    /**
     * Deleta um item emprestavel
     */
    public void deletar(Item itemEmprestavel) {

        biblioteca.getEstoque().getItens().remove(itemEmprestavel);
    }

    /**
     * Lista todos os itens
     */
    public void listarTodos() {
        List<Item> itens = biblioteca.getEstoque().getItens();

        if (itens != null) {
            for (Item i : itens) {
                if(i instanceof Emprestavel) {
                System.out.println(i);
                }
            }
        } else {
            System.out.println("Nenhum item encontrado no estoque.");
        }
    }

    /**
     * Lista estoque da biblioteca
     * @throws Exception
     */
    public List<Emprestavel> listar(Biblioteca biblioteca) throws Exception {
        List<Item> itens = biblioteca.getEstoque().getItens();
        List<Emprestavel> disponiveis = new ArrayList<>();
        
        if (itens == null) {
            throw new Exception("Nenhum item encontrado no estoque.");
        }

        for (Item i : itens) {
            if (i instanceof Emprestavel) {
                if (((Emprestavel) i).getStatusEmprestimo() == StatusEmprestimo.DISPONIVEL)
                    disponiveis.add((Emprestavel) i);
            }
        }
        
        return disponiveis;
    }

    //todo: excluir método??
    private String obterValorParaTipo(Item item, FiltroPesquisa tipo) {
        switch (tipo) {
            case TITULO:
                return item.getTitulo();
            case AUTOR:
                if (item instanceof Livro) {
                    return ((Livro) item).getAutor();
                }
                return null;
            case ANO:
                return String.valueOf(item.getDataPublicacao().getYear());
            default:
                return null;
        }
    }

    //todo: excluir método??
    private void anoPublicacao(String ano) {
        int anoPesquisa = Integer.parseInt(ano);
        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getDataPublicacao().getYear() == anoPesquisa) {
                System.out.println(item);
            }
        }
    }

    //todo: excluir método??
    private String choice(List<String> valores) {
        System.out.println("Escolha um valor para pesquisa:");
        for (int i = 0; i < valores.size(); i++) {
            System.out.println(i + 1 + ". " + valores.get(i));
        }
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Para consumir a nova linha

        if (escolha >= 1 && escolha <= valores.size()) {
            return valores.get(escolha - 1);
        } else {
            System.out.println("Escolha inválida.");
            return null;
        }
    }

    public void emprestar(int id, Usuario usuario) {
        try {
            // Encontre o item com o ID especificado no estoque da biblioteca
            Item itemEmprestavel = null;
            for (Item item : biblioteca.getEstoque().getItens()) {
                if (item.getId() == id && item instanceof Emprestavel) {
                    itemEmprestavel = item;
                    break;
                }
            }
    
            if (itemEmprestavel == null) {
                System.out.println("Item não encontrado no estoque da biblioteca.");
                return;
            }
    
            // Verifique o status do item
            if (((Emprestavel) itemEmprestavel).getStatusEmprestimo() == StatusEmprestimo.EMPRESTADO) {
                System.out.println("Este item já está emprestado.");
            } else {
                // Atualize o status do item para EMPRESTADO
                ((Emprestavel) itemEmprestavel).setStatusEmprestimo(StatusEmprestimo.EMPRESTADO);
                ((Emprestavel) itemEmprestavel).setQtdEmprestimo(((Emprestavel) itemEmprestavel).getQtdEmprestimo() + 1);
                ((Emprestavel) itemEmprestavel).setDataEmprestimo(LocalDate.now());
                System.out.println("Empréstimo realizado com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar o empréstimo: " + e.getMessage());
        }
    }

    //todo: excluir método??
    private Item buscarItemPorId(int id) {
        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id && item instanceof Emprestavel) {
                return (Emprestavel) item;
            }
        }
        return null;
    }
    

    public void devolver(int id, Usuario usuario) {
        try {
            // Encontre o item com o ID especificado no estoque da biblioteca
            Item itemEmprestavel = null;
            for (Item item : biblioteca.getEstoque().getItens()) {
                if (item.getId() == id && item instanceof Emprestavel) {
                    itemEmprestavel = item;
                    break;
                }
            }
    
            if (itemEmprestavel == null) {
                System.out.println("Item não encontrado no estoque da biblioteca.");
                return;
            }
    
            // Verifique se o item está emprestado e pertence ao usuário
            if (((Emprestavel) itemEmprestavel).getStatusEmprestimo() == StatusEmprestimo.EMPRESTADO
                    && ((Emprestavel) itemEmprestavel).getQtdEmprestimo() > 0) {
                if (((Emprestavel) itemEmprestavel).getQtdEmprestimo() == 1) {
                    // Se este for o último empréstimo do usuário, atualize o status para DISPONÍVEL
                    ((Emprestavel) itemEmprestavel).setStatusEmprestimo(StatusEmprestimo.DISPONIVEL);
                    ((Emprestavel) itemEmprestavel).setQtdEmprestimo(0);
                    ((Emprestavel) itemEmprestavel).setDiaEmprestimo(0);
                    ((Emprestavel) itemEmprestavel).setDataEmprestimo(null);
                } else {
                    // Caso contrário, apenas diminua a quantidade de empréstimos do usuário
                    ((Emprestavel) itemEmprestavel).setQtdEmprestimo(((Emprestavel) itemEmprestavel).getQtdEmprestimo() - 1);
                }
    
                System.out.println("Devolução realizada com sucesso.");
            } else {
                System.out.println("Este item não está emprestado por você.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar a devolução: " + e.getMessage());
        }
    }
    
    // todo: Vitor vai implementar???
    public void atualizarDiasDoEmprestimo(int id, Usuario usuario) {

    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Emprestavel getEmprestimo() {
        return emprestavel;
    }

    public void setEmprestimo(Emprestavel emprestavel) {
        this.emprestavel = emprestavel;
    }

        public void setEmprestavel(Emprestavel emprestavel) {
        this.emprestavel = emprestavel;
    }

}
