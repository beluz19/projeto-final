package service;

import model.Product;

/**
 * To interact with terminal to ask information to mount product data
 */

public class CollectProductDataFromTerminal {
    private ITerminal terminalService;

    public CollectProductDataFromTerminal(ITerminal terminalService){
        this.terminalService = terminalService;
    }

    /**
     * To initialize data collector
     * @return product with user-provided data
     */

    public Product collect(){
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

        return product;
    }
}
