
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

public class Kysymystila extends JFrame implements ActionListener { // Kysymystila-luokka luo uuden ikkunanäkymän
                                                                    // jossa pelin kysymyksiin vastataan
    Scanner lukija = new Scanner(System.in);
    Kysymykset kysymykset = new Kysymykset();
    ArrayList<Pelaaja> pelaajat;
    File myObj = new File("Kysymykset.xml");
    KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);

    String kysymys;
    String vari;
    boolean tilanne = false;
    int indeksi;
    int i = 0;
    private JButton button1;
    private JLabel label1;
    private JTextField tf1;
    TilannePaivitys tilannePaivitys;
    boolean tekoaly;
    ArrayList<String> varit = new ArrayList<String>();
    ArrayList<Color> reunavarit = new ArrayList<Color>();
    JLayeredPane pane2 = getLayeredPane();
    ArrayList<Nappula> buttons = new ArrayList<Nappula>();
    ArrayList<JButton> nappulat = new ArrayList<JButton>();
    int kierros = 0;
    int indexib1 = 0;
    int indexib2 = 0;

    // konstruktori ottaa parametreiksi pelin pelaajat listana, aikaisemmin luodun
    // pelilaudan sekä tiedon onko yksi pelaajista tekoäly
    public Kysymystila(ArrayList<Pelaaja> pelaajat, TilannePaivitys tilannePaivitys, boolean tekoaly)
            throws ParserConfigurationException, SAXException, IOException {

        super("Trivial Pursuit");

        this.pelaajat = pelaajat;
        this.tilannePaivitys = tilannePaivitys;
        this.tekoaly = tekoaly;

        setLayout(null);
        setSize(500, 500);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);

        // ArrayList<Color> reunavarit = new ArrayList<Color>();
        reunavarit.add(Color.orange);
        reunavarit.add(Color.black);
        reunavarit.add(Color.white);
        reunavarit.add(Color.cyan);

        pelilauta();

        // label1 näyttää ensimmäisen kysymyksen ja kuka pelaajista on vuorossa

        label1 = new JLabel("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());
        pelaajat.get(i).setSijainti(indeksi);
        nappulat.get(indeksi).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));

        add(label1);
        label1.setBounds(10, 10, 500, 20);
        label1.setForeground(Color.white);

        tf1 = new JTextField(10); // tekstikenttä, johon pelaaja vastaa kysymykseen
        add(tf1);
        tf1.setBounds(10, 30, 200, 20);

        button1 = new JButton("Vastaa");
        add(button1);
        button1.setBounds(10, 60, 200, 20);
        button1.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // painettaessa vastaa nappia kutsutaan peli metodi
        if (e.getActionCommand().equals("Vastaa") && pelaajat.get(i).kaikkiVarit() == tilanne) {

            peli();

        }
        if (e.getSource() == nappulat.get(indexib1)) {
            indeksi = indexib1;
            try {
                valittuKysymys(indexib1);
            } catch (ParserConfigurationException | SAXException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (e.getSource() == nappulat.get(indexib2)) {
            indeksi = indexib2;
            try {
                valittuKysymys(indexib2);
            } catch (ParserConfigurationException | SAXException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }

    // metodilla tyhjennetään vastauslaatikko ja annetaan uudelle pelaajalle kysymys
    public void set(int i) throws ParserConfigurationException, SAXException, IOException {
        // pahasti solmussa, korjaa toiminnallisuus
        if (kierros == 0) {
            tf1.setText(null);
            button1.setText("Vastaa");
            label1.setText("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());
            pelaajat.get(i).setSijainti(indeksi);
            nappulat.get(indeksi).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
        }

        else {
            vaihtoehdot();
            nappulat.get(indexib1).setBorder(BorderFactory.createDashedBorder(Color.black, 5, 5));
            nappulat.get(indexib2).setBorder(BorderFactory.createDashedBorder(Color.black, 5, 5));
            nappulat.get(indexib1).addActionListener(this);
            nappulat.get(indexib2).addActionListener(this);
        }

    }

    public void valittuKysymys(int j) throws ParserConfigurationException, SAXException, IOException{
        nappulat.get(pelaajat.get(i).getSijainti()).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 0));
        int sijainti= pelaajat.get(i).getSijainti();

        tf1.setText(null);
        vari = buttons.get(j).getVari();
        label1.setText("Vuoro: pelaaja" + (i + 1) + " " + käsittely.getKysymys(vari));
        pelaajat.get(i).setSijainti(j);
        
        for(int i=0; i<pelaajat.size(); i++){
            if(pelaajat.get(i).getSijainti()==indexib1){
                nappulat.get(indexib1).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
                
            }
            else if(pelaajat.get(i).getSijainti()==indexib2){
                nappulat.get(indexib2).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
            }

            else{
                nappulat.get(indexib1).setBorder(BorderFactory.createLineBorder(Color.black, 0));
                nappulat.get(indexib2).setBorder(BorderFactory.createLineBorder(Color.black, 0));
            }
        }
        for (int i=0; i<pelaajat.size(); i++){
            if(pelaajat.get(i).getSijainti()==sijainti){
                nappulat.get(sijainti).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
            }
        }
     
        nappulat.get(j).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
    }

    public void vaihtoehdot() {
        int random = new Random().nextInt(1, 6);

        if ((pelaajat.get(i).getSijainti() - random) < 0 && pelaajat.get(i).getSijainti() + random > 11) {
            indexib1 = 11 + (pelaajat.get(i).getSijainti() - random);
            indexib2 = pelaajat.get(i).getSijainti() + random - 11;
        } else if (pelaajat.get(i).getSijainti() - random < 0 && pelaajat.get(i).getSijainti() + random < 11) {
            indexib1 = 11 + (pelaajat.get(i).getSijainti() - random);
            indexib2 = pelaajat.get(i).getSijainti() + random;
        } else if (pelaajat.get(i).getSijainti() + random > 11 && pelaajat.get(i).getSijainti() - random > 0) {
            indexib2 = pelaajat.get(i).getSijainti() + random - 11;
            indexib1 = pelaajat.get(i).getSijainti() - random;
        } else {
            indexib1 = pelaajat.get(i).getSijainti() - random;
            indexib2 = pelaajat.get(i).getSijainti() + random;
        }

    }

    // metodi arpoo satunnaisesta kategoriasta satunnaisen kysymyksen ja palauttaa
    // sen
    // tässä metodissa kutsutaan kysymystenKäsittely-luokkaa, joka lukee
    // xml-tiedoston ja palauttaa kysymyksen
    public String randomKysymys() throws ParserConfigurationException, SAXException, IOException {

        String[] varit = { "siniset", "pinkit", "keltaiset", "violetit", "vihreat", "punaiset" };
        Random random = new Random();
        indeksi = random.nextInt(varit.length);
        vari = varit[indeksi];
        kysymys = käsittely.getKysymys(vari);
        // kysymys = kysymykset.getKysymys(varit[indeksi]);
        return kysymys;
    }

    // metodi vertaa pelaajan vastausta oikeaan vastaukseen
    public boolean oikeaVastaus(String vastaus) throws ParserConfigurationException, SAXException, IOException {
        String oikeavastaus = käsittely.getVastaus();
        if (vastaus.equals(oikeavastaus)) {
            return true;
        } else {
            return false;
        }
    }

    // tämä metodi arpoo kaikista kysymysten vastauksista yhden vastauksen, joka
    // muutetaan tekoälyn vastaukseksi
    // metodi muuttaa sen valmiiksi textfieldiin, josta käyttäjän pitää painaa
    // vastaus nappia
    public void tekoalyVastaus(String vari) throws ParserConfigurationException, SAXException, IOException {
        if (pelaajat.get(1).getClass().equals(Tekoaly.class)) {
            Tekoaly tekoaly = (Tekoaly) pelaajat.get(1);
            String vastaus = tekoaly.vastaa(vari);
            tf1.setText(vastaus);
            button1.doClick();
        }
    }

    public void peli() {

        String vastaus1 = tf1.getText(); // luodaan String muotoinen vastaus1, johon tallennetaan vastauskentän teksti
        try {
            // jos pelaaja vastaa oikein, kutsutaan metodia, joka lisää pelaajalle pisteen
            // ja muuttaa pelilaudassa värin
            if (oikeaVastaus(vastaus1) == true) {
                pelaajat.get(i).oikeaVastaus(vari);
                JOptionPane.showMessageDialog(null, vari + " oikein!"); // ilmoitus, että vastaus on oikein
                tilannePaivitys.muutaTausta(vari, i); // metodi, joka muuttaa pelilaudan nappulan värin
                // System.out.println(pelaajat.get(i).getTilanne());

            } else { // ilmoitus, että vastaus on väärin ja kertoo myös oikean vastauksen
                JOptionPane.showMessageDialog(null, "Väärin! Oikea vastaus on: " + käsittely.getVastaus());
            }
        } catch (HeadlessException | ParserConfigurationException | SAXException | IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        if (pelaajat.get(i).kaikkiVarit() == true) { // jos pelaaja on saavuttanut kaikki värit, peli päättyy
            JOptionPane.showMessageDialog(null, "Pelaaja " + (i + 1) + " voitti!");
            System.exit(0);
        }
        if (i == (pelaajat.size() - 1)) {
            i = 0;
            kierros++; // jos pelaaja on viimeinen pelaaja, aloitetaan alusta
        } else {
            i++; // muuten siirrytään seuraavaan pelaajaan
        }
        try { // tyhjentää vastauskentän ja antaa uuden kysymyksen kutsumalla set
            set(i);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (tekoaly == true && i == 1) { // jos toinen pelaaja on tekoäly, kutsutaan tekoälyn vastaus metodia
            try {
                tekoalyVastaus(vari);
            } catch (ParserConfigurationException | SAXException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }

    public void pelilauta() {
        int x = 10;
        int y = 100;

        for (int i = 0; i < 2; i++) {
            varit.add("siniset");
            varit.add("pinkit");
            varit.add("keltaiset");
            varit.add("violetit");
            varit.add("vihreat");
            varit.add("punaiset");
        }

        for (int i = 0; i < varit.size(); i++) {
            Nappula nappula = new Nappula(varit.get(i), x, y);
            // x=x+50;
            if (y == 250 && x == 160) {
                x = x - 50;
            } else if (y <= 250 && y > 100 && x == 10) {
                y = y - 50;
            } else if (x == 160) {
                y = y + 50;
            } else if (y == 250) {
                x = x - 50;
            } else {
                x = x + 50;
            }
            // nappula.getNappula().addActionListener(this);
            pane2.add(nappula.getNappula(), new Integer(1));
            buttons.add(nappula);
            nappulat.add(nappula.getNappula());

        }
    }

}
