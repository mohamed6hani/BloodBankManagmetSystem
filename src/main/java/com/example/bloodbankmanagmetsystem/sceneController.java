package com.example.bloodbankmanagmetsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class sceneController {
    private Stage stage;
    private Scene scene;


    public void switchToIdentify(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("IdentifyPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("homePage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchLoginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("loginPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDoctorPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDoctorLoginPage1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Doctor Login Page1.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDoctorCreateAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPageCreateAccount.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Quit() {
        System.exit(0);
    }
}