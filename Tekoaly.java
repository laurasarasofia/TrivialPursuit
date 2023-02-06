import java.io.File;


public class Tekoaly extends Pelaaja{ //tekoäly perii pelaajan ominaisuudet

    File myObj = new File("Kysymykset.xml"); //tekoälyllä on pääsy kysymyksiin, jotta se voi vastata
    KysymystenKäsittely käsittely = new KysymystenKäsittely(myObj);

    public boolean onkoAI(){
        return true;
    }
  
}
