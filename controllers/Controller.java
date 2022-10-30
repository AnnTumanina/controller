package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Controller {

    private final String regexp = "\\D*\\d+"; // Регулярное выражение для проверки ввода в поля

    //Элементы JavaFX
    @FXML
    public Button result;
    @FXML
    public Label res1;
    @FXML
    public Label res2;
    @FXML
    public Button help;
    @FXML
    private TextField firstNum;
    @FXML
    private TextField secondNum;
    @FXML
    private TextField thirdNum;
    @FXML
    private TextField lastNum;


    /**
     *
     * @param str Текстовое поле на форме
     * @return Числовое значение из поля
     */
    private Integer intFromBox(TextField str) {
        return Integer.valueOf(str.getText());
    }

    /**
     * Метод, проверяющий на корректность ввода и выводящий результаты
     */
    public void getResult() {
        if (firstNum.getText().matches(regexp) && secondNum.getText().matches(regexp) && thirdNum.getText().matches(regexp) && lastNum.getText().matches(regexp)) {
            List<Integer> resultList = answer(intFromBox(firstNum), intFromBox(secondNum), intFromBox(thirdNum), intFromBox(lastNum));
            switch (resultList.size()) {

                case 1:
                    res1.setText("X = " + resultList.get(0).toString());
                    res2.setText("");
                    break;
                case 2:
                    res1.setText("X2 = " + resultList.get(0).toString());
                    res2.setText("X1 = " + resultList.get(1).toString());
                    break;
                default:
                    res1.setText("Корней нет");
                    res2.setText("");
                    break;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Введены нечисловые значения!", ButtonType.OK);
            alert.showAndWait();
        }


    }

    /**
     *
     * @param a Первое число с формы
     * @param b Второе число с формы
     * @param c Третье число с формы
     * @param d Четвертое число с формы
     * @return Возвращает результат в виде коллекции значений X
     */
    // метод для решения кубического уравнения
    private static List<Integer> answer(int a, int b, int c, int d) {
        List<Integer> resultList = new ArrayList<>();
        for (int x = -100; x <= 100; x++) {
            double result = a * Math.pow(x, 3) + b * x * x + c * x + d;
            if (result == 0) {
                resultList.add(x);

            }
        }
        return resultList;
    }

    /**
     *
     * @param event Метод для перехода на форму справки
     * @throws IOException
     */
    public void getHelp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample\\resources\\fxml\\help.fxml")));
        root.setId("pane");
        Stage stage = new Stage();
        stage.setTitle("Справка : метод дихотомии");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(String.valueOf(this.getClass().getClassLoader().getResource("sample\\resources\\style\\style.css")));
        stage.setScene(scene);
        stage.show();
    }
}
