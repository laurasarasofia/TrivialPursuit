import java.util.*;

public class Kysymykset {

    int indeksi;
    String vari;

    Map<String, String> siniset = Map.of(
            "Mikä on Suomen pääkaupunki?", "Helsinki",
            "Maailman korkein vuori?", "Mount Everest",
            "Maailman pisin joki?", "Amazon",
            "Missä kaupungissa sijaitsee Iisakin kirkko?", "Pietari"
            );

    Map<String, String> pinkit = Map.of(
            "Kim Kardashianin pituus senttimetreinä?", "157",
            "Ensimmäisen Harry Potter elokuvan julkaisuvuosi?", "2001",
            "Spotifyn kuunnelluin kappale?", "Blinding Lights",
            "Kuka näyttelee Frendit-sarjassa Chandleria?", "Matthew Perry");

    Map<String, String> keltaiset = Map.of(
            "Euroopan hulluvuosi?", "1848",
            "Mihin Yhdysvallat tiputtivat ensimmäisen atomipommin?", "Hiroshima",
            "Suomen ensimmäinen presidentti? (sukunimi)", "Ståhlberg",
            
            "Milloin Suomi itsenäistyi?", "1917");

    Map<String, String> violetit = Map.of(
            "Kuka maalasi Mona Lisan?", "Leonardo Da Vinci",
            "Mistä maasta Vivienne Westwood on kotoisin?", "Iso-Britannia",
            "Myydyin musiikkialbumi?", "Thriller",
            "Kuka on säveltänyt teoksen näin puhui Zarathustra?", "Richard Strauss"

    );
    Map<String, String> vihreat = Map.of(
            "Mikä on kullan järjestysluku?", "79",
            "Mikä on neljäs olomuoto kiinteän, nesteen ja kaasun lisäksi?", "Plasma",
            "Montako mahaa lehmällä on?", "4",
            "Mikä soluelin vastaa eläinsolun energian tuotannosta?", "Mitokondrio");
    Map<String, String> punaiset = Map.of(
            "Missä kaupungissa pidettiin vuoden 2008 olympialaiset?", "Peking",
            "Mikä oli Caitlyn Jennerin olympialaji?", "Kymmenottelu",
            "Mikä on Tony Hawkin urheilulaji?", "Skeittaus",
            "Mikä on Sebastian Ahon kasvattajaseura?", "Kärpät");

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
        if (vari.equals("violetit")) {
            Random random = new Random();
            indeksi = random.nextInt(violetit.size());
            for (String kysymys : violetit.keySet()) {
                kysymykset.add(kysymys);
            }

        }
        if (vari.equals("vihreat")) {
            Random random = new Random();
            indeksi = random.nextInt(vihreat.size());
            for (String kysymys : vihreat.keySet()) {
                kysymykset.add(kysymys);
            }

        }
        if (vari.equals("punaiset")) {
            Random random = new Random();
            indeksi = random.nextInt(punaiset.size());
            for (String kysymys : punaiset.keySet()) {
                kysymykset.add(kysymys);
            }

        }

        return kysymykset.get(indeksi);

    }

    public String getVastaus() {
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
        if (vari.equals("violetit")) {
            for (String vastaus : violetit.values()) {
                vastaukset.add(vastaus);
            }
        }
        if (vari.equals("vihreat")) {
            for (String vastaus : vihreat.values()) {
                vastaukset.add(vastaus);
            }
        }
        if (vari.equals("punaiset")) {
            for (String vastaus : punaiset.values()) {
                vastaukset.add(vastaus);
            }
        }

        return vastaukset.get(indeksi);
    }
}
