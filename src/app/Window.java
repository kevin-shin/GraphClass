package app;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {

    private GraphPanel graphPanel;
    private buttonPanel buttonPanel;

    public Window() {
        super("Example Program");

        this.graphPanel = new GraphPanel();
        this.buttonPanel = new buttonPanel();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        graphPanel.setPreferredSize(new Dimension(600, 600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(graphPanel);

        this.pack();
        this.setVisible(true);
    }


}
