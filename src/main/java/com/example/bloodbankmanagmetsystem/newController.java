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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;


public class newController implements Initializable {



    @FXML
    private Label aposl;
    @FXML
    private Label bposl;
    @FXML
    private Label abposl;
    @FXML
    private Label oposl;
    @FXML
    private Label anegl;
    @FXML
    private Label abnegl;
    @FXML
    private Label bnegl;
    @FXML
    private Label onegl;



//    @FXML
//    private TableView<admin> adminsTable;
//    @FXML
//    private TableColumn<admin, Integer> adminIDc;
//    @FXML
//    private TableColumn <admin, String> adminNamec;
//    @FXML
//    private TableColumn  <admin, String> adminEmailc;
//    @FXML
//    private TableColumn<admin, String> adminPhonenumc;

    public void switchToDoctorPage(ActionEvent event) throws IOException, NullPointerException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("DoctorPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        bloodBank bbapos = new bloodBank("A+");
        bbapos.viewBloodBank(aposl);

        bloodBank bbaneg = new bloodBank("A-");
        bbaneg.viewBloodBank(anegl);

        bloodBank bbbpos = new bloodBank("B+");
        bbbpos.viewBloodBank(bposl);

        bloodBank bbbneg = new bloodBank("B-");
        bbbneg.viewBloodBank(bnegl);

        bloodBank bbabpos = new bloodBank("AB+");
        bbabpos.viewBloodBank(abposl);

        bloodBank bbabneg = new bloodBank("AB-");
        bbabneg.viewBloodBank(abnegl);

        bloodBank bbopos = new bloodBank("O+");
        bbopos.viewBloodBank(oposl);

        bloodBank bboneg = new bloodBank("O-");
        bboneg.viewBloodBank(onegl);



//        ObservableList<admin> admindata= FXCollections.observableArrayList();
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
//
//
 }
}
