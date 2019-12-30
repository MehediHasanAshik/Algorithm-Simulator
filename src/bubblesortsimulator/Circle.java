
package bubblesortsimulator;

import java.awt.Color;


public class Circle {

    private int x;
    private int y;
    private int r;
    private Color c;
    private int data;

    public Circle(int x, int y, int r, Color c, int data) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.data = data;
    }

    Circle() {
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public Color getC() {
        return c;
    }

    public int getData() {
        return data;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
