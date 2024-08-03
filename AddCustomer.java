
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddCustomer extends JFrame implements ActionListener
{
    JTextField tname,tphone,tnationality,tadhar,taddress;
    JRadioButton male,female;
    
  public  AddCustomer()
    {
        setLayout(null);
        
        JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(300,20,500,35);
        heading.setFont(new Font("Tohma",Font.PLAIN,30));
        heading.setForeground(Color.BLUE);
        add(heading);
        
           JLabel lblname=new JLabel("Name");
        lblname.setBounds(60,90,150,24);
        lblname.setFont(new Font("Tohma",Font.PLAIN,18));
        add(lblname);
        
         tname=new JTextField();
        tname.setBounds(200,90,160,25);
        add(tname);
        
                  JLabel lblnationality=new JLabel("Nationality");
       lblnationality.setBounds(60,140,160,24);
        lblnationality.setFont(new Font("Tohma",Font.PLAIN,18));
        add(lblnationality);
        
         tnationality=new JTextField();
         tnationality.setBounds(200,140,160,25);
        add( tnationality);
        
         JLabel lbladhar=new JLabel("Aadhar No");
       lbladhar.setBounds(60,190,150,24);
       lbladhar.setFont(new Font("Tohma",Font.PLAIN,18));
        add(lbladhar);
        
          tadhar =new JTextField();
        tadhar.setBounds(200,190,160,25);
        add( tadhar);
        
              JLabel lbladdress=new JLabel("Address");
       lbladdress.setBounds(60,240,150,24);
       lbladdress.setFont(new Font("Tohma",Font.PLAIN,18));
        add(lbladdress);
        
      taddress =new JTextField();
       taddress.setBounds(200,240,160,25);
        add(taddress);
        
              JLabel lblgender=new JLabel("Gender");
       lblgender.setBounds(60,290,150,24);
       lblgender.setFont(new Font("Tohma",Font.PLAIN,18));
        add(lblgender);
        
        ButtonGroup gendergroup=new ButtonGroup();
        
        male=new JRadioButton("Male");
        male.setBounds(200,290,80,30);
        male.setBackground(Color.WHITE);
        add(male);
        
            female=new JRadioButton("Feamle");
        female.setBounds(310,290,90,30);
         female.setBackground(Color.WHITE);
        add( female);
        
        gendergroup.add(male);
        gendergroup.add(female);
        
             JLabel lblphone=new JLabel("Phone No");
       lblphone.setBounds(60,340,160,24);
       lblphone.setFont(new Font("Tohma",Font.PLAIN,18));
        add(lblphone);
        
        tphone =new JTextField();
       tphone.setBounds(200,340,160,25);
        add(tphone);
        
        JButton save=new JButton("Save");
        save.setForeground(Color.WHITE);
        save.setBackground(Color.BLACK);
        save.setBounds(200,390,160,30);
       save.addActionListener(this);
        add(save);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/emp.png"));
        JLabel lblimage=new JLabel(i1);
        lblimage.setBounds(430,80,280,400);
        add(lblimage);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(900,600);
        setLocation(300,100);
        setVisible(true);
    }
  public void actionPerformed(ActionEvent e1)
  {
      String name=tname.getText();
      String nationality=tnationality.getText();
      String phone=tphone.getText();
      String adhar=tadhar.getText();
      String address=taddress.getText();
      String gender=null;
      if(male.isSelected())
      {
          gender="Male";
      }
      else{
          gender="Female";
      }
      try{
          Conn conn=new Conn();
     String qurey="insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+adhar+"','"+address+"','"+gender+"')";
         conn.s.executeUpdate(qurey);
         JOptionPane.showMessageDialog(null, "Customer details added sucessfully");
          setVisible(false);
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
  }
    
    public static void main(String args[])
    {
        new AddCustomer();
    }
}
