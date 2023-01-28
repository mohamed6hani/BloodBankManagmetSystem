package com.example.bloodbankmanagmetsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Person {
    Person( String email, String password){
        this.email = email;
        this.password = password;

    }
    Person(String email){
        this.email = email;

    }
//    Person( String Name, String email, String password, String phonenum){
//        this.email = email;
//        this.password = password;
//        this.Name = Name;
//        this.phonenum = phonenum;
//
//    }
    Person(){}

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
            throw new RuntimeException("unhandled", e);
        }

        return false;
    };

}
