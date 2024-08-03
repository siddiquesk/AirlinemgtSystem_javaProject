
package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class Journeydetail extends JFrame implements ActionListener
{
    JTable table;
    JTextField pnr;
    JButton show;
    Journeydetail()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel lblpnr=new JLabel("PNR DETAILS");
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,17));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        pnr=new JTextField();
        pnr.setBounds(160,50,100,25);
        add(pnr);
        
        show=new JButton("Show");
        show.setBounds(290,50,120,25);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.addActionListener(this);
        add(show);
        
         table=new JTable();
        
       
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
     setSize(850,500);
     setLocation(400,200);
     setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e1)
    {
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from reservative where PNR ='"+pnr.getText()+"'");
            if(!rs.isBeforeFirst())
            {
                JOptionPane.showMessageDialog(null, "Invalid pnr");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new Journeydetail();
    }
    
}
