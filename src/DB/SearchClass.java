package DB;

import bean.Passenger;
import gui.MainWindowAdmin;
import gui.MyDefaultTableModel;
import gui.SearchFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SearchClass {

private String firstNameItem;

    @Override
    public String toString() {
        return "SearchClass{" +
                "firstNameItem='" + firstNameItem + '\'' +
                '}';
    }

    public String getFirstNameItem() {
        return firstNameItem;
    }

    public void setFirstNameItem(String firstNameItem) {
        this.firstNameItem = firstNameItem;
    }
}
