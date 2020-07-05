import javax.swing.*;
import java.awt.event.*;

public class Main {
	
	private static void createAndShowGUI() {
		JFrame jFrame = new JFrame("BookYourTor");
		jFrame.setSize(600, 400);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(null);
		
		JButton jBtnAppointments = new JButton("Appointments");
		jBtnAppointments.setSize(200 , 80);
		jBtnAppointments.setLocation(20 , 20);
		jBtnAppointments.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        //your actions
		    }
		});
		jFrame.getContentPane().add(jBtnAppointments);
		
		JButton jBtnServices = new JButton("Services");
		jBtnServices.setSize(200 , 80);
		jBtnServices.setLocation(370 , 20);
		jFrame.getContentPane().add(jBtnServices);
		
		JButton jBtnCustomers = new JButton("Customers");
		jBtnCustomers.setSize(200 , 80);
		jBtnCustomers.setLocation(20 , 150);
		jFrame.getContentPane().add(jBtnCustomers);
		
		JButton jBtnWorkers = new JButton("Workers");
		jBtnWorkers.setSize(200 , 80);
		jBtnWorkers.setLocation(370 , 150);
		jFrame.getContentPane().add(jBtnWorkers);
		
		JButton jBtnStatistics = new JButton("Statistics");
		jBtnStatistics.setSize(200 , 80);
		jBtnStatistics.setLocation(190 , 280);
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