package com.biruzka.educationbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Biruzka on 15.10.2015.
 */
public class Main {

    private static Connection conn;

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost/education";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","lucky759");
        try {
            conn = DriverManager.getConnection(url, props);

            String queryPut = "INSERT INTO students (sername,sex,living_place) VALUES " +
                    "('Khabibullin','m','Agidel')";
            conn.prepareStatement(queryPut).executeUpdate();

            String queryGet = "SELECT * FROM students";

            ResultSet res = conn.prepareStatement(queryGet).executeQuery();

            while (res.next()) {
                System.out.println(res.getString("sername"));
                System.out.println(res.getString("id"));
            }
//            String queryDelete = "DELETE FROM students WHERE id=";
//
//            for (int i = 3; i<=8;i++) {
//                String num = "'" + i + "'";
//                System.out.println(queryDelete+num);
//                conn.prepareStatement(queryDelete+num).executeUpdate();
//            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
