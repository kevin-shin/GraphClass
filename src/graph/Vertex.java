package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;

public class Vertex{

    private Color color;
    private double x;
    private double y;

    public Vertex(Color color, double x, double y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void updatePosition(double x,double y){
        this.x = x;
        this.y = y;
    }


}
