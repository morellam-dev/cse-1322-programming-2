package module_3.lab_3a;

import java.awt.*;
import java.awt.event.*;

/**
 * ButtonApp
 */

public class ButtonApp extends Frame {
    private static final long serialVersionUID = 1785282950335421969L;

    public static void main(String[] args) {
        ButtonApp main = new ButtonApp();
        main.setVisible(true);
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
    private static final long serialVersionUID = -3242933000059067958L;

    private TextField textField;
    private Panel buttonPanel;

    public ButtonAppComponent() {
        super();

        setLayout(new BorderLayout());

        // Text Field
        textField = new TextField(40);
        textField.setText("Welcome! Please press a button!");
        textField.setEditable(false);
        this.add(textField, BorderLayout.PAGE_START);

        // Button Panel
        buttonPanel = new Panel(new GridLayout(2, 3));
        for (int i = 0; i < 6; i++) {
            String label = "Button #" + (i + 1);
            Button btn = new Button(label);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    displayText(
                        buttonMessage(label)
                    );
                }
            });
            buttonPanel.add(btn);
        }
        this.add(buttonPanel, BorderLayout.PAGE_END);
    }

    public void displayText(String text) {
        textField.setText(text);
    }

    public String buttonMessage(String buttonName) {
        final String[] LITERALS = { 
            "Blam! You pressed %s!", 
            "Wowie! %s was pressed!",
            "Bazinga! You pressed the heck out of %s!", 
            "Wowie! You just pressed %s!", 
            "Outstanding! That was %s!",
            "Kapow! Nice work on pressing %s!",
            "Whoa mama! Did you just press %s?",
            "Hachi machi, you pressed %s.",
            "Press %s again. See what happens.",
            "Huh. Somebody just pushed %s.",
            "Ah, I love the smell of %s in the morning.",
            "You might wanna lay off pressing %s.",
        };
        String format = LITERALS[(int) (Math.random() * LITERALS.length)];
        return String.format(format, buttonName);
    }
}