import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener
{
    JTextField amountTextField;
    JButton deposit, back;
    String cardno,pin;
    Deposit(String cardno,String pin)
    {
        this.pin=pin;
        this.cardno=cardno;
        
        JLabel name=new JLabel("ENTER THE DEPOSIT AMOUNT ");
        name.setFont(new Font("Google Sans",Font.BOLD,20));
        name.setBounds(70,120,2400,30);
        name.setForeground(Color.black);
        add(name);

        amountTextField=new JTextField();
        amountTextField.setBounds(115,180,200,35);
        amountTextField.setFont(new Font("Arial",Font.BOLD,14));
        amountTextField.setForeground(Color.BLACK);
        amountTextField.setBackground(Color.white);
        amountTextField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        add(amountTextField);

        deposit = new JButton("Deposit");
        deposit.setBounds(100, 300, 100, 30);
        deposit.setBackground(Color.blue);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        add(deposit);

        back = new JButton("Back");
        back.setBounds(240, 300, 100, 30);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        
        back.addActionListener(this);
        add(back);

        JLabel pin1=new JLabel("");
        pin1.setFont(new Font("Osward",Font.BOLD,30));
        pin1.setBounds(120,220,230,30);
        add(pin1);


        getContentPane().setBackground(Color.white);
        setSize(450,500);
        setVisible(true);
        setLocation(700,300);

    } 
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            
            
            if (e.getSource() == back)
            {
                setVisible(false);

            } 
            else if (amountTextField.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Enter the Amount");
            }    
            else if(e.getSource()==deposit)
            {
                Date date = new Date();
                String amount=amountTextField.getText();
                
            
        
            //balance+=amount1;
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO bank (cardno,pin,date,type,amount) VALUES (?,?,?,?,?)");
                statement.setString(1, cardno);
                statement.setString(2, pin);
                statement.setDate(3, new java.sql.Date(date.getTime()));
                statement.setString(4,"deposit");
                statement.setString(5,amount);
                connection.createStatement(); 
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Deposited successfylly");
                setVisible(false);
               
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        new Transactions(cardno,pin).setVisible(true);
    }
    public static void main(String[]args)
    {
        new Deposit("","");
    }
}

