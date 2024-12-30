package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton b;
    JRadioButton r1, r2, r3, r4;
    JTextField t1, t2;
    JComboBox c1, c2, c3, c4, c5;
    String formno;

    Signup2(String formno) {

        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        // Custom font and colors
        Font mainFont = new Font("SansSerif", Font.BOLD, 18);
        Color backgroundColor = new Color(34, 49, 63);
        Color buttonColor = new Color(89, 171, 227);
        Color textColor = new Color(236, 240, 241);

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);

        // Page label
        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setForeground(textColor);
        l1.setBounds(280, 30, 600, 40);
        add(l1);

        // Form fields
        l2 = createLabel("Religion:", 100, 120);
        c1 = createComboBox(new String[]{"Muslim", "Hindu", "Sikh", "Christian", "Other"}, 350, 120);

        l3 = createLabel("Category:", 100, 170);
        c2 = createComboBox(new String[]{"GENERAL", "PUNJABIS", "PASHTUN", "SINDHIS", "Other"}, 350, 170);

        l4 = createLabel("Income:", 100, 220);
        c3 = createComboBox(new String[]{"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"}, 350, 220);

        l5 = createLabel("Educational", 100, 270);
        c4 = createComboBox(new String[]{"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"}, 350, 270);

        l11 = createLabel("Qualification:", 100, 290);

        l6 = createLabel("Occupation:", 100, 340);
        c5 = createComboBox(new String[]{"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"}, 350, 340);

        l7 = createLabel("NTN Number:", 100, 390);
        t1 = createTextField(350, 390);

        l8 = createLabel("NIC Number:", 100, 440);
        t2 = createTextField(350, 440);

        l9 = createLabel("Senior Citizen:", 100, 490);
        r1 = createRadioButton("Yes", 350, 490);
        r2 = createRadioButton("No", 460, 490);
        ButtonGroup groupSeniorCitizen = new ButtonGroup();
        groupSeniorCitizen.add(r1);
        groupSeniorCitizen.add(r2);

        l10 = createLabel("Existing Account:", 100, 540);
        r3 = createRadioButton("Yes", 350, 540);
        r4 = createRadioButton("No", 460, 540);
        ButtonGroup groupExistingAccount = new ButtonGroup();
        groupExistingAccount.add(r3);
        groupExistingAccount.add(r4);

        b = new JButton("Next");
        b.setFont(mainFont);
        b.setBackground(buttonColor);
        b.setForeground(textColor);
        b.setBounds(570, 600, 95, 30);
        b.addActionListener(this);
        add(b);

        // Form number label
        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        l12.setForeground(textColor);
        l12.setBounds(700, 10, 60, 30);
        add(l12);

        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));
        l13.setForeground(textColor);
        l13.setBounds(760, 10, 60, 30);
        add(l13);

        // Set custom background
        getContentPane().setBackground(backgroundColor);
        setLayout(null);
        setSize(850, 750);
        setLocation(200, -1);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Raleway", Font.BOLD, 20));
        label.setForeground(new Color(236, 240, 241));
        label.setBounds(x, y, 200, 30);
        add(label);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 14));
        textField.setBounds(x, y, 320, 30);
        add(textField);
        return textField;
    }

    private JComboBox createComboBox(String[] items, int x, int y) {
        JComboBox comboBox = new JComboBox(items);
        comboBox.setBackground(Color.WHITE);
        comboBox.setFont(new Font("Raleway", Font.BOLD, 14));
        comboBox.setBounds(x, y, 320, 30);
        add(comboBox);
        return comboBox;
    }

    private JRadioButton createRadioButton(String text, int x, int y) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Raleway", Font.BOLD, 14));
        radioButton.setBackground(new Color(34, 49, 63));
        radioButton.setForeground(new Color(236, 240, 241));
        radioButton.setBounds(x, y, 100, 30);
        add(radioButton);
        return radioButton;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) c1.getSelectedItem();
        String category = (String) c2.getSelectedItem();
        String income = (String) c3.getSelectedItem();
        String education = (String) c4.getSelectedItem();
        String occupation = (String) c5.getSelectedItem();

        String NTN = t1.getText();
        String nic = t2.getText();

        String seniorcitizen = "";
        if (r1.isSelected()) {
            seniorcitizen = "Yes";
        } else if (r2.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = "";
        if (r3.isSelected()) {
            existingaccount = "Yes";
        } else if (r4.isSelected()) {
            existingaccount = "No";
        }

        try {
            if (t2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Conn c1 = new Conn();
                String q1 = "insert into signuptwo values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + NTN + "','" + nic + "','" + seniorcitizen + "','" + existingaccount + "')";
                c1.s.executeUpdate(q1);

                new Signup3(formno).setVisible(true);
                setVisible(false);
            }
        } catch (HeadlessException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("").setVisible(true);
    }
}

//package ASimulatorSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class Signup2 extends JFrame implements ActionListener{
//
//    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
//    JButton b;
//    JRadioButton r1,r2,r3,r4;
//    JTextField t1,t2,t3;
//    JComboBox c1,c2,c3,c4,c5;
//    String formno;
//    Signup2(String formno){
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel l14 = new JLabel(i3);
//        l14.setBounds(150, 0, 100, 100);
//        add(l14);
//
//
//        this.formno = formno;
//        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
//
//        l1 = new JLabel("Page 2: Additonal Details");
//        l1.setFont(new Font("Raleway", Font.BOLD, 22));
//
//        l2 = new JLabel("Religion:");
//        l2.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l3 = new JLabel("Category:");
//        l3.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l4 = new JLabel("Income:");
//        l4.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l5 = new JLabel("Educational");
//        l5.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l11 = new JLabel("Qualification:");
//        l11.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l6 = new JLabel("Occupation:");
//        l6.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l7 = new JLabel("NTN Number:");
//        l7.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l8 = new JLabel("NIC Number:");
//        l8.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l9 = new JLabel("Senior Citizen:");
//        l9.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l10 = new JLabel("Existing Account:");
//        l10.setFont(new Font("Raleway", Font.BOLD, 18));
//
//        l12 = new JLabel("Form No:");
//        l12.setFont(new Font("Raleway", Font.BOLD, 13));
//
//        l13 = new JLabel(formno);
//        l13.setFont(new Font("Raleway", Font.BOLD, 13));
//
//        b = new JButton("Next");
//        b.setFont(new Font("Raleway", Font.BOLD, 14));
//        b.setBackground(Color.BLACK);
//        b.setForeground(Color.WHITE);
//
//        t1 = new JTextField();
//        t1.setFont(new Font("Raleway", Font.BOLD, 14));
//
//        t2 = new JTextField();
//        t2.setFont(new Font("Raleway", Font.BOLD, 14));
//
//        r1 = new JRadioButton("Yes");
//        r1.setFont(new Font("Raleway", Font.BOLD, 14));
//        r1.setBackground(Color.WHITE);
//
//        r2 = new JRadioButton("No");
//        r2.setFont(new Font("Raleway", Font.BOLD, 14));
//        r2.setBackground(Color.WHITE);
//
//        r3 = new JRadioButton("Yes");
//        r3.setFont(new Font("Raleway", Font.BOLD, 14));
//        r3.setBackground(Color.WHITE);
//
//        r4 = new JRadioButton("No");
//        r4.setFont(new Font("Raleway", Font.BOLD, 14));
//        r4.setBackground(Color.WHITE);
//
//
//        String religion[] = {"Muslim","Hindu","Sikh","Christian","Other"};
//        c1 = new JComboBox(religion);
//        c1.setBackground(Color.WHITE);
//        c1.setFont(new Font("Raleway", Font.BOLD, 14));
//
//        String category[] = {"GENERAL","PUNJABIS","PASHTUN","SINDHIS","Other"};
//        c2 = new JComboBox(category);
//        c2.setBackground(Color.WHITE);
//        c2.setFont(new Font("Raleway", Font.BOLD, 14));
//
//        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
//        c3 = new JComboBox(income);
//        c3.setBackground(Color.WHITE);
//        c3.setFont(new Font("Raleway", Font.BOLD, 14));
//
//        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
//        c4 = new JComboBox(education);
//        c4.setBackground(Color.WHITE);
//        c4.setFont(new Font("Raleway", Font.BOLD, 14));
//
//        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
//        c5 = new JComboBox(occupation);
//        c5.setBackground(Color.WHITE);
//        c5.setFont(new Font("Raleway", Font.BOLD, 14));
//
//
//        setLayout(null);
//
//
//        l12.setBounds(700,10,60,30);
//        add(l12);
//
//        l13.setBounds(760,10,60,30);
//        add(l13);
//
//        l1.setBounds(280,30,600,40);
//        add(l1);
//
//        l2.setBounds(100,120,100,30);
//        add(l2);
//
//        c1.setBounds(350,120,320,30);
//        add(c1);
//
//        l3.setBounds(100,170,100,30);
//        add(l3);
//
//        c2.setBounds(350,170,320,30);
//        add(c2);
//
//        l4.setBounds(100,220,100,30);
//        add(l4);
//
//        c3.setBounds(350,220,320,30);
//        add(c3);
//
//        l5.setBounds(100,270,150,30);
//        add(l5);
//
//        c4.setBounds(350,270,320,30);
//        add(c4);
//
//        l11.setBounds(100,290,150,30);
//        add(l11);
//
//        l6.setBounds(100,340,150,30);
//        add(l6);
//
//        c5.setBounds(350,340,320,30);
//        add(c5);
//
//        l7.setBounds(100,390,150,30);
//        add(l7);
//
//        t1.setBounds(350,390,320,30);
//        add(t1);
//
//        l8.setBounds(100,440,180,30);
//        add(l8);
//
//        t2.setBounds(350,440,320,30);
//        add(t2);
//
//        l9.setBounds(100,490,150,30);
//        add(l9);
//
//        r1.setBounds(350,490,100,30);
//        add(r1);
//
//        r2.setBounds(460,490,100,30);
//        add(r2);
//
//        l10.setBounds(100,540,180,30);
//        add(l10);
//
//        r3.setBounds(350,540,100,30);
//        add(r3);
//
//        r4.setBounds(460,540,100,30);
//        add(r4);
//
//        b.setBounds(570,570,100,30);
//        add(b);
//
//        b.addActionListener(this);
//
//        getContentPane().setBackground(Color.WHITE);
//
//        setSize(890,910);
//        setLocation(200,0);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae){
//        String religion = (String)c1.getSelectedItem();
//        String category = (String)c2.getSelectedItem();
//        String income = (String)c3.getSelectedItem();
//        String education = (String)c4.getSelectedItem();
//        String occupation = (String)c5.getSelectedItem();
//
//        String NTN = t1.getText();
//        String aadhar = t2.getText();
//
//        String seniorcitizen = "";
//        if(r1.isSelected()){
//            seniorcitizen = "Yes";
//        }
//        else if(r2.isSelected()){
//            seniorcitizen = "No";
//        }
//
//        String existingaccount = "";
//        if(r3.isSelected()){
//            existingaccount = "Yes";
//        }else if(r4.isSelected()){
//            existingaccount = "No";
//        }
//
//        try{
//            if(t2.getText().equals("")){
//                JOptionPane.showMessageDialog(null, "Fill all the required fields");
//            }else{
//                Conn c1 = new Conn();
//                String q1 = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+NTN+"','"+aadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
//                c1.s.executeUpdate(q1);
//
//                new Signup3(formno).setVisible(true);
//                setVisible(false);
//            }
//
//
//
//        }catch(HeadlessException | SQLException ex){
//        }
//
//
//    }
//
//
//    public static void main(String[] args){
//        new Signup2("").setVisible(true);
//
//    }
//}
