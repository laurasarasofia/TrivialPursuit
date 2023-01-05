//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map.Entry;

public class Pelaaja {
    boolean siniset = false;
    boolean pinkit = false;
    boolean ruskeat = false;
    boolean keltaiset= false;
    boolean vihreat = false;
    boolean oranssit = false;

    public void oikeaVastaus(String vari){
        if(vari.equals("siniset")){
            siniset=true;
        }
        if(vari.equals("pinkit")){
            pinkit=true;
        }
        if(vari.equals("ruskeat")){
            ruskeat=true;
        }
        if(vari.equals("keltaiset")){
            keltaiset=true;
        }
        if(vari.equals("vihreat")){
            vihreat=true;
        }
        if(vari.equals("oranssit")){
            oranssit=true;
        }
    }

    public HashMap<String, Boolean> getTilanne(){
        HashMap<String, Boolean> tilanne = new HashMap<String, Boolean>();
        tilanne.put("siniset", siniset);
        tilanne.put("pinkit", pinkit);
        tilanne.put("ruskeat",ruskeat);
        tilanne.put("keltaiset", keltaiset);
        tilanne.put("vihreat",vihreat);
        tilanne.put("oranssit",oranssit);

        for (Boolean arvo : tilanne.values()) {
            if(arvo==false){
                //System.out.println();
            }
        }

        return tilanne;

    }

    public boolean kaikkiVarit(){
        boolean onko =false;

        if(siniset==true){
            onko=true;
        }
        if(pinkit==true){
            onko=true;
        }
        if(keltaiset==true){
            onko=true;
        }
        if(ruskeat==true){
            onko=true;
        }
        if(vihreat==true){
            onko=true;
        }
        if(oranssit==true){
            onko=true;
        }

        return onko;
    }

}
