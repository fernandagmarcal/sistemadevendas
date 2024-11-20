import java.util.ArrayList;
public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(int productCode, String productName, double unitPrice, int stock, int shelfLifeInDays) {
        Product product = new Product(productCode, productName, unitPrice, stock, shelfLifeInDays);
        products.add(product);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Não há produtos");
        } else {
            System.out.println("Produtos:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}
