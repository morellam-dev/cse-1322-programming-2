package module_3.lab_3b;

import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/* Foreword: It is worth noting that while this lab is meant to involve
 *  String parsing and 
 */
public class StringApp extends Application {
    // Set the Scene

    // Create Nodes
    TextField inputOne; 
    TextField inputTwo;
    Label labelPlus = new Label("+");
    Button equalsButton = new Button("=");
    Label labelOutput = new Label("Loading...");

    @Override
    public void start(Stage stage) {
        Pane root = new HBox(10);
        Scene myScene = new Scene(root, 400, 200);
        root.paddingProperty().set(new Insets(10));
        stage.setTitle("Basic Sum Application");

        // Set widths for input fields
        inputOne = new TextField();
        inputOne.setPrefWidth(100);
        inputTwo = new TextField();
        inputTwo.setEditable(true);
        inputTwo.setPrefWidth(100);

        labelOutput.setPrefWidth(100);

        //
        equalsButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                submit();
            }
        });
        
        stage.setScene(myScene);

        root.getChildren().addAll(
            inputOne, 
            labelPlus, 
            inputTwo, 
            equalsButton, 
            labelOutput
        );

        submit();

        stage.show();
    }

    public double getInputOne() {
        try {
            return Double.parseDouble(inputOne.getText());
        } catch (NumberFormatException e) {
            inputOne.setText("" + 0);
            return 0;
        }
    }
    
    public double getInputTwo() {
        try {
            return Double.parseDouble(inputTwo.getText());
        } catch (NumberFormatException e) {
            inputTwo.setText("" + 0);
            return 0;
        }
    }
    
    public void submit() {
        // I am a god among men. I am a god among men!!!!
        // I am a god among men. I am a god among men!!!!
        // I am a god among men. I am a god among men!!!!
        double sum = getInputOne() + getInputTwo();
        labelOutput.setText("" + sum);
    }

    public static void main(String[] args) {
        launch(args);
    }
}