import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener 
{
    
    private JPasswordField pinTextField1,pinTextField2;
    private JButton change, back;
    private JTextField cardTextField;
    String cardno,pin;

    Pin(String cardno,String pin)
    {
        this.cardno=cardno;
        this.pin=pin;
        setTitle("Punjab National Bank");
        setLayout(null);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Google Sans", Font.BOLD, 25));
        card.setBounds(80, 50, 400, 40);
        card.setForeground(Color.black);
        add(card);

        cardTextField = new JTextField();
        cardTextField.setBounds(80, 100, 250, 25);
        cardTextField.setFont(new Font("Google Sans", Font.BOLD, 14));
        cardTextField.setForeground(Color.black);
        cardTextField.setBackground(Color.white);
        cardTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        cardTextField.setColumns(10);
        add(cardTextField);

        pinTextField1 = new JPasswordField();
        pinTextField1.setBounds(80, 185, 250, 25);
        pinTextField1.setFont(new Font("Google Sans", Font.BOLD, 14));
        pinTextField1.setForeground(Color.black);
        pinTextField1.setBackground(Color.white);
        pinTextField1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pinTextField1.setColumns(10);
        add(pinTextField1);

        JLabel pin1 = new JLabel("Current PIN");
        pin1.setFont(new Font("Google Sans", Font.BOLD, 25));
        pin1.setBounds(80, 140, 240, 30);
        pin1.setForeground(Color.black);
        add(pin1);

        JLabel pin2 = new JLabel("New PIN:");
        pin2.setFont(new Font("Google Sans", Font.BOLD, 25));
        pin2.setBounds(80, 225, 240, 30);
        pin2.setForeground(Color.black);
        add(pin2);

        pinTextField2 = new JPasswordField();
        pinTextField2.setBounds(80, 270, 250, 25);
        pinTextField2.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField2.setForeground(Color.black);
        pinTextField2.setBackground(Color.white);
        pinTextField2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pinTextField2.setColumns(10);
        add(pinTextField2);

        
        back = new JButton("Back");
        back.setBounds(160, 380, 100, 30);
        back.setBackground(Color.BLUE);
        back.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        change = new JButton("Change");
        change.setBounds(160, 330, 100, 30);
        change.setBorder(BorderFactory.createMatteBorder(1, 2, 2, 1, Color.black));
        change.setBackground(Color.BLUE);
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        add(change);

        getContentPane().setBackground(Color.white);
        setSize(450,500);
        setVisible(true);
        setLocation(700,300);
    }

    public void actionPerformed(ActionEvent e) {
        try 
        {
            
            
           
            
            
            if (e.getSource() == back) 
            {
                setVisible(false);
                new Transactions(cardno,pin).setVisible(true);

            } 
            else if (e.getSource() == change) 
            {
                String input_cardno = cardTextField.getText();
                String input_pin = pinTextField1.getText();
                if (!cardno.equals(input_cardno)) 
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number");
                else{
                    if(!pin.equals(input_pin)) 
                        JOptionPane.showMessageDialog(null, "Incorrect PIN");
                    else{

                        String new_pin;
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");
                        PreparedStatement statement = connection.prepareStatement("select * from login where cardno=? and pin=?");
                        statement.setString(1, input_cardno);
                        statement.setString(2, input_pin);
                        ResultSet r=statement.executeQuery();
                        if(r.next())
                        {
                    
                            new_pin = pinTextField2.getText();
                            PreparedStatement statement1 = connection.prepareStatement("UPDATE login SET pin = ? WHERE cardno = ?");
                            PreparedStatement statement2 = connection.prepareStatement("UPDATE bank SET pin = ? WHERE pin = '"+input_pin+"'");
                    
                            statement1.setString(1, new_pin);
                            statement1.setString(2,cardno);
                            statement2.setString(1, new_pin);

                            statement1.executeUpdate();
                            statement2.executeUpdate();
                            connection.close();
                            JOptionPane.showMessageDialog(null, "Password changed successfully");

                            new Transactions(cardno,new_pin).setVisible(true);
                            setVisible(false);
                    

                            }
                        }

                }
                
                
            }
        } 
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
         new Pin("","");
                    
        }
 }

