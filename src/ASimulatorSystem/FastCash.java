package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel title;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    FastCash(String pin) {
        this.pin = pin;

        // Background image setup
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, 1200, 700);
        add(backgroundLabel);

        // Title label
        title = new JLabel("SELECT WITHDRAWAL AMOUNT");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setBounds(210, 170, 600, 35);
        backgroundLabel.add(title);

        // Buttons
        b1 = createButton("Rs 100", 220, 222);
        b2 = createButton("Rs 500", 450, 222);
        b3 = createButton("Rs 1000", 220, 280);
        b4 = createButton("Rs 2000", 450, 280);
        b5 = createButton("Rs 5000", 220, 335);
        b6 = createButton("Rs 10000", 450, 335);
        b7 = createButton("BACK", 325, 388);

        // Adding buttons to the background label
        backgroundLabel.add(b1);
        backgroundLabel.add(b2);
        backgroundLabel.add(b3);
        backgroundLabel.add(b4);
        backgroundLabel.add(b5);
        backgroundLabel.add(b6);
        backgroundLabel.add(b7);

        // Action listeners for buttons
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        // Frame setup
        setSize(1200, 700);
        setLocationRelativeTo(null); // Center the frame
        setUndecorated(true); // Remove window decorations (e.g., title bar)
        setVisible(true);
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
        try {
            String amount = ((JButton) ae.getSource()).getText().substring(3); // Extracting amount from button text
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            } else {
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')");
                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}










//package ASimulatorSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//import java.util.Date;
//
//public class FastCash extends JFrame implements ActionListener {
//
//    JLabel l1, l2;
//    JButton b1, b2, b3, b4, b5, b6, b7, b8;
//    JTextField t1;
//    String pin;
//
//    FastCash(String pin) {
//        this.pin = pin;
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l3 = new JLabel(i3);
//        l3.setBounds(0, 0, 960, 1080);
//        add(l3);
//
//        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
//        l1.setForeground(Color.WHITE);
//        l1.setFont(new Font("System", Font.BOLD, 16));
//
//        b1 = new JButton("Rs 100");
//        b2 = new JButton("Rs 500");
//        b3 = new JButton("Rs 1000");
//        b4 = new JButton("Rs 2000");
//        b5 = new JButton("Rs 5000");
//        b6 = new JButton("Rs 10000");
//        b7 = new JButton("BACK");
//
//        setLayout(null);
//
//        l1.setBounds(235, 400, 700, 35);
//        l3.add(l1);
//
//        b1.setBounds(170, 499, 150, 35);
//        l3.add(b1);
//
//        b2.setBounds(390, 499, 150, 35);
//        l3.add(b2);
//
//        b3.setBounds(170, 543, 150, 35);
//        l3.add(b3);
//
//        b4.setBounds(390, 543, 150, 35);
//        l3.add(b4);
//
//        b5.setBounds(170, 588, 150, 35);
//        l3.add(b5);
//
//        b6.setBounds(390, 588, 150, 35);
//        l3.add(b6);
//
//        b7.setBounds(390, 633, 150, 35);
//        l3.add(b7);
//
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//        b3.addActionListener(this);
//        b4.addActionListener(this);
//        b5.addActionListener(this);
//        b6.addActionListener(this);
//        b7.addActionListener(this);
//
//        setSize(1200, 700);
//        setLocation(65, -30);
//        setUndecorated(true);
//        setVisible(true);
//
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        try {
//            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
//            Conn c = new Conn();
//            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
//            int balance = 0;
//            while (rs.next()) {
//                if (rs.getString("mode").equals("Deposit")) {
//                    balance += Integer.parseInt(rs.getString("amount"));
//                } else {
//                    balance -= Integer.parseInt(rs.getString("amount"));
//                }
//            } String num = "17";
//            if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
//                JOptionPane.showMessageDialog(null, "Insuffient Balance");
//                return;
//            }
//
//            if (ae.getSource() == b7) {
//                this.setVisible(false);
//                new Transactions(pin).setVisible(true);
//            }else{
//                Date date = new Date();
//                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
//                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
//
//                setVisible(false);
//                new Transactions(pin).setVisible(true);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void main(String[] args) {
//        new FastCash("").setVisible(true);
//    }
//}
