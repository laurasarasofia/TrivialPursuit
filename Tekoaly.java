import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class Tekoaly extends Pelaaja{ //tekoäly perii pelaajan ominaisuudet

    boolean vaikea;

    public Tekoaly(boolean vaikea){
        this.vaikea = vaikea;
    }
 
    public boolean onkoAI(){
        return true;
    }
    public boolean onkoVaikea(){
        return vaikea;
    }

    
  
}
