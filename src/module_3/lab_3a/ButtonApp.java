package module_3.lab_3a;

import java.awt.*;
import java.awt.event.*;

/**
 * ButtonApp
 */

public class ButtonApp extends Frame {

    public static void main(String[] args) {
        ButtonApp main = new ButtonApp();
    }
    public ButtonApp() {
        // WINDOW LOGIC
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setTitle("Button App");
        this.setSize(400, 150);
        this.setLayout(new FlowLayout());

        this.add(new ButtonAppComponent());
    }
}

class ButtonAppComponent extends Panel {
    private TextField textField;
    private Panel buttonPanel;

    public ButtonAppComponent() {
        super();

        // Text Field
        textField = new TextField(40);
        textField.setText("Welcome! Please press a button!");
        textField.setEditable(false);
        this.add(textField);

        // Button Panel
        buttonPanel = new Panel(new GridLayout(2, 3));
        for (int i = 0; i < 6; i++) {
            String label = "Button #" + (i + 1);
            Button btn = new Button(label);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String msg = buttonClickMessage(label);
                    textField.setText(msg);
                }
            });
            buttonPanel.add(btn);
        }
        this.add(buttonPanel);
    }


    public String buttonClickMessage(String buttonName) {
        String[] formats = { 
            "Blam! You pressed %s!", "Wowie! %s was pressed!",
            "Bazinga! You pressed the heck out of %s!", 
            "Wowie! You just pressed %s!", 
            "Outstanding! That was %s!",
            "Kapow! Nice work on pressing %s!",
            "Whoa mama! Did you just press %s?",
            "Hachi machi, you pressed %s.",
            "Press %s again. See what happens.",
            "What? Somebody just pushed %s.",
        };
        String format = formats[(int) (Math.random() * formats.length)];
        return String.format(format, buttonName);
    }
}

class ButtonPanel extends Panel {
    public ButtonPanel(LayoutManager layout, ActionListener al, int buttonCount) {
        super(layout);

        for (int i = 0; i < buttonCount; i++) {
            int num = i + 1;
            String label = "Button #" + num;
            Button btn = new Button(label);
            btn.addActionListener(al);
            this.add(btn);
        }
    }
}