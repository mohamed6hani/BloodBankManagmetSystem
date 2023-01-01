package com.example.bloodbankmanagmetsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class CreateUserAccount implements Initializable {
    public ImageView myProfileU;
    @FXML
    public ChoiceBox<String> genderBox;
    @FXML
    private PasswordField pass;
    @FXML
    private Button creataccB;


    @FXML
    private TextField ph;
    @FXML
    private Label userlabel;

    @FXML
    private TextField username;

    @FXML
    private TextField email;
    private final String[] Gender = {"M", "F"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderBox.getItems().addAll(Gender);
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
    public void switchUserLogin(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("User Login Page.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void UserCreateAcc(){
        user k = new user();
        if(k.UserCreateAcc(username.getText(),  email.getText() , pass.getText(), ph.getText(), genderBox.getValue())){
            userlabel.setText("Account Successfully Created!");
        }
        else{
            userlabel.setText("Failed...");
        }

    }

    }
