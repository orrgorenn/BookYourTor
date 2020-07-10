package Backend;
public class Manager extends Person {
	
	private double revenue = 0;
	private int totalOrders = 0;

	public Manager(String fullName, String phone, String email) {
		super(fullName, phone, email);
	}

	public void addRevenue(double sum) {
		this.revenue += sum;
	}
	
	public void incTotalOrders() { this.totalOrders++; }
	
	public double getRevenue() {
		return this.revenue;
	}
	
	public int getTotalOrders() {
		return this.totalOrders;
	}
	
}