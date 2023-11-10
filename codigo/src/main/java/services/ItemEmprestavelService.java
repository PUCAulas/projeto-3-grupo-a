package main.java.services;

import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;
import main.java.interfaces.GerenciarEmprestimo;
import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.models.Usuario;
import main.java.models.itens.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemEmprestavelService implements GerenciarEmprestimo {

    private Biblioteca biblioteca;
    private Emprestavel emprestavel;
    private Estoque estoque;

    /**
     * Construtor padrao de ItemEmprestavelService
     */
    public ItemEmprestavelService() {
    }

    /**
     * Construtor padrao de ItemEmprestavelService, com biblioteca
     */
    public ItemEmprestavelService(Biblioteca biblioteca) {
        this.emprestavel = null;
        this.biblioteca = biblioteca;
        this.estoque = biblioteca.getEstoque();
    }

    /**
     * Cria um novo DVD
     */
    public void criarDVD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
                         StatusEmprestimo statusEmprestimo, String diretor, Duration duracao, String idioma, String sinopse,
                         String genero) {

        Emprestavel emprestavel = this.getEmprestimo();

        if (emprestavel instanceof DVD) {
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
            //dvd.setNumEmprestimos(0);

            biblioteca.getEstoque().addItem(dvd);
        }

        this.setEmprestimo(null);
    }


    /**
     * Cria um novo CD
     */
    public void criarCD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
            StatusEmprestimo statusEmprestimo, String artista, Duration duracao, List<String> faixas) {

        Emprestavel emprestavel = this.getEmprestimo();

        if (emprestavel instanceof DVD) {
            CD cd = (CD) emprestavel;
            cd.setTitulo(titulo);
            cd.setDataPublicacao(dataPublicacao);
            cd.setStatusClassificacao(statusClassificacao);
            cd.setStatusEmprestimo(statusEmprestimo);
            cd.setArtista(artista);
            cd.setDuracao(duracao);
            cd.setFaixas(faixas);
            //cd.setNumEmprestimos(0);
            biblioteca.getEstoque().addItem(cd);
        }

        this.setEmprestimo(null);
    }

    /**
     * Cria um novo livro
     */
    public void criarLivro(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
            StatusEmprestimo statusEmprestimo, String autor,
            int numeroPaginas, String editora, String edicao, String volume, String idioma, String genero,
            String sinopse) {

        Livro livro = (Livro) emprestavel;
        Emprestavel emprestavel = this.getEmprestimo();

        if(emprestavel instanceof Livro) {
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
            //livro.setNumEmprestimos(0);
            biblioteca.getEstoque().addItem(livro);
        }

        this.setEmprestimo(null);
    }

    /**
     * Atualiza um DVD
     */
    public void atualizarDVD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
            StatusEmprestimo statusEmprestimo, String diretor, Duration duracao, String idioma, String sinopse,
            String genero) {

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
    public void atualizarCD(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
            StatusEmprestimo statusEmprestimo, String artista, Duration duracao, List<String> faixas) {

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
    public void atualizarLivro(String titulo, LocalDate dataPublicacao, StatusClassificacao statusClassificacao,
            StatusEmprestimo statusEmprestimo, String autor, String editora, String edicao, String volume,
            String idioma, String genero, String sinopse, int numeroPaginas) {

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
    public void listar() {
        List<Item> itens = biblioteca.getEstoque().getItens();

        if (itens != null) {
            for (Item i : itens) {
                if (i instanceof Emprestavel) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Nenhum item encontrado no estoque.");
        }
    }

    /**
     * Lista estoque da biblioteca
     * 
     * @throws Exception
     */
    public List<Emprestavel> listarDisponiveis(Biblioteca biblioteca) throws Exception {
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



    public void emprestar(int id, Usuario usuario) throws Exception {

        usuario.verificarLimiteParaEmprestimo();

        emprestavelEmAtrasoDoUsuario(usuario);

        verificarUnicoEmprestavelNoEstoque();

        Emprestavel emprestavel = encontrarEmprestavelPorId(id);

        this.setEmprestimo(emprestavel);

        verificarDisponibilidadeParaEmprestimo();

        this.getEmprestimo().setStatusEmprestimo(StatusEmprestimo.EMPRESTADO);
        this.getEmprestimo().setDataEmprestimo(LocalDate.now());
        this.getEmprestimo().setNumEmprestimos(emprestavel.getNumEmprestimos() + 1);


        usuario.setQtdItensEmprestadosAtualmente(usuario.getQtdItensEmprestadosAtualmente() + 1);
        usuario.addEmprestimo(this.getEmprestimo());

        this.setEmprestimo(null);

    }


    public void verificarDisponibilidadeParaEmprestimo() throws Exception {
        if(this.getEmprestimo().getStatusEmprestimo() == StatusEmprestimo.EMPRESTADO)
            throw new Exception("Este item já está emprestado!");
    }



    public Emprestavel encontrarEmprestavelPorId(int id) throws Exception {
        Emprestavel emprestavel = biblioteca.getEstoque().getItens()
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .map(x -> (Emprestavel) x).orElse(null);


        if(emprestavel == null) throw new Exception("Item não encontrado no estoque!");

        return emprestavel;
    }


    public void emprestavelEmAtrasoDoUsuario(Usuario usuario) throws Exception {
        Optional<Emprestavel> emprestavelEmAtraso = usuario.getItensEmprestados().stream()
                .filter(this::devolucaoEmAtraso)
                .findFirst();

        if (emprestavelEmAtraso.isPresent()) {
            Emprestavel emprestavel = emprestavelEmAtraso.get();
            throw new Exception("Há um item em atraso, devolva-o antes de realizar outro empréstimo. " +
                    "ID: " + emprestavel.getId() + " | Status do empréstimo: " + emprestavel.getStatusEmprestimo());
        }

    }


    public void verificarUnicoEmprestavelNoEstoque() throws Exception {

        long emprestaveisEmEstoque = this.getBiblioteca().getEstoque().getItens()
                .stream()
                .filter(x -> x instanceof Emprestavel &&
                        ((Emprestavel) x).getStatusEmprestimo() == StatusEmprestimo.DISPONIVEL)
                .count();

        if(emprestaveisEmEstoque == 1)
            throw new Exception("Não pode fazer empréstimo, pois só tem 1 item na biblioteca que não foi emprestado");

    }







    public void devolver(int id, Usuario usuario) throws Exception {

        Emprestavel emprestavel = usuario.acharEmprestavelPorId(id);

        Emprestavel emprestavelNoEstoque = this.encontrarEmprestavelPorId(id);

        if(emprestavel != emprestavelNoEstoque)
            throw new Exception("O item informado não existe!");

        if(emprestavelNoEstoque.getStatusEmprestimo() != StatusEmprestimo.EMPRESTADO)
            throw new Exception("O item informado já está disponível");


        emprestavelNoEstoque.setStatusEmprestimo(StatusEmprestimo.DISPONIVEL);
        emprestavelNoEstoque.setDiaEmprestimo(0);
        emprestavelNoEstoque.setDataEmprestimo(null);

        usuario.removerEmprestimo(emprestavel);
        usuario.setQtdItensEmprestadosAtualmente(usuario.getQtdItensEmprestadosAtualmente() - 1);


    }
    



    public boolean devolucaoEmAtraso(Emprestavel itemEmprestavel) {
        return LocalDate.now().isAfter(itemEmprestavel.getDataEmprestimo().plusDays(10));
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




}
