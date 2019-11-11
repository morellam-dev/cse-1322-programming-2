package module_6.lab_6b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * A simple GUI text editor demonstrating File I/O operations
 * @author M Morella
 */
public class TextEditorApp extends JFrame {
    private static final long serialVersionUID = 3616427372788490052L;

    private JTextField pathField = new JTextField("./hello_world.txt", 40);
    private JButton loadButton = new JButton("Load");
    private JButton saveButton = new JButton("Save");

    private JTextArea textField = new JTextArea("Enter a path and click 'Load' to get started.");

    private JLabel statusBar = new JLabel("Enter a path and click 'Load' to get started.");

    public static void main(String[] args) {
        new TextEditorApp();
    }

    public TextEditorApp() {
        super("Text Editor - no file loaded");
        // Create new Window
        setSize(800, 600);
        setLayout(new BorderLayout());
        // Exit app when window closes.
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // Create and show GUI
        JPanel topBar = new JPanel(new FlowLayout());
        topBar.add(pathField);
        topBar.add(loadButton);
        topBar.add(saveButton);
        saveButton.setEnabled(false);
        add(topBar, BorderLayout.PAGE_START);

        textField.setLineWrap(true);
        textField.setEnabled(false);
        add(textField, BorderLayout.CENTER);

        add(statusBar, BorderLayout.PAGE_END);
        setVisible(true);

        // Create event handlers
        loadButton.addActionListener((event) -> handleLoad());
        saveButton.addActionListener((event) -> handleSave());
    }


    public File getFileFromPath() {
        String path = pathField.getText();
        return new File(path);
    }
    
    public void handleLoad() {
        textField.setText("");
        File file = getFileFromPath();
        if (!file.exists()) {
            displayStatus(String.format("%s does not exist. To create it, click 'Save'.", file.getName()));
        } else {
            try {
                textField.setText(readFile(file));
                displayStatus(String.format("%s loaded successfully!", file.getName()));
            } catch (IOException e) {
                displayAlert("Unable to read file at " + file.getPath());
            }
        }
        setTitle("Editing " + file.getName());
        textField.setEnabled(true);
        saveButton.setEnabled(true);
    }

    public void handleSave() {
        File file = getFileFromPath();
        String text = textField.getText();
        try {
            writeFile(file, text);
        } catch (IOException e) {
            displayAlert(e.getMessage());
        }
    }

    public String readFile(File f) throws IOException {
        String text = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            text = "";
            while (reader.ready()) {
                text += reader.readLine() + "\n";
            }
        }
        return text;
    }
    
    public void writeFile(File f, String s) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(f, false))) {
            out.write(s);
            displayStatus("Successfully wrote to " + f.getName());
        }
    }

    public void displayStatus(String status) {
        statusBar.setText(status);
    }

    public void displayAlert(String alert) {
        statusBar.setText("ERROR: " + alert);
    }
}