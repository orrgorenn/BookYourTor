package Backend;
public class Customer extends Person {

	private int totalOrders = 0;
	private double totalPayed = 0.0;
	
	public Customer(String fullName, String phone, String email) {
		super(fullName, phone, email);
	}
	
	public void incTotalOrders() { this.totalOrders++; }
	
	public void addTotalPayed(double sum) {
		this.totalPayed += sum;
	}
	
	public int getTotalOrders() {
		return this.totalOrders;
	}
	
	public double getTotalPayed() {
		return this.totalPayed;
	}
	
	public String toString() {
		return super.fullName + ":" + this.phone + ":" + this.email;
	}
}