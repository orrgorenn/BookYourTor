package GUI;
import java.awt.GridLayout;
import java.awt.event.*;
import Backend.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ServicesGUI {
    public static JDialog servicesDlg;
    public static JList servicesList;
    public static int currentIndex = -1;
    final static DefaultListModel services = new DefaultListModel();

    public static JDialog getDialog(){
        return servicesDlg;
    }

    public static void setSetting(){
        servicesDlg = new JDialog();
        servicesDlg.setLayout(null);
        servicesDlg.setTitle("Services");

        JButton addService = new JButton("Add Service");
        addService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addServiceDlg = new JDialog();
                addServiceDlg.setSize(300, 150);
                addServiceDlg.setLayout(new GridLayout(4, 2));

                JLabel serviceNameLbl = new JLabel("Service Name:");
                JTextField serviceNameTxt = new JTextField();

                JLabel serviceDurationLbl = new JLabel("Service Duration:");
                JTextField serviceDurationTxt = new JTextField();

                JLabel priceLbl = new JLabel("Price:");
                JTextField priceTxt = new JTextField();

                addServiceDlg.add(serviceNameLbl, 0, 0);
                addServiceDlg.add(serviceNameTxt, 0, 1);

                addServiceDlg.add(serviceDurationLbl);
                addServiceDlg.add(serviceDurationTxt);

                addServiceDlg.add(priceLbl);
                addServiceDlg.add(priceTxt);

                JButton addBtn = new JButton("Add");
                addBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String serviceName = serviceNameTxt.getText();
                        String serviceDuration = serviceDurationTxt.getText();
                        String servicePrice = priceTxt.getText();
                        if (serviceName.matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(addServiceDlg, "Error: Name cannot contain numbers.");
                        } else {
                        	double priceDbl = 0;
                        	double durationDbl = 0;
                        	boolean error = false;
                        	try {
                        		priceDbl = Double.parseDouble(servicePrice);
                        	} catch(NumberFormatException er) {
                        		JOptionPane.showMessageDialog(addServiceDlg, "Error: Price not in correct format. (only numbers or decimal)");
                        		error = true;
                        	}
                        	try {
                        		durationDbl = Double.parseDouble(serviceDuration);
                        	} catch(NumberFormatException er) {
                        		JOptionPane.showMessageDialog(addServiceDlg, "Error: Duration not in correct format. (only numbers or decimal)");
                        		error = true;
                        	}
                        	if(!error) {
	                            String serviceLine = "";
	                            serviceLine += serviceName + " | Price: " + servicePrice + " ILS | Duration: " + serviceDuration + " hrs.";
	                            services.addElement(serviceLine);
	                            Barbershop.addElement(Service.class, new Service(serviceName, priceDbl, durationDbl));
	                            addServiceDlg.dispose();
                        	}
                        }
                    }
                });

                addServiceDlg.add(addBtn);
                addServiceDlg.setVisible(true);
            }
        });

        JButton delService = new JButton("Delete Service");
        delService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel model = (DefaultListModel) servicesList.getModel();

                if (currentIndex != -1) {
                    Barbershop.removeElement(Service.class, currentIndex);
                    model.remove(currentIndex);
                }
            }
        });

        servicesList = new JList(services);

        servicesList.setSize(600, 350);
        servicesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    currentIndex = servicesList.getSelectedIndex();
                }
            }
        });
        
        addService.setSize(300, 75);
        addService.setLocation(0, 350);

        delService.setSize(300, 75);
        delService.setLocation(300, 350);

        services.clear();
        for(int i = 0; i < Barbershop.getListOfServices().size(); i++) {
            String[] split = Barbershop.getListOfServices().get(i).toString().split(":");
            services.addElement(split[0] + " | Price: " + split[1] + " ILS | Duration: " + split[2] + " hrs.");
        }

        servicesDlg.add(servicesList);
        servicesDlg.add(addService);
        servicesDlg.add(delService);

        servicesDlg.setSize(600, 450);
    }
}
