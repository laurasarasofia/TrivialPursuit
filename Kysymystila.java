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

public class Kysymystila extends JFrame implements ActionListener {

    private JButton button1;
    private JLabel label1;
    private JTextField tf1;
    ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
    int i = 0;

    public Kysymystila() {

        super("Trivial Pursuit");
        setLayout(null);
        setSize(400, 400);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);

        label1 = new JLabel("Kuinka monta pelaajaa? ");
        add(label1);
        label1.setBounds(10, 10, 400, 20);
        label1.setForeground(Color.white);

        tf1 = new JTextField(10);
        add(tf1);
        tf1.setBounds(10, 30, 200, 20);

        button1 = new JButton("Aloita peli");
        add(button1);
        button1.setBounds(10, 60, 200, 20);
        button1.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int maara = Integer.parseInt(tf1.getText());
        for (int i = 0; i < maara; i++) {
            Pelaaja pelaaja = new Pelaaja();
            pelaajat.add(pelaaja);
        }

        new Aloitustila();
    }

}
