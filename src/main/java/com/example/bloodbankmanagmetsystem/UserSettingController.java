package com.example.bloodbankmanagmetsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserSettingController implements Initializable {
    @FXML
    public Label name;
    @FXML
    public Label Pass;
    @FXML
    public Button save;
    @FXML
    public Label bloodTypeUser;
    @FXML
    public ImageView myProfileU;
    @FXML
    private TextField changeName;
    @FXML
    private TextField changePassword;
    @FXML
    private ChoiceBox<String> bloodTypeBox;
    @FXML
    private final String[] BloodType = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bloodTypeBox.getItems().addAll(BloodType);
    }

    public void ChangeNameButton() throws NullPointerException{
        changeName.setOpacity(100);
    }
    public void ChangeName() throws NullPointerException{
        String Name = changeName.getText();
        name.setText(Name);
    }
    public void ChangePasswordButton() throws NullPointerException{
        changePassword.setOpacity(100);
    }
    public void ChangePassword() throws NullPointerException{
        String pass = changePassword.getText();
        Pass.setText(pass);
    }
    public void ChangeBloodTypeButton() throws NullPointerException{
        bloodTypeBox.setOpacity(100);
        save.setOpacity(100);
    }
    public void ChangeBlood() throws NullPointerException{
        String bloodType = bloodTypeBox.getValue();
        bloodTypeUser.setText(bloodType);
    }

    public void switchUserPage(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
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

}
