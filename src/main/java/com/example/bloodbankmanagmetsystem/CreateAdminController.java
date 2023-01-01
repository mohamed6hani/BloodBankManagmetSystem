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

public class CreateAdminController implements Initializable {


    @FXML
    private Button adminCreateB;

    @FXML
    private TextField aemailf;
    @FXML
    private TextField aidf;

    @FXML
    private TextField anamef;

    @FXML
    private TextField aphonenumf;
    @FXML
    private Label adminlabel;
    @FXML
    private PasswordField apasswordf;
    public ImageView myProfileA;
    @FXML
    public ChoiceBox<String> genderBox;
    private final String[] Gender = {"Male", "Female"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderBox.getItems().addAll(Gender);
    }
    public void singleFileUploadAdmin() throws FileNotFoundException, NullPointerException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pictures", "*.jpg", "*.jpeg", "*.PNG"));
        File file = fileChooser.showOpenDialog(null);
        InputStream image1 = new FileInputStream(String.valueOf(file));
        Image image = new Image(image1);
        myProfileA.setImage(image);
    }
    public void switchToAdminPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void adminCreate(){
        admin a = new admin();
        if(a.adminCreateAcc(aidf.getText(), anamef.getText(), aemailf.getText(), apasswordf.getText(),  aphonenumf.getText())){
            adminlabel.setText("Admin Successfully Added!");
        }
        else{
            adminlabel.setText("Failed...");
        }
    }
}
