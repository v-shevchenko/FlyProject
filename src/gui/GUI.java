package gui;

import DB.FlightDAO;
import bean.Flight;
import net.miginfocom.swing.MigLayout;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI{

    public static void jfrm(){

        JFrame frame = new JFrame("Fly Project by Vladimir Shevchenko");
        JButton arrivals = new JButton("Arrivals");
        JButton departures = new JButton("Departures");
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Flight_status");
        model.addColumn("Flight_type");
        model.addColumn("Flight_number");
        model.addColumn("City");
        model.addColumn("Terminal");
        model.addColumn("Gate");
        model.addColumn("Departure_time");

        FlightDAO flightDAO = new FlightDAO();
        List<Flight> flightTable1 = flightDAO.getFlightByStatus("ARRIVAL");
        for (int i = 0; i < flightTable1.size(); i++) {
            model.addRow(new Object[]{flightTable1.get(i).getFlightStatus(), flightTable1.get(i).getFlightType(), flightTable1.get(i).getFlightNumber(), flightTable1.get(i).getCity(),
                    flightTable1.get(i).getTerminal(), flightTable1.get(i).getGate(), flightTable1.get(i).getDepartureTime()});
        }

        /*Object[] headers = {"Fly", "Flight status", "Flight number", "City", "Terminal", "Gate", "Time"};
        List<Flight> dateTable = FlightDAO.getFlightByStatus("ARRIVAL");*/

        /*final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("Arrivals", new JPanel());
        tabbedPane.add("Departures", new JPanel());


        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());

        JPanel buttons = new JPanel();
        content.add(buttons, BorderLayout.NORTH);*/

        JTable tableFlight = new JTable(model);
        //tableFlight.isCellEditable(0,0);
        //frame.getContentPane().setLayout(new MigLayout());
        frame.setSize(800, 860);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tableFlight = new JTable(model);
        //JScrollPane jScrollPane = new JScrollPane(tableFlight);
        //tableFlight.setPreferredScrollableViewportSize(new Dimension(750, 800));
        //frame.getContentPane().add(jScrollPane);
        //tableFlight.getAutoResizeMode();

        frame.setSize(800, 600);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        JPanel panel = new JPanel(new MigLayout());
        //frame.pack();
        //frame.add(panel);
        //buttons.add(arrivals);
        //buttons.add(departures);
        //frame.add(buttons);
        //frame.add(content);
        //content.add(tabbedPane, BorderLayout.CENTER);
        //getContentPane().add(content);

        //panel.add(arrivals);
        //panel.add(departures, "wrap");
        //panel.add(tableFlight);
        frame.setVisible(true);

        /* JFrame frame = new JFrame("Fly Project by Vladimir Shevchenko");
        frame.setContentPane().setLayout(new MigLayout());

        JButton arrivals = new JButton("Arrivals");
        JButton departures = new JButton("Departures");
        JPanel panel = new JPanel(new MigLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.add(arrivals);
        panel.add(departures);*/



    }

}

/*public static void jfrm(){
        JFrame frame = new JFrame("Fly Project by Vladimir Shevchenko");
        JButton arrivals = new JButton("Arrivals");
        JButton departures = new JButton("Departures");
        final DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Flight_status");
        model.addColumn("Flight_type");
        model.addColumn("Flight_number");
        model.addColumn("City");
        model.addColumn("Terminal");
        model.addColumn("Gate");
        model.addColumn("Departure_time");

        FlightDAO flightDAO = new FlightDAO();
        List<Flight> flightTable1 = flightDAO.getFlightByStatus("ARRIVAL");
        for (int i = 0; i < flightTable1.size(); i++) {
            model.addRow(new Object[]{flightTable1.get(i).getFlightStatus(), flightTable1.get(i).getFlightType(), flightTable1.get(i).getFlightNumber(), flightTable1.get(i).getCity(),
                    flightTable1.get(i).getTerminal(), flightTable1.get(i).getGate(), flightTable1.get(i).getDepartureTime()});
        }

        Object[] headers = {"Fly", "Flight status", "Flight number", "City", "Terminal", "Gate", "Time"};
        List<Flight> dateTable = FlightDAO.getFlightByStatus("ARRIVAL");

        JTable tableFlight;
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(800, 860);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tableFlight = new JTable(model);
        //JScrollPane jScrollPane = new JScrollPane(tableFlight);
        tableFlight.setPreferredScrollableViewportSize(new Dimension(750, 800));
        //frame.getContentPane().add(jScrollPane);
        //tableFlight.getAutoResizeMode();

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.add(arrivals);
        panel.add(departures);
        panel.add(tableFlight);
        frame.setVisible(true);

    }*/
