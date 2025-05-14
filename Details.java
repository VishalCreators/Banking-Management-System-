import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Details extends JFrame  implements ActionListener{

    JLabel nameLabel, addressLabel,aadharLabel,atypeLabel,cardLabel,numLabel;
    JButton back;
    String cardno,pin;
    Details(String cardno,String pin) 
    {
        this.cardno=cardno;
        this.pin=pin;
        setLayout(null);

        // Custom rounded panel for the header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.blue);
        headerPanel.setBounds(0, 0, 590, 60);
        headerPanel.setLayout(null);
        add(headerPanel);

        back = new JButton("Back");
        back.setBounds(480, 380, 100, 30);
        back.setBackground(Color.BLUE);
        back.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        JLabel label = new JLabel("PERSONAL  DETAILS");
        label.setFont(new Font("Google Sans", Font.BOLD, 30));
        label.setForeground(Color.white);
        label.setBounds(140, 10, 400, 40);
        headerPanel.add(label);

        JLabel acc = new JLabel("ACCOUNT NO      :- ");
        acc.setFont(new Font("Google Sans", Font.PLAIN, 18));
        acc.setBounds(45, 80, 180, 20);
        acc.setForeground(Color.black);
        add(acc);

        JLabel cif = new JLabel("CIF NUMBER        :-        44684458");
        cif.setFont(new Font("Google Sans", Font.PLAIN, 18));
        cif.setBounds(45, 120, 380, 20);
        cif.setForeground(Color.black);
        add(cif);

        JLabel ifc = new JLabel("IFCS CODE           :-        634676544");
        ifc.setFont(new Font("Google Sans", Font.PLAIN, 18));
        ifc.setBounds(45, 160, 380, 20);
        ifc.setForeground(Color.black);
        add(ifc);

        JLabel acctyp = new JLabel("ACCOUNT TYPE  :- ");
        acctyp.setFont(new Font("Google Sans", Font.PLAIN, 18));
        acctyp.setBounds(45, 200, 180, 20);
        acctyp.setForeground(Color.black);
        add(acctyp);

        JLabel name = new JLabel("HOLDER NAME    :- ");
        name.setFont(new Font("Google Sans", Font.PLAIN, 18));
        name.setBounds(45, 240, 180, 20);
        name.setForeground(Color.black);
        add(name);

        JLabel address = new JLabel("ADDRESS             :- ");
        address.setFont(new Font("Google Sans", Font.PLAIN, 18));
        address.setBounds(45, 280, 180, 20);
        address.setForeground(Color.black);
        add(address);

        JLabel aadhar = new JLabel("AADHAR NO          :- ");
        aadhar.setFont(new Font("Google Sans", Font.PLAIN, 18));
        aadhar.setBounds(45, 320, 180, 20);
        aadhar.setForeground(Color.black);
        add(aadhar);

        JLabel num =new JLabel("PHONE NUMBER :- ");
        num.setFont(new Font("Google Sans", Font.PLAIN, 18));
        num.setBounds(45, 360, 180, 20);
        num.setForeground(Color.black);
        add(num);

        nameLabel = new JLabel("Fetching name...");
        nameLabel.setFont(new Font("Google Sans", Font.PLAIN, 18));
        nameLabel.setBounds(245, 238, 180, 20);
        add(nameLabel);

        addressLabel = new JLabel("Fetching address...");
        addressLabel.setFont(new Font("Google Sans", Font.PLAIN, 18));
        addressLabel.setBounds(245, 278, 480, 20);
        add(addressLabel);

        aadharLabel = new JLabel("Fetching address...");
        aadharLabel.setFont(new Font("Google Sans", Font.PLAIN, 18));
        aadharLabel.setBounds(245, 318, 180, 20);
        add(aadharLabel);

        cardLabel = new JLabel("Fetching address...");
        cardLabel.setFont(new Font("Google Sans", Font.PLAIN, 18));
        cardLabel.setBounds(245, 78, 180, 20);
        add(cardLabel);

        atypeLabel = new JLabel("Fetching address...");
        atypeLabel.setFont(new Font("Google Sans", Font.PLAIN, 18));
        atypeLabel.setBounds(245, 198, 180, 20);
        add(atypeLabel);

        numLabel = new JLabel("Fetching address...");
        numLabel.setFont(new Font("Google Sans", Font.PLAIN, 18));
        numLabel.setBounds(245, 358, 180, 20);
        add(numLabel);

        
        fetchData();
        

        
        getContentPane().setBackground(Color.white);
        setSize(600, 450);
        setVisible(true);
        setLocation(700, 300);
    }

    private void fetchData()  {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");

           
            PreparedStatement statement = connection.prepareStatement("SELECT name,address,phone FROM sign1 WHERE cardno = ?");
            statement.setString(1, cardno); // Setting the parameter

            ResultSet resultSet = statement.executeQuery();

            // Check if a record is found
            if (resultSet.next()) {
                nameLabel.setText(resultSet.getString("name"));
                addressLabel.setText(resultSet.getString("address"));  // Update the label
                numLabel.setText(resultSet.getString("phone"));  
            }
            PreparedStatement statement1 = connection.prepareStatement("SELECT aadhaar FROM sign2 WHERE cardno= ?");
            statement1.setString(1,cardno); // Setting the parameter

            ResultSet resultSet1 = statement1.executeQuery();

            // Check if a record is found
            if (resultSet1.next()) {
                aadharLabel.setText(resultSet1.getString("aadhaar")); // Update the label
            }

            PreparedStatement statement2 = connection.prepareStatement("SELECT cardno,atype FROM sign3 WHERE cardno= ?");
            statement2.setString(1, cardno); // Setting the parameter

            ResultSet resultSet2 = statement2.executeQuery();

            // Check if a record is found
            if (resultSet2.next()) {
                cardLabel.setText(resultSet2.getString("cardno")); // Update the label
                atypeLabel.setText(resultSet2.getString("atype"));
            }
            // Close database resources
            resultSet.close();
            statement.close();
            resultSet1.close();
            statement1.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error!");
        }
    }  
    public void actionPerformed(ActionEvent e) {
        try 
        {
            
            
           
            
            
            if (e.getSource() == back) 
            {
                setVisible(false);
                new Transactions(cardno,pin).setVisible(true);

            }
        }
        catch (Exception exception) 
        {
            exception.printStackTrace();
        }
    }  public static void main(String[] args) {
        new Details("","");
    }
}
