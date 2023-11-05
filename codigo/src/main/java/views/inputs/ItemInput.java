package main.java.views.inputs;

import java.util.List;

import main.java.enums.StatusClassificacao;
import main.java.models.Biblioteca;
import main.java.models.itens.Item;
import main.java.services.ItemService;
import main.java.utils.InputScannerUtil;

public class ItemInput {

    public static void excluirItem(ItemService itemService, Biblioteca biblioteca) {

        System.out.print("Informe o ID do item: ");
        int id = InputScannerUtil.scanner.nextInt();

        Item itemDeletado = null;
        for (Item item : biblioteca.getEstoque().getItens()) {
            if (item.getId() == id) {
                itemDeletado = item;
                itemService.deletar(itemDeletado);
                break;
            }
        }

        if (itemDeletado != null) {
            System.out.println("Item deletado com sucesso!");
        } else {
            System.out.println("Item não encontrado!");
        }
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
