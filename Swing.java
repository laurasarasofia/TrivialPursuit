
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Swing extends JFrame implements ActionListener {

    Scanner lukija = new Scanner(System.in);
    Pelaaja pelaaja = new Pelaaja();
    Kysymykset kysymykset = new Kysymykset();
    String kysymys;
    String vari;
    boolean tilanne = false;
    int i = 0;
    private JButton button1, button2;
    private JLabel label1;
    private JTextField tf1, tf2;

    private JTextField vastaus;

    public Swing() {

        super("Trivial Pursuit");
        setLayout(null);
        setSize(400, 400);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);

        label1 = new JLabel("Kuinka monta pelaajaa? ");
        add(label1);
        label1.setBounds(10, 10, 200, 20);
        label1.setForeground(Color.white);

        tf1 = new JTextField(10);
        add(tf1);
        tf1.setBounds(10, 30, 200, 20);

        button1 = new JButton("Aloita peli");
        add(button1);
        button1.setBounds(10, 60, 200, 20);
        button1.addActionListener(this);

        button2 = new JButton("Seuraava");
        add(button2);
        button2.setBounds(10, 90, 200, 20);
        button2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            int maara = Integer.parseInt(tf1.getText());
            ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();
            for (int i = 0; i < maara; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }

            /*while (tilanne == pelaajat.get(i).kaikkiVarit()) {
                System.out.println("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());
                String vastaus1 = lukija.nextLine();
                if (oikeaVastaus(vastaus1) == true) {
                    pelaajat.get(i).oikeaVastaus(vari);
                    System.out.println(vari + " arvattu oikein!!!");
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
            }*/
        }
        if (e.getActionCommand().equals("Aloita peli")) {
            label1.setText(randomKysymys());
            System.out.println("");
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
