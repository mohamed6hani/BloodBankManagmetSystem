package com.example.bloodbankmanagmetsystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;

public class bloodBank implements Initializable {
    bloodBank(String bloodType){
        this.bloodType = bloodType;
    }
    private String bloodAmount;
    private final String bloodType;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setBloodAmount(String bloodAmount){
        this.bloodAmount = bloodAmount;
    }

    public String getBloodAmount(){
        return bloodAmount;
    }
    public void viewBloodBank(Label bamount) throws NullPointerException{

        DB db = new DB();
        Connection con;
        con = db.getConnection();
        String bb = "SELECT blood_amount FROM blood_bank WHERE blood_type = '"+bloodType+"'";

        try {
            Statement stmt;
            stmt = con.createStatement();
            ResultSet queryResult = stmt.executeQuery(bb);
            while (queryResult.next()) {
                setBloodAmount(queryResult.getString(1));
            }
            bamount.setText(getBloodAmount());
            con.close();



        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }



    };


    public String upadateAmount(String addedAmount){
        int newBloodAmount = Integer.valueOf(getBloodAmount()) + Integer.valueOf(addedAmount) ;
        String newBA = String.valueOf(newBloodAmount);
        return newBA;

    };




}
