package bubblesortsimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MaxThread extends Thread {

    private ArrayList<Circle> circles;
    private MyPanel panel;

    int j, i, k,cnt=0,maxi=0;

    Circle c1, c2, dummy;

    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }

    public void run() {
        
        forceSleep(1500);

        j = 0;

        for (i = 1; i < 10; i++) {

            c2 = circles.get(i);
            c1 = circles.get(j);

            circles.get(i).setY(circles.get(i).getY() + 60);
            circles.get(j).setY(circles.get(j).getY() + 60);
            
            updatePanel();
            forceSleep(400);
            
            cnt++;
         
            updatePanel();
            forceSleep(400);

            if (c2.getData() > c1.getData()) {
                
                maxi=j;
                
                circles.get(maxi).setY(circles.get(maxi).getY() - 60);
                updatePanel();
                forceSleep(400);
                
                j = i;
                
               
               circles.get(i).setY(circles.get(i).getY() - 60);
               
        
                updatePanel();
                forceSleep(400);

            } 
            
            
            else {
                circles.get(j).setY(circles.get(j).getY() - 60);
                circles.get(i).setY(circles.get(i).getY() - 60);

                updatePanel();
                forceSleep(400);
            }
            
        }

        updatePanel();
        forceSleep(400);

       // System.out.println("J new : " + j);
        
        

        circles.get(j).setY(circles.get(j).getY() + 200);
        circles.get(j).setX(circles.get(j).getX());

        updatePanel();
        forceSleep(400);

    }

    void updatePanel() {
        panel.setCircles(circles);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                panel.revalidate();
                panel.repaint();

            }
        });
    }

    private void forceSleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException ex) {
            Logger.getLogger(MaxThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}