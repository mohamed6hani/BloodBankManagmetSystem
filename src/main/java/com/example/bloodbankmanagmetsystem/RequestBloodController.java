package com.example.bloodbankmanagmetsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class RequestBloodController implements Initializable {
    @FXML
    private ChoiceBox<String> bloodTypeBox;
    @FXML
    public ChoiceBox<String> genderBox;
    @FXML
    private final String[] BloodType = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    @FXML
    private final String[] Gender = {"M", "F"};


    @FXML
    TextField location;
    @FXML
    DatePicker date;
    @FXML
    TextField amount;
    @FXML
    TextField patient_name;
    @FXML
    TextField age;
    @FXML
    Button send;
    @FXML
    Label requestlabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws NullPointerException {
        genderBox.getItems().addAll(Gender);
        bloodTypeBox.getItems().addAll(BloodType);

    }

    public void switchToDoctorPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //-----------ADD REQUEST---------
    public void addRequest() {
        bloodRequest br = new bloodRequest();
        // if(!bloodTypeBox.getValue().isBlank() && !patient_name.getText().isBlank() && !location.getText().isBlank() && !age.getText().isBlank() && !genderBox.getValue().isBlank() && !amount.getText().isBlank()){
        br.addRequest(date.getValue(), bloodTypeBox.getValue(), location.getText(), patient_name.getText(), age.getText(), genderBox.getValue(), 5);
        requestlabel.setText("Request Successfully Added!");
        //}
        //else{
        //  requestlabel.setText("Please Fill Empty Fields");
        //}

    }

    public void switchToDVBB2(ActionEvent event) throws IOException, NullPointerException {
        Parent fxmlLoader = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorViewBloodBank.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}