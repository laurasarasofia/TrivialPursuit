import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Aloitus extends JFrame implements ActionListener {

    private JButton button1;
    private JLabel label1;
    private JTextField tf1;
    private JRadioButton rb1, rb2, rb3, rb4;
    ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
    int i = 0;

    public Aloitus() {

        super("Trivial Pursuit");
        setLayout(null);
        setSize(400, 400);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);

        label1 = new JLabel("Kuinka monta pelaajaa? ");
        add(label1);
        label1.setBounds(10, 10, 400, 20);
        label1.setForeground(Color.white);

        rb1 = new JRadioButton("Tekoälyä vastaan");
        rb2 = new JRadioButton("2 pelaajaa");
        rb3 = new JRadioButton("3 pelaajaa");
        rb4 = new JRadioButton("4 pelaajaa");
        add(rb1);
        add(rb2);
        add(rb3);
        add(rb4);
        rb1.setBounds(10, 30, 200, 20);
        rb2.setBounds(10, 50, 200, 20);
        rb3.setBounds(10, 70, 200, 20);
        rb4.setBounds(10, 90, 200, 20);

        tf1 = new JTextField(10);
        add(tf1);
        tf1.setBounds(10, 30, 200, 20);

        button1 = new JButton("Aloita peli");
        add(button1);
        button1.setBounds(10, 110, 200, 20);
        button1.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (rb1.isSelected()) {
            System.out.println("ei valmis vielä");
            
        }

        if (rb2.isSelected()) {
            for (int i = 0; i < 2; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
        }
        if (rb3.isSelected()) {
            for (int i = 0; i < 3; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
        }
        if (rb4.isSelected()) {
            for (int i = 0; i < 4; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
        }

        try {
            new Kysymystila(pelaajat);
        } catch (ParserConfigurationException | SAXException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}
