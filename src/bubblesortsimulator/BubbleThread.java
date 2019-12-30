
package bubblesortsimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BubbleThread extends Thread {

    private ArrayList<Circle> circles;
    private MyPanel panel;

    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }

   
    public void run() {
        
        forceSleep(1500);

        for (int i = 0; i < 9; i++) {
            
            for (int j = 0; j < 9 - i; j++) {
                
                forceSleep(400);
                
                Circle c1 = circles.get(j);
                Circle c2 = circles.get(j + 1);
                
                if (c1.getData() > c2.getData()) {

                    circles.get(j).setY(circles.get(j).getY() + 20);
                    circles.get(j + 1).setY(circles.get(j + 1).getY() + 20);

                    updatePanel();
                    forceSleep(400);

                    int x = circles.get(j).getX();
                    circles.get(j).setX(circles.get(j + 1).getX());
                    circles.get(j + 1).setX(x);

                    Collections.swap(circles, j, j + 1);
                    panel.setCircles(circles);

                    updatePanel();
                    forceSleep(400);

                    circles.get(j).setY(circles.get(j).getY() - 20);
                    circles.get(j + 1).setY(circles.get(j + 1).getY() - 20);

                    updatePanel();
                    forceSleep(100);

                }
            }
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
            Logger.getLogger(BubbleThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
