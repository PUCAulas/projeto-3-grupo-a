package main.java.views.inputs;

import main.java.enums.StatusClassificacao;
import main.java.models.itens.Revista;
import main.java.models.itens.Tese;
import main.java.services.ItemService;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;
import main.java.utils.ObjectFactoryUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CriarItemInput {

    /**
     * Menu de criacao de revista
     *
     * @param itemService servico de item
     */
    public static void obterDadosDeRevista(ItemService itemService) {

        System.out.println("Informe o título da Revista: ");
        String titulo = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        LocalDate dataPublicacao = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

        System.out.println("Informe o status de classificação da Revista:");
        StatusClassificacao statusClassificacao = ItemInput.escolherStatusClassificacao();

        System.out.println("Informe a editora da Revista: ");
        String editora = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a edição da Revista: ");
        String edicao = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe os artigos da revista (digite 'FIM' para sair): ");
        List<String> artigos = new ArrayList<>();
        ItemInput.inserirConteudo(artigos);

        Revista revista = ObjectFactoryUtil.newRevista();
        itemService.setItem(revista);
        try {
            itemService.criarRevista(titulo, dataPublicacao, statusClassificacao, editora, edicao, artigos);
            System.out.println("\nRevista cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Menu de criacao de tese
     *
     * @param itemService servico de item
     */
    public static void obterDadosDeTese(ItemService itemService) {

        System.out.println("Informe o título da tese: ");
        String titulo = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a data de publicação (dd/MM/yyy): ");
        LocalDate dataPublicacao = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

        System.out.println("Informe o status de classificação da tese:");
        StatusClassificacao statusClassificacao = ItemInput.escolherStatusClassificacao();

        System.out.println("Informe o autor da tese: ");
        String autor = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe o orientador da tese: ");
        String orientador = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a data de defesa da tese: ");
        LocalDate dataDefesa = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

        System.out.println("Informe os capítulos da tese (digite 'FIM' para sair): ");
        List<String> capitulos = new ArrayList<>();
        ItemInput.inserirConteudo(capitulos);

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
}
