package module_3.lab_3b;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * App
 */
public class App extends JFrame {
    private static final long serialVersionUID = 1L;

    public static final int WINDOW_WIDTH = 450;
    public static final int WINDOW_HEIGHT = 150;

    public App(String title) {
        super(title);
        addWindowListener(new WindowCloseListener()); // Window logic
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new FlowLayout()) ; // LAYOUT MANAGER: FlowLayout

        add(new StringGUI());
    }

    public static void main(String[] args) {
        App main = new App("String GUI App Demo");
        main.setVisible(true);
    }

    // EXAMPLE of a private event listener class
    private class WindowCloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}