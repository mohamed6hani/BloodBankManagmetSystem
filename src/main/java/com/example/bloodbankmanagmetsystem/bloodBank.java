package com.example.bloodbankmanagmetsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class bloodBank {
    private int bloodAmount;
    private String bloodType;

    public void viewBloodBank(){

        DB db = new DB();
        Connection con = db.getConnection();
        String viewBB = "";

        try {
            Statement stmt = con.createStatement();
            ResultSet queryResult = stmt.executeQuery(viewBB);


            System.out.println("Success");
            con.close();


        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }



    };


    public void upadateAmount(){};

}
