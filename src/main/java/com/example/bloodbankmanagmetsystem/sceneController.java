package com.example.bloodbankmanagmetsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class sceneController implements Initializable {
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



    //salma

    @FXML
    private Button login;

    @FXML
    private Label invalidLabel;
    @FXML
    private TextField login_email;
    @FXML
    private PasswordField login_password;
    public void login_setOnAction(ActionEvent event) {
        if(login_email.getText().isBlank() ==false && login_password.getText().isBlank() ==false ){
            validateLogin();
        }
        else{
            invalidLabel.setText("Please enter email and password");
        }
    }

    public void validateLogin (){
        

        String verifyLogin = "SELECT count(1) FROM Doctor WHERE Doctor_email = '" + login_email.getText() +  "' AND Doctor_password = '" + login_password.getText() + "'";
        DB db = new DB();
        Connection con = db.getConnection();


        try {
                Statement stmt = con.createStatement();
                ResultSet queryResult = stmt.executeQuery(verifyLogin);

                while(queryResult.next()){
                    if(queryResult.getInt( 1) == 1){
                        invalidLabel.setText("Successful Login!");
                    }
                    else {
                        invalidLabel.setText("Invalid Email or Password, Please try again.");
                    }
                }


        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
       }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}