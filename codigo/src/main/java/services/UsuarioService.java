package main.java.services;

import java.time.LocalDate;
import main.java.models.Biblioteca;
import main.java.models.Usuario;


public class UsuarioService  {

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



    public void criar(String nome, String email, String senha, LocalDate dataNascimento) {

        this.usuario.setNome(nome);
        this.usuario.setEmail(email);
        this.usuario.setSenha(senha);
        this.usuario.setDataNascimento(dataNascimento);

        this.biblioteca.addUsuario(this.usuario);
        this.setUsuario(null);

    }

    public void atualizar(String name, String email, String senha, LocalDate dataNascimento) {

        this.getBiblioteca().removeUsuario(this.getUsuario());

        this.usuario.setNome(name);
        this.usuario.setEmail(email);
        this.usuario.setSenha(senha);
        this.usuario.setDataNascimento(dataNascimento);

        this.getBiblioteca().addUsuario(usuario);
    }


    public void deletar(Usuario usuario) throws Exception {

        this.getBiblioteca().getUsuarios().remove(usuario);
    }


    public Usuario verificarSenhaEmail(String senha, String email) throws Exception {
        Usuario u = null;
        for(Usuario usuario : biblioteca.getUsuarios()) {
            if(usuario.getSenha().equals(senha) && usuario.getEmail().equals(email))
                u = usuario;
        }

        if(u == null)
            throw new Exception("Usuário não existe!");

        return u;
    }


    public void listar() {
        for (Usuario u : biblioteca.getUsuarios()) {
            System.out.println(u);
        }
    }

}
