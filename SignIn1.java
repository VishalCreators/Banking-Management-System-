import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.*;

public class SignIn1 extends JFrame implements ActionListener
{
    JTextField nameTextField,fnameTextField,dateTextField,stateTextField,pinTextField,cityTextField,emailTextField,addressTextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried,others1;
    String cardno;
    SignIn1()
    {
        setTitle("SIGN IN");

        JLabel text=new JLabel("APPLICATION FORM");
        text.setFont(new Font("Times New Roman",Font.BOLD,30));
        text.setBounds(200,40,400,40);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel text1=new JLabel("Page1 : Personal Details");
        text1.setFont(new Font("Times New Roman",Font.BOLD,20));
        text1.setBounds(250,100,400,40);
        text1.setForeground(Color.BLACK);
        add(text1);

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        name.setBounds(100,160,240,30);
        name.setForeground(Color.BLACK);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(270,160,310,25);
        nameTextField.setFont(new Font("Arial",Font.BOLD,14));
        nameTextField.setForeground(Color.BLACK);
        nameTextField.setBackground(Color.white);
        nameTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(nameTextField);


        JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Times New Roman",Font.BOLD,20));
        fname.setBounds(100,210,240,30);
        fname.setForeground(Color.BLACK);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setBounds(270,210,310,25);
        fnameTextField.setFont(new Font("Arial",Font.BOLD,14));
        fnameTextField.setForeground(Color.BLACK);
        fnameTextField.setBackground(Color.white);
        fnameTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(fnameTextField);

        JLabel date=new JLabel("Date Of Birth :");
        date.setFont(new Font("Times New Roman",Font.BOLD,20));
        date.setBounds(100,260,240,30);
        date.setForeground(Color.BLACK);
        add(date);

        dateTextField=new JTextField();
        dateTextField.setBounds(270,260,310,25);
        dateTextField.setFont(new Font("Arial",Font.BOLD,14));
        dateTextField.setForeground(Color.BLACK);
        dateTextField.setBackground(Color.white);
        dateTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(dateTextField);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Times New Roman",Font.BOLD,20));
        gender.setBounds(100,310,240,30);
        gender.setForeground(Color.BLACK);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(270,310,60,30);
        male.setBackground(Color.white);
        male.setForeground(Color.BLACK);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(385,310,80,30);
        female.setBackground(Color.white);
        female.setForeground(Color.BLACK);
        add(female);

        others=new JRadioButton("Others");
        others.setBounds(510,310,80,30);
        others.setBackground(Color.white);
        others.setForeground(Color.BLACK);
        add(others);

        ButtonGroup gendegroup=new ButtonGroup();
        gendegroup.add(male);
        gendegroup.add(female);
        gendegroup.add(others);

        JLabel email=new JLabel("Phone Number:");
        email.setFont(new Font("Times New Roman",Font.BOLD,20));
        email.setBounds(100,360,240,30);
        email.setForeground(Color.BLACK);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setBounds(270,360,310,25);
        emailTextField.setFont(new Font("Arial",Font.BOLD,14));
        emailTextField.setForeground(Color.BLACK);
        emailTextField.setBackground(Color.white);
        emailTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(emailTextField);

        JLabel status=new JLabel("Marital Status:");
        status.setFont(new Font("Times New Roman",Font.BOLD,20));
        status.setBounds(100,410,240,30);
        status.setForeground(Color.BLACK);
        add(status);

        married=new JRadioButton("Married");
        married.setBounds(270,410,100,30);
        married.setBackground(Color.white);
        married.setForeground(Color.BLACK);
        add(married);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(385,410,100,30);
        unmarried.setBackground(Color.white);
        unmarried.setForeground(Color.BLACK);
        add(unmarried);

        others1=new JRadioButton("Others");
        others1.setBounds(515,410,80,30);
        others1.setBackground(Color.white);
        others1.setForeground(Color.BLACK);
        add(others1);

        ButtonGroup statusgroup=new ButtonGroup();
        statusgroup.add(married);
        statusgroup.add(unmarried);
        statusgroup.add(others);


        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.setBounds(100,460,240,30);
        address.setForeground(Color.BLACK);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setBounds(270,460,310,25);
        addressTextField.setFont(new Font("Arial",Font.BOLD,14));
        addressTextField.setForeground(Color.BLACK);
        addressTextField.setBackground(Color.white);
        addressTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(addressTextField);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Times New Roman",Font.BOLD,20));
        city.setBounds(100,510,240,30);
        city.setForeground(Color.BLACK);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setBounds(270,510,310,25);
        cityTextField.setFont(new Font("Arial",Font.BOLD,14));
        cityTextField.setForeground(Color.BLACK);
        cityTextField.setBackground(Color.white);
        cityTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(cityTextField);

        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(new Font("Times New Roman",Font.BOLD,20));
        pin.setBounds(100,560,240,30);
        pin.setForeground(Color.BLACK);
        add(pin);

        pinTextField=new JTextField();
        pinTextField.setBounds(270,560,310,25);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        pinTextField.setForeground(Color.BLACK);
        pinTextField.setBackground(Color.white);
        pinTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(pinTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Times New Roman",Font.BOLD,20));
        state.setBounds(100,610,240,30);
        state.setForeground(Color.BLACK);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setBounds(270,610,310,25);
        stateTextField.setFont(new Font("Arial",Font.BOLD,14));
        stateTextField.setForeground(Color.BLACK);
        stateTextField.setBackground(Color.white);
        stateTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(stateTextField);

        next=new JButton("NEXT");
        next.setBounds(280,690,90,25);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Times New Roman",Font.BOLD,15));
        next.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        next.addActionListener(this);
        add(next);


        JLabel pin1=new JLabel("");
        pin1.setFont(new Font("Osward",Font.BOLD,30));
        pin1.setBounds(120,220,230,30);
        add(pin1);


        getContentPane().setBackground(Color.white);
        setSize(700,800);
        setVisible(true);
        setLocation(700,200);
    }
    public void actionPerformed(ActionEvent e)
    {
        Random ran = new Random();
        long first7 = (Math.abs(ran.nextLong()) % 9000000000000000L) + 1000000000000000L;
        String cardno = Long.toString(first7);


        String name = nameTextField.getText();
        String father = fnameTextField.getText();
        String dob = dateTextField.getText();
        String gender = null;
        if(male.isSelected()){ 
            gender = "Male";
        }else if(female.isSelected()){ 
            gender = "Female";
        }
        else if(others.isSelected())
        {
            gender = "Others";
        }
            
        String phone = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){ 
            marital = "Married";
        }else if(unmarried.isSelected()){ 
            marital = "Unmarried";
        }else if(others1.isSelected()){ 
            marital = "Other";
        }   
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pinTextField.getText();
        String state = stateTextField.getText();
        try 
        {
            if (nameTextField.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } 
            else if (stateTextField.getText().equals("")) 
            {
                
                JOptionPane.showMessageDialog(null, "Fill the State ");
            } 
            else if (emailTextField.getText().equals("")) 
            {
                
                JOptionPane.showMessageDialog(null, "Fill the Email ID ");
            } 
            else if (cityTextField.getText().equals("")) 
            {
                
                JOptionPane.showMessageDialog(null, "Fill the City");
            } 
            else if(e.getSource() == next)  
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO sign1 (cardno,name,father,dob,gender,phone,marital,address,city,pincode,state) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                statement.setString(1, cardno);
                statement.setString(2, name);
                statement.setString(3, father);
                statement.setString(4,dob);
                statement.setString(5,gender);
                statement.setString(6,phone);
                statement.setString(7,marital);
                statement.setString(8,address);
                statement.setString(9,city);
                statement.setString(10,pincode);
                statement.setString(11,state);
                connection.createStatement(); 
                statement.executeUpdate();
                setVisible(false);
                new SignIn2(cardno).setVisible(true); 
                connection.close();                                
            }
        } 
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
    }
    public static void main(String[]args)
    {
        new SignIn1();
    }
}