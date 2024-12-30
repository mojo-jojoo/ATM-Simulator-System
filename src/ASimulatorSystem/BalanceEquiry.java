//package ASimulatorSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//class BalanceEnquiry extends JFrame implements ActionListener {
//
//    JButton b1;
//    JLabel l1;
//    String pin;
//
//    BalanceEnquiry(String pin) {
//        this.pin = pin;
//
//        // Background image setup
//        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image scaledImage = backgroundImage.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
//        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
//        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
//        backgroundLabel.setBounds(0, 0, 1200, 700);
//        add(backgroundLabel);
//
//        // Label for balance display
//        l1 = createLabel("", 220, 260, 400, 35);
//        backgroundLabel.add(l1);
//
//        // Back button
//        b1 = createButton("BACK", 440, 370, 150, 35);
//        backgroundLabel.add(b1);
//
//        // Fetching balance from database
//        int balance = fetchBalance(pin);
//        l1.setText("Your Current Account Balance is Rs " + balance);
//
//        // Action listener for back button
//        b1.addActionListener(this);
//
//        // Frame setup
//        setSize(1200, 700);
//        setLocationRelativeTo(null); // Center the frame
//        setUndecorated(true); // Remove window decorations (e.g., title bar)
//        setVisible(true);
//    }
//
//    // Helper method to create and style labels
//    private JLabel createLabel(String text, int x, int y, int width, int height) {
//        JLabel label = new JLabel(text);
//        label.setForeground(Color.WHITE);
//        label.setFont(new Font("Arial", Font.BOLD, 16));
//        label.setBounds(x, y, width, height);
//        return label;
//    }
//
//    // Helper method to create and style buttons
//    private JButton createButton(String text, int x, int y, int width, int height) {
//        JButton button = new JButton(text);
//        button.setFont(new Font("Arial", Font.BOLD, 18));
//        button.setBackground(new Color(59, 89, 182));
//        button.setForeground(Color.WHITE);
//        button.setFocusPainted(false);
//        button.setBounds(x, y, width, height);
//        return button;
//    }
//
//    // Method to fetch balance from database
//    private int fetchBalance(String pin) {
//        int balance = 0;
//        try {
//            Conn c1 = new Conn();
//            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
//            while (rs.next()) {
//                if (rs.getString("type").equals("Deposit")) {
//                    balance += Integer.parseInt(rs.getString("amount"));
//                } else {
//                    balance -= Integer.parseInt(rs.getString("amount"));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return balance;
//    }
//
//    // ActionListener method to handle button clicks
//    public void actionPerformed(ActionEvent ae) {
//        setVisible(false);
//        new Transactions(pin).setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        new BalanceEnquiry("").setVisible(true);
//    }
//}
//
//
//
//
//
//





package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    String pin;

    // Constructor for BalanceEnquiry
    BalanceEnquiry(String pin) {
        this.pin = pin;

        // Background image setup
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, 1200, 700);
        add(backgroundLabel);

        // Label for balance display
        l1 = createLabel("", 220, 260, 400, 35);
        backgroundLabel.add(l1);

        // Back button
        b1 = createButton("BACK", 440, 370, 150, 35);
        backgroundLabel.add(b1);

        // Fetching balance from database
        int balance = fetchBalance(pin); // Fetch balance safely using a synchronized method
        l1.setText("Your Current Account Balance is Rs " + balance);

        // Action listener for back button
        b1.addActionListener(this);

        // Frame setup
        setSize(1200, 700);
        setLocationRelativeTo(null); // Center the frame
        setUndecorated(true); // Remove window decorations (e.g., title bar)
        setVisible(true);
    }

    // Helper method to create and style labels
    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(x, y, width, height);
        return label;
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

    // Synchronized method to fetch balance from database
    private synchronized int fetchBalance(String pin) {
        // Synchronization ensures thread-safe access to this method.
        // Only one thread can access this method at a time for a given BalanceEnquiry instance.
        int balance = 0;
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    // Main method to run the BalanceEnquiry class
    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
