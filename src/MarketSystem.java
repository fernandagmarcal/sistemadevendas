import java.util.Scanner;

public class MarketSystem {
    private ProductManager productManager;
    private Scanner scanner;

    // construtor
    public MarketSystem() {
        this.productManager = new ProductManager();
        this.scanner = new Scanner(System.in);
    }

    // add produto
    public void addProduct() {
        System.out.println("Digite os detalhes do produto:");

        System.out.print("Código do Produto: ");
        int code = scanner.nextInt();
        scanner.nextLine(); // Consome a linha

        System.out.print("Nome do Produto: ");
        String name = scanner.nextLine();

        System.out.print("Preço Unitário: ");
        double price = scanner.nextDouble();

        System.out.print("Quantidade em Estoque: ");
        int stock = scanner.nextInt();

        System.out.print("Validade (em dias): ");
        int shelfLife = scanner.nextInt();

        productManager.addProduct(code, name, price, stock, shelfLife);
        System.out.println("Produto adicionado com sucesso!");
    }

    // exibe todos os produtos
    public void displayProducts() {
        productManager.displayProducts();
    }

    // menu p.
    public void menu() {
        while (true) {
            System.out.println("\nMenu MERCADINHO:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Ver Produtos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
