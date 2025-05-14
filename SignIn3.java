import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import javax.swing.*;

public class SignIn3 extends JFrame implements ActionListener
{
    JRadioButton sAccount,cAccount,fAccount,rAccount;

    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit;
    String cardno;
    SignIn3(String cardno)
    {
        this.cardno = cardno;
        setTitle("SIGN IN");

        JLabel head=new JLabel("APPLICATION FORM");
        head.setFont(new Font("Times New Roman",Font.BOLD,30));
        head.setBounds(200,30,400,40);
        head.setForeground(Color.BLACK);
        add(head);

        JLabel text=new JLabel("Page3 : Account Details");
        text.setFont(new Font("Times New Roman",Font.BOLD,21));
        text.setBounds(250,80,400,40);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel name=new JLabel("Account Type :");
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        name.setBounds(100,135,240,30);
        name.setForeground(Color.BLACK);
        add(name);

        sAccount=new JRadioButton("Savings Account");
        sAccount.setBounds(120,170,150,45);
        sAccount.setFont(new Font("Raleway", Font.BOLD, 15));
        sAccount.setBackground(Color.WHITE);
        sAccount.setForeground(Color.BLACK);
        add(sAccount);

        cAccount=new JRadioButton("Current Account");
        cAccount.setBounds(120,215,170,45);
        cAccount.setFont(new Font("Raleway", Font.BOLD, 15));
        cAccount.setBackground(Color.WHITE);
        cAccount.setForeground(Color.BLACK);
        add(cAccount);

        fAccount=new JRadioButton("Fixed Deposit Account");
        fAccount.setBounds(300,170,250,45);
        fAccount.setFont(new Font("Raleway", Font.BOLD, 15));
        fAccount.setBackground(Color.WHITE);
        fAccount.setForeground(Color.BLACK);
        add(fAccount);

        rAccount=new JRadioButton("Recurring Deposit Account");
        rAccount.setBounds(300,215,290,45);
        rAccount.setFont(new Font("Raleway", Font.BOLD, 15));
        rAccount.setBackground(Color.WHITE);
        rAccount.setForeground(Color.BLACK);
        add(rAccount);

        ButtonGroup cgroup=new ButtonGroup();
        cgroup.add(sAccount);
        cgroup.add(cAccount);
        cgroup.add(fAccount);
        cgroup.add(rAccount);

        JLabel num=new JLabel("Card Number :");
        num.setFont(new Font("Times New Roman",Font.BOLD,20));
        num.setBounds(100,280,240,30);
        num.setForeground(Color.BLACK);
        add(num);

        JLabel text1=new JLabel("(Your 16-Digit Card number)");
        text1.setFont(new Font("Arial",Font.BOLD,11));
        text1.setBounds(100,300,240,30);
        text1.setForeground(Color.BLACK);
        add(text1);

        JLabel num1=new JLabel("XXXX-XXXX-XXXX-XXXX");
        num1.setFont(new Font("Arial",Font.BOLD,16));
        num1.setBounds(300,280,240,30);
        num1.setForeground(Color.BLACK);
        add(num1);

        JLabel text2=new JLabel("(It would appear on ATM card and Passbook)");
        text2.setFont(new Font("Arial",Font.BOLD,11));
        text2.setBounds(300,300,250,30);
        text2.setForeground(Color.BLACK);
        add(text2);

        JLabel pin=new JLabel("Password :");
        pin.setFont(new Font("Times New Roman",Font.BOLD,20));
        pin.setBounds(100,339,240,30);
        pin.setForeground(Color.BLACK);
        add(pin);

        JLabel text3=new JLabel("(Your 4-Digit Password)");
        text3.setFont(new Font("Arial",Font.BOLD,11));
        text3.setBounds(100,360,240,30);
        text3.setForeground(Color.BLACK);
        add(text3);

        JLabel pin1=new JLabel("XXXX");
        pin1.setFont(new Font("Arial",Font.BOLD,16));
        pin1.setBounds(300,339,240,30);
        pin1.setForeground(Color.BLACK);
        add(pin1);
        
        JLabel sevice=new JLabel("Services Required :");
        sevice.setFont(new Font("Times New Roman",Font.BOLD,20));
        sevice.setBounds(100,420,240,30);
        sevice.setForeground(Color.BLACK);
        add(sevice);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setForeground(Color.BLACK);
        c1.setFont(new Font("Raleway", Font.BOLD, 15));
        c1.setBounds(120,480,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setForeground(Color.BLACK);
        c2.setFont(new Font("Raleway", Font.BOLD, 15));
        c2.setBounds(350,480,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setForeground(Color.BLACK);
        c3.setFont(new Font("Raleway", Font.BOLD, 15));
        c3.setBounds(120,530,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setForeground(Color.BLACK);
        c4.setFont(new Font("Raleway", Font.BOLD, 15));
        c4.setBounds(350,530,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setForeground(Color.BLACK);
        c5.setFont(new Font("Raleway", Font.BOLD, 15));
        c5.setBounds(120,580,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setForeground(Color.BLACK);
        c6.setFont(new Font("Raleway", Font.BOLD, 15));
        c6.setBounds(350,580,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setForeground(Color.BLACK);
        c7.setFont(new Font("Raleway", Font.BOLD, 13));
        c7.setBounds(90,640,600,20);
        add(c7);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setBounds(280,700,100,30);
        submit.addActionListener(this);
        add(submit);

        JLabel pin2=new JLabel("");
        pin2.setFont(new Font("Osward",Font.BOLD,30));
        pin2.setBounds(120,220,230,30);
        add(pin2);

        getContentPane().setBackground(Color.WHITE);
        setSize(700,800);
        setVisible(true);
        setLocation(700,200);
    }
     public void actionPerformed(ActionEvent e)
     {
        String atype ="";
        if(sAccount.isSelected()){ 
            atype = "Saving Account";
        }
        else if(fAccount.isSelected()){ 
            atype = "Fixed Deposit Account";
        }
        else if(cAccount.isSelected()){ 
            atype = "Current Account";
        }else if(rAccount.isSelected()){ 
            atype = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);
        
        String facility = "";
        if(c1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        try 
        {
            if (atype.equals("")) {
                
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } 
            else if (facility.equals("")) 
            {
                
                JOptionPane.showMessageDialog(null, "Fill all the required fields ");
            } 
            else if (e.getSource() == submit) 
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO sign3 (atype,facility,cardno,pin) VALUES (?,?,?,?)");
                PreparedStatement statement1 = connection.prepareStatement("INSERT INTO login (cardno, pin) VALUES (?, ?)");
                statement.setString(1, atype);
                statement.setString(2, facility);
                statement.setString(3, cardno);
                statement.setString(4, pin);

                statement1.setString(1, cardno);
                statement1.setString(2, pin);
                connection.createStatement(); 
                statement.executeUpdate();
                statement1.executeUpdate();
                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                setVisible(false);
                new Deposit(cardno,pin).setVisible(true); 
                connection.close();                  
                
            }
        }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            
     }
    public static void main(String[]args)
    {
        new SignIn3(" ");
    }
}
