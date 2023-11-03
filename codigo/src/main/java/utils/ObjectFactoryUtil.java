package main.java.utils;


import main.java.enums.Perfil;
import main.java.models.Biblioteca;
import main.java.models.Estoque;
import main.java.models.Usuario;
import main.java.services.UsuarioService;

import java.time.LocalDate;

import static main.java.utils.DataUtil.fmt;


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


   public static void construirAdm(UsuarioService usuarioService) {
       Usuario usuario = newUsuario();
       usuarioService.setUsuario(usuario);
       try {
           usuarioService.criar("adm", "emailAdm", "senhaAdm", LocalDate.parse("21/10/1988", fmt), Perfil.ADM);
       } catch (Exception e) {
           System.out.println("Erro: " + e.getMessage());
       }
   }



}
