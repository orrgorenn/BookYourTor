package GUI;

import java.awt.GridLayout;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Backend.*;

public class AppointmentsGUI {

	public static JDialog appointmentsGUI;
	public static JList appointmentsList;
	public static int currentIndex = -1;
	final static DefaultListModel appointments = new DefaultListModel();
	private static String customerName;
	private static String serviceName;
	private static String workerName;
	private static int[] indexes = new int[3];
	
	public static JDialog getDialog() {
		return appointmentsGUI;
	}
	
	public static void setSettings() {
		
		appointmentsGUI = new JDialog();
		appointmentsGUI.setLayout(null);
		appointmentsGUI.setTitle("Appointments");
		
		JButton jBtnAddAppointment = new JButton("Add Appointment");
		JButton jBtnDelAppointment = new JButton("Delete Appointment");
		
		jBtnAddAppointment.setSize(300, 75);
		jBtnAddAppointment.setLocation(0, 350);
		jBtnAddAppointment.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	JDialog addAppointmentDlg = new JDialog();
		    	addAppointmentDlg.setSize(300, 200);
		    	addAppointmentDlg.setLayout(new GridLayout(6, 2));
		    	
		    	JLabel customerLbl = new JLabel("Customer:");
		    	String[] customerNameList = new String[Barbershop.getListOfCustomers().size()];
		    	for(int i = 0; i < Barbershop.getListOfCustomers().size(); i++) {
		    		if(i == 0) {
		    			customerName = Barbershop.getListOfCustomers().get(i).getFullName();
		    			indexes[0] = i;
		    		}
		    		customerNameList[i] = Barbershop.getListOfCustomers().get(i).getFullName();
		    	}
		    	JComboBox customerSelection = new JComboBox(customerNameList);
		    	customerSelection.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							customerName = e.getItem().toString();
							indexes[0] = customerSelection.getSelectedIndex();
						}
					}
				});
		    	
		    	addAppointmentDlg.add(customerLbl);
		    	addAppointmentDlg.add(customerSelection);
		    	
		    	JLabel serviceLbl = new JLabel("Service:");
		    	String[] serviceNameList = new String[Barbershop.getListOfServices().size()];
		    	for(int i = 0; i < Barbershop.getListOfServices().size(); i++) {
		    		if(i == 0) {
		    			serviceName = Barbershop.getListOfServices().get(i).getName();
		    			indexes[1] = i;
		    		}
		    		serviceNameList[i] = Barbershop.getListOfServices().get(i).getName();
		    	}
		    	JComboBox serviceSelection = new JComboBox(serviceNameList);
		    	serviceSelection.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							serviceName = e.getItem().toString();
							indexes[1] = serviceSelection.getSelectedIndex();
						}
					}
				});
		    	
		    	addAppointmentDlg.add(serviceLbl);
		    	addAppointmentDlg.add(serviceSelection);
		    	
		    	JLabel workerLbl = new JLabel("Worker:");
		    	String[] workerNameList = new String[Barbershop.getListOfWorkers().size()];
		    	for(int i = 0; i < Barbershop.getListOfWorkers().size(); i++) {
		    		if(i == 0) {
		    			workerName = Barbershop.getListOfWorkers().get(i).getFullName();
		    			indexes[2] = i;
		    		}
		    		workerNameList[i] = Barbershop.getListOfWorkers().get(i).getFullName();
		    	}
		    	JComboBox workerSelection = new JComboBox(workerNameList);
		    	workerSelection.addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						if (e.getStateChange() == ItemEvent.SELECTED) {
							workerName = e.getItem().toString();
							indexes[2] = workerSelection.getSelectedIndex();
							System.out.println(indexes[2]);
						}
					}
		    		
				});
		    	
		    	addAppointmentDlg.add(workerLbl);
		    	addAppointmentDlg.add(workerSelection);
		    	
		    	JLabel timeLbl = new JLabel("Time:");
		    	JSpinner timeSpinner = new javax.swing.JSpinner();
		    	SpinnerDateModel spinnermodel = new SpinnerDateModel();
		    	spinnermodel.setCalendarField(Calendar.MINUTE);
		    	timeSpinner.setModel(spinnermodel);
		    	timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner , "HH:mm"));
		    	
		    	addAppointmentDlg.add(timeLbl);
		    	addAppointmentDlg.add(timeSpinner);
		    	
		    	JLabel dateLbl = new JLabel("Date:");
		    	JSpinner dateSpinner = new javax.swing.JSpinner();
		    	SpinnerDateModel dateSpinnerModel = new SpinnerDateModel();
		    	dateSpinnerModel.setCalendarField(Calendar.MINUTE);
		    	dateSpinner.setModel(dateSpinnerModel);
		    	dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner , "dd-MM-yyyy"));
		    	
		    	addAppointmentDlg.add(dateLbl);
		    	addAppointmentDlg.add(dateSpinner);
		    	
		    	JButton addBtn = new JButton("Add");
		    	addBtn.addActionListener(new ActionListener() {
		    		@Override
		    		public void actionPerformed(ActionEvent e) {
		    			String date = dateSpinnerModel.getDate().toLocaleString();
		    			String[] split = date.split(",");
		    			String correctDate = split[0];
		    			String time = spinnermodel.getDate().toLocaleString();
		    			String[] split2 = time.split(",");
		    			String[] split3 = split2[1].split(":");
		    			String correctTime = split3[0] + ":" + split3[1];
		    			appointments.addElement(correctDate + " | " + correctTime + " - " + customerName + " >> " + serviceName + " @ " + workerName);
		    			Barbershop.addElement(Appointment.class, new Appointment(correctDate, correctTime, Barbershop.getListOfCustomers().get(indexes[0]), Barbershop.getListOfServices().get(indexes[1]), Barbershop.getListOfWorkers().get(indexes[2])));
		    			addAppointmentDlg.dispose();
		    		}
		    	});
		    	
		    	addAppointmentDlg.add(addBtn);
		    	addAppointmentDlg.setVisible(true);
		    }
		});
		
		appointmentsList = new JList(appointments);
		
		appointmentsList.setSize(600, 350);
		appointmentsList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					currentIndex = appointmentsList.getSelectedIndex();
				}
			}
		});
		
		appointmentsGUI.add(jBtnAddAppointment);
		
		jBtnDelAppointment.setSize(300, 75);
		jBtnDelAppointment.setLocation(300, 350);
		jBtnDelAppointment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel model = (DefaultListModel) appointmentsList.getModel();
				
				if (currentIndex != -1) {
					Barbershop.removeElement(Appointment.class, currentIndex);
					model.remove(currentIndex);
				}
			}
		});
		appointmentsGUI.add(jBtnDelAppointment);
		
		appointments.clear();
		for(int i = 0; i < Barbershop.getListOfAppointments().size(); i++) {
			String[] split = Barbershop.getListOfAppointments().get(i).toString().split("-");
			appointments.addElement(split[0] + " | " + split[1] + " - " + split[2] + " >> " + split[3] + " @ " + split[4]);
		}
		
		appointmentsGUI.add(appointmentsList);
		appointmentsGUI.setSize(600, 450);
	}
}