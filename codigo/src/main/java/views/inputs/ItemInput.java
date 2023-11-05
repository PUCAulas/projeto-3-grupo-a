package main.java.views.inputs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.java.enums.StatusClassificacao;
import main.java.models.Biblioteca;
import main.java.models.itens.Item;
import main.java.models.itens.Revista;
import main.java.models.itens.Tese;
import main.java.services.ItemService;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;
import main.java.utils.ObjectFactoryUtil;
import main.java.views.menus.AdmMenu;

public class ItemInput {
    public static void obterDadosDeRevista(ItemService itemService) {

        System.out.println("Informe o título da Revista: ");
        String titulo = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        LocalDate dataPublicacao = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

        System.out.println("Informe o status de classificação da Revista:");
        StatusClassificacao statusClassificacao = escolherStatusClassificacao();

        System.out.println("Informe a editora da Revista: ");
        String editora = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a edição da Revista: ");
        String edicao = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe os artigos da revista (digite 'FIM' para sair): ");
         List<String> artigos = new ArrayList<>();
        inserirConteudo(artigos);

        Revista revista = ObjectFactoryUtil.newRevista();
        itemService.setItem(revista);
        try {
            itemService.criarRevista(titulo, dataPublicacao, statusClassificacao, editora, edicao, artigos);
            System.out.println("\nRevista cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void obterDadosDeTese(ItemService itemService) {

        System.out.println("Informe o título da tese: ");
        String titulo = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        LocalDate dataPublicacao = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

        System.out.println("Informe o status de classificação da tese:");
        StatusClassificacao statusClassificacao = escolherStatusClassificacao();

        System.out.println("Informe o autor da tese: ");
        String autor = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe o orientador da tese: ");
        String orientador = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a data de defesa da tese: ");
        LocalDate dataDefesa = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

        System.out.println("Informe os capítulos da tese (digite 'FIM' para sair): ");
        List<String> capitulos = new ArrayList<>();
        inserirConteudo(capitulos);

        Tese tese = ObjectFactoryUtil.newTese();
        itemService.setItem(tese);
        try {
            itemService.criarTese(titulo, dataPublicacao, statusClassificacao, autor, orientador, dataDefesa,
                    capitulos);
            System.out.println("\nTese cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void atualizarDadosDeRevista(ItemService itemService, Biblioteca biblioteca) {
        System.out.print("Informe o ID do item a ser atualizado: ");
        int id = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();

        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id && item instanceof Revista) {
                AdmMenu.opcoesRevista();
                itemService.setItem(item);

                int escolha = InputScannerUtil.scanner.nextInt();
                InputScannerUtil.scanner.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o novo título: ");
                        String titulo = InputScannerUtil.scanner.nextLine();
                        itemService.atualizarRevista(titulo, ((Revista) item).getDataPublicacao(),
                                ((Revista) item).getStatusClassificacao(), ((Revista) item).getEdicao(),
                                ((Revista) item).getEditora(), ((Revista) item).getArtigos());
                        break;
                    case 2:
                        System.out.println("Informe a nova data de publicação (dd/MM/yyyy): ");
                        LocalDate novaData = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);
                        itemService.atualizarRevista(((Revista) item).getTitulo(), novaData,
                                ((Revista) item).getStatusClassificacao(), ((Revista) item).getEdicao(),
                                ((Revista) item).getEditora(), ((Revista) item).getArtigos());
                        break;
                    case 3:
                        System.out.println("Informe a nova classificação: ");
                        StatusClassificacao novaClassificacao = escolherStatusClassificacao();
                        itemService.atualizarRevista(((Revista) item).getTitulo(), ((Revista) item).getDataPublicacao(),
                                novaClassificacao, ((Revista) item).getEdicao(), ((Revista) item).getEditora(),
                                ((Revista) item).getArtigos());
                        break;
                    case 4:
                        System.out.println("Informe a nova edição: ");
                        String novaEdicao = InputScannerUtil.scanner.nextLine();
                        itemService.atualizarRevista(((Revista) item).getTitulo(), ((Revista) item).getDataPublicacao(),
                                ((Revista) item).getStatusClassificacao(), novaEdicao, ((Revista) item).getEditora(),
                                ((Revista) item).getArtigos());
                        break;
                    case 5:
                        System.out.println("Informe a nova editora");
                        String novaEditora = InputScannerUtil.scanner.nextLine();
                        itemService.atualizarRevista(((Revista) item).getTitulo(), ((Revista) item).getDataPublicacao(),
                                ((Revista) item).getStatusClassificacao(), ((Revista) item).getEdicao(), novaEditora,
                                ((Revista) item).getArtigos());
                        break;
                    case 6:
                        List<String> artigos = new ArrayList<>();
                        System.out.println("Informe os artigos (FIM para sair): ");
                        inserirConteudo(artigos);
                        itemService.atualizarRevista(((Revista) item).getTitulo(), ((Revista) item).getDataPublicacao(),
                                ((Revista) item).getStatusClassificacao(), ((Revista) item).getEdicao(),
                                ((Revista) item).getEditora(), artigos);
                    default:
                        System.out.println("Atributo inválido.");
                }

                System.out.println("Item atualizado!");
                return;
            }
        }
        System.out.println("Item não encontrado ou tipo de item incorreto!");
    }

    public static void atualizarDadosDeTese(ItemService itemService, Biblioteca biblioteca) {
        System.out.print("Informe o ID do item a ser atualizado: ");
        int id = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();

        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id && item instanceof Tese) {
                AdmMenu.opcoesTese();
                itemService.setItem(item);

                int escolha = InputScannerUtil.scanner.nextInt();
                InputScannerUtil.scanner.nextLine();

                switch (escolha) {
                    case 1:
                        System.out.println("Informe o novo título: ");
                        String novoTitulo = InputScannerUtil.scanner.nextLine();
                        itemService.atualizarTese(novoTitulo, ((Tese) item).getDataPublicacao(),
                                ((Tese) item).getStatusClassificacao(), ((Tese) item).getAutor(),
                                ((Tese) item).getOrientador(), ((Tese) item).getDataDefesa(),
                                ((Tese) item).getCapitulos());
                        break;
                    case 2:
                        System.out.println("Informe a nova data (dd/MM/yyyy): ");
                        LocalDate novaData = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);
                        itemService.atualizarTese(((Tese) item).getTitulo(), novaData,
                                ((Tese) item).getStatusClassificacao(), ((Tese) item).getAutor(),
                                ((Tese) item).getOrientador(), ((Tese) item).getDataDefesa(),
                                ((Tese) item).getCapitulos());
                        break;
                    case 3:
                        System.out.println("Informe a nova classificação: ");
                        StatusClassificacao novaClassificacao = escolherStatusClassificacao();
                        itemService.atualizarTese(((Tese) item).getTitulo(), ((Tese) item).getDataPublicacao(),
                                novaClassificacao, ((Tese) item).getAutor(),
                                ((Tese) item).getOrientador(), ((Tese) item).getDataDefesa(),
                                ((Tese) item).getCapitulos());
                        break;
                    case 4:
                        System.out.println("Informe o novo autor: ");
                        String novoAutor = InputScannerUtil.scanner.nextLine();
                        itemService.atualizarTese(((Tese) item).getTitulo(), ((Tese) item).getDataPublicacao(),
                                ((Tese) item).getStatusClassificacao(), novoAutor,
                                ((Tese) item).getOrientador(), ((Tese) item).getDataDefesa(),
                                ((Tese) item).getCapitulos());
                        break;
                    case 5:
                        System.out.println("Informe o novo orientador: ");
                        String novoOrientador = InputScannerUtil.scanner.nextLine();
                        itemService.atualizarTese(((Tese) item).getTitulo(), ((Tese) item).getDataPublicacao(),
                                ((Tese) item).getStatusClassificacao(), ((Tese) item).getAutor(),
                                novoOrientador, ((Tese) item).getDataDefesa(),
                                ((Tese) item).getCapitulos());
                        break;
                    case 6:
                        System.out.println("Informe a nova data de defesa (dd/MM/yyyy): ");
                        LocalDate novaDataDefesa = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);
                        itemService.atualizarTese(((Tese) item).getTitulo(), ((Tese) item).getDataPublicacao(),
                                ((Tese) item).getStatusClassificacao(), ((Tese) item).getAutor(),
                                ((Tese) item).getOrientador(), novaDataDefesa,
                                ((Tese) item).getCapitulos());
                        break;
                    case 7:
                        List<String> capitulos = new ArrayList<>();
                        System.out.println("Informe os capítulos (FIM para sair): ");
                        inserirConteudo(capitulos);
                        itemService.atualizarTese(((Tese) item).getTitulo(), ((Tese) item).getDataPublicacao(),
                                ((Tese) item).getStatusClassificacao(), ((Tese) item).getAutor(),
                                ((Tese) item).getOrientador(), ((Tese) item).getDataDefesa(),
                                capitulos);
                        break;
                    default:
                        System.out.println("Atributo inválido.");
                }

                System.out.println("Item atualizado!");
                return;
            }
        }
        System.out.println("Item não encontrado ou tipo de item incorreto!");
    }

    public static StatusClassificacao escolherStatusClassificacao() {

        for (StatusClassificacao status : StatusClassificacao.values()) {
            System.out.println(status.ordinal() + 1 + ". " + status.name());
        }

        int escolha = InputScannerUtil.scanner.nextInt();
        InputScannerUtil.scanner.nextLine();

        if (escolha >= 1 && escolha <= StatusClassificacao.values().length) {
            return StatusClassificacao.values()[escolha - 1];
        } else {
            System.out.println("Opção inválida.");
            return null;
        }
    }

    public static void inserirConteudo(List<String> conteudo) {
        while (true) {
            String linha = InputScannerUtil.scanner.nextLine();
            if ("FIM".equalsIgnoreCase(linha)) {
                break;
            }
            conteudo.add(linha);
        }
    }
}
