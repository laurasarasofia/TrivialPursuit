import java.awt.Container;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

//TilannePaivitys-luokka luo uuden ikkunanäkymän, jossa pelilauta näkyy ja siihen päivittyvät myös pelinappulat
public class TilannePaivitys extends JFrame {

    ArrayList<JButton> nappulat = new ArrayList<JButton>(); //lista väri-nappuloita varten
    JButton sininen, pinkki, keltainen, violetti, vihrea, punainen; //nappulat tehdään JButtoneista helpon käsittelyn vuoksi
    
    int pelaajat; //pelaajien määrä

    //konstruktori ottaa parametreiksi pelaajien määrän
    public TilannePaivitys(int pelaajat) {

        super("Trivial Pursuit");

        this.pelaajat = pelaajat;

        setLayout(null);
        setSize(500, 500);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);

        JLayeredPane pane = getLayeredPane();

        int x = 5; //luodaan muuttujia, jotta voidaan helposti hallita nappuloiden sijaintia pelilaudalla pelaajien määrän muuttuessa
        int y = 40;
        int width = 50;
        int height = 50;
        int labelY = 20;
        int labelX = 5;

        for (int i = 0; i < pelaajat; i++) {

            JLabel label = new JLabel("Pelaaja " + (i + 1));
            label.setBounds(labelX, labelY, 100, 20);
            label.setForeground(Color.white);
            pane.add(label, new Integer(1));
            

            sininen = new JButton();
            sininen.setBorder(BorderFactory.createLineBorder(Color.blue));
            sininen.setBounds(x, y, width, height);
            nappulat.add(sininen);

            pinkki = new JButton();
            pinkki.setBorder(BorderFactory.createLineBorder(Color.pink));
            pinkki.setBounds(x, (y + height), width, height);
            nappulat.add(pinkki);

            keltainen = new JButton();
            keltainen.setBorder(BorderFactory.createLineBorder(Color.yellow));
            keltainen.setBounds(x, (y + (2 * height)), width, height);
            nappulat.add(keltainen);

            violetti = new JButton();
            violetti.setBorder(BorderFactory.createLineBorder(Color.magenta));
            violetti.setBounds((x + width), y, width, height);
            nappulat.add(violetti);

            vihrea = new JButton();
            vihrea.setBorder(BorderFactory.createLineBorder(Color.green));
            vihrea.setBounds((x + width), (y + height), width, height);
            nappulat.add(vihrea);

            punainen = new JButton();
            punainen.setBorder(BorderFactory.createLineBorder(Color.red));
            punainen.setBounds((x + width), (y + (2 * height)), width, height);
            nappulat.add(punainen);

            x = x + 105;
            labelX = labelX + 105;
       

        }

        for(int i=0; i<nappulat.size(); i++){
            pane.add(nappulat.get(i), new Integer(1));
        }

        



        setVisible(true);
    }
    //muuta paremmaksi

    public void muutaTausta(String vari, int pelaaja) {

        if (vari.equals("siniset")) {
            int indeksi=0;
            for(int i=0; i<(pelaaja+1); i++){
                if(i==pelaaja){
                    nappulat.get(indeksi).setBackground(Color.blue);
                }
                indeksi=indeksi+6;
            }
        }
        if (vari.equals("pinkit")) {
            int indeksi=1;
            for(int i=0; i<(pelaaja+1); i++){
                if(i==pelaaja){
                    nappulat.get(indeksi).setBackground(Color.pink);
                }
                indeksi=indeksi+6;
            }
        }
        if (vari.equals("keltaiset")) {
            int indeksi=2;
            for(int i=0; i<(pelaaja+1); i++){
                if(i==pelaaja){
                    nappulat.get(indeksi).setBackground(Color.yellow);
                }
                indeksi=indeksi+6;
            }
        }
        if (vari.equals("violetit")) {
            int indeksi=3;
            for(int i=0; i<(pelaaja+1); i++){
                if(i==pelaaja){
                    nappulat.get(indeksi).setBackground(Color.magenta);
                }
                indeksi=indeksi+6;
            }
        }
        if (vari.equals("vihreat")) {
            int indeksi=4;
            for(int i=0; i<(pelaaja+1); i++){
                if(i==pelaaja){
                    nappulat.get(indeksi).setBackground(Color.green);
                }
                indeksi=indeksi+6;
            }
        }
        if (vari.equals("punaiset")) {
            int indeksi=5;
            for(int i=0; i<(pelaaja+1); i++){
                if(i==pelaaja){
                    nappulat.get(indeksi).setBackground(Color.red);
                }
                indeksi=indeksi+6;
            }
        }

    }

}
