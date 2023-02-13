
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
    ArrayList<Pelaaja> pelaajat;
    File myObj = new File("Kysymykset.xml");
    KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);

    String kysymys;
    String vari;
    int indeksi; //käytetään pelilaudassa
    int i = 0; //käytetään pelaajien vuoron seuraamiseen
    private JButton button1;
    private JLabel label1;
    private JTextField tf1;
    TilannePaivitys tilannePaivitys;
    
    ArrayList<String> varit = new ArrayList<String>(); //pelilaudan luomista varten
    ArrayList<Color> reunavarit = new ArrayList<Color>(); //pelaajien sijainti laudalla
    JLayeredPane pane2 = getLayeredPane();
    ArrayList<Nappula> buttons = new ArrayList<Nappula>(); //pelilaudan nappula-oliot
    ArrayList<JButton> nappulat = new ArrayList<JButton>(); //pelilaudan nappulat
    int kierros = 0; //monesko kierros käynnissä
    int indexib1 = 0; //pelilaudan vaihtoehtojen indeksit
    int indexib2 = 0;

    // konstruktori ottaa parametreiksi pelin pelaajat listana, aikaisemmin luodun
    public Kysymystila(ArrayList<Pelaaja> pelaajat, TilannePaivitys tilannePaivitys)
            throws ParserConfigurationException, SAXException, IOException {

        super("Trivial Pursuit");

        this.pelaajat = pelaajat;
        this.tilannePaivitys = tilannePaivitys;
       
        setLayout(null);
        setSize(500, 500);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);

        //lisää listaan värit, joidenka avulla merkataan pelilaudalle kenen vuoro on kyseessä
        Color c1 = new Color(255, 153, 204);
        Color c2 = new Color(153, 255, 51);
        Color c3 = new Color(255, 255, 51);
        Color c4 = new Color(51, 153, 255);
        Color c5 = new Color(204, 0, 102);
        Color c6 = new Color(102, 255, 255);
        Color c7 = new Color(76, 0, 153);
        reunavarit.add(c7);
        reunavarit.add(c1);
        reunavarit.add(c2);
        reunavarit.add(c3);
        reunavarit.add(c4);
        reunavarit.add(c5);
        reunavarit.add(c6);


        //kutsuu metodia, joka luo pelilaudan
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

        if(pelaajat.get(i).onkoAI()==true){
            tekoalyVastaus();
        }
    }

    

    public void actionPerformed(ActionEvent e) {
        // painettaessa vastaa nappia kutsutaan peli metodi
        if (e.getActionCommand().equals("Vastaa") && pelaajat.get(i).kaikkiVarit() == false) {

            peli();

        }
        // painettaessa vaihtoehto nappeja kutsutaan valittukysymys-metodia oikealla indeksillä
        if (e.getSource() == nappulat.get(indexib1)) {
            nappulat.get(indexib1).removeActionListener(this);
            nappulat.get(indexib2).removeActionListener(this);
            indeksi = indexib1; //muutetaan indeksi, jotta voidaan muuttaa nappulan reunat oikealle kohdalle
            try {
                valittuKysymys(indexib1);
            } catch (ParserConfigurationException | SAXException | IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == nappulat.get(indexib2)) {
            nappulat.get(indexib1).removeActionListener(this);
            nappulat.get(indexib2).removeActionListener(this);
            indeksi = indexib2;
            try {
                valittuKysymys(indexib2);
            } catch (ParserConfigurationException | SAXException | IOException e1) {
                e1.printStackTrace();
            }
        }

    }

 
    public void set(int i) throws ParserConfigurationException, SAXException, IOException {
        //testaa onko pelin ensimmäinen kierros käynnissä, koska ensimmäisellä kierroksella paikat pelilaudalla arvotaan eikä vielä valita
        if (kierros == 0) {
            tf1.setText(null);
            button1.setText("Vastaa");
            label1.setText("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());
            pelaajat.get(i).setSijainti(indeksi);
            nappulat.get(indeksi).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5)); //muuttaa nappulan reunat, jotta näkyy kenen vuoro on kyseessä
        }
        //muilla kierroksilla kutsutaan vaihtoehdot-metodia, jonka avulla toteutetaan kysymys vaihtoehdot
        else {
            vaihtoehdot();
            nappulat.get(indexib1).setBorder(BorderFactory.createDashedBorder(Color.black, 5, 5)); //merkitsee vaihtoehtoa
            nappulat.get(indexib2).setBorder(BorderFactory.createDashedBorder(Color.black, 5, 5));
            nappulat.get(indexib1).addActionListener(this);
            nappulat.get(indexib2).addActionListener(this);
        }

    }
    //metodin avulla  hallitaan pelilaudan nappula kohtaisia reunoja
    //sekä annetaan kysymykset
    public void valittuKysymys(int j) throws ParserConfigurationException, SAXException, IOException{
        //poistaa pelaajan aikaisemman sijainnin pelilaudalla, muuttamalla reunan paksuuden 0:ksi
        nappulat.get(pelaajat.get(i).getSijainti()).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 0)); 
        int sijainti= pelaajat.get(i).getSijainti(); //tallentaa pelaajan vanhan sijainnin, jotta tiedetään peittääkö se muiden pelaajien sijainteja

        tf1.setText(null);
        vari = buttons.get(j).getVari();
        label1.setText("Vuoro: pelaaja" + (i + 1) + " " + käsittely.getKysymys(vari));
        pelaajat.get(i).setSijainti(j);
        
        //käydään pelaajien sijainnit läpi, jotta muiden pelaajien sijainnit pysyvät pelilaudalla
        for(int i=0; i<pelaajat.size(); i++){
            if(pelaajat.get(i).getSijainti()==indexib1){ //jos toinen vaihtoehto on muun pelaajan sijainti, muutetaan reunat pelaajan reunaväriksi
                nappulat.get(indexib1).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
                
            }
            else if(pelaajat.get(i).getSijainti()==indexib2){ //jos toinen vaihtoehto on muun pelaajan sijainti, muutetaan reunat pelaajan reunaväriksi
                nappulat.get(indexib2).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
            }

            else{ //jos ei ole muun pelaajan sijainti, otetaan reunat pois muuttamalla paksuus 0:ksi
                nappulat.get(indexib1).setBorder(BorderFactory.createLineBorder(Color.black, 0));
                nappulat.get(indexib2).setBorder(BorderFactory.createLineBorder(Color.black, 0));
            }
        }
        for (int i=0; i<pelaajat.size(); i++){
            if(pelaajat.get(i).getSijainti()==sijainti){ //jos kaksi pelaajista on ollut päällekkäin pelilaudalla, pelaajan poistuessa
                                                //muutetaan reunat edellisen pelaajan reunaväriksi
                nappulat.get(sijainti).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
            }
        }
        //uuden sijainnin reunat muutetaan pelaajan reunaväriksi
        nappulat.get(j).setBorder(BorderFactory.createLineBorder(reunavarit.get(i), 5));
    }
    //metodin avulla luodaan pelilaudalle kaksi kysymysvaihtoehtoa arpomalla silmäluku
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
        if (oikeavastaus.equals(vastaus)) {
            return true;
        } else {
            return false;
        }
    }

    // tämä metodi arpoo kaikista kysymysten vastauksista yhden vastauksen, joka
    // muutetaan tekoälyn vastaukseksi
    // metodi muuttaa sen valmiiksi textfieldiin, josta käyttäjän pitää painaa
    // vastaus nappia
    public void tekoalyVastaus() throws ParserConfigurationException, SAXException, IOException {
        pelaajat.get(i).annaKysymystenKäsittely(käsittely);
        
        if(kierros>0){
            nappulat.get(indexib1).doClick(3000);
            vari = buttons.get(indexib1).getVari();
        }
    
        if (pelaajat.get(i).onkoAI()==true) {
            String testi =pelaajat.get(i).vaikeaAI(vari);
            //String vastaus = pelaajat.get(i).annaOikeaVastaus(vari);
            tf1.setText(testi);
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

            e.printStackTrace();
        }
        if (pelaajat.get(i).onkoAI()==true) { // jos toinen pelaaja on tekoäly, kutsutaan tekoälyn vastaus metodia
            try {
                tekoalyVastaus();
            } catch (ParserConfigurationException | SAXException | IOException e1) {
                e1.printStackTrace();
            }
        }

    }

    public void pelilauta() {
        // luodaan pelilauta ja lisätään Nappula-luokan nappulat edustamaan sijainteja. Nappula saa värin ja sijainnin parametreina
        //lauta muodostuu 12 nappulasta, joista 2 on sinisiä, 2 on pinkkejä, 2 on keltaisia, 2 on violetteja, 2 on vihreitä ja 2 on punaisia
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
        //for-loopissa muutetaan nappuloiden sijainteja, jotta saadaan oikean muotoinen pelilauta
        for (int i = 0; i < varit.size(); i++) {
            //Font nappulafont=new Font("Arial", Font.BOLD, 10);
            Nappula nappula = new Nappula(varit.get(i), x, y);
            if (y == 310 && x == 220) {
                x = x - 70;
            } else if (y <= 310 && y > 100 && x == 10) {
                y = y - 70;
            } else if (x == 220) {
                y = y + 70;
            } else if (y == 310) {
                x = x - 70;
            } else {
                x = x + 70;
            }
            nappula.getNappula().setText(nappula.getVari());
            //nappula.getNappula().setFont(nappulafont);
            pane2.add(nappula.getNappula(), new Integer(1));
            buttons.add(nappula);
            nappulat.add(nappula.getNappula());

        }
    }

}
