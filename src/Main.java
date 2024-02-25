import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Effect;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;

public class Main extends Application {
    static private BigDecimal firstValue = new BigDecimal(0);
    static private boolean isNonInt =  false;
    static private char nextOperation = '0';
    static int decimalPlacement = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {

        // user interface elements:
        primaryStage.setTitle("Calculator");
        TextField displayedText = new TextField();
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


        // Button Action Handlers:
        one.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }
            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(1));
            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }
            displayedText.setText(firstValue.toString());
        });

        two.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }
            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(2));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        three.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }
            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(3));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        four.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }

            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(4));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        five.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }
            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(5));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        six.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }
            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(6));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        seven.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }
            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(7));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        eight.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }
            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(8));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        nine.setOnAction(e -> {
            if (isNonInt) {
                firstValue = firstValue.movePointRight(decimalPlacement);
            }
            firstValue = firstValue.multiply(new BigDecimal(10));
            firstValue = firstValue.add(new BigDecimal(9));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        zero.setOnAction(e -> {
            firstValue = firstValue.multiply(new BigDecimal(10));

            if (isNonInt) {
                decimalPlacement += 1;
                firstValue = firstValue.movePointLeft(decimalPlacement);
            }

            displayedText.setText(firstValue.toString());
        });

        AC.setOnAction(e -> {
            firstValue = new BigDecimal(0);
            decimalPlacement = 0;
            isNonInt = false;
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
        });



    }
    public static void main(String[] args) {
        launch(args);
    }
}
