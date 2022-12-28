package com.example.bloodbankmanagmetsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Person {
    Person(String email, String password){
        this.email = email;
        this.password = password;
    }
    protected String Name;
    protected String email;
    protected String password;
    protected String phonenum;

    public boolean verifyLogin(String login){
        DB db = new DB();
        Connection con = db.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet queryResult = stmt.executeQuery(login);

            while(queryResult.next()){
                if(queryResult.getInt( 1) == 1){
                    System.out.println("success");
                    return true;
                }
                else {
                    System.out.println("failure");
                    return false;
                }
            }


        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return false;
    };

}
