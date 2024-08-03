package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener {
    JTextField tpnr;
    JLabel tname, cancelno, lblcode, lbldate;
    JButton flight, fetch;

    public Cancel() {
        setLayout(null);
        Random random = new Random();

        JLabel heading = new JLabel("Cancellation");
        heading.setBounds(180, 20, 200, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 140, 250, 250);
        add(image);

        JLabel lbladhar = new JLabel("PNR-Number");
        lbladhar.setBounds(60, 90, 150, 24);
        lbladhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbladhar);

        tpnr = new JTextField();
        tpnr.setBounds(200, 90, 160, 25);
        add(tpnr);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 24);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblname);

        tname = new JLabel();
        tname.setBounds(200, 130, 160, 25);
        add(tname);

        fetch = new JButton("Show details");
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(380, 90, 120, 25);
        fetch.addActionListener(this);
        add(fetch);

        JLabel lblnationality = new JLabel("Cancel No");
        lblnationality.setBounds(60, 180, 160, 24);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblnationality);

        cancelno = new JLabel("" + random.nextInt(100000));
        cancelno.setBounds(200, 180, 160, 25);
        add(cancelno);

        JLabel lbladdress = new JLabel("Flight code");
        lbladdress.setBounds(60, 240, 150, 24);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbladdress);

        lblcode = new JLabel();
        lblcode.setBounds(200, 240, 160, 25);
        add(lblcode);

        JLabel lblgender = new JLabel("Date of travel");
        lblgender.setBounds(60, 290, 150, 24);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        lbldate = new JLabel();
        lbldate.setBounds(220, 290, 150, 24);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        flight = new JButton("Cancel");
        flight.setForeground(Color.WHITE);
        flight.setBackground(Color.BLACK);
        flight.setBounds(220, 330, 120, 25);
        flight.addActionListener(this);
        add(flight);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 500);
        setLocation(200, 20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fetch) {
            String pnr = tpnr.getText();
            try {
                Conn conn = new Conn();
                String query = "SELECT * FROM reservative WHERE PNR='" + pnr + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    tname.setText(rs.getString("name"));
                    lblcode.setText(rs.getString("flightcode"));
                    lbldate.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (e.getSource() == flight) {
            String name = tname.getText();
            String pnr = tpnr.getText();
            String cancel = cancelno.getText();
            String code = lblcode.getText();
            String date = lbldate.getText();

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO cancell (pnr, name, cancelno, ddate, fcode) VALUES ('" + pnr + "', '" + name + "', '" + cancel + "', '" + date + "', '" + code + "')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate("DELETE FROM reservative WHERE PNR = '" + pnr + "'");

                JOptionPane.showMessageDialog(null, "Ticket canceled");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Cancel();
    }
}
