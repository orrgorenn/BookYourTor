package Backend;
public class Worker extends Person {

	private double totalSalary;
	private int totalOrders;
	
	public Worker(String fullName, String phone, String email) {
		super(fullName, phone, email);
	}
	
	public void incTotalOrders() { this.totalOrders++; }
	
	public void addTotalSalary(double salary) {
		this.totalSalary += salary;
	}
	
	public int getTotalOrders() {
		return this.totalOrders;
	}
	
	public double getTotalSalary() {
		return this.totalSalary;
	}
	
	public String toString() {
		return super.fullName + ":" + this.phone + ":" + this.email;
	}

}