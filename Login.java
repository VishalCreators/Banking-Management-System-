import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    private JPasswordField pinTextField;
    private JButton login, clear, sign;
    private JTextField cardTextField;

    Login() {
        setLayout(null);

        // Custom rounded panel for the header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.blue);
        headerPanel.setBounds(0, 0, 590, 60);
        headerPanel.setLayout(null);
        add(headerPanel);

        JLabel label = new JLabel("ONLINE BANKING");
        label.setFont(new Font("Google Sans", Font.BOLD, 30));
        label.setForeground(Color.white);
        label.setBounds(160, 10, 400, 40);
        headerPanel.add(label);

        JLabel card = new JLabel("Card No:");
        card.setFont(new Font("Google Sans", Font.BOLD, 30));
        card.setBounds(95, 120, 400, 40);
        card.setForeground(Color.blue);
        add(card);

        cardTextField = new JTextField();
        cardTextField.setBounds(245, 125, 240, 30);
        cardTextField.setFont(new Font("Google Sans", Font.BOLD, 14));
        cardTextField.setForeground(Color.black);
        cardTextField.setBackground(Color.white);
        cardTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        cardTextField.setColumns(10);
        add(cardTextField);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(245, 190, 240, 30);
        pinTextField.setFont(new Font("Google Sans", Font.BOLD, 14));
        pinTextField.setForeground(Color.BLACK);
        pinTextField.setBackground(Color.white);
        pinTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        pinTextField.setColumns(10);
        add(pinTextField);

        JLabel pin1 = new JLabel("PIN:");
        pin1.setFont(new Font("Google Sans", Font.BOLD, 30));
        pin1.setBounds(95, 190, 240, 30);
        pin1.setForeground(Color.blue);
        add(pin1);

        sign = new JButton("SIGN UP");
        sign.setBounds(245, 320, 240, 30);
        sign.setBackground(Color.blue);
        sign.setForeground(Color.white);
        sign.addActionListener(this);
        add(sign);

        clear = new JButton("Clear");
        clear.setBounds(385, 270, 100, 30);
        clear.setBackground(Color.blue);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        login = new JButton("LOGIN");
        login.setBounds(245, 270, 100, 30);
        login.setBackground(Color.blue);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        getContentPane().setBackground(Color.white);
        setSize(600, 450);
        setVisible(true);
        setLocation(700, 300);
    }

    // Custom panel for rounded corners
    class RoundedPanel extends JPanel {
        private int cornerRadius;

        public RoundedPanel(int radius) {
            this.cornerRadius = radius;
            setOpaque(false); // Make the panel transparent
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == sign) {
                setVisible(false);
                new SignIn1().setVisible(true);
            } else if (e.getSource() == clear) {
                cardTextField.setText("");
                pinTextField.setText("");
            } else if (e.getSource() == login) {
                String cardno = cardTextField.getText();
                String pin = new String(pinTextField.getPassword());

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");
                     PreparedStatement statement = connection.prepareStatement("SELECT * FROM login WHERE cardno=? AND pin=?")) {

                    statement.setString(1, cardno);
                    statement.setString(2, pin);
                    ResultSet r = statement.executeQuery();

                    if (r.next()) {
                        setVisible(false);
                        new Transactions(cardno,pin).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect card number or PIN!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Database Error!");
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
