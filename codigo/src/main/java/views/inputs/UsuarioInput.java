package main.java.views.inputs;

import main.java.models.Usuario;
import main.java.services.UsuarioService;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;
import java.time.LocalDate;

public class UsuarioInput {


    public static void obterDadosDeCadastro(UsuarioService usuarioService) {

        String name, email, senha;
        LocalDate dataNascimento;

        System.out.print("Informe o nome do usuário: ");
        name = InputScannerUtil.scanner.nextLine();

        System.out.print("Informe o e-mail do usuário: ");
        email = InputScannerUtil.scanner.nextLine();

        System.out.print("Informe a senha do usuário: ");
        senha = InputScannerUtil.scanner.nextLine();

        System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
        dataNascimento = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

       usuarioService.setUsuario(new Usuario());
       usuarioService.criar(name, email, senha, dataNascimento);
       System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void obterDadosDeAtualizacao(UsuarioService usuarioService) {
        System.out.print("Informe sua senha: ");
        String senha = InputScannerUtil.scanner.nextLine();
        System.out.print("Informe seu email: ");
        String email = InputScannerUtil.scanner.nextLine();

        try {
            Usuario usuario = usuarioService.verificarSenhaEmail(senha, email);
            usuarioService.setUsuario(usuario); //Setando para instância do usuário logado

            System.out.println("\nOpção:");
            System.out.println("1. Nome");
            System.out.println("2. E-mail");
            System.out.println("3. Senha");
            System.out.println("4. Data de nascimento");
            System.out.print("Escolha: ");

            int escolha = InputScannerUtil.scanner.nextInt();
            InputScannerUtil.scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Informe o novo nome: ");
                    String nome = InputScannerUtil.scanner.nextLine();
                    usuarioService.atualizar(nome, usuario.getEmail(), usuario.getSenha(),usuario.getDataNascimento());
                    break;
                case 2:
                    System.out.print("Informe o novo E-mail: ");
                    email = InputScannerUtil.scanner.nextLine();
                    usuarioService.atualizar(usuario.getNome(), email, usuario.getSenha(),
                            usuario.getDataNascimento());
                    break;
                case 3:
                    System.out.print("Informe a nova senha: ");
                    senha = InputScannerUtil.scanner.nextLine();
                    usuarioService.atualizar(usuario.getNome(), usuario.getEmail(),senha,usuario.getDataNascimento());
                    break;
                case 4:
                    System.out.print("Informe a nova data de nascimento (dd/MM/yyyy): ");
                    LocalDate dataNascimento = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);
                    usuarioService.atualizar(usuario.getNome(), usuario.getEmail(), usuario.getSenha(),dataNascimento);
                default:
                    System.out.println("Atributo inválido.");
            }

            System.out.println("Usuário atualizado com sucesso");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    public static void obterDadosDeExclusao(UsuarioService usuarioService) {

        System.out.print("Informe sua senha: ");
        String senha = InputScannerUtil.scanner.nextLine();
        System.out.println("Informe seu email: ");
        String email = InputScannerUtil.scanner.nextLine();

        try {
            Usuario usuario = usuarioService.verificarSenhaEmail(senha, email);
            usuarioService.deletar(usuario);
            System.out.println("Usuário deletado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }




}
