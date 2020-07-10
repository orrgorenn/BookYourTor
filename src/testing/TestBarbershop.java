package testing;

import Backend.*;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.instanceOf;

public class TestBarbershop extends TestCase {
	Barbershop barbershop1;
	
	public TestBarbershop() { }
	
	protected void setUp() throws Exception {
		barbershop1 = new Barbershop();
	}
	
	public void testInstances() {
		assertThat("Barbershop should be from barbershop class.", barbershop1, instanceOf(Barbershop.class));
		assertThat("List of services should be from List<Service> class.", Barbershop.getListOfServices(), instanceOf(List.class));
		assertThat("List of workers should be from List<Worker> class.", Barbershop.getListOfWorkers(), instanceOf(List.class));
		assertThat("List of customers should be from List<Customer> class.", Barbershop.getListOfCustomers(), instanceOf(List.class));
		assertThat("List of appointments should be from List<Appointment> class.", Barbershop.getListOfAppointments(), instanceOf(List.class));
	}
	
	public void testAddElement() {
		Barbershop.addElement(Service.class, new Service("name", 90.0, 1.5));
		Barbershop.addElement(Worker.class, new Worker("name", "phone", "email"));
		Barbershop.addElement(Customer.class, new Customer("name", "phone", "email"));
		Barbershop.addElement(Appointment.class, new Appointment("10 Jul 2020", "20:30", new Customer("name", "phone", "email"), new Service("name", 90.0, 1.5), new Worker("name", "phone", "email")));
	}
}