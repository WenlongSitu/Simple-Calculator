import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.math.BigDecimal;
import java.math.MathContext;

public class Main extends Application {
    static private BigDecimal firstValue = new BigDecimal(0);
    static private BigDecimal secondValue = null;
    static private boolean isNonInt =  false;
    static private char nextOperation = '0';

    private TextField displayedText;
    static int decimalPlacement = 0;

    private void insertDigit(int num) {
        if (firstValue == null) {
            firstValue = new BigDecimal(0);
        }
        if (isNonInt) {
            firstValue = firstValue.movePointRight(decimalPlacement);
        }
        firstValue = firstValue.multiply(new BigDecimal(10));
        firstValue = firstValue.add(new BigDecimal(num));
        if (isNonInt) {
            decimalPlacement += 1;
            firstValue = firstValue.movePointLeft(decimalPlacement);
        }
        displayedText.setText(firstValue.toString());
    }

    private void compute() {
        if (firstValue == null) {
            return;
        }
        if (nextOperation == '0') {
            secondValue =  firstValue;
            displayedText.setText(secondValue.toString());
            firstValue = null;
        } else if (nextOperation == '+') {
            secondValue = secondValue.add(firstValue);
            displayedText.setText(secondValue.toString());
            firstValue = null;
        } else if (nextOperation == '-') {
            secondValue = secondValue.subtract(firstValue);
            displayedText.setText(secondValue.toString());
            firstValue = null;
        } else if (nextOperation == '*') {
            secondValue = secondValue.multiply(firstValue);
            displayedText.setText(secondValue.toString());
            firstValue = null;
        } else if (nextOperation == '/') {
            secondValue = secondValue.divide(firstValue, new MathContext(10));
            displayedText.setText(secondValue.toString());
            firstValue = null;
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        // user interface elements:
        primaryStage.setTitle("Calculator");
        displayedText = new TextField("0");
        Button AC = new Button("AC");
        Button changeSign = new Button("+/-");
        Button percent = new Button("%");
        Button division = new Button("/");
        Button zero = new Button("0");
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button decimal = new Button(".");
        Button addition = new Button("+");
        Button multiplication = new Button("*");
        Button subtraction = new Button("-");
        Button equates = new Button("=");

        // Layouts
        HBox h1 = new HBox(5, AC, changeSign, percent, division);
        HBox h2 = new HBox(5, seven, eight, nine, multiplication);
        HBox h3 = new HBox(5, four, five, six, subtraction);
        HBox h4 = new HBox(5, one, two, three, addition);
        HBox h5 = new HBox(10, zero, decimal, equates);
        VBox v1 = new VBox(10, displayedText, h1, h2, h3, h4, h5);
        displayedText.setDisable(true);
        displayedText.setText(firstValue.toString());
        displayedText.setAlignment(Pos.CENTER_RIGHT);
        displayedText.setStyle("-fx-opacity: 1.0");

        primaryStage.setScene(new Scene(v1, 300, 440));
        primaryStage.show();

        // Set initial operation (null);
        nextOperation = '0';


        // Button Action Handlers:
        one.setOnAction(e -> {
            insertDigit(1);
        });

        two.setOnAction(e -> {
            insertDigit(2);
        });

        three.setOnAction(e -> {
            insertDigit(3);
        });

        four.setOnAction(e -> {
            insertDigit(4);
        });

        five.setOnAction(e -> {
            insertDigit(5);
        });

        six.setOnAction(e -> {
            insertDigit(6);
        });

        seven.setOnAction(e -> {
            insertDigit(7);
        });

        eight.setOnAction(e -> {
            insertDigit(8);
        });

        nine.setOnAction(e -> {
            insertDigit(9);
        });

        zero.setOnAction(e -> {
            insertDigit(0);
        });

        AC.setOnAction(e -> {
            firstValue = new BigDecimal(0);
            secondValue = null;
            decimalPlacement = 0;
            isNonInt = false;
            nextOperation = '0';
            displayedText.setText(firstValue.toString());
        });

        changeSign.setOnAction(e-> {
            firstValue = firstValue.multiply(new BigDecimal(-1));
            displayedText.setText(firstValue.toString());
        });

        decimal.setOnAction(e -> {
            if (isNonInt) {
                return;
            }
            isNonInt = true;
            displayedText.setText(firstValue.toString() + ".");
        });


        // Operation Button Handlers: Error to be Fixed::
        // Clicking operational buttons consecutively compute when it's not supposed to.
        addition.setOnAction(e -> {
            compute();
            nextOperation = '+';
        });

        subtraction.setOnAction(e -> {
            compute();
            nextOperation = '-';
        });

        multiplication.setOnAction(e -> {
            compute();
            nextOperation = '*';
        });

        division.setOnAction(e -> {
            compute();
            nextOperation = '/';
        });


    }
    public static void main(String[] args) {
        launch(args);
    }
}
