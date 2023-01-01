package com.example.bloodbankmanagmetsystem;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
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
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminControllerClass implements Initializable {
//    @FXML
//    private TableView<admin> adminsTable;
//    @FXML
//    private TableColumn<admin, Integer> adminIDc;
//    @FXML
//    private TableColumn <admin, String> adminNamec;
//    @FXML
//    private TableColumn  <admin, String> adminEmailc;
//    @FXML
//    private TableColumn <admin, String>  adminPhonenumc;



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
    public void loadDB(){
        ObservableList<admin> admindata= FXCollections.observableArrayList();
        String viewAdmins = "SELECT * FROM admin";
        try {
            DB db = new DB();
            PreparedStatement pstmt = db.getConnection().prepareStatement(viewAdmins);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                admindata.add(new admin (
                        rs.getString("admin_name"),
                        rs.getInt("admin_id"),
                        rs.getString("admin_email"),
                        rs.getString("admin_phonenum")));

            }
   //         adminsTable.setItems(admindata);
//          adminNamec.setText(new PropertyValueFactory<admin, String>("Name"));
//          adminIDc.setCellValueFactory(new PropertyValueFactory ("adminID"));
//         adminEmailc.setCellValueFactory(new PropertyValueFactory("email"));
//         adminPhonenumc.setCellValueFactory(new PropertyValueFactory ("phonenum"));


        }


        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
   //ObservableList<admin> admindata= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        adminNamec.setCellValueFactory(new PropertyValueFactory<admin, String>("Name"));
//        adminIDc.setCellValueFactory(new PropertyValueFactory ("adminID"));
//        adminEmailc.setCellValueFactory(new PropertyValueFactory("email"));
//        adminPhonenumc.setCellValueFactory(new PropertyValueFactory ("phonenum"));
//        String viewAdmins = "SELECT * FROM admin";
//        try{
//            DB db = new DB();
//            Connection cn = db.getConnection();
//
//            Statement stmt = cn.createStatement();
//            ResultSet rs = stmt.executeQuery(viewAdmins);
//            while (rs.next())
//            {
//                admindata.add(new admin (
//                        rs.getString("admin_name"),
//                        rs.getInt("admin_id"),
//                        rs.getString("admin_email"),
//                        rs.getString("admin_phonenum")));
//
//            }
//        }
//        catch (Exception e){
//            System.out.println(e);
//        }
//        adminsTable.setItems(admindata);

  }
}
