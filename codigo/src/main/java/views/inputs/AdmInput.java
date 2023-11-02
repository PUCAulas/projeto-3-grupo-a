package main.java.views.inputs;

import main.java.models.Usuario;
import main.java.services.UsuarioService;
import main.java.utils.InputScannerUtil;

import java.util.Optional;

public class AdmInput {

    // todo: está faltando a verificação de senha e login do adm
    // todo: adm é um usuário com permissões especiais.


    public static Optional<Usuario> dadosDePesquisaDoUsuario(UsuarioService usuarioService) {
        System.out.println("Digite o id do usuário desejado: ");
        int id = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();

        try {
            Usuario usuario = usuarioService.pesquisarUsuarioPorId(id);
            return Optional.ofNullable(usuario);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return Optional.empty();
    }

    public static void deletarUsuarioPorId(UsuarioService usuarioService) {
        Optional<Usuario> usuarioOptional = dadosDePesquisaDoUsuario(usuarioService);
        usuarioOptional.ifPresent(usuario -> usuarioService.deletar(usuario));
    }


    public static void dadosDeTodosOsUsuarios(UsuarioService usuarioService) {
        usuarioService.listar();
    }
}
