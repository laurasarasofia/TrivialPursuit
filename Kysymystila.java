
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class Kysymystila extends JFrame implements ActionListener { //Kysymystila-luokka luo uuden ikkunanäkymän
                                                                    //jossa pelin kysymyksiin vastataan
    Scanner lukija = new Scanner(System.in);
    Kysymykset kysymykset = new Kysymykset();
    ArrayList<Pelaaja> pelaajat;
    File myObj = new File("Kysymykset.xml");
    KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);

    String kysymys;
    String vari;
    boolean tilanne = false;
    int i = 0;
    private JButton button1;
    private JLabel label1;
    private JTextField tf1;
    TilannePaivitys tilannePaivitys;
    boolean tekoaly;

    //konstruktori ottaa parametreiksi pelin pelaajat listana, aikaisemmin luodun pelilaudan sekä tiedon onko yksi pelaajista tekoäly
    public Kysymystila(ArrayList<Pelaaja> pelaajat, TilannePaivitys tilannePaivitys, boolean tekoaly)
            throws ParserConfigurationException, SAXException, IOException {

        super("Trivial Pursuit"); 

        this.pelaajat = pelaajat;
        this.tilannePaivitys = tilannePaivitys;
        this.tekoaly = tekoaly;

        setLayout(null);
        setSize(500, 400);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);
        
        //label1 näyttää ensimmäisen kysymyksen ja kuka pelaajista on vuorossa
        label1 = new JLabel("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());
        add(label1);
        label1.setBounds(10, 10, 400, 20);
        label1.setForeground(Color.white);

        tf1 = new JTextField(10); //tekstikenttä, johon pelaaja vastaa kysymykseen
        add(tf1);
        tf1.setBounds(10, 30, 200, 20);

        button1 = new JButton("Vastaa");
        add(button1);
        button1.setBounds(10, 60, 200, 20);
        button1.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //painettaessa vastaa nappia kutsutaan peli metodi
        if (e.getActionCommand().equals("Vastaa") && pelaajat.get(i).kaikkiVarit() == tilanne) {

            peli();

        }
    }
    //metodilla tyhjennetään vastauslaatikko ja annetaan uudelle pelaajalle kysymys
    public void set(int i) throws ParserConfigurationException, SAXException, IOException {
        tf1.setText(null);
        button1.setText("Vastaa");
        label1.setText("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());

    }
    //metodi arpoo satunnaisesta kategoriasta satunnaisen kysymyksen ja palauttaa sen
    //tässä metodissa kutsutaan kysymystenKäsittely-luokkaa, joka lukee xml-tiedoston ja palauttaa kysymyksen
    public String randomKysymys() throws ParserConfigurationException, SAXException, IOException {

        String[] varit = { "siniset", "pinkit", "keltaiset", "violetit", "vihreat", "punaiset" };
        Random random = new Random();
        int indeksi = random.nextInt(varit.length);
        vari = varit[indeksi];
        kysymys = käsittely.getKysymys(vari);
        // kysymys = kysymykset.getKysymys(varit[indeksi]);
        return kysymys;
    }
    //metodi vertaa pelaajan vastausta oikeaan vastaukseen
    public boolean oikeaVastaus(String vastaus) throws ParserConfigurationException, SAXException, IOException {
        String oikeavastaus = käsittely.getVastaus();
        if (vastaus.equals(oikeavastaus)) {
            return true;
        } else {
            return false;
        }
    }
    //tämä metodi arpoo kaikista kysymysten vastauksista yhden vastauksen, joka muutetaan tekoälyn vastaukseksi
    //metodi muuttaa sen valmiiksi textfieldiin, josta käyttäjän pitää painaa vastaus nappia
    public void tekoalyVastaus(String vari) throws ParserConfigurationException, SAXException, IOException {
        if (pelaajat.get(1).getClass().equals(Tekoaly.class)) {
            Tekoaly tekoaly = (Tekoaly) pelaajat.get(1);
            String vastaus = tekoaly.vastaa(vari);
            tf1.setText(vastaus);
        }
    }

    public void peli() {
        String vastaus1 = tf1.getText(); //luodaan String muotoinen vastaus1, johon tallennetaan vastauskentän teksti
        try {
            //jos pelaaja vastaa oikein, kutsutaan metodia, joka lisää pelaajalle pisteen ja muuttaa pelilaudassa värin
            if (oikeaVastaus(vastaus1) == true) {
                pelaajat.get(i).oikeaVastaus(vari);
                JOptionPane.showMessageDialog(null, vari + " oikein!"); //ilmoitus, että vastaus on oikein
                tilannePaivitys.muutaTausta(vari, i); //metodi, joka muuttaa pelilaudan nappulan värin
                //System.out.println(pelaajat.get(i).getTilanne());

            } else { //ilmoitus, että vastaus on väärin ja kertoo myös oikean vastauksen
                JOptionPane.showMessageDialog(null, "Väärin! Oikea vastaus on: " + käsittely.getVastaus());
            }
        } catch (HeadlessException | ParserConfigurationException | SAXException | IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        if (pelaajat.get(i).kaikkiVarit() == true) { //jos pelaaja on saavuttanut kaikki värit, peli päättyy
            JOptionPane.showMessageDialog(null, "Pelaaja " + (i + 1) + " voitti!");
            System.exit(0);
        }
        if (i == (pelaajat.size() - 1)) {
            i = 0; //jos pelaaja on viimeinen pelaaja, aloitetaan alusta
        } else {
            i++; //muuten siirrytään seuraavaan pelaajaan
        }
        try { //tyhjentää vastauskentän ja antaa uuden kysymyksen kutsumalla set
            set(i);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (tekoaly == true && i == 1) { //jos toinen pelaaja on tekoäly, kutsutaan tekoälyn vastaus metodia
            try {
                tekoalyVastaus(vari);
            } catch (ParserConfigurationException | SAXException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }


}
