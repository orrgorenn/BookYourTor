package GUI;

import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import Backend.*;

public class ManagerGUI {
	public static JDialog managerGUI;
	
	public static JDialog getDialog() {
		return managerGUI;
	}
	
	public static void setSettings() {
		managerGUI = new JDialog();
		managerGUI.setTitle("Login");
		
    	
    	JLabel passwordLbl = new JLabel("Password:");
    	JPasswordField passwordTxt = new JPasswordField();
		
    	managerGUI.setLayout(new GridLayout(2, 2));
    	
    	JButton logInBtn = new JButton("Log In");
    
    	logInBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	String passText = new String(passwordTxt.getPassword());
		    	if (passText.equals("Aa123456")) {
		    		managerGUI.dispose();
		    		statisticWin.setSetting();
		    		statisticWin.getDialog().setVisible(true);
		    	} else {
		    		JOptionPane.showMessageDialog(managerGUI, "Error: The Password Is Wrong");
		    	}
		    }
		});
    	
    	managerGUI.add(passwordLbl);
    	managerGUI.add(passwordTxt);
    	managerGUI.add(logInBtn);
    	
		managerGUI.setSize(300, 100);
	}

};

class statisticWin {
	public static JDialog statisticsDlg;
	public static JTable revenueTable;
	public static JScrollPane scrollPane;
	public static String[] columnNames = {"Full Name", "Total Orders", "Total Salary"};
	public static String[][] data;
	
	public static JDialog getDialog() {
		return statisticsDlg;
	} 
	public static void setSetting() {
		statisticsDlg = new JDialog();
		statisticsDlg.setLayout(null);
		statisticsDlg.setTitle("Statistics");
		
		data = new String[10][3];
		
		for(int c = 0; c < Barbershop.getListOfWorkers().size(); c++) {
			System.out.println("c: " + c);
			data[c][0] = Barbershop.getListOfWorkers().get(c).getFullName();
			data[c][1] = String.valueOf(Barbershop.getListOfWorkers().get(c).getTotalOrders());
			data[c][2] = String.valueOf(Barbershop.getListOfWorkers().get(c).getTotalSalary());
		}
		
		revenueTable = new JTable(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(revenueTable);
		revenueTable.setFillsViewportHeight(true);
		scrollPane.setSize(600, 400);
		statisticsDlg.add(scrollPane);
		
		JLabel totalOrders = new JLabel("Total Orders: 100");
		JLabel totalRevenue = new JLabel("Total Revenue: 100000");
		JButton logoutBtn = new JButton("Logout");
		
		totalOrders.setSize(200, 20);
		totalOrders.setLocation(20, 420);
		
		totalRevenue.setSize(200, 20);
		totalRevenue.setLocation(200, 420);
		
		logoutBtn.setSize(180, 50);
		logoutBtn.setLocation(400, 410);
		logoutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to logout?", "Warning", dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					statisticsDlg.dispose();
				}
			}
		});
		
		statisticsDlg.add(totalOrders);
		statisticsDlg.add(totalRevenue);
		statisticsDlg.add(logoutBtn);
		
		statisticsDlg.setSize(600, 500);
	}
	
}



