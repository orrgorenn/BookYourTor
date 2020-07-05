public class Customer extends Person {

	private int totalOrders = 0;
	private double totalPayed = 0;
	private Worker worker;
	
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
	
	public void setWorker(Worker w) {
		this.worker = w;
	}
	
	public Worker getWorker() {
		return this.worker;
	}
	
}