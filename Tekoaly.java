import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Tekoaly extends Pelaaja{

    File myObj = new File("Kysymykset.xml");
    KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);

    public Tekoaly(){

    }

    public String vastaa(String vari) throws ParserConfigurationException, SAXException, IOException{
        if(vari.equals("sininen")){
            String kysymys = käsittely.getKysymys("siniset");
            return käsittely.getVastaus();
        }
        else if(vari.equals("pinkki")){
            String kysymys = käsittely.getKysymys("pinkit");
            return käsittely.getVastaus();
        }
        else if(vari.equals("violetti")){
            String kysymys = käsittely.getKysymys("violetit");
            return käsittely.getVastaus();
        }
        else if(vari.equals("keltainen")){
            String kysymys = käsittely.getKysymys("keltaiset");
            return käsittely.getVastaus();
        }
        else if(vari.equals("vihreä")){
            String kysymys = käsittely.getKysymys("vihreat");
            return käsittely.getVastaus();
        }
        else {
            String kysymys = käsittely.getKysymys("punaiset");
            return käsittely.getVastaus();
        } 

    }
}
