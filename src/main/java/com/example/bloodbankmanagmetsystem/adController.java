package com.example.bloodbankmanagmetsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class adController implements Initializable {
    @FXML
    ListView<String > reqlistview;
    ObservableList<Donors> donorData= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DB db= new DB();
        Connection conn= db.getConnection();
        String query = "SELECT * FROM Donors";
        try{
            Statement stmt = conn.createStatement();
            ResultSet queryResult = stmt.executeQuery(query);
            while(queryResult.next()){
                Donors d = new Donors(
                        queryResult.getString("Donors_name"),
                        queryResult.getString("Donors_email"),
                        queryResult.getString("blood_type"),
                        queryResult.getString("status"),
                        queryResult.getString("chronicillness"),
                        queryResult.getString("lastDonation")
                );
                donorData.add(d);
                reqlistview.getItems().add(donorData.get(0).toString());

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
