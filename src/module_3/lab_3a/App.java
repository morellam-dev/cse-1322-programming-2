package module_3.lab_3a;

import java.awt.*;
import java.awt.event.*;

/**
 * App
 */
public class App extends Frame {
    private static final long serialVersionUID = 1L;

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 150;

    public App(String title) {
        super(title);
        addWindowListener(new WindowCloseListener()); // Window logic
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new FlowLayout()) ; // LAYOUT MANAGER: FlowLayout

        add(new ButtonGUI());
    }

    public static void main(String[] args) {
        App main = new App("My First Button App");
        main.setVisible(true);
    }

    // Exit app when main window closes.
    private class WindowCloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}