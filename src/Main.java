import DB.FlightDAO;
import DB.PassengerDAO;
import bean.Flight;
import bean.Passenger;
import gui.GUI;
import gui.MainWindow;
import gui.MainWindowAdmin;

import javax.swing.*;
import java.nio.charset.MalformedInputException;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                MainWindow mainWindow = new MainWindow();
                //MainWindowAdmin mainWindowAdmin = new MainWindowAdmin();

            }
        });


    }
}
