import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by Nguyen on 11/3/2016.
 */
public class ExchangeMain extends Application {
    public static void main(String []args) {
        launch (args);
    }
    Label starch;
    Label dairy;
    Label protein;
    Label fruit;
    Label vegetable;
    Label fat;
    Button calculate;
    TextField starchInput;
    TextField dairyInput;
    TextField proteinInput;
    TextField fruitInput;
    TextField vegetableInput;
    TextField fatInput;
    TextArea output;

    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Exchange Calculator");
        VBox box = new VBox();
        VBox button = new VBox();
        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root,500,500));
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,30));
        grid.setHgap(100);
        grid.setVgap(10);
        starch = new Label("Starch");
        dairy = new Label("Dairy");
        protein = new Label("Protein");
        fruit = new Label("Fruit");
        vegetable = new Label("Vegetable");
        fat = new Label("Fat");
        starchInput = new TextField();
        dairyInput = new TextField();
        proteinInput = new TextField();
        fruitInput = new TextField();
        vegetableInput = new TextField();
        fatInput = new TextField();
        output = new TextArea();
        output.setPadding(new Insets(10,10,10,10));
        output.setEditable(false);
        calculate = new Button("Calculate");
        starchInput.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() > oldValue.intValue()) {
                    char ch = starchInput.getText().charAt(oldValue.intValue());
                    if(!(ch >= '0' && ch <= '9'|| ch == '.'))
                    {
                        starchInput.setText((starchInput.getText().substring(0,starchInput.getText().length()-1)));
                    }
                }

            }
        });
        dairyInput.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() > oldValue.intValue()) {
                    char ch = dairyInput.getText().charAt(oldValue.intValue());
                    if(!(ch >= '0' && ch <= '9'|| ch == '.'))
                    {
                        dairyInput.setText((dairyInput.getText().substring(0,dairyInput.getText().length()-1)));
                    }
                }

            }
        });
        proteinInput.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() > oldValue.intValue()) {
                    char ch = proteinInput.getText().charAt(oldValue.intValue());
                    if(!(ch >= '0' && ch <= '9'|| ch == '.'))
                    {
                        proteinInput.setText((proteinInput.getText().substring(0,proteinInput.getText().length()-1)));
                    }
                }

            }
        });
        fruitInput.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() > oldValue.intValue()) {
                    char ch = fruitInput.getText().charAt(oldValue.intValue());
                    if(!(ch >= '0' && ch <= '9'|| ch == '.'))
                    {
                        fruitInput.setText((fruitInput.getText().substring(0,fruitInput.getText().length()-1)));
                    }
                }

            }
        });
        vegetableInput.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() > oldValue.intValue()) {
                    char ch = vegetableInput.getText().charAt(oldValue.intValue());
                    if(!(ch >= '0' && ch <= '9'|| ch == '.'))
                    {
                        vegetableInput.setText((vegetableInput.getText().substring(0,vegetableInput.getText().length()-1)));
                    }
                }

            }
        });
        fatInput.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.intValue() > oldValue.intValue()) {
                    char ch = fatInput.getText().charAt(oldValue.intValue());
                    if(!(ch >= '0' && ch <= '9' || ch == '.'))
                    {
                        fatInput.setText((fatInput.getText().substring(0,fatInput.getText().length()-1)));
                    }
                }

            }
        });
        button.setPadding(new Insets(10,100,10,230));
        //calculate.setPadding(new Insets(10,10,10,150));
        calculate.setOnAction(event -> calculatekcal());
        root.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode() == KeyCode.ENTER)
                calculatekcal();
        });
        grid.add(starch,0,0);
        grid.add(starchInput,0,1);
        grid.add(dairy,1,0);
        grid.add(dairyInput,1,1);
        grid.add(protein,2,0);
        grid.add(proteinInput,2,1);
        grid.add(fruit,0,2);
        grid.add(fruitInput,0,3);
        grid.add(vegetable,1,2);
        grid.add(vegetableInput,1,3);
        grid.add(fat,2,2);
        grid.add(fatInput,2,3);
        button.getChildren().add(calculate);
        box.getChildren().add(grid);
        box.getChildren().add(button);
        box.getChildren().add(output);
        root.getChildren().add(box);
        primaryStage.show();
    }

    public void calculatekcal()
    {
        float tempOutput = 0;
        if(starchInput.getText().trim().isEmpty() == false)
            tempOutput += (Float.parseFloat(starchInput.getText()) * 100);
        if(proteinInput.getText().trim().isEmpty() == false)
            tempOutput += (Float.parseFloat(proteinInput.getText()) * 65);
        if(dairyInput.getText().trim().isEmpty() == false)
            tempOutput += (Float.parseFloat(dairyInput.getText()) * 110);
        if(fruitInput.getText().trim().isEmpty() == false)
            tempOutput += (Float.parseFloat(fruitInput.getText()) * 60);
        if(vegetableInput.getText().trim().isEmpty() == false)
            tempOutput += (Float.parseFloat(vegetableInput.getText()) * 25);
        if(fatInput.getText().trim().isEmpty() == false)
            tempOutput += (Float.parseFloat(fatInput.getText()) * 45);
        output.setText(Float.toString(tempOutput));
    }

}
