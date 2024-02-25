import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {
    static String displayedTemp = "";
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Calculator");
        TextField operations = new TextField();
        Button AC = new Button("AC");
        Button plusMinus = new Button("+/-");
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

        HBox h1 = new HBox(5, AC, plusMinus, percent, division);
        HBox h2 = new HBox(5, seven, eight, nine, multiplication);
        HBox h3 = new HBox(5, four, five, six, subtraction);
        HBox h4 = new HBox(5, one, two, three, addition);
        HBox h5 = new HBox(10, zero, decimal, equates);
        VBox v1 = new VBox(10, operations, h1, h2, h3, h4, h5);
        operations.setDisable(true);

        primaryStage.setScene(new Scene(v1, 300, 440));
        primaryStage.show();

        one.setOnAction(e -> {
            displayedTemp += "1";
            operations.setText(displayedTemp);
        });

        two.setOnAction(e -> {
            displayedTemp += "2";
            operations.setText(displayedTemp);
        });

        three.setOnAction(e -> {
            displayedTemp += "3";
            operations.setText(displayedTemp);
        });

        four.setOnAction(e -> {
            displayedTemp += "4";
            operations.setText(displayedTemp);
        });

        five.setOnAction(e -> {
            displayedTemp += "5";
            operations.setText(displayedTemp);
        });

        six.setOnAction(e -> {
            displayedTemp += "6";
            operations.setText(displayedTemp);
        });

        seven.setOnAction(e -> {
            displayedTemp += "7";
            operations.setText(displayedTemp);
        });

        eight.setOnAction(e -> {
            displayedTemp += "8";
            operations.setText(displayedTemp);
        });

        nine.setOnAction(e -> {
            displayedTemp += "9";
            operations.setText(displayedTemp);
        });

        zero.setOnAction(e -> {
            displayedTemp += "0";
            operations.setText(displayedTemp);
        });

        AC.setOnAction(e -> {
            displayedTemp = "";
            operations.setText(displayedTemp);
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
