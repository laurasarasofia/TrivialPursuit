import java.awt.Container;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class Tilanne extends JFrame {
 

    public Tilanne() {

        super("Trivial Pursuit");
        setLayout(null);
        setSize(400, 400);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);
        setVisible(true);
        JPanel panelForColors = new JPanel();
        panelForColors.setBackground(Color.green.darker());

    }
    private Color varjaa(String vari) {
        if (vari.equals("sininen")) {
            return Color.blue;
        }
        if (vari.equals("pinkki")) {
            return Color.pink;
        }
        if (vari.equals("keltainen")) {
            return Color.yellow;
        }
        if (vari.equals("violetti")) {
            return Color.magenta;
        }
        if (vari.equals("vihrea")) {
            return Color.green;
        }
        else {
            return Color.red;
        }
    }

    // aloitustilanne
    public void paint(Graphics g) {
        super.paint(g);
        
        // sininen
        g.setColor(Color.blue);
        g.drawRect(40, 40, 50, 50);
        // pinkki
        g.setColor(Color.pink);
        g.drawRect(40, 90, 50, 50);
        // keltainen
        g.setColor(Color.yellow);
        g.drawRect(40, 140, 50, 50);
        // violetti
        g.setColor(Color.magenta);
        g.drawRect(90, 40, 50, 50);
        // vihreä
        g.setColor(Color.green);
        g.drawRect(90, 90, 50, 50);
        // punainen
        g.setColor(Color.red);
        g.drawRect(90, 140, 50, 50);

    }

  

}
