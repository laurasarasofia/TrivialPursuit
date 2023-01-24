import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.util.*;


public class Aloitus extends JFrame implements ActionListener {

    private JButton button1;
    private JLabel label1, label2;
    private JTextArea ta1, ta2;
    private JRadioButton rb1, rb2, rb3, rb4;
    ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
    int i = 0;
    TilannePaivitys tilannePaivitys;

    public Aloitus() {

        super("Trivial Pursuit");
        setLayout(null);
        setSize(400, 400);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);

        ta1 = new JTextArea("Tervetuloa pelaamaan Trivial Pursuitia!" + "\n" + "Pelissä on tarkoituksena kerätä oikeat vastaukset jokaisesta" + "\n" + "kategoriasta. Suoritettuaan sen peli päättyy." + "\n" + "Tärkeä ohje: kirjoita vastauksesi isoilla alkukirjaimilla tarkasti oikein.");
        add(ta1);
        ta1.setBounds(10, 10, 400, 70);
        ta1.setBackground(Color.darkGray);
        ta1.setForeground(Color.white);

        ta2 = new JTextArea("Pelissä toimivat kategoriat"+ "\n" + "Sininen: maantiede"+ "\n" + "Pinkki: viihde"+ "\n" + "Keltainen: historia ja yhteiskunta"+ "\n" + "Ruskea: taide ja kirjallisuus"+ "\n" + "Vihreä: tiede ja ympäristö"+ "\n" + "Oranssi: urheilu");
        add(ta2);
        ta2.setBounds(10, 85, 400, 115);
        ta2.setBackground(Color.darkGray);
        ta2.setForeground(Color.white);

        //label2= new JLabel("Tervetuloa pelaamaan Trivial Pursuitia!" + "\n" + "Pelissä on tarkoituksena kerätä oikeat vastaukset jokaisesta kategoriasta ja suoritettuaan sen peli päättyy.");
        //add(label2);
        //label2.setBounds(10, 10, 400, 60);
        //label2.setForeground(Color.white);
        label1 = new JLabel("Kuinka monta pelaajaa? ");
        add(label1);
        label1.setBounds(10, 200, 400, 20);
        label1.setForeground(Color.white);

        rb1 = new JRadioButton("Tekoälyä vastaan");
        rb2 = new JRadioButton("2 pelaajaa");
        rb3 = new JRadioButton("3 pelaajaa");
        rb4 = new JRadioButton("4 pelaajaa");
        add(rb1);
        add(rb2);
        add(rb3);
        add(rb4);
        rb1.setBounds(10, 220, 200, 20);
        rb2.setBounds(10, 240, 200, 20);
        rb3.setBounds(10, 260, 200, 20);
        rb4.setBounds(10, 280, 200, 20);


        button1 = new JButton("Aloita peli");
        add(button1);
        button1.setBounds(10, 300, 200, 20);
        button1.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (rb1.isSelected()) {
            Pelaaja pelaaja = new Pelaaja();
            pelaajat.add(pelaaja);

            Tekoaly tekoaly = new Tekoaly();
            pelaajat.add(tekoaly);

            tilannePaivitys = new TilannePaivitys(2);

        }

        if (rb2.isSelected()) {
            for (int i = 0; i < 2; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
            tilannePaivitys = new TilannePaivitys(2);
        }
        if (rb3.isSelected()) {
            for (int i = 0; i < 3; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
            tilannePaivitys = new TilannePaivitys(3);
        }
        if (rb4.isSelected()) {
            for (int i = 0; i < 4; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
            tilannePaivitys = new TilannePaivitys(4);
        }

        for (int i = 0; i < pelaajat.size(); i++) {
            if (pelaajat.get(i).getClass().equals(Tekoaly.class)) {
                System.out.println("Pelaat tekoälyä vastaan");
            }

        }

        try {
            new Kysymystila(pelaajat, tilannePaivitys, onkoTekoaly());
            set();
        } catch (ParserConfigurationException | SAXException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void set() throws ParserConfigurationException, SAXException, IOException {
        label1.setText("Peli alkoi!");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        rb1.setVisible(false);
        rb2.setVisible(false);
        rb3.setVisible(false);
        rb4.setVisible(false);
        button1.setVisible(false);

    }

    public boolean onkoTekoaly(){
        for (int i = 0; i < pelaajat.size(); i++) {
            if (pelaajat.get(i).getClass().equals(Tekoaly.class)) {
                return true;
            }

        }
        return false;
    }

}
