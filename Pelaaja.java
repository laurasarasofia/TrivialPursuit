
import java.io.IOException;
import java.util.Random;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class Pelaaja {

    // File myObj = new File("Kysymykset.xml"); // tekoälyllä on pääsy kysymyksiin,
    // jotta se voi vastata
    KysymystenKäsittely käsittely;

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

    // tämän avulla tallennetaan pelaajan sijainti pelilaudalla
    public void setSijainti(int indeksi) {
        this.indeksi = indeksi;
    }

    // tämän avulla saadaan pelaajan sijainti pelilaudalla
    public int getSijainti() {
        return indeksi;
    }

    public void annaKysymystenKäsittely(KysymystenKäsittely käsittely) {
        this.käsittely = käsittely;
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

    // käytetään tekoälyn vastauksen generoimiseen
    public String annaOikeaVastaus(String vari) throws ParserConfigurationException, SAXException, IOException {
        if (vari.equals("siniset")) {
            return käsittely.getVastaus();
        } else if (vari.equals("pinkit")) {
            return käsittely.getVastaus();
        } else if (vari.equals("violetit")) {
            return käsittely.getVastaus();
        } else if (vari.equals("keltaiset")) {
            return käsittely.getVastaus();
        } else if (vari.equals("vihreat")) {
            return käsittely.getVastaus();
        } else {
            return käsittely.getVastaus();
        }

    }

    public String annaVastaus(String vari) throws ParserConfigurationException, SAXException, IOException {
        return käsittely.satunnainenVastaus(vari);
    }

    public boolean onkoAI() {
        return false;
    }

    public String vaikeaAI(String vari) throws ParserConfigurationException, SAXException, IOException {
        Random random = new Random();
        int arvottu = random.nextInt(2) + 1;

        if (arvottu == 1) {
            return annaVastaus(vari);
        } else {
            return annaOikeaVastaus(vari);
        }
    }
}
