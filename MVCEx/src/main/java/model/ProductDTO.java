package model;

public class ProductDTO {
	private String prdNo;
    private String prdName;
    private int Price;
    private int Stock;

    public ProductDTO() {
    }

    public ProductDTO(String prdNo, String prdName, int Price, int Stock) {
        this.prdNo = prdNo;
        this.prdName = prdName;
        this.Price = Price;
        this.Stock = Stock;
    }

	public String getPrdNo() {
		return prdNo;
	}

	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}
    
    
}
