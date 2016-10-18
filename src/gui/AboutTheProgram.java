package gui;

import javax.swing.*;
import java.awt.*;

public class AboutTheProgram {

    static String s = "Airport project for Brain Academy \r\nby Shevchenko Vladimir 2016";

    public static void aboutTheProgram() {
        JFrame frame = new JFrame("About Fly Project");
        JPanel panel = new JPanel();
        JLabel label = new JLabel(s, JLabel.CENTER);
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);


        frame.add(panel, BorderLayout.CENTER);
        panel.add(label, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 200);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
