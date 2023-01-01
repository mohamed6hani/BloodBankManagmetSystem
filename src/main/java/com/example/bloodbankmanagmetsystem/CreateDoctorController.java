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
import java.util.Objects;
import java.util.ResourceBundle;

public class CreateDoctorController implements Initializable {
    @FXML
    private Button createaccB;

    @FXML
    private TextField emailf;

    @FXML
    private ChoiceBox<String> genderBox;

    @FXML
    private TextField hospitalf;

    @FXML
    private TextField idf;

    @FXML
    public ImageView myProfile;

    @FXML
    private TextField namef;

    @FXML
    private TextField phonenumf;
    @FXML
    private Label doclabel;


    @FXML
    private PasswordField passwordf;

    @FXML
    private final String[] Gender = {"Male", "Female"};
    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) throws NullPointerException {
        genderBox.getItems().addAll(Gender);
    }
    public void switchToAdminPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
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

    public void docCreate(){
        doctor d = new doctor();
        if(d.DocCreateAcc(idf.getText(), namef.getText(), emailf.getText(), passwordf.getText(), hospitalf.getText(), phonenumf.getText())){
            doclabel.setText("Doctor Successfully Added!");
        }
       else{
            doclabel.setText("Failed...");
        }
    }
}
