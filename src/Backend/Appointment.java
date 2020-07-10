package Backend;
public class Appointment {
	private String date;
	private String time;
	private Customer customer;
	private Service service;
	private Worker worker;
	
	public Appointment(String date, String time, Customer cus, Service serv, Worker work) {
		this.date = date;
		this.time = time;
		this.customer = cus;
		this.service = serv;
		this.worker = work;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void setWorker(Worker work) {
		this.worker = work;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public Service getService() {
		return this.service;
	}
	
	public Worker getWorker() {
		return this.worker;
	} 
	
	public String toString() {
		return this.date + "-" + this.time + "-" + this.customer.getFullName() + "-" + this.service.getName() + "-" + this.worker.getFullName();
	}
}