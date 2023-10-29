package main.java.models;

import main.java.models.itens.Emprestimo;

import java.time.LocalDate;
import java.util.List;

public class Usuario {
    private int id;

    private static int PROX_ID = 0;

    private String senha;

    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private int qtdItensEmprestados;
    private List<Emprestimo> emprestimos;
    private final int QTD_MAX_ITENS_EMPRESTADOS = 3;


    public Usuario() {
    }

    public Usuario(String senha, String email, LocalDate dataNascimento) {
        this.senha = senha;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getQtdItensEmprestados() {
        return qtdItensEmprestados;
    }


    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }


    public int getQTD_MAX_ITENS_EMPRESTADOS() {
        return QTD_MAX_ITENS_EMPRESTADOS;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addEmprestimo(Emprestimo emprestimo) {
        this.getEmprestimos().add(emprestimo);
    }

    public void removerEmpresimo(Emprestimo emprestimo) {
        this.getEmprestimos().remove(emprestimo);
    }


    public String listarEmprestimo() {
        StringBuilder emprestimos = new StringBuilder();
        for (Emprestimo emprestimo : this.getEmprestimos()) {
            emprestimos.append(emprestimo);
            emprestimos.append("\n");
        }
        return emprestimos.toString();
    }

    public boolean verificarEmprestimo() {
        return this.getEmprestimos().isEmpty();
    }


    @Override
    public String toString() {
        return "Dados do usuário: "
             + "\nNome: "
             + this.getNome()
             + "\nData de nascimento: "
             + this.getDataNascimento()
             + "\nE-mail: "
             + this.getEmail()
             + "\nQuantidade de itens emprestados: "
             + this.getQtdItensEmprestados()
             + "\nQuantidade máxima de itens para empréstimo: "
             + this.getQTD_MAX_ITENS_EMPRESTADOS()
             + "\nEmpréstimos feitos: \n"
             + (verificarEmprestimo() ? listarEmprestimo() : "Nenhum empréstimo");
    }


}
