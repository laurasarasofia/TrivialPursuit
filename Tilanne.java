import java.awt.Container;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComponent;


public class Tilanne extends JFrame {
    
    public  Tilanne() {

        super("Trivial Pursuit");
        setLayout(null);
        setSize(400, 400);
        Container c = getContentPane();
        c.setBackground(Color.darkGray);
        setVisible(true);
        
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(10, 10, 100, 100);
        g.setColor(Color.MAGENTA);
        g.fillRect(10, 10, 100, 100);
    }
    
}
