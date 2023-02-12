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
    private JLabel label1, sekuntikello, AIpelaajat; //luodaan tarvittavat toiminnot käyttöliittymää varten
    private JTextArea ta1, ta2;
    private JRadioButton rb1, rb2;
    private JTextField tf1, tf2;
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

        AIpelaajat = new JLabel("Kuinka monta AIpelaajaa? "); //luodaan otsikko allaoleville napeille
        add(AIpelaajat);
        AIpelaajat.setBounds(10, 200, 400, 20);
        AIpelaajat.setForeground(Color.white);

        tf2 = new JTextField("");
        add(tf2);
        tf2.setBounds(10, 220, 200, 20);

        rb1 = new JRadioButton("Tekoälyn taso: helppo");
        rb2 = new JRadioButton("Tekoälyn taso: vaikea"); //luodaan napit, joilla valitaan pelaajien määrä
        add(rb1);
        add(rb2);
        rb1.setBounds(10, 250, 200, 20);
        rb2.setBounds(10, 270, 200, 20);
 

        label1 = new JLabel("Kuinka monta pelaajaa yhteensä? ");
        add(label1);
        label1.setBounds(10, 300, 200, 20);
        label1.setForeground(Color.white);

        tf1 = new JTextField();
        add(tf1);
        tf1.setBounds(10, 320, 200, 20);

        button1 = new JButton("Aloita peli");
        add(button1);   //luodaan nappi, jolla aloitetaan peli
        button1.setBounds(10, 340, 200, 20);
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
        int AIpelaajienMaara= Integer.valueOf(tf2.getText()); 

        if (rb1.isSelected()) { //pelatessa tekoälyä vastaan pelaajat listaan lisätään pelaaja-olion lisäksi tekoaly-olio
            for(int i = 0; i < AIpelaajienMaara; i++) {
                Pelaaja tekoaly = new Tekoaly(false);
                pelaajat.add(tekoaly);
            }
        }

        if (rb2.isSelected()) {
            for (int i = 0; i < AIpelaajienMaara; i++) {
                Pelaaja tekoaly = new Tekoaly(true);
                pelaajat.add(tekoaly);
            }
        }

        for(int i =0; i < Integer.valueOf(tf1.getText())-AIpelaajienMaara; i++) { //tämä for-looppi lisää pelaajat-listaan pelaajien nimet
            Pelaaja pelaaja = new Pelaaja();
            pelaajat.add(pelaaja);
        }

        TilannePaivitys tilannePaivitys = new TilannePaivitys(pelaajat.size()); //luodaan TilannePaivitys-olio, joka päivittää pelaajien pisteet


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
        button1.setVisible(false);
        //sekuntikello.setVisible(true);

    }

    public String convertSecondsToHMmSs(long seconds) {
        long s = seconds % 60;
        long m = (seconds / 60) % 60;
        long h = (seconds / (60 * 60)) % 24;
        return String.format("%d:%02d:%02d", h,m,s);
    }




}

