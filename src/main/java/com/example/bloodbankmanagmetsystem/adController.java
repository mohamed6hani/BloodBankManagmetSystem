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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class adController implements Initializable {



    @FXML
    private TableColumn<Donors, String> btc;

    @FXML
    private TableColumn<Donors, String> clc;

    @FXML
    private Button denyButton;

    @FXML
    private TableColumn<Donors, String> emailc;

    @FXML
    private TableColumn<Donors, String> ldc;

    @FXML
    private TableColumn<Donors, String> namec;
    ObservableList<Donors> donorData= FXCollections.observableArrayList();
    @FXML
    TableView<Donors> tv;

    @FXML
    Button acceptButton;
    int amountflag =0;

    public void switchToDoctorPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void acceptButtonAction(){

        tv.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            newValue.setStatus("accepted");
            System.out.println("Selected Person: " +  newValue.getStatus());
            //updating value in db
            DB db = new DB();
            Connection conn = db.getConnection();
            String query1 = "SELECT * FROM Donors";
            String email = newValue.getEmail();
            String query2 = "UPDATE Donors SET status = '"+"accepted"+"' WHERE Donors_email = '"+newValue.getEmail()+"'";
            try {
                Statement stmt = conn.createStatement();
                ResultSet queryResult = stmt.executeQuery(query1);

                while (queryResult.next()) {
                    if(queryResult.getString("Donors_email").compareTo(newValue.getEmail())==0){
                        System.out.println("Entered");
                        PreparedStatement pstmt = conn.prepareStatement(query2);
                        pstmt.executeUpdate();
                        System.out.println("Success...");
                        amountflag =1;
                    }

                }
                bloodBank bb = new bloodBank(newValue.getBloodType());
                //bb.updateamount();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void denyButtonAction(){
        tv.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            newValue.setStatus("denied");
            System.out.println("Selected Person: " +  newValue.getStatus());
            //updating value in db
            DB db = new DB();
            Connection conn = db.getConnection();
            String query1 = "SELECT * FROM Donors";
            String email = newValue.getEmail();
            String query2 = "UPDATE Donors SET status = '"+"denied"+"' WHERE Donors_email = '"+newValue.getEmail()+"'";
            try {
                Statement stmt = conn.createStatement();
                ResultSet queryResult = stmt.executeQuery(query1);

                while (queryResult.next()) {
                    if(queryResult.getString("Donors_email").compareTo(newValue.getEmail())==0){
                        System.out.println("Entered");
                        PreparedStatement pstmt = conn.prepareStatement(query2);
                        pstmt.executeUpdate();
                        System.out.println("Success...");
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        namec.setCellValueFactory(new PropertyValueFactory<Donors, String>("Name"));
        ldc.setCellValueFactory(new PropertyValueFactory<Donors, String>("lastDonation"));
        emailc.setCellValueFactory(new PropertyValueFactory<Donors, String>("email"));
        btc.setCellValueFactory(new PropertyValueFactory<Donors, String>("bloodType"));
        clc.setCellValueFactory(new PropertyValueFactory<Donors, String>("chronicIllness"));

        DB db = new DB();
        Connection conn = db.getConnection();
        String query = "SELECT * FROM Donors";
        try {
            Statement stmt = conn.createStatement();
            ResultSet queryResult = stmt.executeQuery(query);
            while (queryResult.next()) {
                Donors d = new Donors(
                        queryResult.getString("Donors_name"),
                        queryResult.getString("Donors_email"),
                        queryResult.getString("blood_type"),
                        queryResult.getString("status"),
                        queryResult.getString("chronicillness"),
                        queryResult.getString("lastDonation")
                );
                donorData.add(d);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tv.setItems(donorData);


    }


}
