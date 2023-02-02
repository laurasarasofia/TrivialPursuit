import java.awt.Color;

import javax.swing.JButton;

public class Nappula {
    String vari;
    JButton nappula;
    int width =50;
    int height =50;
    int x;
    int y;

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
    public JButton getNappula(){
        return nappula;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String getVari(){
        return vari;
    }


}
