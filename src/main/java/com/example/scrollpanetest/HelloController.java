package com.example.scrollpanetest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TabPane tabPane;
    @FXML
    private BorderPane borderPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox content;

    @FXML
    private GridPane headerGridPane;

    @FXML
    private GridPane mainGridPane;

    @FXML
    private TextArea textArea;

    static int TOTAL_COLUMNS = 19;
    static int TOTAL_CONTROLS = TOTAL_COLUMNS;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupHeaderGridPane();
        setupMainGridPane();
    }


    private void setupHeaderGridPane() {
        for (int i = 0; i < TOTAL_COLUMNS; i++) {
            Label label = new Label("Column " + String.valueOf(i+1));
            headerGridPane.addColumn(i, label);

            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setMinWidth(110);
            columnConstraints.setPrefWidth(110);
//            columnConstraints.setHgrow(Priority.SOMETIMES);
            columnConstraints.setPercentWidth(5.263);
            headerGridPane.getColumnConstraints().add(columnConstraints);
        }

        headerGridPane.setGridLinesVisible(true);
    }

    private void setupMainGridPane() {
        ObservableList<String> observableList = FXCollections.observableArrayList("Dog", "Cat", "Bird", "Hamster");

        for (int i = 0; i < TOTAL_COLUMNS; i++) {
            for (int j = 0; j < TOTAL_CONTROLS; j++) {
                ComboBox<String> comboBox = new ComboBox<>(observableList);
                comboBox.getSelectionModel().select(0);
                mainGridPane.addRow(i, comboBox);
            }
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setMinWidth(90);
            columnConstraints.setPrefWidth(90);
//            columnConstraints.setHgrow(Priority.SOMETIMES);
            columnConstraints.setPercentWidth(5.263);
            mainGridPane.getColumnConstraints().add(columnConstraints);
        }
        mainGridPane.setVgap(5);
        mainGridPane.setGridLinesVisible(true);
    }
}
