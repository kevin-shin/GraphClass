package app;

import graph.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class buttonPanel extends JPanel {

    private static final int VERTEX_WIDTH = 30;
    private static final int EDGE_WIDTH = 2;
    private ArrayList<Vertex> vertices;

    public buttonPanel() {
        super();
        setBackground(new Color(204, 166, 166));
        this.addMouseListener(new ClickListener());
        this.addMouseMotionListener(new ClickListener());
        this.vertices = new ArrayList<>();

    }

    private Vertex vertexAt(double x, double y) {
        for (Vertex v : vertices) {
            if (v.getX() >= x - VERTEX_WIDTH / 2 && v.getX() <= x + VERTEX_WIDTH / 2 &&
                    v.getY() >= y - VERTEX_WIDTH / 2 && v.getY() <= y + VERTEX_WIDTH) {
                return v;
            }
        }
        return null;
    }

    // Draw everything
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(EDGE_WIDTH));
        g2.setColor(Color.BLACK);

        for (Vertex v : vertices) {
            Ellipse2D node = new Ellipse2D.Double(v.getX() - VERTEX_WIDTH / 2, v.getY() - VERTEX_WIDTH / 2,
                    VERTEX_WIDTH, VERTEX_WIDTH);
            g2.draw(node);
        }
    }

    private class ClickListener implements MouseListener, MouseMotionListener, ActionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Vertex v = vertexAt(e.getX(),e.getY());
            if (!(v == null)){
                v.updatePosition(e.getX(),e.getY());
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
