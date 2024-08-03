
package airlinemanagementsystem;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");// 1)register the driver
            c=DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem","root","Sk@123456");//2)connection stablish
            s=c.createStatement();//3)create statement
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
    }
    
   
}
