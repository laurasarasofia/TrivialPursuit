import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Tekoaly extends Pelaaja { // tekoäly perii pelaajan ominaisuudet

    boolean vaikea;
    KysymystenKäsittely käsittely;

    public Tekoaly(boolean vaikea) {
        this.vaikea = vaikea;
    }

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
    
    public void annaKysymystenKäsittely(KysymystenKäsittely käsittely) {
        this.käsittely = käsittely;
    }

    public String annaVastaus(String vari) throws ParserConfigurationException, SAXException, IOException {
        return käsittely.satunnainenVastaus(vari);
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

    public boolean onkoAI() {
        return true;
    }

    public boolean onkoVaikea() {
        return vaikea;
    }

}
