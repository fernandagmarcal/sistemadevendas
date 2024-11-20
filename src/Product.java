public class Product {
    private int productCode;
    private String productName;
    private double unitPrice;
    private int stock;
    private int shelfLifeInDays; 

    public Product(int productCode, String productName, double unitPrice, int stock, int shelfLifeInDays) {
        this.productCode = productCode;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.shelfLifeInDays = shelfLifeInDays;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getShelfLifeInDays() {
        return shelfLifeInDays;
    }

    public void setShelfLifeInDays(int shelfLifeInDays) {
        this.shelfLifeInDays = shelfLifeInDays;
    }

}
