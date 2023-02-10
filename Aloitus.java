import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.util.*;
import java.util.Timer;


public class Aloitus extends JFrame implements ActionListener { //Aloitus-luokka, joka perii JFrame-luokan, joka toimii ikkunanäkymänä

    private JButton button1;
    private JLabel label1, sekuntikello; //luodaan tarvittavat toiminnot käyttöliittymää varten
    private JTextArea ta1, ta2;
    private JRadioButton rb1, rb2, rb3, rb4;
    ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>(); //luodaan lista pelaajista
    int i = 0;
    TilannePaivitys tilannePaivitys;

    public Aloitus() {

        super("Trivial Pursuit"); //otsikoi ikkunan

        long start = System.currentTimeMillis();

        setLayout(null); 
        setSize(500, 500);
        Container c = getContentPane(); //luodaan Container näkymää varten
        c.setBackground(Color.darkGray);

        ta1 = new JTextArea("Tervetuloa pelaamaan Trivial Pursuitia!" + "\n" + "Pelissä on tarkoituksena kerätä oikeat vastaukset jokaisesta" + "\n" + "kategoriasta. Suoritettuaan sen peli päättyy." + "\n" + "Tärkeä ohje: kirjoita vastauksesi isoilla alkukirjaimilla tarkasti oikein.");
        add(ta1);
        ta1.setBounds(10, 10, 400, 70); //tämä tekstikenttä kertoo pelin ohjeistuksen
        ta1.setBackground(Color.darkGray);
        ta1.setForeground(Color.white);

        ta2 = new JTextArea("Pelissä toimivat kategoriat"+ "\n" + "Sininen: maantiede"+ "\n" + "Pinkki: viihde"+ "\n" + "Keltainen: historia ja yhteiskunta"+ "\n" + "Ruskea: taide ja kirjallisuus"+ "\n" + "Vihreä: tiede ja ympäristö"+ "\n" + "Oranssi: urheilu");
        add(ta2);
        ta2.setBounds(10, 85, 400, 115); //tässä tekstikentässä on pelin kategoriat
        ta2.setBackground(Color.darkGray);
        ta2.setForeground(Color.white);

        label1 = new JLabel("Kuinka monta pelaajaa? "); //luodaan otsikko allaoleville napeille
        add(label1);
        label1.setBounds(10, 200, 400, 20);
        label1.setForeground(Color.white);

        rb1 = new JRadioButton("Tekoälyä vastaan");
        rb2 = new JRadioButton("2 pelaajaa"); //luodaan napit, joilla valitaan pelaajien määrä
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
        add(button1);   //luodaan nappi, jolla aloitetaan peli
        button1.setBounds(10, 300, 200, 20);
        button1.addActionListener(this);
        
        sekuntikello = new JLabel(); //luodaan sekuntikello
        add(sekuntikello);
        sekuntikello.setBounds(420, 10, 200, 20);
        sekuntikello.setForeground(Color.white);

        Timer currentTime = new Timer(); //luodaan Timer, jonka avulla näytetään pelin aloittamisesta kulunut aika
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sekuntikello.setText(convertSecondsToHMmSs((System.currentTimeMillis() - start)/1000));
            }
        };
        currentTime.scheduleAtFixedRate(task, 0, 1000);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) { //tämä metodi käsittelee nappien painalluksia
        if (rb1.isSelected()) { //pelatessa tekoälyä vastaan pelaajat listaan lisätään pelaaja-olion lisäksi tekoaly-olio
            Pelaaja pelaaja = new Pelaaja();
            pelaajat.add(pelaaja);

            Pelaaja tekoaly = new Tekoaly(true);
            pelaajat.add(tekoaly);

            tilannePaivitys = new TilannePaivitys(2); //tämän avulla luodaan pelilauta, jossa on 2 pelaajaa

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
            tilannePaivitys = new TilannePaivitys(3); //tämän avulla luodaan pelilauta, jossa on 3 pelaajaa
        }
        if (rb4.isSelected()) {
            for (int i = 0; i < 4; i++) {
                Pelaaja pelaaja = new Pelaaja();
                pelaajat.add(pelaaja);
            }
            tilannePaivitys = new TilannePaivitys(4); //tämän avulla luodaan pelilauta, jossa on 4 pelaajaa
        }


        try {
            new Kysymystila(pelaajat, tilannePaivitys); //luodaan uusi Kysymystila-olio, joka avaa uuden ikkunan
            set(); //kutsutaan set                                     //ja lähettää pelaajat-listan ja tilannePaivitys-olion
        } catch (ParserConfigurationException | SAXException | IOException e1) { //sekä metodin, joka tarkistaa onko tekoälyä mukana
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    



    public void set() throws ParserConfigurationException, SAXException, IOException {
        label1.setText("Peli alkoi!"); //tämä metodi muuttaa aloitusikkunan tekstin pelin alettua ja piilottaa näkymästä tarpeettomat asiat
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        rb1.setVisible(false);
        rb2.setVisible(false);
        rb3.setVisible(false);
        rb4.setVisible(false);
        button1.setVisible(false);
        //sekuntikello.setVisible(true);

    }

    public boolean onkoTekoaly(){ //tällä metodilla tarkastetaan onko tekoälyä mukana
        for (int i = 0; i < pelaajat.size(); i++) {
            if (pelaajat.get(i).onkoAI()==true) {
                return true;
            }

        }
        return false;
    }
    public String convertSecondsToHMmSs(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;
        return String.format("%d:%02d:%02d", h,m,s);
    }




}

