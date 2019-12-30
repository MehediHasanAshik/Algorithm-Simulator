package bubblesortsimulator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

class LinearThread extends Thread {

    private ArrayList<Circle> circles;
    private MyPanel panel;
    int j;

    Circle c1, c2;

    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }

    public void run() {
        
        forceSleep(1500);
        
        int j=0;
        int k=11;
        int flag=0;
        
        c1=circles.get(j);

        for (int i = 1; i < 11; i++) {
            
            c2=circles.get(i);
            
             circles.get(j).setY(circles.get(j).getY() + 50);
             circles.get(i).setY(circles.get(i).getY() + 50);
             
              updatePanel();
              forceSleep(400);
            
            if (c2.getData() == c1.getData()) /* if required element found */ {
                
                circles.get(i).setY(circles.get(i).getY() + 100);
                circles.get(j).setY(circles.get(j).getY() + 100);
                
                
              updatePanel();
              forceSleep(400);
              
              circles.get(j).setX(circles.get(j).getX()+400);
              flag=1;
              updatePanel();
              forceSleep(400);
                
                break;
            }
            
            else
            {
             circles.get(j).setY(circles.get(j).getY() - 50);
             circles.get(i).setY(circles.get(i).getY() - 50);
            }
        }
        
        updatePanel();
        forceSleep(400);
        
        if(flag==0)
        {
            updatePanel();
            forceSleep(400);
            
            circles.get(j).setY(circles.get(j).getY() + 100);
            circles.get(j).setX(circles.get(j).getX()+350);
            circles.get(k).setX(150 + k*36);
            circles.get(k).setY(circles.get(k).getY() + 310);
            updatePanel();
            forceSleep(400);
            //circles.get(j+1).setY(circles.get(j+1).getY() - 75);
        }

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
            Logger.getLogger(LinearThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
