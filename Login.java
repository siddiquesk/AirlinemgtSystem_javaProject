package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JLabel lblusername,lblpassword;
    JTextField tusername;
    JPasswordField tpassword;
    JButton reset,submit,close;
    
    
    Login()
    {
        setLayout(null);
        lblusername =new JLabel("username");
        lblusername.setBounds(30,30,100,20);
        lblusername.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblusername);
        
        tusername =new JTextField();
        tusername.setBounds(150,30,220,25);
        add(tusername);
        
       lblpassword =new JLabel("password");
        lblpassword.setBounds(30,75,100,20);
        lblpassword.setFont(new Font("Raleway",Font.BOLD,20));
        add(lblpassword);
        
        tpassword =new JPasswordField();
       tpassword.setBounds(150,75,220,25);
        add(tpassword);
        
        reset =new JButton("Reset");
        reset.setBounds(50,150,140,25);
        reset.addActionListener(this);
        add(reset);
        
        submit =new JButton("Submit");
        submit.setBounds(220,150,140,25);
        submit.addActionListener(this);
        add(submit);
        
          close =new JButton("Close ");
        close .setBounds(120,190,170,25);
        close.addActionListener(this);
        add(close );
       
        getContentPane().setBackground(Color.WHITE);
        setSize(430,300);
        setLocation(200,100);
        setTitle("airline management system");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()==reset)
        {
            tusername.setText("");
            tpassword.setText("");
        }
        else if(e1.getSource()==submit)
        {
            String username=tusername.getText();
            String password=tpassword.getText();
            
            try{
                Conn c=new Conn();
                String qurey="select * from login where username='"+username+"'and password='"+password+"'";
               ResultSet rs= c.s.executeQuery(qurey);
               if(rs.next())
               {
                   new Home();
                          
                   setVisible(false);
               }
               else{
                  JOptionPane.showMessageDialog(null, "invalid usernameor password");
                  setVisible(false);
               }
            }
            catch(Exception ae)
            {
                
            }
        }
        else if(e1.getSource()==close)
        {
            setVisible(false);
        }
    }
public static void main(String args[])
{
    new Login();
}

}
