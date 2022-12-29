package com.example.bloodbankmanagmetsystem;

import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class bloodBank {
    bloodBank(String bloodType){
        this.bloodType = bloodType;
    }
    private String bloodAmount;
    private String bloodType;

    public String getBloodAmount(){
       return bloodAmount;
    }

    public void setBloodAmount(String bloodAmount){
       this.bloodAmount = bloodAmount;
    }
    public void viewBloodBank(Label bamount){

        DB db = new DB();
        Connection con = db.getConnection();
        String bb = "SELECT blood_amount FROM blood_bank WHERE blood_type = '"+getBloodAmount()+"'";

        try {
            Statement stmt = con.createStatement();
            ResultSet queryResult = stmt.executeQuery(bb);
            setBloodAmount(queryResult.getString(1));
            bamount.setText(getBloodAmount());
            con.close();



        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }



    };


    public void upadateAmount(){};


}
