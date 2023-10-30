package main.java;

import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.models.Usuario;
import main.java.services.UsuarioService;

public class Main {

    public static void main(String[] args) {

        // Objetos como Usuario e item (incluindo emprestimo) devem ser instanciado aqui com o construtor padrão.
        // Quem tem que setar os atributos é o método criar do serviço
        // Estoque também tem que ser instanciado pelo construtor padrão.


        Estoque estoque = new Estoque();
        Biblioteca biblioteca = new Biblioteca(estoque);
        Usuario usuario1 = new Usuario();
        UsuarioService usuarioService = new UsuarioService(biblioteca, usuario1);

        // Cadastrar
        usuarioService.criar();


    }





}

