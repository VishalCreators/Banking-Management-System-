import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;
public class SignIn2 extends JFrame implements ActionListener
{
    JTextField rTextField,incomeTextField,panTextField,aadhaarTextField;
    JComboBox categorys, educations,occupations;
    JRadioButton yes,no,yes1,no1;
    JButton next;
    String cardno;

    SignIn2(String cardno)
    {
        this.cardno=cardno;
        setTitle("SIGN IN");

        JLabel text=new JLabel("APPLICATION FORM");
        text.setFont(new Font("Times New Roman",Font.BOLD,30));
        text.setBounds(200,40,400,40);
        text.setForeground(Color.BLACK);
        add(text);

        JLabel text1=new JLabel("Page2 : Additional Details");
        text1.setFont(new Font("Times New Roman",Font.BOLD,20));
        text1.setBounds(250,100,400,40);
        text1.setForeground(Color.BLACK);
        add(text1);

        JLabel name=new JLabel("Religion :");
        name.setFont(new Font("Times New Roman",Font.BOLD,20));
        name.setBounds(100,160,240,30);
        name.setForeground(Color.BLACK);
        add(name);

        rTextField=new JTextField();
        rTextField.setBounds(270,160,310,25);
        rTextField.setFont(new Font("Arial",Font.BOLD,14));
        rTextField.setForeground(Color.BLACK);
        rTextField.setBackground(Color.WHITE);
        rTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(rTextField);


        JLabel fname=new JLabel("Category :");
        fname.setFont(new Font("Times New Roman",Font.BOLD,20));
        fname.setBounds(100,210,240,30);
        fname.setForeground(Color.BLACK);
        add(fname);

        String valCategory[]={null,"General","OBC","ST","SC","Others"};
        categorys=new JComboBox(valCategory);
        categorys.setBounds(270,210,310,25);
        categorys.setForeground(Color.BLACK);
        categorys.setBackground(Color.WHITE);
        categorys.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(categorys);

        JLabel date=new JLabel("Income :");
        date.setFont(new Font("Times New Roman",Font.BOLD,20));
        date.setBounds(100,260,240,30);
        date.setForeground(Color.BLACK);
        add(date);

        incomeTextField=new JTextField();
        incomeTextField.setBounds(270,260,310,25);
        incomeTextField.setFont(new Font("Arial",Font.BOLD,14));
        incomeTextField.setForeground(Color.BLACK);
        incomeTextField.setBackground(Color.WHITE);
        incomeTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(incomeTextField);

        JLabel ed=new JLabel("Educational ");
        ed.setFont(new Font("Times New Roman",Font.BOLD,20));
        ed.setBounds(100,310,240,30);
        ed.setForeground(Color.BLACK);
        add(ed);

        JLabel ed1=new JLabel("Qualification : ");
        ed1.setFont(new Font("Times New Roman",Font.BOLD,20));
        ed1.setBounds(100,330,240,30);
        ed1.setForeground(Color.BLACK);
        add(ed1);

        String valEducation[]={null,"Non Graduate","Graduate","Post Graduate","Others"};
        educations=new JComboBox(valEducation);
        educations.setBounds(270,320,310,25);
        educations.setForeground(Color.BLACK);
        educations.setBackground(Color.WHITE);
        educations.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(educations);

        JLabel email=new JLabel("Occupation:");
        email.setFont(new Font("Times New Roman",Font.BOLD,20));
        email.setBounds(100,380,240,30);
        email.setForeground(Color.BLACK);
        add(email);

        String valOccupation[]={null,"Student","Self-Employed","Salaried","Retiered","Others"};
        occupations=new JComboBox(valOccupation);
        occupations.setBounds(270,380,310,25);
        occupations.setForeground(Color.BLACK);
        occupations.setBackground(Color.WHITE);
        occupations.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(occupations);

        JLabel pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Times New Roman",Font.BOLD,20));
        pan.setBounds(100,430,240,30);
        pan.setForeground(Color.BLACK);
        add(pan);

        panTextField=new JTextField();
        panTextField.setBounds(270,430,310,25);
        panTextField.setFont(new Font("Arial",Font.BOLD,14));
        panTextField.setForeground(Color.BLACK);
        panTextField.setBackground(Color.WHITE);
        panTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(panTextField);

        JLabel address=new JLabel("Aadhaar Number:");
        address.setFont(new Font("Times New Roman",Font.BOLD,20));
        address.setBounds(100,480,240,30);
        address.setForeground(Color.BLACK);
        add(address);

        aadhaarTextField=new JTextField();
        aadhaarTextField.setBounds(270,480,310,25);
        aadhaarTextField.setFont(new Font("Arial",Font.BOLD,14));
        aadhaarTextField.setForeground(Color.BLACK);
        aadhaarTextField.setBackground(Color.WHITE);
        aadhaarTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        add(aadhaarTextField);

        JLabel city=new JLabel("Senior Citizen:");
        city.setFont(new Font("Times New Roman",Font.BOLD,20));
        city.setBounds(100,530,240,30);
        city.setForeground(Color.BLACK);
        add(city);

        yes=new JRadioButton("Yes");
        yes.setBounds(270,530,60,30);
        yes.setBackground(Color.WHITE);
        yes.setForeground(Color.BLACK);
        add(yes);

        no=new JRadioButton("No");
        no.setBounds(385,530,80,30);
        no.setBackground(Color.WHITE);
        no.setForeground(Color.BLACK);
        add(no);

        ButtonGroup cgroup=new ButtonGroup();
        cgroup.add(yes);
        cgroup.add(no);
    

        JLabel pin=new JLabel("Existing Account:");
        pin.setFont(new Font("Times New Roman",Font.BOLD,20));
        pin.setBounds(100,580,240,30);
        pin.setForeground(Color.BLACK);
        add(pin);

        yes1=new JRadioButton("Yes");
        yes1.setBounds(270,580,60,30);
        yes1.setBackground(Color.WHITE);
        yes1.setForeground(Color.BLACK);
        add(yes1);
        
        no1=new JRadioButton("No");
        no1.setBounds(385,580,80,30);
        no1.setBackground(Color.WHITE);
        no1.setForeground(Color.BLACK);
        add(no1);

        ButtonGroup egroup=new ButtonGroup();
        egroup.add(yes1);
        egroup.add(no1);
    


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


        getContentPane().setBackground(Color.WHITE);
        setSize(700,800);
        setVisible(true);
        setLocation(700,200);
    }
    public void actionPerformed(ActionEvent e)
    {
        String religion = rTextField.getText(); 
        String category = (String)categorys.getSelectedItem();
        String income= incomeTextField.getText();
        String education = (String)educations.getSelectedItem();
        String occupation = (String)occupations.getSelectedItem();
        String pan = panTextField.getText();
        String aadhaar = aadhaarTextField.getText();
        
        String senior_citizen = "";
        if(yes.isSelected()){ 
            senior_citizen  = "Yes";
        }
        else if(no.isSelected()){ 
            senior_citizen  = "No";
        }
           
        String existing_account = "";
        if(yes1.isSelected()){ 
            existing_account= "Yes";
        }else if(no1.isSelected()){ 
            existing_account = "No";
        }
        try 
        {
            if (rTextField.getText().equals("")) {
                
                JOptionPane.showMessageDialog(null, "Fill the Name fields");
            } 
            else if (incomeTextField.getText().equals("")) 
            {
                
                JOptionPane.showMessageDialog(null, "Fill the Income ");
            } 
            
            else if (aadhaarTextField.getText().equals("")) 
            {
                
                JOptionPane.showMessageDialog(null, "Fill the Aadhaar fields");
            } 
            else if (panTextField.getText().equals("")) 
            {
                
                JOptionPane.showMessageDialog(null, "Fill the PAN Number ");
            } 
            
            
            else if(e.getSource() == next)  
            {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_demo1", "root", "bishal");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO sign2(cardno,religion,category,income,education,occupation,pan,aadhaar ,senior_citizen,existing_account) VALUES (?,?,?,?,?,?,?,?,?,?)");
                statement.setString(1, cardno);
                statement.setString(2, religion);
                statement.setString(3,category);
                statement.setString(4,income);
                statement.setString(5,education);
                statement.setString(6,occupation);
                statement.setString(7,pan);
                statement.setString(8,aadhaar );
                statement.setString(9,senior_citizen);
                statement.setString(10,existing_account);
                connection.createStatement(); 
                statement.executeUpdate();
                setVisible(false);
                new SignIn3(cardno).setVisible(true); 
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
        new SignIn2(" ");
    }
}
