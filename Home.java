package airlinemanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener
{
  
    
    
    Home()
    {
        
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg"));
      JLabel image=new JLabel(i1);
      image.setBounds(0,0,1350,768);
      add(image);
        
    
       JLabel heading =new JLabel("AIR INDIA WELCOME YOU");
       heading.setBounds(500,30,800,40);
       heading.setForeground(Color.RED);
       heading.setFont(new Font("Tahoma",Font.PLAIN,36));
       image.add(heading);
        
       JMenuBar menu=new JMenuBar();
       setJMenuBar(menu);
       
       JMenu details=new JMenu("Details");
       menu.add(details);
       
        JMenuItem flightdetails=new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);
        
          JMenuItem customerdetails=new JMenuItem("Add Customer Details");
          customerdetails.addActionListener(this);
        details.add(customerdetails);
        
          JMenuItem bookdetails=new JMenuItem("Book Flight");
              bookdetails.addActionListener(this);
        details.add(bookdetails);
        
        JMenuItem journeydetails=new JMenuItem("Journey Details");
         journeydetails.addActionListener(this);
        details.add(journeydetails);
        
        JMenuItem ticketcancel=new JMenuItem(" Cancel Ticket");
         ticketcancel.addActionListener(this);
        details.add(ticketcancel);
        
        JMenu ticket=new JMenu("Ticket");
       menu.add(ticket);
       
        JMenuItem boardingpass=new JMenuItem("Boarding Pass");
        ticket.add(boardingpass);
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
     String text=e1.getActionCommand();
     if(text.equals("Add Customer Details"))
     {
         new AddCustomer();
     }
     else if(text.equals("Flight Details"))
     {
         new Flightinfo();
     }
     else if(text.equals("Book Flight"))
     {
         new BookFlight();
     }
     else if(text.equals("Journey Details"))
     {
         new Journeydetail();
     }
     
     else if(text.equals("Cancel Ticket"))
     {
         new Cancel();
     }
      else if(text.equals("oarding Pass"))
     {
         new Boardingpass();
     }
    }
public static void main(String args[])
{
    new Home();
}

}
