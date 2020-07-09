package GUI;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.*;

public class WorkersGUI {

	public static JDialog workersGUI;
	public static JList workersList;
	public static int currentIndex = -1;
	final static DefaultListModel workers = new DefaultListModel();
	
	public static JDialog getDialog() {
		return workersGUI;
	}
	
	public static void setSettings() {
		
		workersGUI = new JDialog();
		workersGUI.setLayout(null);
		workersGUI.setTitle("Workers");
		
		JButton jBtnAddWorker = new JButton("Add Worker");
		JButton jBtnDelWorker = new JButton("Delete Worker");
		
		jBtnAddWorker.setSize(300, 75);
		jBtnAddWorker.setLocation(0, 350);
		jBtnAddWorker.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	JDialog addWorkerDlg = new JDialog();
		    	addWorkerDlg.setSize(300, 150);
		    	addWorkerDlg.setLayout(new GridLayout(4, 2));
		    	
		    	JLabel fullNameLbl = new JLabel("Full Name:");
		    	JTextField fullNameTxt = new JTextField();
		    	
		    	JLabel phoneLbl = new JLabel("Phone:");
		    	JTextField phoneTxt = new JTextField();
		    	
		    	JLabel emailLbl = new JLabel("Email:");
		    	JTextField emailTxt = new JTextField();
		    	
		    	addWorkerDlg.add(fullNameLbl);
		    	addWorkerDlg.add(fullNameTxt);
		    	
		    	addWorkerDlg.add(phoneLbl);
		    	addWorkerDlg.add(phoneTxt);
		    	
		    	addWorkerDlg.add(emailLbl);
		    	addWorkerDlg.add(emailTxt);
		    	
		    	JButton addBtn = new JButton("Add");
		    	addBtn.addActionListener(new ActionListener() {
		    		@Override
		    		public void actionPerformed(ActionEvent e) {
		    			String fullName = fullNameTxt.getText();
		    			String email = emailTxt.getText();
		    			String phone = phoneTxt.getText();
		    			if(fullName.matches(".*\\d.*")) {
		    				JOptionPane.showMessageDialog(addWorkerDlg, "Error: Name cannot contain numbers.");
		    			} else if(!email.contains("@")) {
		    				JOptionPane.showMessageDialog(addWorkerDlg, "Error: Email is not in correct format.");
		    			} else if(phone.length() < 10) {
		    				JOptionPane.showMessageDialog(addWorkerDlg, "Error: Phone must be atleast 10 digits.");
		    			} else {
		    				workers.addElement(fullName + " | " + email + " | " + phone);
			    			Barbershop.addElement(Worker.class, new Worker(fullName, phone, email));
			    			addWorkerDlg.dispose();
		    			}
		    		}
		    	});
		    	
		    	addWorkerDlg.add(addBtn);
		    	
		    	addWorkerDlg.setVisible(true);
		    }
		});
		
		workersList = new JList(workers);
		
		workersList.setSize(600, 350);
		workersList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					currentIndex = workersList.getSelectedIndex();
				}
			}
		});
		
		workersGUI.add(jBtnAddWorker);
		
		jBtnDelWorker.setSize(300, 75);
		jBtnDelWorker.setLocation(300, 350);
		jBtnDelWorker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel model = (DefaultListModel) workersList.getModel();
				
				if (currentIndex != -1) {
					Barbershop.removeElement(Worker.class, currentIndex);
					model.remove(currentIndex);
				}
			}
		});
		workersGUI.add(jBtnDelWorker);
		
		workers.clear();
		for(int i = 0; i < Barbershop.getListOfWorkers().size(); i++) {
			String[] split = Barbershop.getListOfWorkers().get(i).toString().split(":");
			workers.addElement(split[0] + " | " + split[1] + " | " + split[2]);
		}
		
		workersGUI.add(workersList);
		workersGUI.setSize(600, 450);
	}
}