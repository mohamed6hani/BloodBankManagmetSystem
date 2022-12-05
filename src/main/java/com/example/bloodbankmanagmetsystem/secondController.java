package com.example.bloodbankmanagmetsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class secondController implements Initializable {
    @FXML
    private ChoiceBox<String> bloodTypeBox;
    @FXML
    public ChoiceBox<String> genderBox;

    private final String[] BloodType = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    private final String[] Gender = {"Male", "Female"};
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) throws NullPointerException {
//        Platform.runLater(() -> {
            genderBox.getItems().addAll(Gender);
            bloodTypeBox.getItems().addAll(BloodType);
//        });
    }
    public void switchUserLogin0(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserLogin0.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
