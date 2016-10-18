package gui;

import DB.PassengerDAO;
import DB.SearchClass;
import bean.Passenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class SearchFrame extends JFrame {

    public SearchFrame() {
        super("Search");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton searchButton = new JButton("Search");
        JButton cancel = new JButton("Cancel");

        String[] items ={"Flight number", "First name", "Second name"};
        JComboBox comboBox = new JComboBox(items);


        JPanel panel = new JPanel(new MigLayout());

        JLabel label = new JLabel("Select search options:  ");
        JLabel label2 = new JLabel("Enter search:");

        JTextField searchText = new JTextField();

        //String textItem = searchText.getText();
        SearchClass searchClass = new SearchClass();



        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) comboBox.getSelectedItem();
                switch (selectedItem){
                    case "Flight number":
                        System.out.println("Flight number");
                        System.out.println(searchText.getText());
                        break;
                    case "First name":

                        searchClass.setFirstNameItem(searchText.getText());
                        System.out.println(searchClass.getFirstNameItem());
                        break;
                    case "Second name":
                        System.out.println("Second name");
                        break;
                    default:
                        System.out.println("Error");

                }

                //setVisible(false);

               // System.out.println(selectedItem);
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println(searchClass.getFirstNameItem());
                //setVisible(false);
            }
        });



        add(panel);
        panel.add(label);
        panel.add(comboBox,       "wrap");
        panel.add(label2);
        panel.add(searchText,    "span, grow");
        panel.add(searchButton);
        panel.add(cancel);

        //setPreferredSize(new Dimension(360, 300));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }


}
