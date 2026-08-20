package exam.finalalgoex;

public class Product implements Comparable<Product> {
	
	private String productName;
    private int productStock;

    public Product(String productName, int productStock) {
        this.productName = productName;
        this.productStock = productStock;
    }

    public Product(String productName) { 
        this.productName = productName;
        this.productStock = 0;
    }
    
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getProductStock() { return productStock; }
    public void setProductStock(int productStock) { this.productStock = productStock; }

    public int getProduct(int quantity) {
        if (this.productStock < quantity) {
            return -1;
        }
        this.productStock -= quantity;
        return this.productStock;
    }

	@Override
	public int compareTo(Product o) {
		return this.productName.compareTo(o.productName);
	}

	@Override
	public String toString() {
		return productName + " : " + productStock;
	}
    
    
}
