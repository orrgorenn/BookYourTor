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
		
		createFiles();
		
		loadWorkers();
		loadServices();
		loadAppointments();
		loadCustomers();
	}
	
	public static void addElement(Class<?> element, Object obj) {
		if(element == Worker.class) {
			try {
				FileWriter myWriter = new FileWriter(workersFile, true);
				myWriter.write(obj.toString() + "\r\n");
				myWriter.close();
				mainWorkersList.add((Worker)obj);
			} catch (FileNotFoundException er) {
				System.out.println("An error occurred.");
				er.printStackTrace();
			} catch (IOException er) {
				System.out.println("An error occurred.");
				er.printStackTrace();
			}
		} else if(element == Customer.class) {
			try {
				FileWriter myWriter = new FileWriter(customersFile, true);
				myWriter.write(obj.toString() + "\r\n");
				myWriter.close();
				mainCustomersList.add((Customer)obj);
			} catch (FileNotFoundException er) {
				System.out.println("An error occurred.");
				er.printStackTrace();
			} catch (IOException er) {
				System.out.println("An error occurred.");
				er.printStackTrace();
			}
		} else {
			System.out.println(element.toString());
		}
	}
	
	public static void addService(Service serv) {
		mainServicesList.add(serv);
	}
	
	public void addAppointment(Appointment a) {
		mainAppointmentsList.add(a);
	}
	
	public static void removeService(int i) {
		mainServicesList.remove(i);
	}
	
	public static void removeElement(Class<?> element, int i) {
		if(element == Worker.class) {
			File inputFile = new File(workersFile);
			File tempFile = new File("temp_" + workersFile);
			try {
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

				String currentLine;

				while((currentLine = reader.readLine()) != null) {
				    String trimmedLine = currentLine.trim();
				    if(trimmedLine.equals(mainWorkersList.get(i).toString())) {
				    	continue;
				    }
				    writer.write(currentLine + System.getProperty("line.separator"));
				}
				writer.close(); 
				reader.close(); 
				boolean successful = tempFile.renameTo(inputFile);
				if(!successful) throw new IOException();
			} catch (IOException er) {
				er.printStackTrace();
			}
			mainWorkersList.remove(i);
		} else if(element == Customer.class) {
			File inputFile = new File(customersFile);
			File tempFile = new File("temp_" + customersFile);
			try {
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

				String currentLine;

				while((currentLine = reader.readLine()) != null) {
				    String trimmedLine = currentLine.trim();
				    if(trimmedLine.equals(mainCustomersList.get(i).toString())) {
				    	continue;
				    }
				    writer.write(currentLine + System.getProperty("line.separator"));
				}
				writer.close(); 
				reader.close(); 
				boolean successful = tempFile.renameTo(inputFile);
				if(!successful) throw new IOException();
			} catch (IOException er) {
				er.printStackTrace();
			}
			mainCustomersList.remove(i);
		}
	}
	
	public static void removeAppointment(int i) {
		mainAppointmentsList.remove(i);
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
			File myObj = new File(workersFile);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				String[] split = data.split(":");
				mainWorkersList.add(new Worker(split[0], split[1], split[2]));
			}
			myReader.close();
		} catch (FileNotFoundException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		}
	}
	
	public static void loadServices() {
		
	}
	
	public static void loadCustomers() {
		try {
			File myObj = new File(customersFile);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				String[] split = data.split(":");
				mainCustomersList.add(new Customer(split[0], split[1], split[2]));
			}
			myReader.close();
		} catch (FileNotFoundException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		}
	}
	
	public static void loadAppointments() {
		
	}
	
	public static void createFiles() {
		try {
			File wFile = new File(workersFile);
			if (wFile.createNewFile()) {
				System.out.println("File created: " + wFile.getName());
			}
			File cFile = new File(customersFile);
			if (cFile.createNewFile()) {
				System.out.println("File created: " + cFile.getName());
			}
		} catch (FileNotFoundException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		} catch (IOException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		}
	}
	
}