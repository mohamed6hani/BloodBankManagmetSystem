package com.example.bloodbankmanagmetsystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class DonorInfoController implements Initializable {

    @FXML
     Label bloodID,QID;
    @FXML
    TextField blood_group_text;
    @FXML
    TextField illness_text;

    @FXML
    Button ok;

    @FXML
    TextField when_text;


    @FXML
    Button back;

    @FXML
    MenuItem menu1,menu2,menu3,menu4,menu5,menu6,menu7,q1,q2,q3;


    private Stage stage;
    private Scene scene;


    public void switchToUserPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToHomePage(ActionEvent event) throws IOException, SQLException {
        if (QID.getText().isBlank() || bloodID.getText().isBlank() || illness_text.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("You Should enter data first!");
            alert.showAndWait();
        }else{
            String cill = illness_text.getText();
            //String bgroup
            //Add Donor to DB
            DB db = new DB();
            Connection conn = db.getConnection();
            String Query = "INSERT INTO Donors (Donors_name, Donors_email, blood_type, chronicillness, lastDonation) VALUES ( '"+"Salma Ahmed"+"' , '"+"sa.a@nu.edu.eg"+"', '"+bloodID.getText()+"', '"+illness_text.getText()+"', '"+QID.getText()+"' )";
            Statement stmt =conn.createStatement();
            stmt.executeUpdate(Query);
            System.out.println("Success");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Request has been sent Successfully");
            alert.showAndWait();


        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserPage.fxml"))));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MenuItem menues[] = {menu1,menu2,menu3,menu4,menu5,menu6,menu7};
        MenuItem Q[] = {q1,q2,q3};
        for (int i=0;i<menues.length;i++){
            int finalI = i;
            menues[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    bloodID.setText(menues[finalI].getText());
                }
            });
        }
        for (int i=0;i<Q.length;i++){
            int finalI = i;
            Q[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    QID.setText(Q[finalI].getText());
                }
            });
        }
    }
}
