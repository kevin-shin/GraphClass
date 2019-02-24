package app;

import graph.Edge;
import graph.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class GraphPanel extends JPanel {

    private static final int VERTEX_WIDTH = 50;
    private static final int EDGE_WIDTH = 2;
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private Rectangle application = new Rectangle(5, 150, 550, 550);
    private Rectangle toolbar = new Rectangle(555, 5, 200, 700);

    public GraphPanel() {
        super();
        this.addMouseListener(new ClickListener());
        this.addMouseMotionListener(new ClickListener());
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();

        vertices.add(new Vertex(50, 50, 10));
        vertices.add(new Vertex(140, 50, 15));
        vertices.add(new Vertex(230, 50, 20));
        vertices.add(new Vertex(320, 50, 25));
        vertices.add(new Vertex(410, 50, 30));


        repaint();
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


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(EDGE_WIDTH));
        g2.setColor(Color.BLACK);
        g2.draw(toolbar);
        g2.draw(application);

        for (Vertex v : vertices) {
            Ellipse2D node = new Ellipse2D.Double(v.getX() - v.getRadius(), v.getY() - v.getRadius(),
                    v.getRadius() * 2, v.getRadius() * 2);
            g2.draw(node);
            g2.fill(node);
        }

        for (Edge edge : edges) {
            g.drawLine(edge.getVertex1().getX(), edge.getVertex1().getY(), edge.getVertex2().getX(), edge.getVertex2().getY());
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
            Vertex v = vertexAt(e.getX(), e.getY());
            if (!(v == null)) {
                v.updatePosition(e.getX(), e.getY());
                if (v.getY() > 150) {
                    for (Vertex other : vertices) {
                        if (other.getRadius() < v.getRadius() && other.getY()>150) {
                            edges.add(new Edge(other, v));
                        }
                    }

                    repaint();
                }
            }

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}