package service;

import model.Product;

public class CollectProductDataFromTerminal {
    private ITerminal terminalService;

    public CollectProductDataFromTerminal(ITerminal terminalService){
        this.terminalService = terminalService;
    }

    public Product collect(){
        terminalService.showMessage("INFORME O NOME DO PRODUTO: ");
        var name = terminalService.readLine();
        terminalService.showMessage("INFORME O PREÇO DO PRODUTO: ");
        var value = terminalService.readLineAsDouble();
        terminalService.showMessage("INFORME O ESTOQUE DO PRODUTO: ");
        var stock = terminalService.readLineAsInt();

        value *= 100;
        var intValue = (int) value;

        var product = new Product();
        product.setName(name);
        product.setValue(intValue);
        product.setStock(stock);

        return product;
    }
}
