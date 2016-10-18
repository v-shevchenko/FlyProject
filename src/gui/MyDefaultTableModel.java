package gui;

import javax.swing.table.DefaultTableModel;

public class MyDefaultTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
}
