//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map.Entry;

public class Pelaaja {
    boolean siniset = false;
    boolean pinkit = false;
    boolean violetit = false;
    boolean keltaiset= false;
    boolean vihreat = false;
    boolean punaiset = false;

    public void oikeaVastaus(String vari){
        if(vari.equals("siniset")){
            siniset=true;
        }
        if(vari.equals("pinkit")){
            pinkit=true;
        }
        if(vari.equals("violetit")){
            violetit=true;
        }
        if(vari.equals("keltaiset")){
            keltaiset=true;
        }
        if(vari.equals("vihreat")){
            vihreat=true;
        }
        if(vari.equals("punaiset")){
            punaiset=true;
        }
    }

    public HashMap<String, Boolean> getTilanne(){
        HashMap<String, Boolean> tilanne = new HashMap<String, Boolean>();
        tilanne.put(Vari.CYAN + "siniset" + Vari.RESET, siniset);
        tilanne.put(Vari.PINK + "pinkit" + Vari.RESET, pinkit);
        tilanne.put(Vari.PURPLE + "violetit" + Vari.RESET,violetit);
        tilanne.put(Vari.YELLOW + "keltaiset" + Vari.RESET, keltaiset);
        tilanne.put(Vari.GREEN + "vihreat" + Vari.RESET,vihreat);
        tilanne.put(Vari.TESTI + "punaiset" + Vari.RESET,punaiset);

        for (Boolean arvo : tilanne.values()) {
            if(arvo==false){
                //System.out.println();
            }
        }

        return tilanne;

    }

    public boolean kaikkiVarit(){

        if(siniset==true && pinkit==true && keltaiset==true && violetit==true && vihreat==true && punaiset == true){
            return true;
        }

        else{
            return false;
        }
    }

}
