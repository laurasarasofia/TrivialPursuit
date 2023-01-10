
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

public class Swing extends JFrame implements ActionListener {
    // Create GUI for asking questions from user
    Scanner lukija = new Scanner(System.in);
    Pelaaja pelaaja = new Pelaaja();
    Kysymykset kysymykset = new Kysymykset();
    String kysymys;
    String vari;
    boolean tilanne = false;
    int i = 0;
    private JButton button1;
    private JLabel label1;
    private JTextField textfield1;

    public Swing() {
        super("Trivial Pursuit");
        setLayout(new FlowLayout());
        button1 = new JButton("Vastaa");
        label1 = new JLabel("Kuinka monta pelaajaa? ");
        textfield1 = new JTextField(10);
        add(label1);
        add(textfield1);
        add(button1);
        button1.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            int maara = Integer.parseInt(textfield1.getText());
            ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
            for (int i = 0; i < maara; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
            while (tilanne == pelaajat.get(i).kaikkiVarit()) {
                System.out.println("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());
                String vastaus = lukija.nextLine();
                if (oikeaVastaus(vastaus) == true) {
                    pelaajat.get(i).oikeaVastaus(vari);
                    System.out.println(vari + " arvattu oikein!!!");

                    //create colorful buttons for getTilanne()
                    

                    System.out.println(pelaajat.get(i).getTilanne());
                }
                if (pelaajat.get(i).kaikkiVarit() == true) {
                    System.out.println("Pelaaja" + (i + 1) + " voitti!");
                    break;
                }
                if (i == (pelaajat.size() - 1)) {
                    i = 0;
                } else {
                    i++;
                }
            }
        }
    }

    public String randomKysymys() {
        String[] varit = { "siniset", "pinkit", "keltaiset", "violetit", "vihreat", "punaiset" };
        Random random = new Random();
        int indeksi = random.nextInt(varit.length);
        vari = varit[indeksi];
        kysymys = kysymykset.getKysymys(varit[indeksi]);
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


