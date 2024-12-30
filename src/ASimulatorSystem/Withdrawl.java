//main code ha 
//package ASimulatorSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.util.Date;
//import java.sql.*;
//
//public class Withdrawl extends JFrame implements ActionListener {
//
//    JTextField t1;
//    JButton b1, b2;
//    JLabel l1, l2, backgroundLabel;
//    String pin;
//
//    Withdrawl(String pin) {
//        this.pin = pin;
//
//        // Background image
//        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
//        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
//        backgroundLabel = new JLabel(scaledBackgroundIcon);
//        backgroundLabel.setBounds(0, 0, 1200, 700);
//        add(backgroundLabel);
//
//        // Setting up labels with custom fonts and colors
//        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.50,000");
//        l1.setForeground(Color.BLACK);
//        l1.setFont(new Font("Arial", Font.BOLD, 20));
//        l1.setBounds(270, 180, 400, 28);
//        backgroundLabel.add(l1);
//
//        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
//        l2.setForeground(Color.WHITE);
//        l2.setFont(new Font("Arial", Font.BOLD, 20));
//        l2.setBounds(270, 230, 400, 30);
//        backgroundLabel.add(l2);
//
//        // Text field for amount input
//        t1 = new JTextField();
//        t1.setFont(new Font("Arial", Font.BOLD, 25));
//        t1.setBounds(250, 280, 400, 40);
//        backgroundLabel.add(t1);
//
//        // Buttons
//        b1 = createButton("WITHDRAW", 260, 350);
//        b2 = createButton("BACK", 470, 350);
//        backgroundLabel.add(b1);
//        backgroundLabel.add(b2);
//
//        // Adding action listeners
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//
//        // Frame settings
//        setSize(1200, 700);
//        setLocationRelativeTo(null); // Center the frame
//        setUndecorated(true);
//        setVisible(true);
//    }
//
//    // Helper method to create and style buttons
//    private JButton createButton(String text, int x, int y) {
//        JButton button = new JButton(text);
//        button.setFont(new Font("Arial", Font.BOLD, 18));
//        button.setBackground(new Color(59, 89, 182));
//        button.setForeground(Color.WHITE);
//        button.setFocusPainted(false);
//        button.setBounds(x, y, 180, 50);
//        return button;
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        try {
//            String amount = t1.getText();
//            Date date = new Date();
//            if (ae.getSource() == b1) {
//                if (amount.equals("")) {
//                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw.");
//                } else {
//                    Conn c1 = new Conn();
//                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
//                    int balance = 0;
//                    while (rs.next()) {
//                        if (rs.getString("type").equals("Deposit")) {
//                            balance += Integer.parseInt(rs.getString("amount"));
//                        } else {
//                            balance -= Integer.parseInt(rs.getString("amount"));
//                        }
//                    }
//                    if (balance < Integer.parseInt(amount)) {
//                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
//                        return;
//                    }
//
//                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')");
//                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " debited successfully");
//
//                    setVisible(false);
//                    new Transactions(pin).setVisible(true);
//                }
//            } else if (ae.getSource() == b2) {
//                setVisible(false);
//                new Transactions(pin).setVisible(true);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("error: " + e);
//        }
//    }
//
//    public static void main(String[] args) {
//        new Withdrawl("").setVisible(true);
//    }
//}
//
//
//
//

//
//package ASimulatorSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.util.Date;
//import java.sql.*;
//
//// Generic Response class to demonstrate generics
//class GenericResponse<T> {
//    private T data;
//    private String message;
//
//    public GenericResponse(T data, String message) {
//        this.data = data;
//        this.message = message;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//}
//
//public class Withdrawl extends JFrame implements ActionListener {
//
//    JTextField t1;
//    JButton b1, b2;
//    JLabel l1, l2, backgroundLabel;
//    private final String pin; // Immutable field
//
//    Withdrawl(String pin) {
//        this.pin = pin;
//
//        // Background image
//        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
//        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
//        backgroundLabel = new JLabel(scaledBackgroundIcon);
//        backgroundLabel.setBounds(0, 0, 1200, 700);
//        add(backgroundLabel);
//
//        // Setting up labels with custom fonts and colors
//        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.50,000");
//        l1.setForeground(Color.BLACK);
//        l1.setFont(new Font("Arial", Font.BOLD, 20));
//        l1.setBounds(270, 180, 400, 28);
//        backgroundLabel.add(l1);
//
//        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
//        l2.setForeground(Color.WHITE);
//        l2.setFont(new Font("Arial", Font.BOLD, 20));
//        l2.setBounds(270, 230, 400, 30);
//        backgroundLabel.add(l2);
//
//        // Text field for amount input
//        t1 = new JTextField();
//        t1.setFont(new Font("Arial", Font.BOLD, 25));
//        t1.setBounds(250, 280, 400, 40);
//        backgroundLabel.add(t1);
//
//        // Buttons
//        b1 = createButton("WITHDRAW", 260, 350);
//        b2 = createButton("BACK", 470, 350);
//        backgroundLabel.add(b1);
//        backgroundLabel.add(b2);
//
//        // Adding action listeners
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//
//        // Frame settings
//        setSize(1200, 700);
//        setLocationRelativeTo(null); // Center the frame
//        setUndecorated(true);
//        setVisible(true);
//    }
//
//    // Helper method to create and style buttons
//    private JButton createButton(String text, int x, int y) {
//        JButton button = new JButton(text);
//        button.setFont(new Font("Arial", Font.BOLD, 18));
//        button.setBackground(new Color(59, 89, 182));
//        button.setForeground(Color.WHITE);
//        button.setFocusPainted(false);
//        button.setBounds(x, y, 180, 50);
//        return button;
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        try {
//            String amount = t1.getText();
//            Date date = new Date();
//            if (ae.getSource() == b1) {
//                if (amount.equals("") || !isValidTransaction(amount)) {
//                    JOptionPane.showMessageDialog(null, "Invalid amount. Please try again.");
//                } else {
//                    Conn c1 = new Conn();
//                    int balance = getBalance(c1);
//
//                    if (balance < Integer.parseInt(amount)) {
//                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
//                        return;
//                    }
//
//                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')");
//                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " debited successfully");
//
//                    setVisible(false);
//                    new Transactions(pin).setVisible(true);
//                }
//            } else if (ae.getSource() == b2) {
//                setVisible(false);
//                new Transactions(pin).setVisible(true);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
//            e.printStackTrace();
//        }
//    }
//
//    // Method to validate transaction amount
//    private boolean isValidTransaction(String amount) {
//        try {
//            int amt = Integer.parseInt(amount);
//            return amt > 0 && amt <= 50000; // Maximum withdrawal limit
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//
//    // Synchronized method to ensure thread safety during balance enquiry
//    private synchronized int getBalance(Conn c1) throws SQLException {
//        ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
//        int balance = 0;
//        while (rs.next()) {
//            if (rs.getString("type").equals("Deposit")) {
//                balance += Integer.parseInt(rs.getString("amount"));
//            } else {
//                balance -= Integer.parseInt(rs.getString("amount"));
//            }
//        }
//        return balance;
//    }
//
//    public static void main(String[] args) {
//        new Withdrawl("").setVisible(true);
//    }
//}



package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1, b2;
    JLabel l1, l2, backgroundLabel;
    private final String pin; // Immutable field

    Withdrawl(String pin) {
        this.pin = pin;

        // Background image
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        backgroundLabel = new JLabel(scaledBackgroundIcon);
        backgroundLabel.setBounds(0, 0, 1200, 700);
        add(backgroundLabel);

        // Setting up labels with custom fonts and colors
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.50,000");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBounds(270, 180, 400, 28);
        backgroundLabel.add(l1);

        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setBounds(270, 230, 400, 30);
        backgroundLabel.add(l2);

        // Text field for amount input
        t1 = new JTextField();
        t1.setFont(new Font("Arial", Font.BOLD, 25));
        t1.setBounds(250, 280, 400, 40);
        backgroundLabel.add(t1);

        // Buttons
        b1 = createButton("WITHDRAW", 260, 350);
        b2 = createButton("BACK", 470, 350);
        backgroundLabel.add(b1);
        backgroundLabel.add(b2);

        // Adding action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);

        // Frame settings
        setSize(1200, 700);
        setLocationRelativeTo(null); // Center the frame
        setUndecorated(true);
        setVisible(true);
    }

    // Helper method to create and style buttons
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(59, 89, 182));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBounds(x, y, 180, 50);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (amount.equals("") || !isValidTransaction(amount)) {
                    JOptionPane.showMessageDialog(null, "Invalid amount. Please try again.");
                } else {
                    Conn c1 = new Conn();
                    int balance = getBalance(c1);

                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " debited successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred. Please try again.");
            e.printStackTrace();
        }
    }

    // Method to validate transaction amount
    private boolean isValidTransaction(String amount) {
        try {
            int amt = Integer.parseInt(amount);
            return amt > 0 && amt <= 50000; // Maximum withdrawal limit
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Synchronized method to ensure thread safety during balance enquiry
    private synchronized int getBalance(Conn c1) throws SQLException {
        ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
        int balance = 0;
        while (rs.next()) {
            if (rs.getString("type").equals("Deposit")) {
                balance += Integer.parseInt(rs.getString("amount"));
            } else {
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        }
        return balance;
    }

    public static void main(String[] args) {
        new Withdrawl("").setVisible(true);
    }
}
