import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//luokkaa ei käytetä

public class Pelitila {
    Scanner lukija = new Scanner(System.in);
    Pelaaja pelaaja = new Pelaaja();
    Kysymykset kysymykset = new Kysymykset();
    String kysymys;
    String vari;
    boolean tilanne = false;
    int i = 0;

    public void aloitaPeli() {

        System.out.println("Kuinka monta pelaajaa? ");
        int maara = Integer.parseInt(lukija.nextLine());
        ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();

        for (int i = 0; i < maara; i++) {
            Pelaaja pelaaja = new Pelaaja();
            pelaajat.add(pelaaja);
        }

        while (tilanne == pelaajat.get(i).kaikkiVarit()) {
            System.out.println("Vuoro: pelaaja" + (i + 1) + " " + randomKysymys());

            String vastaus = lukija.nextLine();

            if (oikeaVastaus(vastaus) == true) {
                pelaajat.get(i).oikeaVastaus(vari);
                System.out.println(vari + " arvattu oikein!!!");
                System.out.println(pelaajat.get(i).getTilanne());
            }
            if (pelaajat.get(i).kaikkiVarit() == true) {
                System.out.println("Pelaaja" + (i + 1) + " voitti!");
                break;
            }
            if (i == (pelaajat.size() - 1)) {
                i = 0;
            } else {
                i++;
            }

        }

    }

    public boolean oikeaVastaus(String vastaus) {
        if (vastaus.equals(vastaus = kysymykset.getVastaus())) {
            return true;
        } else {
            return false;
        }
    }

    public String randomKysymys() {
        String[] varit = { "siniset", "pinkit", "keltaiset", "violetit", "vihreat", "punaiset" };
        Random random = new Random();
        int indeksi = random.nextInt(varit.length);
        vari = varit[indeksi];
        kysymys = kysymykset.getKysymys(varit[indeksi]);
        return kysymys;
    }
}
