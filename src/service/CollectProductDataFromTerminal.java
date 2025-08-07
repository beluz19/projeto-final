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

    /**
     * To initialize data collector using product as base.
     * 
     * @param product
     * @return
     */

    public Optional<Product> collectByProduct(Product product) {
        try {
            terminalService.showMessage("INFORME O NOME DO PRODUTO: ".formatted(product.getName()));
            var name = terminalService.readLine();
            var doubleValue = product.getValue() / 100.00;
            terminalService.showMessage("INFORME O PREÇO DO PRODUTO: ".formatted(doubleValue));
            var value = terminalService.readLineAsDouble();
            terminalService.showMessage("INFORME O ESTOQUE DO PRODUTO: ".formatted(product.getStock()));
            var stock = terminalService.readLineAsInt();
            // multiply to prevent float number
            value *= 100;
            var intValue = (int) value;

            var newProduct = new Product();
            newProduct.setName(name);
            newProduct.setValue(intValue);
            newProduct.setStock(stock);
            newProduct.setId(product.getId());

            return Optional.of(newProduct);
        } catch (NumberFormatException ex) {
            terminalService.showMessage("REGISTRO DO PRODUTO CANCELADO DEVIDO A ERRO: %s".formatted(ex.getMessage()));
            return Optional.empty();
        }
    }

}
