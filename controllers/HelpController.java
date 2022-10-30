package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelpController implements Initializable {

    @FXML
    public TextArea area;

    /**
     *
     * @param location Метод, срабатывающий при переходе на форму справки
     * @param resources Применяет CSS-стили отображения на элементы формы
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
    }
    }

