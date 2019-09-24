package module_3.lab_3b;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * StringGUI
 */
public class StringGUI extends JPanel {
    private static final long serialVersionUID = 4037710281083546920L;

    JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    TextField inputBoxOne = new TextField(6); // AWT textfields support tab focus by default.
    TextField inputBoxTwo = new TextField(6);
    JLabel outputBox = new JLabel("0"); // Use Swing's JLabel to avoid concurrency issues
    Button submitButton = new Button("=");

    public StringGUI() {
        // BUILD PANEL GUI
        setLayout(new BorderLayout(5, 5));
        inputPanel.add(inputBoxOne);
        inputPanel.add(new Label("+"));
        inputPanel.add(inputBoxTwo);
        inputPanel.add(submitButton);
        inputPanel.add(outputBox);
        add(inputPanel, BorderLayout.PAGE_START);

        // ADD EVENT LISTENER
        submitButton.addActionListener(new SubmitListener());
    }

    private class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            submit();
        }
    }

    public void submit() {
        try {
            String inputOne = inputBoxOne.getText();
            String inputTwo = inputBoxTwo.getText();
            double num1 = Double.parseDouble(inputOne);
            double num2 = Double.parseDouble(inputTwo);
            double sum = num1 + num2;

            outputBox.setText("" + sum);
            outputBox.repaint();
        } catch (NumberFormatException e) {
            // ERROR: INVALID INPUT
            inputBoxOne.setText("0");
            inputBoxTwo.setText("0");
        }
    }
}