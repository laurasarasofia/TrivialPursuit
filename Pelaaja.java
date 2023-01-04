import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Pelaaja {
    boolean sininen = false;
    boolean pinkki = false;
    boolean ruskea = false;
    boolean keltainen= false;
    boolean vihrea = false;
    boolean oranssi = false;

        

    public void oikeaVastaus(String vari){
        if(vari.equals("sininen")){
            sininen=true;
        }
        if(vari.equals("pinkki")){
            pinkki=true;
        }if(vari.equals("ruskea")){
            ruskea=true;
        }if(vari.equals("keltainen")){
            keltainen=true;
        }
        if(vari.equals("vihrea")){
            vihrea=true;
        }
        if(vari.equals("oranssi")){
            oranssi=true;
        }
    }

    public HashMap<String, Boolean> getTilanne(){
        HashMap<String, Boolean> tilanne = new HashMap<String, Boolean>();
        tilanne.put("sininen", sininen);
        tilanne.put("pinkki", pinkki);
        tilanne.put("ruskea", ruskea);
        tilanne.put("keltainen", keltainen);
        tilanne.put("vihrea", vihrea);
        tilanne.put("oranssi", oranssi);

        for (Boolean arvo : tilanne.values()) {
            if(arvo==false){
                System.out.println();
            }
        }

        return tilanne;

    }

}
