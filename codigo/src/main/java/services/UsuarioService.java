package main.java.services;

import java.time.LocalDate;
import java.util.Scanner;

import main.java.interfaces.GerenciarBiblioteca;
import main.java.models.Biblioteca;
import main.java.models.Usuario;
import main.java.utils.Data;

public class UsuarioService implements GerenciarBiblioteca {

    private Biblioteca biblioteca;
    private Usuario usuario;

    public UsuarioService() {
    }

    public UsuarioService(Usuario usuario,Biblioteca biblioteca) {
        this.usuario = usuario;
        this.biblioteca = biblioteca;
    }

    public UsuarioService(Biblioteca biblioteca) {
        this.usuario = null;
        this.biblioteca = biblioteca;
    }

    public Biblioteca getBiblioteca() {

        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public void criar() {

        Scanner sc = new Scanner(System.in);
        Usuario novoUsuario = new Usuario();

        System.out.print("Informe o nome do usuário: ");
        novoUsuario.setNome(sc.nextLine());

        System.out.print("Informe o e-mail do usuário: ");
        novoUsuario.setEmail(sc.nextLine());

        System.out.print("Informe a senha do usuário: ");
        novoUsuario.setSenha(sc.nextLine());

        System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
        novoUsuario.setDataNascimento(LocalDate.parse(sc.nextLine(), Data.fmt));

        this.biblioteca.addUsuario(novoUsuario);

        System.out.println("Usuário cadastrado!");
    }

    public void atualizar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o ID do usuário: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Usuario u : biblioteca.getUsuarios()) {
            if (u.getId() == id) {
                System.out.print("Informe o novo nome: ");
                u.setNome(sc.nextLine());

                System.out.print("Informe o novo e-mail: ");
                u.setEmail(sc.nextLine());

                System.out.print("Informe a nova senha: ");
                u.setSenha(sc.nextLine());

                System.out.print("Informe a nova data de nascimento (dd/MM/yyyy): ");
                u.setDataNascimento(LocalDate.parse(sc.nextLine(), Data.fmt));

                System.out.println("Usuário atualizado!");
                return;
            }
        }
        System.out.println("Usuário não encontrado!");
    }

    public void deletar() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o ID do usuário: ");
        int id = sc.nextInt();
        
        Usuario usuarioDeletar = null;
        for (Usuario u : biblioteca.getUsuarios()) {
            if (u.getId() == id) {
                usuarioDeletar = u;
                break;
            }
        }
        if(usuarioDeletar != null) {
            biblioteca.getUsuarios().remove(usuarioDeletar);
            System.out.println("Usuário deletado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    public void listar() {
        for (Usuario u : biblioteca.getUsuarios()) {
            System.out.println(u);
        }
    }

}
