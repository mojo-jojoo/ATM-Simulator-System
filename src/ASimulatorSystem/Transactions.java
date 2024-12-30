//main code 
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel title;
    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pin;

    Transactions(String pin) {
        this.pin = pin;

        // Background image setup
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, 1200, 700);
        add(backgroundLabel);

        // Title label
        title = new JLabel("Please Select Your Transaction");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setBounds(210, 170, 600, 35);
        backgroundLabel.add(title);

        // Buttons
        deposit = createButton("DEPOSIT", 220, 222);
        withdraw = createButton("CASH WITHDRAWL", 450, 222);
        fastCash = createButton("FAST CASH", 220, 280);
        miniStatement = createButton("MINI STATEMENT", 450, 280);
        pinChange = createButton("PIN CHANGE", 220, 335);
        balanceEnquiry = createButton("BALANCE ENQUIRY", 450, 335);
        exit = createButton("EXIT", 325, 388);

        // Adding buttons to the background label
        backgroundLabel.add(deposit);
        backgroundLabel.add(withdraw);
        backgroundLabel.add(fastCash);
        backgroundLabel.add(miniStatement);
        backgroundLabel.add(pinChange);
        backgroundLabel.add(balanceEnquiry);
        backgroundLabel.add(exit);

        // Frame setup
        setSize(1200, 700);
        setLocationRelativeTo(null); // Center the frame
        setUndecorated(true); // Remove window decorations (e.g., title bar)
        setVisible(true);

        // Action listeners for buttons
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        fastCash.addActionListener(this);
        miniStatement.addActionListener(this);
        pinChange.addActionListener(this);
        balanceEnquiry.addActionListener(this);
        exit.addActionListener(this);
    }

    // Helper method to create and style buttons
    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(59, 89, 182));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBounds(x, y, 200, 40);
        return button;
    }

    // ActionListener method to handle button clicks
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
//
//
//
//
//
//
//
//
//
//
//
//
//
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
//// Generic utility class demonstrating Generics in Java
//class GenericResponse<T> {
//    private T response;
//
//    public GenericResponse(T response) {
//        this.response = response;
//    }
//
//    public T getResponse() {
//        return response;
//    }
//}
//
//public class Transactions extends JFrame implements ActionListener {
//    JButton depositButton, withdrawButton, fastCashButton, balanceEnquiryButton, exitButton;
//    JLabel welcomeLabel;
//    String pin;
//
//    // Synchronization lock for thread-safe operations
//    private static final Object lock = new Object();
//
//    Transactions(String pin) {
//        this.pin = pin;
//        setTitle("ATM Transaction System");
//
//        // Background image
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_SMOOTH);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel backgroundLabel = new JLabel(i3);
//        backgroundLabel.setBounds(0, 0, 960, 1080);
//        add(backgroundLabel);
//
//        // Welcome Label
//        welcomeLabel = new JLabel("Please Select Your Transaction");
//        welcomeLabel.setForeground(Color.BLACK);
//        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 22));
//        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
//        welcomeLabel.setBounds(80, 250, 590, 30);
//        backgroundLabel.add(welcomeLabel);
//
//        // Button styling
//        Font buttonFont = new Font("Arial", Font.BOLD, 16);
//        Color buttonColor = new Color(30, 144, 255); // DodgerBlue
//        Color buttonTextColor = Color.WHITE;
//
//        depositButton = createStyledButton("DEPOSIT", buttonFont, buttonColor, buttonTextColor);
//        withdrawButton = createStyledButton("WITHDRAW", buttonFont, buttonColor, buttonTextColor);
//        fastCashButton = createStyledButton("FAST CASH", buttonFont, buttonColor, buttonTextColor);
//        balanceEnquiryButton = createStyledButton("BALANCE ENQUIRY", buttonFont, buttonColor, buttonTextColor);
//        exitButton = createStyledButton("EXIT", buttonFont, buttonColor, buttonTextColor);
//
//        // Set button positions
//        depositButton.setBounds(190, 350, 200, 40);
//        withdrawButton.setBounds(390, 350, 200, 40);
//        fastCashButton.setBounds(190, 400, 200, 40);
//        balanceEnquiryButton.setBounds(390, 400, 200, 40);
//        exitButton.setBounds(290, 450, 200, 40);
//
//        // Add buttons to the background
//        backgroundLabel.add(depositButton);
//        backgroundLabel.add(withdrawButton);
//        backgroundLabel.add(fastCashButton);
//        backgroundLabel.add(balanceEnquiryButton);
//        backgroundLabel.add(exitButton);
//
//        // Add Action Listeners
//        depositButton.addActionListener(this);
//        withdrawButton.addActionListener(this);
//        fastCashButton.addActionListener(this);
//        balanceEnquiryButton.addActionListener(this);
//        exitButton.addActionListener(this);
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
//            if (ae.getSource() == depositButton) {
//                setVisible(false);
//                new Deposit(pin).setVisible(true);
//            } else if (ae.getSource() == withdrawButton) {
//                setVisible(false);
//                new Withdrawl(pin).setVisible(true);
//            } else if (ae.getSource() == fastCashButton) {
//                setVisible(false);
//                new FastCash(pin).setVisible(true);
//            } else if (ae.getSource() == balanceEnquiryButton) {
//                performBalanceEnquiry();
//            } else if (ae.getSource() == exitButton) {
//                System.exit(0);
//            }
//        } catch (Exception e) {
//            // Exception Handling: Display user-friendly error messages
//            JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
//            e.printStackTrace();
//        }
//    }
//
//    private void performBalanceEnquiry() {
//        synchronized (lock) { // Synchronization for thread safety
//            try {
//                Conn c1 = new Conn(); // ADT for database connection
//                ResultSet rs = c1.s.executeQuery("SELECT balance FROM bank WHERE pin = '" + pin + "'");
//                if (rs.next()) {
//                    String balance = rs.getString("balance");
//                    JOptionPane.showMessageDialog(null, "Your current balance is Rs. " + balance);
//                } else {
//                    JOptionPane.showMessageDialog(null, "No account found for this PIN.");
//                }
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null, "Database error occurred. Please try again.");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    // Unit Testing: Simple method to validate transaction type
//    public boolean isValidTransaction(String transactionType) {
//        return transactionType.equalsIgnoreCase("Deposit") ||
//                transactionType.equalsIgnoreCase("Withdraw") ||
//                transactionType.equalsIgnoreCase("FastCash") ||
//                transactionType.equalsIgnoreCase("BalanceEnquiry");
//    }
//
//    // Demonstrating Deadlock (for educational purposes)
//    private void demonstrateDeadlock() {
//        Thread thread1 = new Thread(() -> {
//            synchronized (lock) {
//                synchronized (welcomeLabel) {
//                    System.out.println("Thread 1: Locked resources");
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            synchronized (welcomeLabel) {
//                synchronized (lock) {
//                    System.out.println("Thread 2: Locked resources");
//                }
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//    }
//
//    public static void main(String[] args) {
//        new Transactions("").setVisible(true);
//    }
//}
