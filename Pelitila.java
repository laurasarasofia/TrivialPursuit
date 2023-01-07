import java.util.Random;
import java.util.Scanner;

public class Pelitila {
    Scanner lukija = new Scanner(System.in);
    Pelaaja pelaaja = new Pelaaja();
    Kysymykset kysymykset = new Kysymykset();
    String kysymys;
    String vari;
    boolean tilanne = false;

    public void aloitaPeli() {

        while (tilanne == pelaaja.kaikkiVarit()) {
            System.out.println(randomKysymys());
            String vastaus = lukija.nextLine();

            if (oikeaVastaus(vastaus) == true) {
                pelaaja.oikeaVastaus(vari);
                System.out.println(vari + " arvattu oikein!!!");
                System.out.println(pelaaja.getTilanne());
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
