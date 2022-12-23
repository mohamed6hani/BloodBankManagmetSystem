package com.example.bloodbankmanagmetsystem;
import java.sql.*;



public class DB {
    public Connection conlink;
    public Connection getConnection() {


        String host = "jdbc:mysql://localhost:3306/bloodpointdb";
        String username = "root";
        String pass = "SalP@ss757757";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conlink = (Connection) DriverManager.getConnection(host, username, pass);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }


        return conlink;
    }


}
