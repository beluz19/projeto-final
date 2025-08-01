package service;

import java.util.Optional;

import model.Product;

/**
 * To interact with terminal to ask information to mount product data
 */

public class CollectProductDataFromTerminal {
    private ITerminal terminalService;

    public CollectProductDataFromTerminal(ITerminal terminalService) {
        this.terminalService = terminalService;
    }

    /**
     * To initialize data collector
     * 
     * @return product with user-provided data
     */

    public Optional<Product> collect() {
        try {
            terminalService.showMessage("INFORME O NOME DO PRODUTO: ");
            var name = terminalService.readLine();
            terminalService.showMessage("INFORME O PREÇO DO PRODUTO: ");
            var value = terminalService.readLineAsDouble();
            terminalService.showMessage("INFORME O ESTOQUE DO PRODUTO: ");
            var stock = terminalService.readLineAsInt();
            // multiply to prevent float number
            value *= 100;
            var intValue = (int) value;

            var product = new Product();
            product.setName(name);
            product.setValue(intValue);
            product.setStock(stock);

            return Optional.of(product);
        } catch (NumberFormatException ex) {
            terminalService.showMessage("REGISTRO DO PRODUTO CANCELADO DEVIDO A ERRO: %s".formatted(ex.getMessage()));
            return Optional.empty();
        }
    }

    public Optional<Product> collectByProduct(Product product){
        return Optional.empty();
    }
}
