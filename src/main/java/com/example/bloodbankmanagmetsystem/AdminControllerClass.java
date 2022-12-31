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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import kotlin.jvm.internal.Intrinsics;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminControllerClass implements Initializable {

    @FXML
    private TableView <admin> adminsTable;
    @FXML
    private TableColumn <admin, Integer> adminIDc;
    @FXML
    private TableColumn <admin, String> adminNamec;
    @FXML
    private TableColumn  <admin, String> adminEmailc;
    @FXML
    private TableColumn   <admin, String> adminPhonenumc;

    ObservableList <admin> list = FXCollections.observableArrayList(
     // new admin("Sara Ahmed", 1212, "sara@nu.edu.eg", "121212")
    );
    public void vieww(){



    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminIDc.setCellValueFactory(new PropertyValueFactory<admin, Integer>("adminID"));
        adminNamec.setCellValueFactory(new PropertyValueFactory<admin, String>("Name"));
        adminEmailc.setCellValueFactory(new PropertyValueFactory<admin, String>("email"));
        adminPhonenumc.setCellValueFactory(new PropertyValueFactory<admin, String>("phonenum"));

        adminsTable.setItems(list);


    }


    public void switchToDoctorCreateAccount(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPageCreateAccount.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToAdminLogin(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("Admin Login Page.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToAdminCreateAccount(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminPageCreateAccount.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToAdminPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    //---------view admins-------------
    public void switchToAdminViewAccountPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminViewAccount.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //------view doctors
    public void switchToAdminDoctorViewAccountPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AdminDoctorViewAccount.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
