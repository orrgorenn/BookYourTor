import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class Barbershop extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private List<Service> services;
	private List<Worker> workers;
	private List<Appointment> appointments;
	private List<Customer> customers;
	
	// Swing Parts
	protected JLabel heading;
	
	public Barbershop() {
		init();
	}
	
	private void init() {
		heading = new JLabel("Welcome to BookYourTor!");
		add(heading);
	}
	
	public void addService(Service serv) {
		this.services.add(serv);
	}
	
	public void addWorker(Worker w) {
		this.workers.add(w);
	}
	
	public void addAppointment(Appointment a) {
		this.appointments.add(a);
	}
	
	public void addCustomer(Customer c) {
		this.customers.add(c);
	}
	
	public void removeService(int i) {
		this.services.remove(i);
	}
	
	public void removeWorker(int i) {
		this.workers.remove(i);
	}
	
	public void removeAppointment(int i) {
		this.appointments.remove(i);
	}
	
	public void removeCustomer(int i) {
		this.customers.remove(i);
	}
	
	public List<Service> getListOfServices() {
		return this.services;
	}
	
	public List<Worker> getListOfWorkers() {
		return this.workers;
	}
	
	public List<Appointment> getListOfAppointments() {
		return this.appointments;
	}
	
	public List<Customer> getListOfCustomers() {
		return this.customers;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
}