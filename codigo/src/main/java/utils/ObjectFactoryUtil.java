package main.java.utils;


import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.models.Usuario;
import main.java.services.UsuarioService;


/**
 * todo: Coloque aqui, toda a instância para o start do programa
 * Essa classe também tem objetivo de evitar que qualquer mudança de atributo que afete os construtores seja mudado
 * na classe principal (Main)
 */
public class ObjectFactoryUtil {

   public static Biblioteca construirBiblioteca() {
       Estoque estoque = new Estoque();
       Biblioteca biblioteca = new Biblioteca(estoque);
       return biblioteca;
   }

   public static UsuarioService usuarioService(Biblioteca biblioteca) {
       UsuarioService usuarioService = new UsuarioService(biblioteca);
       return usuarioService;
   }

   public static Usuario newUsuario() {
       return new Usuario();
   }

}
