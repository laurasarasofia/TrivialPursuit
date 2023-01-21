import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
        System.out.println("Tervetuloa pelaamaan Trivial Pursuitia!" + "\n" + "Pelissä on tarkoituksena kerätä oikeat vastaukset jokaisesta kategoriasta ja suoritettuaan sen peli päättyy.");
        System.out.println("Tärkeä ohje: kirjoita vastauksesi isoilla alkukirjaimilla tarkasti oikein.");
        System.out.println("Pelissä toimivat kategoriat"+ "\n" + "Sininen: maantiede"+ "\n" + "Pinkki: viihde"+ "\n" + "Keltainen: historia ja yhteiskunta"+ "\n" + "Ruskea: taide ja kirjallisuus"+ "\n" + "Vihreä: tiede ja ympäristö"+ "\n" + "Oranssi: urheilu");

        File myObj = new File("Kysymykset.xml");

        KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);

        System.out.println(käsittely.getKysymys("pinkit"));
        System.out.println(käsittely.getVastaus());

        //Pelitila uusipeli = new Pelitila();

        //uusipeli.aloitaPeli();
        new TilannePaivitys();


        new Aloitus();

        
    }
}