import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Balance extends JFrame implements ActionListener
{

    JLabel l;
    JButton b1;
    JPasswordField pinTextField; 
    String cardno,pin;
    Balance(String cardno,String pin)
    {
        this.cardno=cardno;
        this.pin=pin;
        JLabel text=new JLabel("Enter Your 4-digit PIN");
        text.setBounds(120, 40, 400, 40);
        text.setFont(new Font("Google Sans", Font.BOLD, 25));
        text.setForeground(Color.black);
        add(text);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(150, 110, 180, 30);
        pinTextField.setFont(new Font("Google Sans", Font.BOLD, 14));
        pinTextField.setForeground(Color.black);
        pinTextField.setBackground(Color.white);
        pinTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pinTextField.setColumns(10);
        add(pinTextField);

        b1 = new JButton("OK");
        b1.setBounds(220, 190, 55, 30);
        b1.setFont(new Font("Google Sans", Font.BOLD, 13));
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);


        JLabel cardno2=new JLabel("");
        cardno2.setFont(new Font("Osward",Font.BOLD,30));
        cardno2.setBounds(120,220,230,30);
        add(cardno2);

       
        

        
        
        getContentPane().setBackground(Color.white);
        setSize(500,400);
        setVisible(true);
        setLocation(700,300);
           
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource()==b1)
            {
                String input_pin= pinTextField.getText();
                if(!input_pin.equals(pin))
                {
                    JOptionPane.showMessageDialog(null, "Incorrect pin!");
                    setVisible(false);
                }
                else{

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");
                    PreparedStatement statement = connection.prepareStatement("SELECT * FROM bank WHERE cardno=? ");
                    statement.setString(1, cardno);

                    ResultSet r=statement.executeQuery();
                    double balance=0;
                     if(r.next())
                    {
                        while(r.next())
                        {
                            if (r.getString("type").equals("deposit")) {
                                balance += Integer.parseInt(r.getString("amount"));
                            } 
                            else
                            {
                            balance -= Integer.parseInt(r.getString("amount"));
                            }
                        
                        }
                        JOptionPane.showMessageDialog(null, "Your Current Account Balance is Rs "+balance);
                        setVisible(false);
                                            
                    }
                    
            } 
            new Transactions(cardno,pin).setVisible(true);
        } 

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Balance("","");
    }
}