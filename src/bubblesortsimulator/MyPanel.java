package bubblesortsimulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;


public class MyPanel extends JPanel {

    private ArrayList<Circle> circles = new ArrayList<Circle>();
    private Circle dummy;
    private boolean isDummy;

    public void setDummy(Circle dummy) {
        this.dummy = dummy;
    }

    public void setIsDummy(boolean isDummy) {
        this.isDummy = isDummy;
    }
    

    public MyPanel() {
        this.setBounds(10, 20, 1050, 600);
        this.setBackground(Color.MAGENTA);
    }

    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }

    protected void paintComponent(Graphics g) {

        g.fillOval(100, 100, 50, 50);

        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        for (Circle c : circles) {

            g2.setColor(c.getC());
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillOval(c.getX(), c.getY(), c.getR(), c.getR());
            g2.setColor(Color.black);
            g2.drawString(Integer.toString(c.getData()), (c.getX()-5) + c.getR() / 2, c.getY() + c.getR() / 2 + 5);
            
           // System.out.println(c.getX() + " " + c.getY());
        }
        
        if(isDummy)
        {
            g2.setColor(dummy.getC());
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillOval(dummy.getX(), dummy.getY(), dummy.getR(), dummy.getR());
            g2.setColor(Color.black);
            g2.drawString(Integer.toString(dummy.getData()), (dummy.getX()-5) + dummy.getR() / 2,dummy.getY() + dummy.getR() / 2 + 5);
        }

    }

}
