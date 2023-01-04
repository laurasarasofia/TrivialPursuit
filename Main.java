public class Main {
    public static void main(String[] args) {
        Pelaaja pelaaja = new Pelaaja();

        pelaaja.oikeaVastaus("sininen");

        System.out.println(pelaaja.getTilanne());

        Kysymykset kysymykset = new Kysymykset();


        System.out.println(kysymykset.getKysymys("pinkit") + " " + kysymykset.getValue());

    }
}