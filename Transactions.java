import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Transactions extends JFrame implements ActionListener
{

   
    JButton b1,b2,b3,b4,b5,b6,b7;
    String cardno,pin;
    Transactions(String cardno,String pin)
    {
        setLayout(null);

        // Custom rounded panel for the header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.blue);
        headerPanel.setBounds(0, 0, 590, 60);
        headerPanel.setLayout(null);
        add(headerPanel);

        this.cardno=cardno;
        this.pin=pin;
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setForeground(Color.white);
        text.setBounds(85, 10, 400, 40);
        text.setFont(new Font("Google Sans", Font.BOLD, 22));
        
       
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("PASSBOOK");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("LOG OUT");
        
        setLayout(null);
        
        // b1.setBackground(Color.blue);
        // b1.setForeground(Color.white);
        
        // b2.setBackground(Color.blue);
        // b2.setForeground(Color.white);
    

        // b3.setBackground(Color.blue);
        // b3.setForeground(Color.white);
        

        // b4.setBackground(Color.blue);
        // b4.setForeground(Color.white);
        
        // b5.setBackground(Color.blue);
        // b5.setForeground(Color.white);
       

        b7.setBackground(Color.blue);
        b7.setForeground(Color.white);


        b1.setFont(new Font("Google Sans", Font.BOLD, 13));
        b2.setFont(new Font("Google Sans", Font.BOLD, 12));
        b3.setFont(new Font("Google Sans", Font.BOLD, 13));
        b4.setFont(new Font("Google Sans", Font.BOLD, 13));
        b5.setFont(new Font("Google Sans", Font.BOLD, 13));
        b6.setFont(new Font("Google Sans", Font.BOLD, 12));
        b7.setFont(new Font("Google Sans", Font.BOLD, 15));
        
         
        

        
        
        
        b1.setBounds(60,100,150,35);
        
        
        b2.setBounds(280,100,150,35);
        
        
        b3.setBounds(60,150,150,35);
        
        
        b4.setBounds(280,150,150,35);
        
        b5.setBounds(60,200,150,35);
        
        
        b6.setBounds(280,200,150,35);
        
        
        b7.setBounds(169,280,150,35);
        b7.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 0, Color.white));
        
       
       add(b1);
       add(b2);
       add(b3);
       add(b4);
       add(b5);
       add(b6);
       add(b7);
       headerPanel.add(text);
        
        b1.addActionListener(this);
        b7.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        
        
        
    

        
        
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
                setVisible(false);
                new Deposit(cardno,pin).setVisible(true);
            }
            else if(e.getSource()==b7)
            {
                setVisible(false);
                new Login().setVisible(true);
            }
            else if(e.getSource()==b5)
            {
                setVisible(false);
                new Pin(cardno,pin).setVisible(true);
            }
            else if(e.getSource()==b6)
            {
                setVisible(false);
                new Balance(cardno,pin).setVisible(true);
            }
            else if(e.getSource()==b2)
            {
                setVisible(false);
                new Withdrawl(cardno,pin).setVisible(true);
            }
            else if(e.getSource()==b3)
            {
                setVisible(false);
                new Details(cardno,pin).setVisible(true);
            }
            

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Transactions("","");
    }
}