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

public class sceneController  implements Initializable {
    public ImageView myProfile;
    public TextArea tracePdf;
    public ImageView myProfileA;
    public TextArea tracePdfA;
    public Button Login;
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
    public void switchDoctorLogin0(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorLogin0.fxml"))));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchAdminLogin0(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminLogin0.fxml"))));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchUserLogin0(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserLogin0.fxml"))));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
    public void switchToDoctorPage(ActionEvent event) throws IOException {
        if(login_email.getText().isBlank() ==false && login_password.getText().isBlank() ==false ){
            if(validateLogin()){
                Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPage.fxml"))));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        else{
            invalidLabel.setText("Please enter email and password");
        }

    }

    public void switchToDoctorLoginPage1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Doctor Login Page1.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToDoctorCreateAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPageCreateAccount.fxml"))));
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
    public void switchToAdminCreateAccount(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminPageCreateAccount.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToAdminLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Admin Login Page.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void Quit() {
        System.exit(0);
    }
    @FXML
    public void multiFileUploadDoctor(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
        File file = fileChooser.showOpenDialog(null);

        String fileNames = file.getName();
        tracePdf.setText(fileNames);
    }
    public void multiFileUploadAdmin(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files","*.pdf"));
        File file = fileChooser.showOpenDialog(null);

        String fileNames = file.getName();
        tracePdfA.setText(fileNames);
    }
    @FXML

    public void singleFileUploadDoctor() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pictures", "*.jpg", "*.jpeg", "*.PNG"));
        File file = fileChooser.showOpenDialog(null);
        InputStream image1 = new FileInputStream(String.valueOf(file));
        Image image = new Image(image1);
        myProfile.setImage(image);
    }
    public void singleFileUploadAdmin() throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pictures", "*.jpg", "*.jpeg", "*.PNG"));
        File file = fileChooser.showOpenDialog(null);
        InputStream image1 = new FileInputStream(String.valueOf(file));
        Image image = new Image(image1);
        myProfileA.setImage(image);
    }




    @FXML
    private Button login;

    @FXML
    private Label invalidLabel;
    @FXML
    private TextField login_email;
    @FXML
    private PasswordField login_password;
//    public void login_setOnAction(ActionEvent event) {
//        if(login_email.getText().isBlank() ==false && login_password.getText().isBlank() ==false ){
//            validateLogin();
//        }
//        else{
//            invalidLabel.setText("Please enter email and password");
//        }
//    }

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}