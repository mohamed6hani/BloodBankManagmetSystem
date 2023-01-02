//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.bloodbankmanagmetsystem;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Objects;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class userinfo {
    String blood_group;
    String when;
    String illness;
    @FXML
    private Button return_to_home;
    @FXML
    private AnchorPane donor_info;
    Stage stage;

    public userinfo(String blood_group, String when, String illness) {
        this.illness = illness;
        this.when = when;
        this.blood_group = blood_group;
        ObservableList<donationRequests> requestDonate = UserControllerClass.table_info_app.getSelectionModel().getSelectedItems();

        donationRequests var6;
        for(Iterator var5 = requestDonate.iterator(); var5.hasNext(); var6 = (donationRequests)var5.next()) {
        }

    }

    public String getBloodGroup() {
        return this.blood_group;
    }

    public void setBloodGroup(String blood_group) {
        this.blood_group = blood_group;
    }

    public void switchUserPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = (Parent)FXMLLoader.load((URL)Objects.requireNonNull(this.getClass().getResource("UserPage.fxml")));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
