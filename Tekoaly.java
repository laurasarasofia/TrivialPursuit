import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Tekoaly extends Pelaaja{ //tekoäly perii pelaajan ominaisuudet

    File myObj = new File("Kysymykset.xml"); //tekoälyllä on pääsy kysymyksiin, jotta se voi vastata
    KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);

    public Tekoaly(){

    }
    //jotta voidaan saada vastaus, pitää kutsua ensin getKysymys-metodia, joka palauttaa kysymyksen
    public String vastaa(String vari) throws ParserConfigurationException, SAXException, IOException{
        if(vari.equals("sininen")){
            käsittely.getKysymys("siniset");
            return käsittely.getVastaus();
        }
        else if(vari.equals("pinkki")){
            käsittely.getKysymys("pinkit");
            return käsittely.getVastaus();
        }
        else if(vari.equals("violetti")){
             käsittely.getKysymys("violetit");
            return käsittely.getVastaus();
        }
        else if(vari.equals("keltainen")){
             käsittely.getKysymys("keltaiset");
            return käsittely.getVastaus();
        }
        else if(vari.equals("vihreä")){
             käsittely.getKysymys("vihreat");
            return käsittely.getVastaus();
        }
        else {
            käsittely.getKysymys("punaiset");
            return käsittely.getVastaus();
        } 

    }
}
