import java.awt.Container;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class TilannePaivitys extends JFrame {

    JButton sininen, pinkki, keltainen, violetti, vihrea, punainen;

    public TilannePaivitys() {

        super("Trivial Pursuit");

        setLayout(null);
        setSize(400, 400);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);

        JLayeredPane pane = getLayeredPane(); 
        //creating buttons  
        sininen = new JButton(); 
        sininen.setBorder(BorderFactory.createLineBorder(Color.blue));
        sininen.setBounds(40, 40, 50, 50);  
        
        pinkki= new JButton();  
        pinkki.setBorder(BorderFactory.createLineBorder(Color.pink));
        pinkki.setBounds(40, 90, 50, 50);  
        
        keltainen = new JButton();
        keltainen.setBorder(BorderFactory.createLineBorder(Color.yellow));
        keltainen.setBounds(40, 140, 50, 50);
        
        violetti = new JButton();
        violetti.setBorder(BorderFactory.createLineBorder(Color.magenta));
        violetti.setBounds(90, 40, 50, 50);
        
        vihrea = new JButton();
        vihrea.setBorder(BorderFactory.createLineBorder(Color.green));
        vihrea.setBounds(90, 90, 50, 50);

        punainen = new JButton();
        punainen.setBorder(BorderFactory.createLineBorder(Color.red));
        punainen.setBounds(90, 140, 50, 50);
        //adding buttons on pane  
        pane.add(sininen, new Integer(1));
        pane.add(pinkki, new Integer(1));
        pane.add(keltainen, new Integer(1));    
        pane.add(violetti, new Integer(1));
        pane.add(vihrea, new Integer(1));
        pane.add(punainen, new Integer(1));

        muutaTausta("sininen");

        setVisible(true);
    }
    public void muutaTausta(String vari){
        if (vari.equals("sininen")) {
            sininen.setBackground(Color.blue);
        }
    }

}
