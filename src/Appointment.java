public class Appointment {
	private String date;
	private String startTime;
	private String endTime;
	private Customer customer;
	private Service service;
	
	public Appointment(String date, String startTime, String endTime, Customer cus, Service serv) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.customer = cus;
		this.service = serv;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getStartTime() {
		return this.startTime;
	}
	
	public String getEndTime() {
		return this.endTime;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public Service getService() {
		return this.service;
	}
}