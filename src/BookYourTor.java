import java.awt.GridLayout;

import javax.swing.*;

import Backend.Barbershop;

public class BookYourTor {

	private static void init() {
		
	}
	
	public static void createAndShowGUI() {
		JFrame mainFrame = new JFrame("BookYourTor - App");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Barbershop mainBarbershopPane = new Barbershop();
		GridLayout myLayout = new GridLayout(0,3);
		mainBarbershopPane.setLayout(myLayout);
		mainBarbershopPane.setOpaque(true);
		mainFrame.setContentPane(mainBarbershopPane);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		init();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
}