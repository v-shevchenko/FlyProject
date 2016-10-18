package gui;

import DB.FlightDAO;
import DB.PassengerDAO;
import DB.SearchClass;
import bean.Flight;
import bean.Passenger;
import bean.enums.FlightNumberEnum;
import bean.enums.Sex;
import bean.enums.TicketClass;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainWindowAdmin extends JFrame {
    SearchClass searchClass = new SearchClass();





    public MainWindowAdmin() {

        super("Fly Project by Vladimir Shevchenko - Administration mode");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        buttons.setLayout(new BorderLayout());
        content.add(buttons, BorderLayout.NORTH);

        Font font = new Font("Calibri", Font.PLAIN, 18);
        JButton logoutButton = new JButton("Logout");
        JButton searchButton = new JButton("Search");
        JMenuBar menuBar = new JMenuBar();
        buttons.add(logoutButton, BorderLayout.AFTER_LINE_ENDS);
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



        DefaultTableModel arrivalModel = new DefaultTableModel();
        arrivalModel.addColumn("Flight status");
        arrivalModel.addColumn("Flight type");
        arrivalModel.addColumn("Flight number");
        arrivalModel.addColumn("City");
        arrivalModel.addColumn("Terminal");
        arrivalModel.addColumn("Gate");
        arrivalModel.addColumn("Departure time");

        DefaultTableModel departureModel = new DefaultTableModel();
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

        DefaultTableModel passengerMode  = new MyDefaultTableModel();
        passengerMode.addColumn("First name");
        passengerMode.addColumn("Last name");
        passengerMode.addColumn("Nationality");
        passengerMode.addColumn("Passport");
        passengerMode.addColumn("Date of birthday");
        passengerMode.addColumn("Ticket class");
        passengerMode.addColumn("Flight number");
        passengerMode.addColumn("Sex");

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

        PassengerDAO passengerDAO = new PassengerDAO();
        List<Passenger> passengerListe = passengerDAO.getPassengers();
        for (int i = 0; i < passengerListe.size(); i++) {
            passengerMode.addRow(new Object[]{passengerListe.get(i).getFirstName(), passengerListe.get(i).getLastName(), passengerListe.get(i).getNationality(), passengerListe.get(i).getPassport(),
                    passengerListe.get(i).getDateOfBirthday(), passengerListe.get(i).getTicketClass(), passengerListe.get(i).getFlightNumber(), passengerListe.get(i).getSex()});
            }


        DefaultTableModel passengerSearchModel  = new MyDefaultTableModel();
        passengerSearchModel.addColumn("First name");
        passengerSearchModel.addColumn("Last name");
        passengerSearchModel.addColumn("Nationality");
        passengerSearchModel.addColumn("Passport");
        passengerSearchModel.addColumn("Date of birthday");
        passengerSearchModel.addColumn("Ticket class");
        passengerSearchModel.addColumn("Flight number");
        passengerSearchModel.addColumn("Sex");


        JTable tableFlight = new JTable(arrivalModel);
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(arrivalModel);
        tableFlight.setRowSorter(sorter);

        JTable departureTable = new JTable(departureModel);
        JTable priceTable = new JTable(priceModel);
        JTable passengerTable = new JTable(passengerMode);
        final TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(passengerMode);
        passengerTable.setRowSorter(sorter2);
        JTable searchTable = new JTable(passengerSearchModel);
        final TableRowSorter<TableModel> sorter1 = new TableRowSorter<TableModel>(passengerSearchModel);
        searchTable.setRowSorter(sorter1);


        JTextField searchTextFild = new JTextField();

        JPanel searchALL = new JPanel(new BorderLayout());
        JPanel searchContent = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new BorderLayout());

        JButton addPassengerButton = new JButton("Add passenger");

        JPanel addPassengerPanel = new JPanel(new MigLayout());
        JLabel firstNameLabel = new JLabel("First name");
        JLabel lastNameLabel = new JLabel("Last name");
        JLabel nationalityLabel = new JLabel("Nationality");
        JLabel passportLabel = new JLabel("Passport");
        JLabel sexLabel = new JLabel("Sex");
        JLabel dateOfBirthdayLabel = new JLabel("Date of birthday");
        JLabel ticketClassLabel = new JLabel("Ticket class");
        JLabel flightNumberLabel = new JLabel("Flight number");
        JTextField firstNameTextField = new JTextField(8);
        JTextField lastNameTextField = new JTextField(8);
        JTextField nationalityTextField = new JTextField(8);
        JTextField passportTextField = new JTextField(8);
        JComboBox<Sex> sexJComboBox = new JComboBox<>(Sex.values());
        JTextField dateOfBirthdayTextField = new JTextField(8);
        JComboBox<TicketClass> ticketClassJComboBox = new JComboBox<>(TicketClass.values());
        JComboBox<FlightNumberEnum> flightNumberEnumJComboBox = new JComboBox<>(FlightNumberEnum.values());

        addPassengerPanel.add(firstNameLabel, "cell 0 0");
        addPassengerPanel.add(lastNameLabel, "cell 1 0");
        addPassengerPanel.add(nationalityLabel, "cell 2 0");
        addPassengerPanel.add(passportLabel, "cell 3 0");
        addPassengerPanel.add(sexLabel, "cell 4 0");
        addPassengerPanel.add(dateOfBirthdayLabel, "cell 5 0");
        addPassengerPanel.add(ticketClassLabel, "cell 6 0");
        addPassengerPanel.add(flightNumberLabel, "cell 7 0");
        addPassengerPanel.add(firstNameTextField, "cell 0 1");
        addPassengerPanel.add(lastNameTextField, "cell 1 1");
        addPassengerPanel.add(nationalityTextField, "cell 2 1");
        addPassengerPanel.add(passportTextField, "cell 3 1");
        addPassengerPanel.add(sexJComboBox, "cell 4 1");
        addPassengerPanel.add(dateOfBirthdayTextField, "cell 5 1");
        addPassengerPanel.add(ticketClassJComboBox, "cell 6 1");
        addPassengerPanel.add(flightNumberEnumJComboBox, "cell 7 1");
        addPassengerPanel.add(addPassengerButton, "cell 0 2 2");

        addPassengerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int flightNumberID = flightNumberEnumJComboBox.getSelectedIndex()+1;

                passengerDAO.addPassenger(firstNameTextField, lastNameTextField, nationalityTextField, passportTextField, sexJComboBox, dateOfBirthdayTextField, ticketClassJComboBox, flightNumberID);

                JOptionPane.showMessageDialog(MainWindowAdmin.this, "Passenger successfully added.",
                        "Successfully",
                        JOptionPane.INFORMATION_MESSAGE);
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                nationalityTextField.setText("");
                dateOfBirthdayTextField.setText("");
                passportTextField.setText("");

            }
        });

        DefaultTableModel deletePassengerModel = new MyDefaultTableModel();
        deletePassengerModel.addColumn("First name");
        deletePassengerModel.addColumn("Last name");
        deletePassengerModel.addColumn("Nationality");
        deletePassengerModel.addColumn("Passport");
        deletePassengerModel.addColumn("Date of birthday");
        deletePassengerModel.addColumn("Ticket class");
        deletePassengerModel.addColumn("Flight number");
        deletePassengerModel.addColumn("Sex");
        List<Passenger> passengerListeDelete = passengerDAO.getPassengers();
        for (int i = 0; i < passengerListeDelete.size(); i++) {
            deletePassengerModel.addRow(new Object[]{passengerListeDelete.get(i).getFirstName(), passengerListeDelete.get(i).getLastName(), passengerListeDelete.get(i).getNationality(), passengerListeDelete.get(i).getPassport(),
                    passengerListeDelete.get(i).getDateOfBirthday(), passengerListeDelete.get(i).getTicketClass(), passengerListeDelete.get(i).getFlightNumber(), passengerListeDelete.get(i).getSex()});
        }
        JTable deleteTable = new JTable(deletePassengerModel);
        JButton deleteTableButton = new JButton("Delete");
        JPanel deletePanel = new JPanel(new BorderLayout());
        JPanel deleteTablePanel = new JPanel(new BorderLayout());
        JPanel deleteButtonPanel = new JPanel(new BorderLayout());
        deleteButtonPanel.add(deleteTableButton, BorderLayout.BEFORE_LINE_BEGINS);
        deletePanel.add(deleteButtonPanel, BorderLayout.NORTH);
        deleteTablePanel.add(new JScrollPane(deleteTable));
        deletePanel.add(deleteTablePanel);






        deleteTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //deletePassengerModel.l
            }
        });




        searchContent.add(new JScrollPane(searchTable));
        searchPanel.add(searchButton, BorderLayout.BEFORE_LINE_BEGINS);
        searchPanel.add(searchTextFild);
        searchALL.add(searchPanel, BorderLayout.NORTH);
        searchALL.add(searchContent);
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Arrivals", new JScrollPane(tableFlight));
        tabbedPane.add("Departures", new JScrollPane(departureTable));
        tabbedPane.add("Price", new JScrollPane(priceTable));
        tabbedPane.add("Passenger", new JScrollPane(passengerTable));
        tabbedPane.add("Search", new JScrollPane(searchALL));
        tabbedPane.add("Add passenger", new JScrollPane(addPassengerPanel));
        tabbedPane.add("Delete passenger", new JScrollPane(deletePanel));
        content.add(tabbedPane, BorderLayout.CENTER);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MainWindow mainWindow = new MainWindow();

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (passengerSearchModel.getRowCount() > 0) {
                    for (int i = passengerSearchModel.getRowCount() - 1; i > -1; i--) {
                        passengerSearchModel.removeRow(i);
                    }
                }

                List<Passenger> passengerSearchList = passengerDAO.getSearchPassengers(searchTextFild.getText());
                for (int i = 0; i < passengerSearchList.size(); i++) {
                    passengerSearchModel.addRow(new Object[]{passengerSearchList.get(i).getFirstName(), passengerSearchList.get(i).getLastName(), passengerSearchList.get(i).getNationality(), passengerSearchList.get(i).getPassport(),
                            passengerSearchList.get(i).getDateOfBirthday(), passengerSearchList.get(i).getTicketClass(), passengerSearchList.get(i).getFlightNumber(), passengerSearchList.get(i).getSex()});
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
