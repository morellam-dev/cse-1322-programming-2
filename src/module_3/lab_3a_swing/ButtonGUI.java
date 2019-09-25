package module_3.lab_3a_swing;

import java.awt.*;
import java.awt.event.*;

/**
* A simple component which displays buttons, and shows output when a button is pressed.
*/
public class ButtonGUI extends Panel {
    private static final long serialVersionUID = 2188026364856631809L;
    
    private TextField textField;
    private Panel buttonPanel;
    private String[] buttonNames;
    
    /**
    * A simple component which displays six buttons, and shows output when a button is
    * pressed.
    */
    public ButtonGUI() {
        // Default behavior: six numbered buttons
        this(new String[]{"Button #1", "Button #2", "Button #3", 
        "Button #4", "Button #5", "Button #6"});
    }
    
    /**
    * Create a ButtonGUI with custom button names
    * 
    * @param buttonNames The names of each button to display on the panel.
    * @param messages    A list of formatting strings like {@code "You pressed %s"},
    *                    which will be displayed at random when a button is pressed.
    */
    public ButtonGUI(String[] buttonNames) {
        super(new BorderLayout(5, 5)); // set layout manager
        
        this.buttonNames = buttonNames;
        
        // Text display component
        textField = new TextField(40);
        textField.setText("Welcome! Press a button and see what happens!");
        textField.setEditable(false);
        add(textField, BorderLayout.PAGE_START);
        
        // Button component: a 3-column grid
        buttonPanel = new Panel(new GridLayout(0, 3));
        // Generate six buttons
        for (String name : this.buttonNames) {
            Button btn = new Button(name);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    showButtonMessage(name);
                }
            });
            buttonPanel.add(btn);
        }
        add(buttonPanel, BorderLayout.PAGE_END);
    }
    /**
    * Given the name of the button that was just pressed, return a random message.
    * @param buttonName
    * @return A formatted string including the button name.
    */
    public void showButtonMessage(String buttonName) {
        String[] messages = { 
            "Bazinga! You pressed the heck out of %s!", 
            "Blam! You pressed %s!", 
            "Hachi machi, you pressed %s.",
            "Huh. Somebody just pushed %s.",
            "Kapow! Nice work on pressing %s!", 
            "Outstanding! That was %s!",
            "Press %s again. See what happens.", 
            "Whoa mama! Did you just press %s?", 
            "Wowie! %s was pressed!",
            "Wowie! You just pressed %s!", 
            "何!? %s が押されました!"
        };
        // Get random message format.
        String msgFormat = messages[(int) (Math.random() * messages.length)];
        // Format string into message
        String msg = String.format(msgFormat, buttonName);
        // Set textField to message
        textField.setText(msg);
    }
}