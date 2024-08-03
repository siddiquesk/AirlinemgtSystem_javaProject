package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {
    JTextField tadhar;
    JLabel tname, tnationality, taddress, labelgender, labelfname, labelfcode;
    JButton bookflight, flight, fetch;
    Choice source, destination;
    JDateChooser date;

    public BookFlight() {
        setLayout(null);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tohma", Font.PLAIN, 30));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lbladhar = new JLabel("Aadhar");
        lbladhar.setBounds(60, 90, 150, 24);
        lbladhar.setFont(new Font("Tohma", Font.PLAIN, 18));
        add(lbladhar);

        tadhar = new JTextField();
        tadhar.setBounds(200, 90, 160, 25);
        add(tadhar);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 24);
        lblname.setFont(new Font("Tohma", Font.PLAIN, 18));
        add(lblname);

        tname = new JLabel();
        tname.setBounds(200, 130, 160, 25);
        add(tname);

        fetch = new JButton("Fetch User");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(380, 90, 120, 25);
        fetch.addActionListener(this);
        add(fetch);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 160, 24);
        lblnationality.setFont(new Font("Tohma", Font.PLAIN, 18));
        add(lblnationality);

        tnationality = new JLabel();
        tnationality.setBounds(200, 180, 160, 25);
        add(tnationality);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 240, 150, 24);
        lbladdress.setFont(new Font("Tohma", Font.PLAIN, 18));
        add(lbladdress);

        taddress = new JLabel();
        taddress.setBounds(200, 240, 160, 25);
        add(taddress);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 290, 150, 24);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 24);
        labelgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelgender);

        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 24);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);

        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);

        JLabel dest = new JLabel("Destination");
        dest.setBounds(60, 380, 150, 24);
        dest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(dest);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);

        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        flight = new JButton("Fetch Flight");
        flight.setForeground(Color.WHITE);
        flight.setBackground(Color.BLACK);
        flight.setBounds(390, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 420, 150, 24);
        lblfname.setFont(new Font("Tohma", Font.PLAIN, 18));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(210, 420, 160, 25);
        add(labelfname);

        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 24);
        lbldate.setFont(new Font("Tohma", Font.PLAIN, 18));
        add(lbldate);

        date = new JDateChooser();
        date.setBounds(200, 530, 160, 25);
        add(date);

        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 24);
        lblfcode.setFont(new Font("Tohma", Font.PLAIN, 18));
        add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(210, 480, 160, 25);
        add(labelfcode);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 60, 500, 400);
        add(lblimage);

        bookflight = new JButton("Book Flight");
        bookflight.setForeground(Color.WHITE);
        bookflight.setBackground(Color.BLACK);
        bookflight.setBounds(220, 580, 120, 30);
        bookflight.addActionListener(this);
        add(bookflight);

        getContentPane().setBackground(Color.WHITE);
        setSize(1100, 670);
        setLocation(100, 20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == fetch) {
            String aadhar = tadhar.getText();

            try {
                Conn conn = new Conn();
                String query = "select * from passenger where adhar='" + aadhar + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    tname.setText(rs.getString("name"));
                    tnationality.setText(rs.getString("nationality"));
                    taddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please correct Aadhar");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (e1.getSource() == flight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();

            try {
                Conn conn = new Conn();
                String query = "select * from flight where source='" + src + "' and destination='" + dest + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No flight found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (e1.getSource() == bookflight) {
            Random random = new Random();

            String aadhar = tadhar.getText();
            String name = tname.getText();
            String nationality = tnationality.getText();
            String flightname = labelfname.getText();
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String desti = destination.getSelectedItem();
            String ddate = ((JTextField) date.getDateEditor().getUiComponent()).getText();

            try {
                Conn conn = new Conn();
                String query = "insert into reservative values('PNR-" + random.nextInt(100000) + "', 'TIC" + random.nextInt(10000) + "','" + aadhar + "','" + name + "','" + nationality + "','" + flightname + "','" + flightcode + "','" + src + "','" + desti + "','" + ddate + "')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Ticket booked successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new BookFlight();
    }
}
