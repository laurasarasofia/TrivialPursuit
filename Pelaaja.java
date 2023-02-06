
//import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
//import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Pelaaja {

    File myObj = new File("Kysymykset.xml"); // tekoälyllä on pääsy kysymyksiin, jotta se voi vastata
    KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);


    boolean siniset = false;
    boolean pinkit = false;
    boolean violetit = false;
    boolean keltaiset = false;
    boolean vihreat = false;
    boolean punaiset = false;
    int indeksi;

    // muuttaa pelaajan tilanteen, kun pelaaja arvaa värin oikein
    public void oikeaVastaus(String vari) {
        if (vari.equals("siniset")) {
            siniset = true;
        }
        if (vari.equals("pinkit")) {
            pinkit = true;
        }
        if (vari.equals("violetit")) {
            violetit = true;
        }
        if (vari.equals("keltaiset")) {
            keltaiset = true;
        }
        if (vari.equals("vihreat")) {
            vihreat = true;
        }
        if (vari.equals("punaiset")) {
            punaiset = true;
        }
    }

    public void setSijainti(int indeksi) {
        this.indeksi = indeksi;
    }

    public int getSijainti() {
        return indeksi;
    }

    // tätä metodia käytetään tarkistamaan onko kaikki varit arvattu, palauttaa
    // boolean arvon
    public boolean kaikkiVarit() {

        if (siniset == true && pinkit == true && keltaiset == true && violetit == true && vihreat == true
                && punaiset == true) {
            return true;
        }

        else {
            return false;
        }
    }

    public String annaVastaus(String vari) throws ParserConfigurationException, SAXException, IOException {
        if (vari.equals("sininen")) {
            käsittely.getKysymys("siniset");
            return käsittely.getVastaus();
        } else if (vari.equals("pinkki")) {
            käsittely.getKysymys("pinkit");
            return käsittely.getVastaus();
        } else if (vari.equals("violetti")) {
            käsittely.getKysymys("violetit");
            return käsittely.getVastaus();
        } else if (vari.equals("keltainen")) {
            käsittely.getKysymys("keltaiset");
            return käsittely.getVastaus();
        } else if (vari.equals("vihreä")) {
            käsittely.getKysymys("vihreat");
            return käsittely.getVastaus();
        } else {
            käsittely.getKysymys("punaiset");
            return käsittely.getVastaus();
        }

    }
    public boolean onkoAI(){
        return false;
    }
}
