package generic.object;

public class Box {
	private Object product;
	
	public void set(Object product) {
		this.product = product;
	}
	
	public Object get() {
		return this.product;
	}
}
