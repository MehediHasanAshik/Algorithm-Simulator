

package bubblesortsimulator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SimulatorWindow3 extends JFrame {

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
    
    private MyPanel panel1;

    public SimulatorWindow3() {
        
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
            
            circle = new Circle(270 + i*55 , 190 , 50 , colors.get(i),ran.nextInt(100));
            circles.add(circle);
        }
        

       /* for (int i = 0; i < 12; i++) {
            
            Random ran = new Random();
            
            if(i==0)
            {
                 circle = new Circle(140 + i * 70, 190, 50, colors.get(i), ran.nextInt(100));
            }
            
            else if(i==11)
            {
                circle = new Circle(-70 + i * 0, -20, 50, colors.get(i), -1);
            }
            
            else
            {
                 circle = new Circle(270 + i * 55, 190, 50, colors.get(i), ran.nextInt(100));
            }
            
            circles.add(circle);

        }*/
        
        
        
        /*for (int i = 0; i < 12; i++) {
            
            Random ran = new Random();
            
            if(i==0)
            {
                 circle = new Circle(140 + i * 70, 190, 50, colors.get(i), 6);
            }
            
            else if(i==11)
            {
                circle = new Circle(-70 + i * 0, -20, 50, colors.get(i), -1);
            }
            
            else
            {
                 circle = new Circle(270 + i * 55, 190, 50, colors.get(i), 11-i);
            }
            
            circles.add(circle);

        }*/
        
        
        panel1.setCircles(circles);
        this.setLayout(null);
        this.add(panel1);
        this.setVisible(true);
        
        /*thread1 = new BubbleThread();
        thread1.setCircles(circles);
        thread1.setPanel(panel1);
        thread1.start();*/
        
        thread2 = new InsertThread();
        thread2.setCircles(circles);
        thread2.setPanel(panel1);
        thread2.start();
        
        
        
        
        /*thread3 = new LinearThread();
        thread3.setCircles(circles);
        thread3.setPanel(panel1);
        thread3.start();*/
        
        
        /*thread4 = new MaxThread();
        thread4.setCircles(circles);
        thread4.setPanel(panel1);
        thread4.start();*/
        
       
        /*thread5 = new MinThread();
        thread5.setCircles(circles);
        thread5.setPanel(panel1);
        thread5.start();*/
        
   
        /*for (int i = 1; i < 11; i++) {
            
            for (int j = 1; j < 11 - i; j++) {
 
               Circle c1 = circles.get(j);
               Circle c2 = circles.get(j + 1);
                
                if (c1.getData() > c2.getData()) {

                    circles.get(j).setY(circles.get(j).getY() + 20);
                    circles.get(j + 1).setY(circles.get(j + 1).getY() + 20);

                    int x = circles.get(j).getX();
                    circles.get(j).setX(circles.get(j + 1).getX());
                    circles.get(j + 1).setX(x);

                    Collections.swap(circles, j, j + 1);
            
                    circles.get(j).setY(circles.get(j).getY() - 20);
                    circles.get(j + 1).setY(circles.get(j + 1).getY() - 20);
                }
            }
        }*/
     
        
        /*thread6 = new BinaryThread();
        thread6.setCircles(circles);
        thread6.setPanel(panel1);
        thread6.start();*/
    }

}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bubblesortsimulator;

/**
 *
 * @author ASHIK
 */
//public class SimulatorWindow3 {
    

