//package ASimulatorSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.util.Date;
//import java.sql.*;
//
//public class Deposit extends JFrame implements ActionListener {
//
//    JTextField t1;
//    JButton b1, b2;
//    JLabel l1, l3;
//    String pin;
//
//    Deposit(String pin) {
//        this.pin = pin;
//        setTitle("ATM Deposit System");
//
//         //Background image
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_SMOOTH);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l3 = new JLabel(i3);
//        l3.setBounds(0, 0, 960, 1080);
//        add(l3);
//
//
//        // Main title label
//        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
//        l1.setForeground(Color.BLACK);
//        l1.setFont(new Font("Verdana", Font.BOLD, 24));
//        l1.setHorizontalAlignment(JLabel.CENTER);
//        l1.setBounds(80, 250, 590, 30);
//        l3.add(l1);
//
//        // Input field styling
//        t1 = new JTextField();
//        t1.setFont(new Font("Arial", Font.BOLD, 22));
//        t1.setBounds(190, 420, 320, 30);
//        t1.setHorizontalAlignment(JTextField.CENTER);
//        t1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
//        l3.add(t1);
//
//        // Button styling
//        Font buttonFont = new Font("Arial", Font.BOLD, 16);
//        Color buttonColor = new Color(30, 144, 255); // DodgerBlue
//        Color buttonTextColor = Color.WHITE;
//
//        b1 = createStyledButton("DEPOSIT", buttonFont, buttonColor, buttonTextColor);
//        b2 = createStyledButton("BACK", buttonFont, buttonColor, buttonTextColor);
//
//        // Set button positions
//        b1.setBounds(390, 500, 150, 40);
//        b2.setBounds(390, 560, 150, 40);
//
//        // Add buttons to the background
//        l3.add(b1);
//        l3.add(b2);
//
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//
//        setLayout(null);
//        setSize(960, 1080);
//        setLocationRelativeTo(null);
//        setUndecorated(true);
//        setVisible(true);
//    }
//
//    private JButton createStyledButton(String text, Font font, Color bgColor, Color fgColor) {
//        JButton button = new JButton(text);
//        button.setFont(font);
//        button.setBackground(bgColor);
//        button.setForeground(fgColor);
//        button.setFocusPainted(false);
//        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
//        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        return button;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        try {
//            String amount = t1.getText();
//            Date date = new Date();
//            if (ae.getSource() == b1) {
//                if (t1.getText().equals("")) {
//                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
//                } else {
//                    Conn c1 = new Conn();
//                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
//                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
//                    setVisible(false);
//                    new Transactions(pin).setVisible(true);
//                }
//            } else if (ae.getSource() == b2) {
//                setVisible(false);
//                new Transactions(pin).setVisible(true);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        new Deposit("").setVisible(true);
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
import java.util.Date;
import java.sql.*;

// Demonstrating Generics in Java: Creating a generic utility class
class GenericUtility<T> {
    private T value;

    public GenericUtility(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class Deposit extends JFrame implements ActionListener {

    JTextField t1;
    JButton b1, b2;
    JLabel l1, l3;
    String pin;

    // Synchronization lock to ensure thread safety
    private static final Object lock = new Object();

    Deposit(String pin) {
        this.pin = pin;
        setTitle("ATM Deposit System");

        // Background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);

        // Main title label
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Verdana", Font.BOLD, 24));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBounds(80, 250, 590, 30);
        l3.add(l1);

        // Input field styling
        t1 = new JTextField();
        t1.setFont(new Font("Arial", Font.BOLD, 22));
        t1.setBounds(190, 420, 320, 30);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        l3.add(t1);

        // Button styling
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonColor = new Color(30, 144, 255); // DodgerBlue
        Color buttonTextColor = Color.WHITE;

        b1 = createStyledButton("DEPOSIT", buttonFont, buttonColor, buttonTextColor);
        b2 = createStyledButton("BACK", buttonFont, buttonColor, buttonTextColor);

        // Set button positions
        b1.setBounds(390, 500, 150, 40);
        b2.setBounds(390, 560, 150, 40);

        // Add buttons to the background
        l3.add(b1);
        l3.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);
        setSize(960, 1080);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    private JButton createStyledButton(String text, Font font, Color bgColor, Color fgColor) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = t1.getText();
            Date date = new Date();

            // Demonstrating Immutability: The `date` object is immutable
            final Date immutableDate = new Date(date.getTime());

            if (ae.getSource() == b1) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    synchronized (lock) { // Synchronization to ensure thread safety
                        Conn c1 = new Conn();
                        c1.s.executeUpdate("insert into bank values('" + pin + "', '" + immutableDate + "', 'Deposit', '" + amount + "')");
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (SQLException e) {
            // Exception Handling: Display user-friendly error messages
            JOptionPane.showMessageDialog(null, "Database error occurred. Please try again.");
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
            e.printStackTrace();
        }
    }

    // Abstract Data Type (ADT): Demonstrated with Conn (simplified representation of DB connection management)
    class Conn {
        Connection con;
        Statement s;

        public Conn() {
            try {
                con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","database321");
                s = con.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Demonstrating Deadlock (for educational purposes)
    private void demonstrateDeadlock() {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                synchronized (t1) {
                    System.out.println("Thread 1: Locked resources");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (t1) {
                synchronized (lock) {
                    System.out.println("Thread 2: Locked resources");
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    // Unit Testing: A simple method to validate input amount
    public boolean isValidAmount(String amount) {
        try {
            double value = Double.parseDouble(amount);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
    