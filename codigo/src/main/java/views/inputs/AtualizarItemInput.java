package main.java.views.inputs;

import main.java.enums.StatusClassificacao;
import main.java.models.Biblioteca;
import main.java.models.itens.Item;
import main.java.models.itens.Revista;
import main.java.models.itens.Tese;
import main.java.services.ItemService;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;
import main.java.views.menus.AdmMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtualizarItemInput extends ItemInput{

    /**
     * Atualiza dados de uma revista
     *
     * @param itemService servico de item
     * @param biblioteca  biblioteca de referencia
     */
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
                        ItemInput.inserirConteudo(artigos);
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

    /**
     * Atualiza os dados de uma tese
     *
     * @param itemService servico de item
     * @param biblioteca  biblioteca de referencia
     */
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
                        StatusClassificacao novaClassificacao = ItemInput.escolherStatusClassificacao();
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
                        ItemInput.inserirConteudo(capitulos);
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
}
