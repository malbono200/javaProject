package exam.ojdbc;

public class ProductVO {
	private String productNo;   
    private String productName; 
    private int price;          
    private int stock;
    
    public ProductVO() {}
    
    public ProductVO(String productNo, String productName, int price, int stock) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
    
    
}
