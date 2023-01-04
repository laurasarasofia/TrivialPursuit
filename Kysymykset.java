import java.util.*;

public class Kysymykset {

    int indeksi;
    String vari;

    Map<String, String> siniset = Map.of(
            "Mikä on Suomen pääkaupunki?", "Helsinki",
            "Maailman korkein vuori?", "Mount Everest",
            "Maailman pisin joki?", "Amazon");

    Map<String, String> pinkit = Map.of(
            "Kim Kardashianin pituus senttimetreinä?", "157",
            "Ensimmäisen Harry Potter elokuvan julkaisuvuosi?", "2001",
            "Spotifyn kuunnelluin kappale?", "Blinding Lights");

    Map<String, String> keltaiset = Map.of(
            "Euroopan hulluvuosi?", "1848",
            "Mihin Yhdysvallat tiputtivat ensimmäisen atomipommin?", "Hiroshima",
            "Suomen ensimmäinen presidentti? (sukunimi)", "Ståhlberg");

    public String getKysymys(String vari) {
        this.vari = vari;
        ArrayList<String> kysymykset = new ArrayList<String>();

        if (vari.equals("siniset")) {
            Random random = new Random();
            indeksi = random.nextInt(siniset.size());
            for (String kysymys : siniset.keySet()) {
                kysymykset.add(kysymys);
            }

        }
        if (vari.equals("pinkit")) {
            Random random = new Random();
            indeksi = random.nextInt(pinkit.size());
            for (String kysymys : pinkit.keySet()) {
                kysymykset.add(kysymys);
            }

        }
        if (vari.equals("keltaiset")) {
            Random random = new Random();
            indeksi = random.nextInt(keltaiset.size());
            for (String kysymys : keltaiset.keySet()) {
                kysymykset.add(kysymys);
            }

        }

        return kysymykset.get(indeksi);

    }

    public String getValue() {
        ArrayList<String> vastaukset = new ArrayList<String>();

        if (vari.equals("siniset")) {
            for (String vastaus : siniset.values()) {
                vastaukset.add(vastaus);
            }
        }
        if (vari.equals("pinkit")) {
            for (String vastaus : pinkit.values()) {
                vastaukset.add(vastaus);
            }
        }
        if (vari.equals("keltaiset")) {
            for (String vastaus : keltaiset.values()) {
                vastaukset.add(vastaus);
            }
        }

        return vastaukset.get(indeksi);
    }
}
