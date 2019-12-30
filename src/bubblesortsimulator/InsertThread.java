
package bubblesortsimulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;


class InsertThread extends Thread {

    private ArrayList<Circle> circles;
    private MyPanel panel;
    int j;
    
    Circle c1,c2,dummy;
    int flag = 0,ct=0;

    public void setCircles(ArrayList<Circle> circles) {
        this.circles = circles;
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }

    public void run() {
        
        forceSleep(1500);

        for (int i = 1; i <= 9; i++) {
            
           c1=circles.get(i);
           
           //System.out.println("\nTemp value: "+c1.getData());
           
           
           dummy = c1;
           j=i-1;
           c2=circles.get(j);
            
           forceSleep(400);
            
           c1.setY(c1.getY()+75);
           panel.setDummy(dummy);
           panel.setIsDummy(true);
           updatePanel();
           forceSleep(400);
           
           flag = 0;
           
          // System.out.println("\nInitial Value");
           
          // for(Circle c3: circles)
           //{
               //System.out.print(c3.getData()+"  ");
           //}
           
           System.out.println();
           while(c1.getData()<c2.getData() && j>=0)
           {
              
              
               circles.set(j+1,circles.get(j));
               circles.get(j+1).setX(circles.get(j+1).getX()+ 55);
               
               
               updatePanel();
               forceSleep(400);
               
               //System.out.println(c1.getY());
               
               /*
               
               circles.get(j+1).setX(circles.get(j).getX());
               
               //Collections.swap(circles, j+1, j);
               panel.setCircles(circles);
               
               updatePanel();
               forceSleep(400);
               
               circles.get(j+1).setY(circles.get(j+1).getY()-20);
               circles.get(j).setY(circles.get(j).getY()-20);
               
               updatePanel();
               forceSleep(200);
               
               j--;
               
               
               updatePanel();
               forceSleep(200);
               
               c2=circles.get(j);
               
               
               //updatePanel();
               //forceSleep(200);
               */
               
               j--;
               if(j>=0){
                    c2=circles.get(j);
               }
               //System.out.println("Hello");
               flag = 1;
           }
           
           ct++;
           
          
           System.out.println();
           
           if(flag==1){
               
           dummy.setX(270 + (j+1)*55);
           panel.setDummy(dummy);
           panel.setIsDummy(true);
           updatePanel();
           forceSleep(400);
           circles.set(j+1,c1);
           circles.get(j+1).setX(270 + (j+1)*55);
           circles.get(j+1).setY(circles.get(j+1).getY() - 75);
           

               
           }
         
           else
           {
             c1.setY(circles.get(j+1).getY());
             c1.setY(circles.get(j+1).getY() - 75);
               
           }
           
           
          //  System.out.print("After "+ct + " swap: ");
           
           //for(Circle c: circles){
               
              //System.out.print(c.getData()+"  ");
          // }
           
           
           updatePanel();
           forceSleep(400);
         
           //circles.get(j+1).setX(circles.get(i).getX()-20);
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
            Logger.getLogger(InsertThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
