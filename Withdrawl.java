import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener
{
    JTextField amountTextField,pinTextField;
    JButton withdraw, back;
    String cardno,pin;
    Withdrawl(String cardno,String pin)
    {
        this.pin=pin;
        this.cardno=cardno;
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.blue);
        headerPanel.setBounds(0, 0, 590, 60);
        headerPanel.setLayout(null);
        add(headerPanel);
        
        JLabel name=new JLabel("Enter The withdraw Amount ");
        name.setFont(new Font("Google Sans",Font.BOLD,20));
        name.setBounds(90,90,2400,30);
        name.setForeground(Color.black);
        add(name);

        amountTextField=new JTextField();
        amountTextField.setBounds(130,130,180,35);
        amountTextField.setFont(new Font("Google Sans",Font.BOLD,14));
        amountTextField.setForeground(Color.black);
        amountTextField.setBackground(Color.white);
        amountTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        add(amountTextField);

        
        JLabel text1=new JLabel("Enter Your 4-digit Pin");
        text1.setBounds(115, 185, 400, 40);
        text1.setFont(new Font("Google Sans", Font.BOLD, 20));
        text1.setForeground(Color.black);
        add(text1);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(130, 230, 180, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setForeground(Color.black);
        pinTextField.setBackground(Color.white);
        pinTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pinTextField.setColumns(10);
        add(pinTextField);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(110, 300, 100, 30);
        withdraw.setBackground(Color.blue);
        withdraw.setForeground(Color.white);
        withdraw.addActionListener(this);
        add(withdraw);

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
            String input_pin=pinTextField.getText();
                String amount=amountTextField.getText();    
            if (e.getSource() == back)
            {
                setVisible(false);
                new Transactions(cardno,pin).setVisible(true);
            } 
            else if (amountTextField.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Enter the Amount");
            }
            else if(!input_pin.equals(pin))
                {
                    JOptionPane.showMessageDialog(null, "Incorrect  pin!");
                }    
            else if(e.getSource()==withdraw)
            {
                Date date = new Date();
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");
                PreparedStatement statement = connection.prepareStatement("select * from bank where cardno=?");
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
                    if(balance<Integer.parseInt(amount))
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    else
                    {
                       
                        PreparedStatement statement1 = connection.prepareStatement("INSERT INTO bank (cardno,pin,date,type,amount) VALUES (?,?,?,?,?)");
                        statement1.setString(1, cardno);
                        statement1.setString(2, pin);
                        statement1.setDate(3, new java.sql.Date(date.getTime()));
                        statement1.setString(4,"Withdraw");
                        statement1.setString(5,amount);
                        connection.createStatement(); 
                       
                        statement1.executeUpdate();
                        connection.close();
                        JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdraw successfylly");
                        setVisible(false);
                        new Transactions(cardno,pin).setVisible(true);
                    }
                    
                    
                }
        
            //balance+=amount1;
                
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
}
    public static void main(String[]args)
    {
        new Withdrawl("","");
    }
}

