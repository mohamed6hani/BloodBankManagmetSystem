package com.example.bloodbankmanagmetsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class secondController implements Initializable {

    public ImageView myProfileU;
    @FXML
    private ChoiceBox<String> bloodTypeBox;
    @FXML
    public ChoiceBox<String> genderBox;
    @FXML
    private Button login1;
    @FXML
    private Label invalidLabel;
    @FXML
    private TextField login_email;
    @FXML
    private PasswordField login_password;
    private Stage stage;
    private Scene scene;
    private final String[] BloodType = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    private final String[] Gender = {"Male", "Female"};
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) throws NullPointerException {
//            genderBox.getItems().addAll(Gender);

//            bloodTypeBox.getItems().addAll(BloodType);
    }
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
    public void switchToDoctorLoginPage1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Doctor Login Page1.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void singleFileUploadUser() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pictures", "*.jpg", "*.jpeg", "*.PNG"));
        File file = fileChooser.showOpenDialog(null);
        InputStream image1 = new FileInputStream(String.valueOf(file));
        Image image = new Image(image1);
        myProfileU.setImage(image);
    }

    public void switchToDoctorPage(ActionEvent event) throws IOException {
//        if(!login_email.getText().isBlank() && !login_password.getText().isBlank()){
//            if(validateLogin()){
                Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPage.fxml"))));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
//            }
//        }
//        else{
//            invalidLabel.setText("Please enter email and password");
//        }

    }
    public void switchToDVBB(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorViewBloodBank.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToIdentify(ActionEvent event) throws IOException {
        Parent fxmlLoader = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("IdentifyPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public boolean validateLogin (){


        String verifyLogin = "SELECT count(1) FROM Doctor WHERE Doctor_email = '" + login_email.getText() +  "' AND Doctor_password = '" + login_password.getText() + "'";
        DB db = new DB();
        Connection con = db.getConnection();


        try {
            Statement stmt = con.createStatement();
            ResultSet queryResult = stmt.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt( 1) == 1){
                    invalidLabel.setText("Successful Login!");
                    return true;
                }
                else {
                    invalidLabel.setText("Invalid Email or Password, Please try again.");
                    return false;
                }
            }


        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }
}