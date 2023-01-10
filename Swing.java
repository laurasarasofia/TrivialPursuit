
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
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

    private JTextField vastaus;

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

        if (e.getActionCommand().equals("Vastaa")) {
            while (tilanne == pelaajat.get(i).kaikkiVarit()) {
                // set(i);
                // label1.setText("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());
                // System.out.println("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());
                String vastaus1 = tf1.getText();
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
                set(i);

            }
        }

        if (e.getActionCommand().equals("Aloita peli")) {
            int maara = Integer.parseInt(tf1.getText());
            for (int i = 0; i < maara; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
            // tf1.setText(null);
            // button1.setText("Vastaa");

            // label1.setText(randomKysymys());

        }
        // button1.setVisible(false);
        // add(button2);
        // button2.setVisible(true);
        set(i);

    }

    /*
     * if (e.getSource() == button1) {
     * label1.setText(randomKysymys());
     * button1.setText("Vastaa");
     * System.out.println("");
     * }
     */
    public void set(int i) {
        tf1.setText(null);
        button1.setText("Vastaa");
        label1.setText("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());

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
