import java.util.*;
import java.util.Map.Entry;
import java.util.HashMap;


public class Kysymykset {
    //HashMap<String, String> siniset; 
    int indeksi;
    String vari;
    
    //public void siniset(HashMap<String, String> siniset){

        //this.siniset=siniset;
        //siniset.put("Mikä on Suomen pääkaupunki?", "Helsinki");
        //siniset.put("Maailman korkein vuori?", "Mount Everest");
        //siniset.put("Maailman pisin joki? ", "Amazon");
    //}
    Map<String, String> siniset = Map.of(
        "Mikä on Suomen pääkaupunki?", "Helsinki",
        "Maailman korkein vuori?", "Mount Everest",
        "Maailman pisin joki?", "Amazon"
    );

    Map<String, String> pinkit = Map.of(
        "Kim Kardashianin pituus senttimetreinä?", "157",
        "Ensimmäisen Harry Potter elokuvan julkaisuvuosi?", "2001",
        "Spotifyn kuunnelluin kappale?", "Blinding Lights"
    );

    Map<String, String> keltaiset = Map.of(
        "Euroopan hulluvuosi?", "1848",
        ""
    )

    public String getKysymys(String vari){
        this.vari=vari;
        ArrayList<String> kysymykset= new ArrayList<String>();

        if(vari.equals("siniset")){
            Random random = new Random();
            indeksi = random.nextInt(siniset.size());
            for(String kysymys: siniset.keySet()){
                kysymykset.add(kysymys);
            }
            
        }
        if(vari.equals("pinkit")){
            Random random = new Random();
            indeksi = random.nextInt(pinkit.size());
            for(String kysymys: pinkit.keySet()){
                kysymykset.add(kysymys);
            }
            
        }

        //ArrayList<String> kysymykset= new ArrayList<String>();

       

        return kysymykset.get(indeksi);

    }
    public String getValue(){
        ArrayList<String> vastaukset= new ArrayList<String>();

        if(vari.equals("siniset")){
            for(String vastaus: siniset.values()){
                vastaukset.add(vastaus);
            }
        }
        if(vari.equals("pinkit")){
            for(String vastaus: pinkit.values()){
                vastaukset.add(vastaus);
            }
        }
        
        return vastaukset.get(indeksi);
    }
}
