package main.java.views.inputs;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Scanner;

import main.java.enums.StatusClassificacao;
import main.java.enums.StatusEmprestimo;
import main.java.models.itens.DVD;
import main.java.services.ItemEmprestavelService;
import main.java.services.ItemService;
import main.java.utils.DataUtil;
import main.java.utils.InputScannerUtil;
import main.java.utils.ObjectFactoryUtil;

public class ItemEmprestavelInput extends ItemInput {

    /**
     * Menu de criacao de tese
     *
     * @param itemEmprestavelService servico de item emprestavel
     */
    public static void obterDadosDeDVD(ItemEmprestavelService itemEmprestavelService) {

        System.out.println("Informe o título do DVD: ");
        String titulo = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a data de publicação (dd/MM/yyyy): ");
        LocalDate dataPublicacao = LocalDate.parse(InputScannerUtil.scanner.nextLine(), DataUtil.fmt);

        System.out.println("Informe o status de classificação do DVD:");
        StatusClassificacao statusClassificacao = escolherStatusClassificacao();

        System.out.println("Informe o status de empréstimo do DVD:");
        StatusEmprestimo statusEmprestimo = escolherStatusEmprestimo();

        System.out.println("Informe o diretor do DVD: ");
        String diretor = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a duração em segundos: ");
        Duration duracao = Duration.ofSeconds(Long.parseLong(InputScannerUtil.scanner.nextLine()));

        System.out.println("Informe o idioma do DVD: ");
        String idioma = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe a sinopse do DVD: ");
        String sinopse = InputScannerUtil.scanner.nextLine();

        System.out.println("Informe o gênero do DVD: ");
        String genero = InputScannerUtil.scanner.nextLine();

        DVD dvd = ObjectFactoryUtil.newDVD();
        itemEmprestavelService.setEmprestavel(dvd);

        try {
            itemEmprestavelService.criarDVD(titulo, dataPublicacao, statusClassificacao, statusEmprestimo, diretor,
                    duracao, idioma, sinopse, genero);
            System.out.println("\nDVD cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
