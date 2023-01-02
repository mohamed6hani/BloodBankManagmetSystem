package com.example.bloodbankmanagmetsystem;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;


public class newController implements Initializable {
    @FXML
    private Label aposl;
    @FXML
    private Label bposl;
    @FXML
    private Label abposl;
    @FXML
    private Label oposl;
    @FXML
    private Label anegl;
    @FXML
    private Label abnegl;
    @FXML
    private Label bnegl;
    @FXML
    private Label onegl;



    public void switchToDoctorPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bloodBank bbapos = new bloodBank("A+");
        bbapos.viewBloodBank(aposl);

        bloodBank bbaneg = new bloodBank("A-");
        bbaneg.viewBloodBank(anegl);

        bloodBank bbbpos = new bloodBank("B+");
        bbbpos.viewBloodBank(bposl);

        bloodBank bbbneg = new bloodBank("B-");
        bbbneg.viewBloodBank(bnegl);

        bloodBank bbabpos = new bloodBank("AB+");
        bbabpos.viewBloodBank(abposl);

        bloodBank bbabneg = new bloodBank("AB-");
        bbabneg.viewBloodBank(abnegl);

        bloodBank bbopos = new bloodBank("O+");
        bbopos.viewBloodBank(oposl);

        bloodBank bboneg = new bloodBank("O-");
        bboneg.viewBloodBank(onegl);



    }
}
