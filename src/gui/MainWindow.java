package gui;

import DB.FlightDAO;
import bean.Flight;
import javafx.application.Application;
import net.miginfocom.swing.MigLayout;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MainWindow extends JFrame {

    public MainWindow() {

        super("Fly Project by Vladimir Shevchenko");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        content.add(buttons, BorderLayout.NORTH);

        Font font = new Font("Calibri", Font.PLAIN, 18);
        JButton loginButton = new JButton("Login");
        JMenuBar menuBar = new JMenuBar();
        buttons.add(loginButton, BorderLayout.AFTER_LINE_ENDS);
        JLabel label = new JLabel("Flight information");
        label.setFont(font);
        buttons.add(label);

        getContentPane().add(content);

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        JMenuItem aboutTheProgram = new JMenuItem("About the program");
        helpMenu.add(aboutTheProgram);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        aboutTheProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutTheProgram run = new AboutTheProgram();
                run.aboutTheProgram();
            }
        });



        DefaultTableModel arrivalModel = new MyDefaultTableModel();
        arrivalModel.addColumn("Flight status");
        arrivalModel.addColumn("Flight type");
        arrivalModel.addColumn("Flight number");
        arrivalModel.addColumn("City");
        arrivalModel.addColumn("Terminal");
        arrivalModel.addColumn("Gate");
        arrivalModel.addColumn("Departure time");

        DefaultTableModel departureModel = new MyDefaultTableModel();
        departureModel.addColumn("Flight status");
        departureModel.addColumn("Flight type");
        departureModel.addColumn("Flight number");
        departureModel.addColumn("City");
        departureModel.addColumn("Terminal");
        departureModel.addColumn("Gate");
        departureModel.addColumn("Departure time");

        DefaultTableModel priceModel = new MyDefaultTableModel();
        priceModel.addColumn("Flight number");
        priceModel.addColumn("City");
        priceModel.addColumn("Economy $");
        priceModel.addColumn("Business $");

        FlightDAO flightDAO = new FlightDAO();
        List<Flight> flightTable1 = flightDAO.getFlightByStatus("ARRIVAL");
        for (int i = 0; i < flightTable1.size(); i++) {
            arrivalModel.addRow(new Object[]{flightTable1.get(i).getFlightStatus(), flightTable1.get(i).getFlightType(), flightTable1.get(i).getFlightNumber(), flightTable1.get(i).getCity(),
                    flightTable1.get(i).getTerminal(), flightTable1.get(i).getGate(), flightTable1.get(i).getDepartureTime()});
        }

        List<Flight> flightTable2 = flightDAO.getFlightByStatus("DEPARTURE");
        for (int i = 0; i < flightTable2.size(); i++) {
            departureModel.addRow(new Object[]{flightTable2.get(i).getFlightStatus(), flightTable2.get(i).getFlightType(), flightTable2.get(i).getFlightNumber(), flightTable2.get(i).getCity(),
                    flightTable2.get(i).getTerminal(), flightTable2.get(i).getGate(), flightTable2.get(i).getDepartureTime()});
        }

        List<Flight> flightPrice = flightDAO.getFlightPrice();
        for (int i = 0; i < flightPrice.size(); i++) {
            priceModel.addRow(new Object[]{flightPrice.get(i).getFlightNumber(), flightPrice.get(i).getCity(), flightPrice.get(i).getPriceEconomy(), flightPrice.get(i).getPriceBusiness()});
        }

        JTable tableFlight = new JTable(arrivalModel);
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(arrivalModel);
        tableFlight.setRowSorter(sorter);

        JTable departureTable = new JTable(departureModel);
        JTable priceTable = new JTable(priceModel);

        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Arrivals", new JScrollPane(tableFlight));
        tabbedPane.add("Departures", new JScrollPane(departureTable));
        tabbedPane.add("Price", new JScrollPane(priceTable));
        content.add(tabbedPane, BorderLayout.CENTER);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginFrame loginFrame = new LoginFrame(MainWindow.this);
                loginFrame.setVisible(true);
                if(loginFrame.isSucceeded()){
                    MainWindowAdmin mainWindowAdmin = new MainWindowAdmin();
                    setVisible(false);

                }

            }
        });



        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
        setPreferredSize(new Dimension(800, 600));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
