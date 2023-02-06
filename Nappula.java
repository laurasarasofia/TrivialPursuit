import java.awt.Color;

import javax.swing.JButton;


//Nappula-luokka on pelilaudan helppoa käsittelyä varten luotu luokka, joka sisältää nappulan väriä vastaavan JButtonin
public class Nappula {
    String vari;
    JButton nappula;
    int width =50;
    int height =50;
    int x;
    int y;
    //konstruktori ottaa parametreikseen nappulan väriä vastaavan Stringin ja sijainnin
    public Nappula(String vari, int x, int y) {
        this.vari = vari;
        this.x = x;
        this.y = y;
        nappula = new JButton();
        nappula.setBounds(x, y, width, height);

        if(vari.equals("siniset")){
            nappula.setBackground(Color.blue);
        }
        if(vari.equals("pinkit")){
            nappula.setBackground(Color.pink);
        }
        if(vari.equals("keltaiset")){
            nappula.setBackground(Color.yellow);
        }
        if(vari.equals("violetit")){
            nappula.setBackground(Color.magenta);
        }
        if(vari.equals("vihreat")){
            nappula.setBackground(Color.green);
        }
        if(vari.equals("punaiset")){
            nappula.setBackground(Color.red);
        }
    }
    //palauttaa nappulan JButtonin
    public JButton getNappula(){
        return nappula;
    }
    //palauttaa nappulan sijainnin x-koordinaatin
    public int getX() {
        return x;
    }
    //palauttaa nappulan sijainnin y-koordinaatin
    public int getY() {
        return y;
    }
    //palauttaa nappulan väriä vastaavan Stringin
    public String getVari(){
        return vari;
    }


}
