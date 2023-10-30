package main.java.services;

import main.java.interfaces.GerenciarBiblioteca;
import main.java.models.Biblioteca;
import main.java.models.Usuario;

public class UsuarioService implements GerenciarBiblioteca {

    private Biblioteca biblioteca;
    private Usuario usuario;

    public UsuarioService() {
    }

    public UsuarioService(Biblioteca biblioteca, Usuario usuario) {
        this.biblioteca = biblioteca;
        this.usuario = usuario;
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



        //this.getBiblioteca().addUsuario(this.getUsuario());
    }

    public void atualizar() {

    }

    public void deletar() {

    }

    public void listar() {

    }


}
