package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");

        // Custom font
        Font mainFont = new Font("SansSerif", Font.BOLD, 18);

        // Custom colors
        Color backgroundColor = new Color(34, 49, 63);
        Color buttonColor = new Color(89, 171, 227);
        Color textColor = new Color(236, 240, 241);

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(70, 10, 100, 100);
        add(l11);

        // Welcome label
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setForeground(textColor);
        l1.setBounds(200, 40, 450, 40);
        add(l1);

        // Card number label
        l2 = new JLabel("Card No:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setForeground(textColor);
        l2.setBounds(125, 150, 375, 30);
        add(l2);

        // Card number text field
        tf1 = new JTextField(15);
        tf1.setBounds(300, 150, 230, 30);
        tf1.setFont(mainFont);
        add(tf1);

        // PIN label
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setForeground(textColor);
        l3.setBounds(125, 220, 375, 30);
        add(l3);

        // PIN text field
        pf2 = new JPasswordField(15);
        pf2.setFont(mainFont);
        pf2.setBounds(300, 220, 230, 30);
        add(pf2);

        // Sign in button
        b1 = new JButton("SIGN IN");
        b1.setBackground(buttonColor);
        b1.setForeground(textColor);
        b1.setFont(mainFont);
        b1.setBounds(300, 300, 100, 30);
        add(b1);

        // Clear button
        b2 = new JButton("CLEAR");
        b2.setBackground(buttonColor);
        b2.setForeground(textColor);
        b2.setFont(mainFont);
        b2.setBounds(430, 300, 100, 30);
        add(b2);

        // Sign up button
        b3 = new JButton("SIGN UP");
        b3.setBackground(buttonColor);
        b3.setForeground(textColor);
        b3.setFont(mainFont);
        b3.setBounds(300, 350, 230, 30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // Custom background
        getContentPane().setBackground(backgroundColor);

        setLayout(null);
        setSize(850, 520); // width, height
        setLocation(220, 100); // right top
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource() == b1){
                Conn c1 = new Conn();
                String cardno = tf1.getText();
                String pin = new String(pf2.getPassword());

                // Check if cardno and pin are not empty
                if(cardno.isEmpty() || pin.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Card Number and PIN cannot be empty");
                    return;
                }

                String q = "SELECT * FROM login WHERE cardno = '" + cardno + "' AND pin = '" + pin + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource() == b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource() == b3){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(HeadlessException | SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Login().setVisible(true);
    }
}


//package ASimulatorSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener{
//    JLabel l1,l2,l3;
//    JTextField tf1;
//    JPasswordField pf2;
//    JButton b1,b2,b3;
//
//    Login(){
//        setTitle("AUTOMATED TELLER MACHINE");
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l11 = new JLabel(i3);
//        l11.setBounds(70, 10, 100, 100);
//        add(l11);
//
//        l1 = new JLabel("WELCOME TO ATM");
//        l1.setFont(new Font("Osward", Font.BOLD, 38));
//        l1.setBounds(200,40,450,40);
//        add(l1);
//
//        l2 = new JLabel("Card No:");
//        l2.setFont(new Font("Raleway", Font.BOLD, 28));
//        l2.setBounds(125,150,375,30);
//        add(l2);
//
//        tf1 = new JTextField(15);
//        tf1.setBounds(300,150,230,30);
//        tf1.setFont(new Font("Arial", Font.BOLD, 14));
//        add(tf1);
//
//        l3 = new JLabel("PIN:");
//        l3.setFont(new Font("Raleway", Font.BOLD, 28));
//        l3.setBounds(125,220,375,30);
//        add(l3);
//
//        pf2 = new JPasswordField(15);
//        pf2.setFont(new Font("Arial", Font.BOLD, 14));
//        pf2.setBounds(300,220,230,30);
//        add(pf2);
//
//        b1 = new JButton("SIGN IN");
//        b1.setBackground(Color.BLACK);
//        b1.setForeground(Color.WHITE);
//
//        b2 = new JButton("CLEAR");
//        b2.setBackground(Color.BLACK);
//        b2.setForeground(Color.WHITE);
//
//        b3 = new JButton("SIGN UP");
//        b3.setBackground(Color.BLACK);
//        b3.setForeground(Color.WHITE);
//
//        setLayout(null);
//
//        b1.setFont(new Font("Arial", Font.BOLD, 14));
//        b1.setBounds(300,300,100,30);
//        add(b1);
//
//        b2.setFont(new Font("Arial", Font.BOLD, 14));
//        b2.setBounds(430,300,100,30);
//        add(b2);
//
//        b3.setFont(new Font("Arial", Font.BOLD, 14));
//        b3.setBounds(300,350,230,30);
//        add(b3);
//
//        b1.addActionListener(this);
//        b2.addActionListener(this);
//        b3.addActionListener(this);
//
//        getContentPane().setBackground(Color.WHITE);
//
//        setSize(850,520);// width , length
//        setLocation(220,100);//right top
//        setVisible(true);
//
//    }
//    @Override
//    public void actionPerformed(ActionEvent ae){
//        try{
//            if(ae.getSource()==b1){
//                Conn c1 = new Conn();
//                String cardno  = tf1.getText();
//                String pin  = pf2.getText();
//                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
//
//                ResultSet rs = c1.s.executeQuery(q);
//                if(rs.next()){
//                    setVisible(false);
//                    new Transactions(pin).setVisible(true);
//                }else{
//                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
//                }
//            }else if(ae.getSource()==b2){
//                tf1.setText("");
//                pf2.setText("");
//            }else if(ae.getSource()==b3){
//                setVisible(false);
//                new Signup().setVisible(true);
//            }
//        }catch(HeadlessException | SQLException e){
//        }
//    }
//    public static void main(String[] args){
//        new Login().setVisible(true);
//    }
//
//
//}
//
//
//
