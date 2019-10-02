package module_3.assignment_3;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * Calculator
 */
public class CalculatorGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Calculator calculator = new Calculator();

    TextField display = new TextField();
    GridPane buttonGrid = new GridPane();
    String[][] buttonLabels = {
        {"7", "8", "9", "/"},
        {"4", "5", "6", "*"},
        {"1", "2", "3", "-"},
        {"0", ".", "=", "+"},
        {"AC", }
    };

    public void start(Stage stage) {
        Pane root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        Scene myScene = new Scene(root, 300, 300);
        stage.setScene(myScene);
        stage.setTitle("Basic Sum Application");

        root.getChildren().add(display);
        root.getChildren().add(buttonGrid);
        buttonGrid.setVgap(10);
        buttonGrid.setHgap(10);
        for (int row = 0; row < buttonLabels.length; row++) {
            for(int col = 0; col < buttonLabels[row].length; col++) {
                String label = buttonLabels[row][col];
                Button btn = new Button(label);
                btn.setPrefWidth(60);
                btn.setOnAction(e -> pushButton(label));
                buttonGrid.add(btn, col, row);
            } 
        }
        stage.show();
    }

    public void pushButton(String label) {
        switch(label) {
            case "AC":
                calculator.clear();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                calculator.setOperator(label);
                break;
            case "=":
                calculator.submit();
                break;
            default:
                calculator.addDigit(label);
        }
        display();

        System.out.println("PUSH: " + label);
    }

    public void display() {
        this.display.setText(calculator.display());
    }
}

class Calculator {
    private String[] inputNums = {"", ""};
    private int activeIndex = 0;
    private String operator = "";
    private boolean showResult = false;

    public String display() {
        String out = inputNums[0];
        if (!operator.isEmpty()) {
            out += " " + operator + " " + inputNums[1];
        }
        if (showResult) {
            out += " = " + getResult();
        }
        return out;
    }

    private String getNumString() {
        return inputNums[this.activeIndex];
    }
    private void setNumString(String numString) {
        inputNums[this.activeIndex] = numString;
    }

    public void switchActiveIndex() {
        int len = inputNums.length;
        activeIndex = (++activeIndex) % len;
    }

    public void addDigit(String digit) {
        if (showResult) {
            clear();
        }

        setNumString(getNumString() + digit);
    }

    public void setOperator(String op) {
        this.operator = op;
        switchActiveIndex();
    }
    public void clear() {
        inputNums = new String[]{"", ""};
        activeIndex = 0;
        operator = "";
        showResult = false;
    }

    public void submit() {
        try {
            getResult();
            showResult = true;
        } catch (NumberFormatException e) {
            clear();
        }
    }

    public Double getResult() throws NumberFormatException {

        Double num1 = Double.parseDouble(inputNums[0]);
        Double num2 = Double.parseDouble(inputNums[1]);
        
        switch(operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default: 
                return -99999.99;
        }
    }
}