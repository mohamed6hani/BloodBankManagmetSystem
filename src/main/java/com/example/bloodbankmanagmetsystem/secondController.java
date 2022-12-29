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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;

public class secondController  implements Initializable {
    @FXML
    private Button login1;
    @FXML
    private Label invalidLabel;
    @FXML
    private TextField login_email;
    @FXML
    private PasswordField login_password;


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




    private Stage stage;
    private Scene scene;




    public void switchDoctorAD(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("RequestsADPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchDoctorRequest(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Requests.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToDoctorLoginPage1(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Doctor Login Page1.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    //------doctor login--------
    public void switchToDoctorPage(ActionEvent event) throws IOException, NullPointerException {
//        if(!login_email.getText().isBlank() && !login_password.getText().isBlank()){
//            doctor doc = new doctor(login_email.getText(),login_password.getText() );
//            if(doc.verifyLogin(doc.getdoctorlogin())){
                Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPage.fxml"))));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

//            }
//            else{
//                invalidLabel.setText("Invalid  Email or Password, Please Try Again");
//            }
//        }
//        else{
//            invalidLabel.setText("Please enter email and password");
//        }

    }


    //View Blood Bank
    public void switchToDVBB(ActionEvent event) throws IOException, NullPointerException {
        Parent fxmlLoader = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorViewBloodBank.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }
    public void switchToIdentify(ActionEvent event) throws IOException, NullPointerException {
        Parent fxmlLoader = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("IdentifyPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.setResizable(false);
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