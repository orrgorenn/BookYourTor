import javax.swing.*;

import Backend.Barbershop;
import GUI.*;
import java.awt.event.*;

public class Main {
	
	private static void createAndShowGUI() {
		Barbershop bshop = new Barbershop();
		
		JFrame jFrame = new JFrame("BookYourTor");
		jFrame.setSize(600, 450);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(null);
		
		JButton jBtnAppointments = new JButton("Appointments");
		jBtnAppointments.setSize(200 , 80);
		jBtnAppointments.setLocation(20 , 20);
		jFrame.getContentPane().add(jBtnAppointments);
		
		JButton jBtnServices = new JButton("Services");
		jBtnServices.setSize(200 , 80);
		jBtnServices.setLocation(370 , 20);
		jFrame.getContentPane().add(jBtnServices);
		
		JButton jBtnCustomers = new JButton("Customers");
		jBtnCustomers.setSize(200 , 80);
		jBtnCustomers.setLocation(20 , 150);
		jBtnCustomers.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	CustomersGUI.setSettings();
		    	CustomersGUI.getDialog().setVisible(true);
		    }
		});
		jFrame.getContentPane().add(jBtnCustomers);
		
		JButton jBtnWorkers = new JButton("Workers");
		jBtnWorkers.setSize(200 , 80);
		jBtnWorkers.setLocation(370 , 150);
		jBtnWorkers.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	WorkersGUI.setSettings();
		        WorkersGUI.getDialog().setVisible(true);
		    }
		});
		jFrame.getContentPane().add(jBtnWorkers);
		
		JButton jBtnStatistics = new JButton("Statistics");
		jBtnStatistics.setSize(200 , 80);
		jBtnStatistics.setLocation(190 , 280);
		jBtnStatistics.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	ManagerGUI.setSettings();
		    	ManagerGUI.getDialog().setVisible(true);
		    }
		});
		jFrame.getContentPane().add(jBtnStatistics);
		
		jFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
}