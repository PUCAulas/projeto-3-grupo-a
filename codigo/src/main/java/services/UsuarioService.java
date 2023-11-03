package main.java.services;

import java.time.LocalDate;

import main.java.enums.Perfil;
import main.java.models.Biblioteca;
import main.java.models.Usuario;


public class UsuarioService  {

    private Biblioteca biblioteca;
    private Usuario usuario;


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



    public void criar(String nome, String email, String senha, LocalDate dataNascimento, Perfil perfil) throws Exception {

        verificarEmailUnico(email);

        this.usuario.setPerfil(perfil);
        this.usuario.setNome(nome);
        this.usuario.setEmail(email);
        this.usuario.setSenha(senha);
        this.usuario.setDataNascimento(dataNascimento);
        this.biblioteca.addUsuario(this.usuario);
        this.setUsuario(null);
    }

    private void verificarEmailUnico(String email) throws Exception {
        boolean existeEmail = biblioteca.getUsuarios().stream()
                .anyMatch(usuario -> usuario.getEmail().equals(email));

        if (existeEmail)
            throw new Exception("E-mail já existe!");
    }


    public void atualizar(String name, String email, String senha, LocalDate dataNascimento) {


        this.getBiblioteca().removeUsuario(this.getUsuario());
        this.usuario.setNome(name);
        this.usuario.setEmail(email);
        this.usuario.setSenha(senha);
        this.usuario.setDataNascimento(dataNascimento);

        this.getBiblioteca().addUsuario(usuario);
    }


    public void deletar(Usuario usuario) {

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

    public Usuario pesquisarUsuarioPorId(int id) throws Exception {
        Usuario u = null;

        for(Usuario usuario : biblioteca.getUsuarios()) {
            if(usuario.getId() == id)
                u = usuario;
        }

        if(u == null)
            throw new Exception("Usuário não existe!");

        return u;
    }

    public Usuario verificarAdm(String senha, String email) throws Exception {
        Usuario u = null;

        for(Usuario usuario : biblioteca.getUsuarios()) {
            if(usuario.getPerfil() == Perfil.ADM) {
                if (usuario.getSenha().equals(senha) && usuario.getEmail().equals(email))
                    u = usuario;
            }

        }

        if(u == null) {
            throw new Exception("Acesso não permitido (somente para administrador)!");
        }

        return u;
    }


}
