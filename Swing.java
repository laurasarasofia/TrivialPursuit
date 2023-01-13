
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

public class Swing extends JFrame implements ActionListener {

    Scanner lukija = new Scanner(System.in);
    Kysymykset kysymykset = new Kysymykset();
    ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
    String kysymys;
    String vari;
    boolean tilanne = false;
    int i = 0;
    private JButton button1, button2;
    private JLabel label1;
    private JTextField tf1, tf2;

    public Swing() {

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

        button2 = new JButton("Vastaa");
        // add(button2);
        button2.setBounds(10, 60, 200, 20);
        button2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Vastaa") && pelaajat.get(i).kaikkiVarit() == tilanne) {

            String vastaus1 = tf1.getText();
            if (oikeaVastaus(vastaus1) == true) {
                pelaajat.get(i).oikeaVastaus(vari);
                JOptionPane.showMessageDialog(null, vari + " oikein!" );               
                
                System.out.println(pelaajat.get(i).getTilanne());
            }
            else{
                JOptionPane.showMessageDialog(null, "Väärin! Oikea vastaus on: " + kysymykset.getVastaus() );
            }
            if (pelaajat.get(i).kaikkiVarit() == true) {
                System.out.println("Pelaaja" + (i + 1) + " voitti!");
                System.exit(0);
            }
            if (i == (pelaajat.size() - 1)) {
                i = 0;
            } else {
                i++;
            }
            try {
                set(i);
            } catch (ParserConfigurationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SAXException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

        if (e.getActionCommand().equals("Aloita peli")) {
            int maara = Integer.parseInt(tf1.getText());
            for (int i = 0; i < maara; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }

            try {
                set(i);
            } catch (ParserConfigurationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (SAXException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }
    }

    public void set(int i) throws ParserConfigurationException, SAXException, IOException {
        tf1.setText(null);
        button1.setText("Vastaa");
        label1.setText("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());

    }

    public String randomKysymys() throws ParserConfigurationException, SAXException, IOException {
        File myObj = new File("Kysymykset.xml");
        KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);
        String[] varit = { "siniset", "pinkit", "keltaiset", "violetit", "vihreat", "punaiset" };
        Random random = new Random();
        int indeksi = random.nextInt(varit.length);
        vari = varit[indeksi];
        kysymys = käsittely.getKysymys(vari);
        //kysymys = kysymykset.getKysymys(varit[indeksi]);
        return kysymys;
    }

    public boolean oikeaVastaus(String vastaus) {
        if (vastaus.equals(vastaus = kysymykset.getVastaus())) {
            return true;
        } else {
            return false;
        }
    }
}
