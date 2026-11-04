package analysis_and_design;

public class Fruit {
	private String type;
	private double quantity;
	public Fruits_catalog aFruit_catalog;

	public Fruit(String type, double quantity) {
		this.type = type;
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public double getQuantity() {
		return quantity;
	}

	public void printData() {
		System.out.println("Fruit: " + type + ", Quantity: " + quantity + " units");
	}
}
