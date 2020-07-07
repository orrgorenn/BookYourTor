package Backend;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public class Barbershop extends JPanel {

	private static final long serialVersionUID = 1L;
	private static List<Service> mainServicesList;
	private static List<Worker> mainWorkersList;
	private static List<Appointment> mainAppointmentsList;
	private static List<Customer> mainCustomersList;
	
	private static String workersFile = "workers.txt";
	private static String servicesFile = "services.txt";
	private static String appointmentsFile = "appointments.txt";
	private static String customersFile = "customers.txt";
	
	// Swing Parts
	protected JLabel heading;
	
	public Barbershop() {
		init();
	}
	
	private void init() {
		heading = new JLabel("Welcome to BookYourTor!");
		add(heading);
		
		mainServicesList = new ArrayList<Service>();
		mainWorkersList = new ArrayList<Worker>();
		mainAppointmentsList = new ArrayList<Appointment>();
		mainCustomersList = new ArrayList<Customer>();
		
		loadWorkers();
		loadServices();
		loadAppointments();
		loadCustomers();
	}
	
	public static void addService(Service serv) {
		mainServicesList.add(serv);
	}
	
	public static void addWorker(Worker w) {
		try {
			File myObj = new File(workersFile);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
			
			FileWriter myWriter = new FileWriter(workersFile, true);
			myWriter.write(w.getFullName() + ":" + w.getEmail() + ":" + w.getPhone() + "\r\n");
			myWriter.close();
			mainWorkersList.add(w);
		} catch (FileNotFoundException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		} catch (IOException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		}
	}
	
	public void addAppointment(Appointment a) {
		this.mainAppointmentsList.add(a);
	}
	
	public static void addCustomer(Customer c) {
		mainCustomersList.add(c);
	}
	
	public static void removeService(int i) {
		mainServicesList.remove(i);
	}
	
	public static void removeWorker(int i) {
		
		File inputFile = new File(workersFile);
		File tempFile = new File("temp_" + workersFile + ".txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String currentLine;

			while((currentLine = reader.readLine()) != null) {
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			    if(trimmedLine.equals(mainWorkersList.get(i).toString())) {
			    	continue;
			    }
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			writer.close(); 
			reader.close(); 
			boolean successful = tempFile.renameTo(inputFile);
		} catch (IOException er) {
			er.printStackTrace();
		}
		
		mainWorkersList.remove(i);
	}
	
	public static void removeAppointment(int i) {
		mainAppointmentsList.remove(i);
	}
	
	public static void removeCustomer(int i) {
		mainCustomersList.remove(i);
	}
	
	public static List<Service> getListOfServices() {
		return mainServicesList;
	}
	
	public static List<Worker> getListOfWorkers() {
		return mainWorkersList;
	}
	
	public static List<Appointment> getListOfAppointments() {
		return mainAppointmentsList;
	}
	
	public static List<Customer> getListOfCustomers() {
		return mainCustomersList;
	}
	
	public static void loadWorkers() {
		try {
			File myObj = new File("workers.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				String[] split = data.split(":");
				Worker wrk = new Worker(split[0], split[1], split[2]);
				mainWorkersList.add(wrk);
			}
			myReader.close();
		} catch (FileNotFoundException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		} catch (IOException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		}
	}
	
	public static void loadServices() {
		
	}
	
	public static void loadCustomers() {
		
	}
	
	public static void loadAppointments() {
		
	}
	
}