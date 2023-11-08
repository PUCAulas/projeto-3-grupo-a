package main.java.views.inputs;

import main.java.enums.Perfil;
import main.java.models.Biblioteca;
import main.java.models.Usuario;
import main.java.models.itens.Emprestavel;
import main.java.models.itens.Item;
import main.java.services.ItemEmprestavelService;
import main.java.services.UsuarioService;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;
import main.java.utils.ObjectFactoryUtil;
import main.java.views.menus.PesquisaMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioInput {

    /**
     * Menu de cadastro de usuario
     *
     * @param usuarioService servico de usuario
     */
    public static void obterDadosDeCadastro(UsuarioService usuarioService) {

        String name, email, senha;
        LocalDate dataNascimento;

        System.out.print("\nInforme o nome do usuário: ");
        name = InputScannerUtil.scanner.nextLine();

        System.out.print("Informe o e-mail do usuário: ");
        email = InputScannerUtil.scanner.nextLine();

        System.out.print("Informe a senha do usuário: ");
        senha = InputScannerUtil.scanner.nextLine();

        System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
        dataNascimento = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

        Usuario usuario = ObjectFactoryUtil.newUsuario();
        usuarioService.setUsuario(usuario);
        try {
            usuarioService.criar(name, email, senha, dataNascimento, Perfil.USUARIO);
            System.out.println("\nUsuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Menu de atualizacao de usuario
     *
     * @param usuarioService servico de usuario
     */
    public static void obterDadosDeAtualizacao(UsuarioService usuarioService) {
        try {
            Usuario usuario = obterUsuarioCadastrado(usuarioService);
            usuarioService.setUsuario(usuario);

            System.out.println("\nOpção:");
            System.out.println("1. Nome");
            System.out.println("2. Senha");
            System.out.println("3. Data de nascimento");
            System.out.print("Escolha: ");

            int escolha = InputScannerUtil.scanner.nextInt();
            InputScannerUtil.scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Informe o novo nome: ");
                    String nome = InputScannerUtil.scanner.nextLine();
                    usuarioService.atualizar(nome, usuario.getEmail(), usuario.getSenha(), usuario.getDataNascimento());
                    break;
                case 2:
                    System.out.print("Informe a nova senha: ");
                    String senha = InputScannerUtil.scanner.nextLine();
                    usuarioService.atualizar(usuario.getNome(), usuario.getEmail(), senha, usuario.getDataNascimento());
                    break;
                case 3:
                    System.out.print("Informe a nova data de nascimento (dd/MM/yyyy): ");
                    LocalDate dataNascimento = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);
                    usuarioService.atualizar(usuario.getNome(), usuario.getEmail(), usuario.getSenha(), dataNascimento);
                default:
                    System.out.println("Atributo inválido.");
            }

            System.out.println("Usuário atualizado com sucesso");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static List<Emprestavel> EmprestadosDisponiveis(UsuarioService usuarioService) throws Exception {
        List<Emprestavel> emprestaveis = new ArrayList<>();

        try {
            // Usuario usuario = obterUsuarioCadastrado(usuarioService);
            // usuarioService.setUsuario(usuario);
            ItemEmprestavelService itemEmprestavelService = new ItemEmprestavelService(usuarioService.getBiblioteca());
            emprestaveis = itemEmprestavelService.listar(usuarioService.getBiblioteca());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println();
        }

        if (emprestaveis.isEmpty())
            throw new Exception("Não existe empréstimos disponíveis");

        return emprestaveis;
    }

    public static void escolherItemParaEmprestimo(UsuarioService usuarioService) {

        try {
            Usuario usuario = obterUsuarioCadastrado(usuarioService);
            ItemEmprestavelService itemEmprestavelService = new ItemEmprestavelService(usuarioService.getBiblioteca());

            System.out.println("Escolha o id do item que você pegar emprestado: ");
            int choice = InputScannerUtil.scanner.nextInt();
            InputScannerUtil.scanner.nextLine();

            itemEmprestavelService.emprestar(choice, usuario);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void mostrarItensEmprestados(UsuarioService usuarioService) {
        try {
            Usuario usuario = obterUsuarioCadastrado(usuarioService);
    
            System.out.println("Itens emprestados por você:");
            List<Emprestavel> emprestaveis = usuario.getItensEmprestados(); // Get the list of emprestaveis from the usuario
            
            System.out.println("Numero de itens: " + emprestaveis.size()); // Debugging statement
    
            for (Emprestavel emprestavel : usuario.getItensEmprestados()) {
                System.out.println(
                        "ID: " + emprestavel.getId() + " | Status do empréstimo: " + emprestavel.getStatusEmprestimo());
            }
    
            System.out.print("Digite o ID do item que deseja devolver (ou 0 para sair): ");
            int emprestavelId = InputScannerUtil.scanner.nextInt();
    
            if (emprestavelId == 0) {
                return;
            }
    
            ItemEmprestavelService itemEmprestavelService = new ItemEmprestavelService(usuarioService.getBiblioteca());
    
            // Call the "devolver" method of the service to return the item
            itemEmprestavelService.devolver(emprestavelId, usuario);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    

    /**
     * Menu de exclusao de usuario
     *
     * @param usuarioService servico de usuario
     */
    public static void obterDadosDeExclusao(UsuarioService usuarioService) {
        try {
            Usuario usuario = obterUsuarioCadastrado(usuarioService);
            usuarioService.deletar(usuario);
            System.out.println("Usuário deletado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Menu de login de usuario
     *
     * @param usuarioService servico de usuario
     */
    public static Usuario obterUsuarioCadastrado(UsuarioService usuarioService) throws Exception { // login
        System.out.print("Informe sua senha: ");
        String senha = InputScannerUtil.scanner.nextLine();
        System.out.print("Informe seu email: ");
        String email = InputScannerUtil.scanner.nextLine();

        return usuarioService.verificarSenhaEmail(senha, email);
    }

}
