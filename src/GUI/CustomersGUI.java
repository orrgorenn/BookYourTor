package GUI;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.*;

public class CustomersGUI {

	public static JDialog customersGUI;
	public static JList customersList;
	public static int currentIndex = -1;
	final static DefaultListModel customers = new DefaultListModel();
	
	public static JDialog getDialog() {
		return customersGUI;
	}
	
	public static void setSettings() {
		
		customersGUI = new JDialog();
		customersGUI.setLayout(null);
		customersGUI.setTitle("Customer");
		
		JButton jBtnAddCustomer = new JButton("Add Customer");
		JButton jBtnDelCustomer = new JButton("Delete Customer");
		
		jBtnAddCustomer.setSize(300, 75);
		jBtnAddCustomer.setLocation(0, 350);
		jBtnAddCustomer.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	JDialog addCustomerDlg = new JDialog();
		    	addCustomerDlg.setSize(300, 150);
		    	addCustomerDlg.setLayout(new GridLayout(4, 2));
		    	
		    	JLabel fullNameLbl = new JLabel("Full Name:");
		    	JTextField fullNameTxt = new JTextField();
		    	
		    	JLabel phoneLbl = new JLabel("Phone:");
		    	JTextField phoneTxt = new JTextField();
		    	
		    	JLabel emailLbl = new JLabel("Email:");
		    	JTextField emailTxt = new JTextField();
		    	
		    	addCustomerDlg.add(fullNameLbl);
		    	addCustomerDlg.add(fullNameTxt);
		    	
		    	addCustomerDlg.add(phoneLbl);
		    	addCustomerDlg.add(phoneTxt);
		    	
		    	addCustomerDlg.add(emailLbl);
		    	addCustomerDlg.add(emailTxt);
		    	
		    	JButton addBtn = new JButton("Add");
		    	addBtn.addActionListener(new ActionListener() {
		    		@Override
		    		public void actionPerformed(ActionEvent e) {
		    			String fullName = fullNameTxt.getText();
		    			String email = emailTxt.getText();
		    			String phone = phoneTxt.getText();
		    			if(fullName.matches(".*\\d.*")) {
		    				JOptionPane.showMessageDialog(addCustomerDlg, "Error: Name cannot contain numbers.");
		    			} else if(!email.contains("@")) {
		    				JOptionPane.showMessageDialog(addCustomerDlg, "Error: Email is not in correct format.");
		    			} else if(phone.length() < 10) {
		    				JOptionPane.showMessageDialog(addCustomerDlg, "Error: Phone must be atleast 10 digits.");
		    			} else {
		    				customers.addElement(fullName + " | " + phone + " | " + email);
			    			Barbershop.addElement(Customer.class, new Customer(fullName, phone, email));
			    			addCustomerDlg.dispose();
		    			}
		    		}
		    	});
		    	
		    	addCustomerDlg.add(addBtn);
		    	
		    	addCustomerDlg.setVisible(true);
		    }
		});
		
		customersList = new JList(customers);
		
		customersList.setSize(600, 350);
		customersList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					currentIndex = customersList.getSelectedIndex();
				}
			}
		});
		
		customersGUI.add(jBtnAddCustomer);
		
		jBtnDelCustomer.setSize(300, 75);
		jBtnDelCustomer.setLocation(300, 350);
		jBtnDelCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel model = (DefaultListModel) customersList.getModel();
				
				if (currentIndex != -1) {
					Barbershop.removeElement(Customer.class, currentIndex);
					model.remove(currentIndex);
				}
			}
		});
		customersGUI.add(jBtnDelCustomer);
		
		customers.clear();
		for(int i = 0; i < Barbershop.getListOfCustomers().size(); i++) {
			String[] split = Barbershop.getListOfCustomers().get(i).toString().split(":");
			customers.addElement(split[0] + " | " + split[1] + " | " + split[2]);
		}
		
		customersGUI.add(customersList);
		customersGUI.setSize(600, 450);
	}
}