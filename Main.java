public class Main {
    public static void main(String[] args) {
        
        System.out.println("Tervetuloa pelaamaan Trivial Pursuitia!" + "\n" + "Pelissä on tarkoituksena kerätä oikeat vastaukset jokaisesta kategoriasta ja suoritettuaan sen peli päättyy.");
        System.out.println("Tärkeä ohje: kirjoita vastauksesi isoilla alkukirjaimilla tarkasti oikein.");
        System.out.println("Pelissä toimivat kategoriat"+ "\n" + "Sininen: maantiede"+ "\n" + "Pinkki: viihde"+ "\n" + "Keltainen: historia ja yhteiskunta"+ "\n" + "Ruskea: taide ja kirjallisuus"+ "\n" + "Vihreä: tiede ja ympäristö"+ "\n" + "Oranssi: urheilu");

        //Pelaaja pelaaja = new Pelaaja();

        //pelaaja.oikeaVastaus("sininen");

        //System.out.println(pelaaja.getTilanne());

        //Kysymykset kysymykset = new Kysymykset();

        //System.out.println(kysymykset.getKysymys("keltaiset") + " " + kysymykset.getVastaus());

        Pelitila uusipeli = new Pelitila();

        uusipeli.aloitaPeli();

    }
}