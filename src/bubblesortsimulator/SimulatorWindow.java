
package bubblesortsimulator;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SimulatorWindow extends JFrame {

    private ArrayList<Color> colors = new ArrayList<Color>();
    private ArrayList<Circle> circles = new ArrayList<Circle>();
    
    private Circle color1;
    private Circle circle1;
    Circle circle;
    
    
   
    private BubbleThread thread1;
    private InsertThread thread2;
    private LinearThread thread3;
    private MaxThread thread4;
    private MinThread thread5;
    private BinaryThread thread6;
    
   private JButton b;
   
   private JLabel l;
   
    
    private MyPanel panel1;
    
    
     /* private void bActionPerformed(java.awt.event.ActionEvent evt){
          //thread4.start();
          thread4 =new MaxThread();
          thread4.start();
          
          
          
      }*/
    

    public SimulatorWindow() {
       // b.setVisible(true);
       /* b= new JButton("Go");
        b.setBounds(120, 45, 60, 42);
        add(b);*/
       
        
        
        
        this.setSize(1100, 650);
        panel1 = new MyPanel();
        
        
        //color1
        
        
       // colors.add(Color.WHITE);
        
        colors.add(Color.BLUE);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.pink);
        colors.add(Color.RED);
        colors.add(Color.white);
        colors.add(Color.lightGray);
        //colors.add(Color.CYAN);
        
        for(int i=0;i<10;i++)
        {
            Random ran = new Random();
            
            circle = new Circle(270 + i*55 , 190 , 50 , colors.get(i),ran.nextInt(50));
            circles.add(circle);
        }
       
        
        panel1.setCircles(circles);
        this.setLayout(null);
        this.add(panel1);
        this.setVisible(true);
        
        
        thread4 = new MaxThread();
        thread4.setCircles(circles);
        thread4.setPanel(panel1);
        thread4.start();
        
        
        
        
        
    }
}