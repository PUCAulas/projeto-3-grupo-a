package main.java.views.inputs;

import main.java.models.Biblioteca;
import main.java.models.itens.Item;
import main.java.services.ItemService;
import main.java.utils.InputScannerUtil;

public class ExcluirItemInput {
    /**
     * Menu de exclusao de item
     *
     * @param itemService servico de item
     * @param biblioteca  biblioteca de referencia
     */
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
}
