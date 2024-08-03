package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Boardingpass extends JFrame implements ActionListener {
    JTextField tpnr;
    JLabel tname, tnationality, lblsrc, lbldesti, labelfname, tdate, lblcode;
    JButton fetch;

    public Boardingpass() {
        setLayout(null);

        JLabel heading = new JLabel("Air India");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(350, 40, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 25));
        subheading.setForeground(Color.RED);
        add(subheading);

        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setBounds(60, 80, 150, 24);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblpnr);

        tpnr = new JTextField();
        tpnr.setBounds(200, 80, 160, 25);
        add(tpnr);
        
        fetch = new JButton("Enter");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(380, 80, 120, 25);
        fetch.addActionListener(this);
        add(fetch);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 24);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblname);

        tname = new JLabel();
        tname.setBounds(200, 130, 160, 25);
        add(tname);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 170, 150, 24);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblnationality);

        tnationality = new JLabel();
        tnationality.setBounds(200, 170, 160, 25);
        add(tnationality);

        JLabel lblsrc = new JLabel("SRC");
        lblsrc.setBounds(60, 210, 150, 24);
        lblsrc.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsrc);

        lblsrc = new JLabel();
        lblsrc.setBounds(200, 210, 160, 25);
        add(lblsrc);

        JLabel lbldestiLabel = new JLabel("Desti");
        lbldestiLabel.setBounds(60, 250, 150, 24);
        lbldestiLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldestiLabel);

        lbldesti = new JLabel();
        lbldesti.setBounds(200, 250, 160, 25);
        add(lbldesti);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 290, 150, 24);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(200, 290, 160, 25);
        add(labelfname);

        JLabel lblcodeLabel = new JLabel("Flight code");
        lblcodeLabel.setBounds(60, 330, 150, 24);
        lblcodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblcodeLabel);

        lblcode = new JLabel();
        lblcode.setBounds(200, 330, 160, 25);
        add(lblcode);

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 370, 150, 24);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);

        tdate = new JLabel();
        tdate.setBounds(200, 370, 160, 25);
        add(tdate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(500, 0, 300, 300);
        add(lblimage);

        getContentPane().setBackground(Color.WHITE);
        setSize(900, 450);
        setLocation(200, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e1) {
        String pnr = tpnr.getText();

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM reservation WHERE PNR='" + pnr + "'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if (rs.next()) {
                tname.setText(rs.getString("name")); 
                tnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("src"));
                lbldesti.setText(rs.getString("desti")); 
                labelfname.setText(rs.getString("flightname"));
                lblcode.setText(rs.getString("flightcode"));
                tdate.setText(rs.getString("ddate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Boardingpass();
    }
}
