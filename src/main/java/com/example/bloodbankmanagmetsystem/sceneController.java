package com.example.bloodbankmanagmetsystem;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class sceneController  implements Initializable {
    @FXML
    Label invalidLabel2;

    @FXML
    TextField user_email;
    @FXML
    TextField user_password;

    @FXML
    Button user_loginb;

    @FXML
    TextField admin_email;
    @FXML
    TextField admin_password;

    @FXML
    Button admin_loginb;

    private Stage stage;
    private Scene scene;

    public void switchToIdentify(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("IdentifyPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
}
    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("HomePage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchUserLogin(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("User Login Page.fxml"))));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToDoctorLoginPage1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Doctor Login Page1.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToUserCreateAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserCreateAccountPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //-----user verify login-----
    public void switchUserPage(ActionEvent event) throws IOException, NullPointerException{
        if(!user_email.getText().isBlank() && !user_password.getText().isBlank()){
            user User = new user(user_email.getText(),user_password.getText() );
            if(User.verifyLogin(User.getuserlogin())){
                Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserPage.fxml"))));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            }
            else{
                invalidLabel2.setText("Invalid  Email or Password, Please Try Again");
            }
        }
        else{
            invalidLabel2.setText("Please enter email and password");
        }

    }
    public void switchToAdminLogin(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Admin Login Page.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    //---------admin login--------
    public void switchToAdminPage(ActionEvent event) throws IOException, NullPointerException {
        if(!admin_email.getText().isBlank() && !admin_password.getText().isBlank()){
            admin Admin = new admin(admin_email.getText(),admin_password.getText() );
            if(Admin.verifyLogin(Admin.getadminlogin())){
                Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminPage.fxml"))));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            }
            else{
                invalidLabel2.setText("Invalid  Email or Password, Please Try Again");
            }
        }
        else{
            invalidLabel2.setText("Please enter email and password");
        }

    }
    public void Quit() {
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}