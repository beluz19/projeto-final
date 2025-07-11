import java.util.Scanner;

import repository.ProductRepository;
import service.CollectProductDataFromTerminal;
import service.ITerminal;
import service.TerminalService;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var terminalService = new TerminalService(scanner);
        var productRepository = new ProductRepository();
        var collectProductDataFromTerminal = new CollectProductDataFromTerminal(terminalService);
        var app = new App(terminalService, productRepository, collectProductDataFromTerminal);
        app.run();
    }

    private final String menu = """
            1- Cadastrar um produto.

            0 - Sair.
            """;
            private ITerminal terminalService;
            private ProductRepository productRepository;
            private CollectProductDataFromTerminal collectProductDataFromTerminal;

            public App(
                TerminalService terminalService,
                ProductRepository productRepository,
                CollectProductDataFromTerminal collectProductDataFromTerminal){
                    this.terminalService = terminalService;
                    this.productRepository = productRepository;
                    this.collectProductDataFromTerminal = collectProductDataFromTerminal;
                }

    public void run() {
        var option = 1;

        while(option > 0){
            terminalService.showMessage(menu);
            option = terminalService.readLineAsInt();

            switch (option) {
                case 1 -> registerProduct();
            }
        }
    }

    private void registerProduct(){
        var collectProduct = collectProductDataFromTerminal.collect();
        var product = productRepository.save(collectProduct);

        System.out.println("Registro salvo: %s".formatted(product));
    }

}
