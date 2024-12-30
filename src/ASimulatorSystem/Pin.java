package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {

    JPasswordField t1, t2;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String pin;

    Pin(String pin) {
        this.pin = pin;

        // Background image setup
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, 1200, 700);
        add(backgroundLabel);

        // Labels
        l1 = createLabel("CHANGE YOUR PIN", 330, 220, 800, 35);
        l2 = createLabel("New PIN:", 230, 280, 150, 35);
        l3 = createLabel("Re-Enter New PIN:", 230, 330, 200, 35);

        // Password fields
        t1 = createPasswordField(400, 280, 180, 25);
        t2 = createPasswordField(400, 330, 180, 25);

        // Buttons
        b1 = createButton("CHANGE", 270, 380, 150, 35);
        b2 = createButton("BACK", 480, 380, 150, 35);

        // Action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Adding components to the background label
        backgroundLabel.add(l1);
        backgroundLabel.add(l2);
        backgroundLabel.add(l3);
        backgroundLabel.add(t1);
        backgroundLabel.add(t2);
        backgroundLabel.add(b1);
        backgroundLabel.add(b2);

        // Frame setup
        setSize(1200, 700);
        setLocationRelativeTo(null); // Center the frame
        setUndecorated(true); // Remove window decorations (e.g., title bar)
        setVisible(true);
    }

    // Helper method to create and style labels
    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        label.setBounds(x, y, width, height);
        return label;
    }

    // Helper method to create and style password fields
    private JPasswordField createPasswordField(int x, int y, int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Raleway", Font.BOLD, 25));
        passwordField.setBounds(x, y, width, height);
        return passwordField;
    }

    // Helper method to create and style buttons
    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(59, 89, 182));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBounds(x, y, width, height);
        return button;
    }

    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = new String(t1.getPassword());
            String rpin = new String(t2.getPassword());


            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (ae.getSource() == b1) {
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter New PIN");
                    return;
                }

                Conn c1 = new Conn();
                String q1 = "update bank set pin = '" + rpin + "' where pin = '" + pin + "' ";
                String q2 = "update login set pin = '" + rpin + "' where pin = '" + pin + "' ";
                String q3 = "update signupthree set pin = '" + rpin + "' where pin = '" + pin + "' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } else if (ae.getSource() == b2) {
                new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Pin("").setVisible(true);
    }
}



