package gui;

import DB.Users;
import jdk.internal.org.objectweb.asm.tree.analysis.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JDialog {

    private JTextField loginField;
    private JPasswordField passwordField;

    private boolean succeeded;

    public LoginFrame(Frame parent) {
        super(parent, "Login", true);
        //JFrame frame = new JFrame("Sign in");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);

        Box box2 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        box2.add(passwordLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(passwordField);

        Box box3 = Box.createHorizontalBox();
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(Users.authenticate(getUsername(), getPassword())){
                    JOptionPane.showMessageDialog(LoginFrame.this, "Hi " + getUsername() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    loginField.setText("");
                    passwordField.setText("");
                    succeeded = false;
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        box3.add(Box.createHorizontalGlue());
        box3.add(login);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(cancel);

        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);

        pack();


        setLocationRelativeTo(parent);
        setResizable(false);

    }



    public String getUsername(){
        return loginField.getText().trim();
    }
    public String getPassword(){
        return new String(passwordField.getPassword());
    }
    public boolean isSucceeded(){
        return succeeded;
    }

}
