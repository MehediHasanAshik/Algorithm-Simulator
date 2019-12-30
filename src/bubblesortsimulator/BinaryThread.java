package bubblesortsimulator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

class BinaryThread extends Thread {

    private ArrayList<Circle> circles;
    private MyPanel panel;
    int j;

    Circle c1, c2;
    int first,last,mid;

    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }

    public void run() {
        
        forceSleep(1000);
        
        first=1;
        last=10;
        mid=(first+last)/2;
        
        int j=0;
        int k=11;
        int flag=0;
        
        c2=circles.get(j);
        
        
        while(first<=last)
        {
            
            c1=circles.get(mid);
            
            circles.get(j).setY(circles.get(j).getY() + 50);
            circles.get(mid).setY(circles.get(mid).getY() + 50);
            
            if(c1.getData()<c2.getData())
            {
                first=mid+1;
                
                //circles.get(mid).setX(circles.get(mid).getX()+300);
                updatePanel();
                forceSleep(1000);
            }
            
            else if(c1.getData()==c2.getData())
            {
                flag=1;
                
                circles.get(mid).setY(circles.get(mid).getY() + 100);
                circles.get(j).setY(circles.get(j).getY() + 100);
                circles.get(j).setX(circles.get(j).getX() + 400);
                
                updatePanel();
                forceSleep(1000);
                break;
            }
            
            else
            {
                last=mid-1;
                updatePanel();
                forceSleep(1000);
            }
            
            
            circles.get(j).setY(circles.get(j).getY() - 50);
            circles.get(mid).setY(circles.get(mid).getY() - 50);
            mid=(first+last)/2;
            updatePanel();
            forceSleep(1000);
        }
        
        if(first>last)
        {
            flag=0;
            updatePanel();
            forceSleep(1000);
        }
        
        updatePanel();
        //forceSleep(800);
        
        if(flag==0)
        {
            updatePanel();
            forceSleep(800);
            
            circles.get(j).setY(circles.get(j).getY() + 100);
            circles.get(j).setX(circles.get(j).getX()+350);
            circles.get(k).setX(150 + k*36);
            circles.get(k).setY(circles.get(k).getY() + 310);
            updatePanel();
            forceSleep(800);
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
            Logger.getLogger(BinaryThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
