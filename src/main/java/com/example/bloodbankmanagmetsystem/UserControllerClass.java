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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class UserControllerClass implements Initializable {


    public static TableView<donationRequests> table_info_app;
    public static ObservableList<donationRequests> data_table;
    @FXML
    private TableView<donationRequests> table_info;
    @FXML
    private TableColumn<donationRequests, String> col_id, col_name, col_age, col_bloodGroup, col_unit, col_hospitalName, col_gender, col_date;
    @FXML
    private TableColumn<donationRequests, Button> col_approve;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table_info_app = table_info;
// this you should hash and get data from DB
        initializeCols();
/////////////////////////////////////////
        loadData();
    }

    private void initializeCols() {

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_bloodGroup.setCellValueFactory(new PropertyValueFactory<>("bloodGroup"));
        col_unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        col_hospitalName.setCellValueFactory(new PropertyValueFactory<>("hospitalName"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        //col_approve.setCellValueFactory(new PropertyValueFactory<>("Donate"));
        editableCols();
    }

    private void editableCols() {
        col_id.setCellFactory(TextFieldTableCell.forTableColumn());
        col_id.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setId(e.getNewValue()));

        col_name.setCellFactory(TextFieldTableCell.forTableColumn());
        col_name.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setName(e.getNewValue()));

        col_age.setCellFactory(TextFieldTableCell.forTableColumn());
        col_age.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setAge(e.getNewValue()));

        col_bloodGroup.setCellFactory(TextFieldTableCell.forTableColumn());
        col_bloodGroup.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setBloodGroup(e.getNewValue()));




        table_info.setEditable(false);



    }
    private void addButtonToTable() {
        TableColumn<donationRequests, Void> colBtn = new TableColumn("Action");

        Callback<TableColumn<donationRequests, Void>, TableCell<donationRequests, Void>> cellFactory = new Callback<TableColumn<donationRequests, Void>, TableCell<donationRequests, Void>>() {
            @Override
            public TableCell<donationRequests, Void> call(final TableColumn<donationRequests, Void> param) {
                final TableCell<donationRequests, Void> cell = new TableCell<donationRequests, Void>() {

                    private final Button btn = new Button("Donate");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            donationRequests data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                            try {
                                Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("userInfo.fxml"))));
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.setResizable(false);
                                stage.show();

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        table_info.getColumns().add(colBtn);

    }

    private void ActionButton(ActionEvent event) {
        System.out.println("test");
    }
    private void loadData() {
        data_table = FXCollections.observableArrayList();
        //DB trail
        try {
            DB db = new DB();
            Connection con = db.getConnection();
            Statement stmt = con.createStatement();
            ResultSet query = stmt.executeQuery("SELECT * FROM BloodRequests ");
            int i = 0;
            while (query.next()) {
                data_table.add(new donationRequests(String.valueOf(i), query.getString("patient_name"),query.getString("patient_age") , query.getString("BloodType"), query.getString("amount_in_units"), query.getString("location"), query.getString("patient_gender"), query.getString("date"), new Button()));
                i += 1;
            }
        }
        catch (SQLException e){
            System.out.println(e.getCause());
        }



        // change here with DB table size instead of 12 below
      //  for (int x = 1; x < 12; x++) {
         //   data_table.add(new donationRequests(String.valueOf(x), "Yasmin " , "age" , "bloodGroup " , "unit " , "hospitalName " , "gender " , "date ",new Button()));
        //}

        table_info.setItems(data_table);
        addButtonToTable();

    }


        public void switchToUserSetting(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserSetting.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToUserDH(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserDonationHistory.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchToUserDonation(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserDonatePage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchUserLogin(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("User Login Page.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void switchUserPage(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchDonorInfo(ActionEvent event) throws IOException, NullPointerException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("UserPage.fxml"))));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
