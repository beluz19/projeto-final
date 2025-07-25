import java.util.Scanner;

import repository.ProductRepository;
import service.CollectProductDataFromTerminal;
import service.ITerminal;
import service.ProductService;
import service.TerminalService;

public class App {
    public static void main(String[] args) throws Exception {
        var scanner = new Scanner(System.in);
        var terminalService = new TerminalService(scanner);
        var productRepository = new ProductRepository();
        var productService = new ProductService(productRepository);
        var collectProductDataFromTerminal = new CollectProductDataFromTerminal(terminalService);
        var app = new App(terminalService, productService, collectProductDataFromTerminal);
        app.run();
    }

    private final String menu = """
            1- Cadastrar um produto.
            2 - Listar produtos.
            3 - Buscar por ID.

            0 - Sair.
            """;
            private ITerminal terminalService;
            private ProductService productService;
            private CollectProductDataFromTerminal collectProductDataFromTerminal;

            public App(
                TerminalService terminalService,
                ProductService productService,
                CollectProductDataFromTerminal collectProductDataFromTerminal){
                    this.terminalService = terminalService;
                    this.productService = productService;
                    this.collectProductDataFromTerminal = collectProductDataFromTerminal;
                }

    public void run() {
        var option = 1;

        while(option > 0){
            terminalService.showMessage(menu);
            option = terminalService.readLineAsInt();

            switch (option) {
                case 1 -> registerProduct();
                case 2 -> showProducts();
                case 3 -> showProductById();
            }
        }
    }

    private void registerProduct(){
        var collectProduct = collectProductDataFromTerminal.collect();
        var product = productService.insert(collectProduct);

        System.out.println("Registro salvo: %s".formatted(product));
    }

    private void showProducts(){
        var products = productService.getAll();

        terminalService.showMessage("=== INICÍO LISTA DE PRODUTOS ===");
        products.stream().forEach(p -> {
            terminalService.showMessage("""
                    (cod %s) %s
                    """.formatted(p.getId(),p.getName()));
        });
        terminalService.showMessage("=== FIM LISTA DE PRODUTOS ===");
    }

    private void showProductById(){

        terminalService.showMessage("DIGITE O ID DA BUSCA: ");
        var id = terminalService.readLineAsInt();

        var product = productService.findById(id);
        if (product.isEmpty()) {
            terminalService.showMessage("NENHUM PRODUTO COM ESTE ID ENCONTRADO");
        } else {
            var prod = product.get();
            terminalService.showMessage("=== PRODUTO ===");
            terminalService.showMessage("""
                ID: %s
                NOME: %s
                PREÇO: %s
                ESTOQUE: %s
            """.formatted(
                prod.getId(),
                prod.getName(),
                ((float)prod.getValue() / 100),
                prod.getStock()));
        }
        terminalService.showMessage("=== ===");
    }
}
