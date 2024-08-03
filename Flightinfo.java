
package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class Flightinfo extends JFrame
{
    
    Flightinfo()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JTable table=new JTable();
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,0,800,500);
        add(jsp);
        
     setSize(800,500);
     setLocation(400,200);
     setVisible(true);
    }
    
    public static void main(String args[])
    {
        new Flightinfo();
    }
    
}
