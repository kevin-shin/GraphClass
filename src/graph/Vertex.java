package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;

public class Vertex{

    private int x;
    private int y;
    private double radius;

    public Vertex(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getRadius(){
        return radius;
    }
    public void updatePosition(int x,int y){
        this.x = x;
        this.y = y;
    }


}
