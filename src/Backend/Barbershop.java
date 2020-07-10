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
	
	protected static Manager manager;
	
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
		loadCustomers();
		loadAppointments();
		
		manager = new Manager("Head Manager", "058-6186112", "orrgorenn@gmail.com");
		for(int i = 0; i < mainAppointmentsList.size(); i++) {
			manager.incTotalOrders();
			manager.addRevenue(mainAppointmentsList.get(i).getService().getPrice());
		}
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
				mainCustomersList.add((Customer) obj);
			} catch (FileNotFoundException er) {
				System.out.println("An error occurred.");
				er.printStackTrace();
			} catch (IOException er) {
				System.out.println("An error occurred.");
				er.printStackTrace();
			}
		} else if(element == Service.class) {
			try {
				FileWriter myWriter = new FileWriter(servicesFile, true);
				myWriter.write(obj.toString() + "\r\n");
				myWriter.close();
				mainServicesList.add((Service) obj);
			} catch (FileNotFoundException er) {
				System.out.println("An error occurred.");
				er.printStackTrace();
			} catch (IOException er) {
				System.out.println("An error occurred.");
				er.printStackTrace();
			}
		} else if(element == Appointment.class) {
			try {
				FileWriter myWriter = new FileWriter(appointmentsFile, true);
				myWriter.write(obj.toString() + "\r\n");
				myWriter.close();
				mainAppointmentsList.add((Appointment) obj);
				((Appointment)obj).getWorker().incTotalOrders();
				((Appointment)obj).getWorker().addTotalSalary(((Appointment)obj).getService().getPrice());
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
		} else if(element == Service.class) {
			File inputFile = new File(servicesFile);
			File tempFile = new File("temp_" + servicesFile);
			try {
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

				String currentLine;

				while((currentLine = reader.readLine()) != null) {
					String trimmedLine = currentLine.trim();
					if(trimmedLine.equals(mainServicesList.get(i).toString())) {
						continue;
					}
					writer.write(currentLine + System.getProperty("line.separator"));
				}
				writer.close();
				reader.close();
				boolean successful = tempFile.renameTo(inputFile);
				if(!successful) throw new Exception();
			} catch (IOException er) {
				er.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mainServicesList.remove(i);
		} else if(element == Appointment.class) {
			File inputFile = new File(appointmentsFile);
			File tempFile = new File("temp_" + appointmentsFile);
			try {
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

				String currentLine;

				while((currentLine = reader.readLine()) != null) {
					String trimmedLine = currentLine.trim();
					if(trimmedLine.equals(mainAppointmentsList.get(i).toString())) {
						continue;
					}
					writer.write(currentLine + System.getProperty("line.separator"));
				}
				writer.close();
				reader.close();
				boolean successful = tempFile.renameTo(inputFile);
				if(!successful) throw new Exception();
			} catch (IOException er) {
				er.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			mainAppointmentsList.remove(i);
		}
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
		try {
			File myObj = new File(servicesFile);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] split = data.split(":");
				for (int i = 0; i < split.length; i++) {
					System.out.println(i + " - " + split[i]);
				}
				mainServicesList.add(new Service(split[0], Double.parseDouble(split[1]), Double.parseDouble(split[2])));
			}
			myReader.close();
		} catch (FileNotFoundException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		}
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
		try {
			File myObj = new File(appointmentsFile);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] split = data.split("-");
				Customer cust = mainCustomersList.get(0);
				Service serv = mainServicesList.get(0);
				Worker work = mainWorkersList.get(0);
				for(int i = 0; i < mainCustomersList.size(); i++) {
					if(split[2].equals(mainCustomersList.get(i).getFullName()))
						cust = mainCustomersList.get(i);
				}
				for(int i = 0; i < mainServicesList.size(); i++) {
					if(split[3].equals(mainServicesList.get(i).getName()))
						serv = mainServicesList.get(i);
				}
				for(int i = 0; i < mainWorkersList.size(); i++) {
					if(split[4].equals(mainWorkersList.get(i).getFullName()))
						work = mainWorkersList.get(i);
				}
				mainAppointmentsList.add(new Appointment(split[0], split[1], cust, serv, work));
				work.addTotalSalary(serv.getPrice());
				work.incTotalOrders();
			}
			myReader.close();
		} catch (FileNotFoundException er) {
			System.out.println("An error occurred.");
			er.printStackTrace();
		}
	}
	
	public static Manager getManager() {
		return manager;
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
			File sFile = new File(servicesFile);
			if (sFile.createNewFile()) {
				System.out.println("File created: " + sFile.getName());
			}
			File aFile = new File(appointmentsFile);
			if (aFile.createNewFile()) {
				System.out.println("File created: " + sFile.getName());
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