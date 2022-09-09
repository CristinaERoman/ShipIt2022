package com.example.bunnygene.utils;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
    public static Connection getConnection() {
        String ip = "10.180.184.27";
        String port = "1433";
        String db = "BunnyGene";
        String username = "sa";
        String password = "Passw0rd";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection con = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String connectURL = "jdbc:jtds:sqlserver://" + ip +":"+port+";"
                    + "databaseName=" + db + ";user=" + username + ";password="
                    + password + ";";
            con = DriverManager.getConnection(connectURL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return con;
    }

    public static String retrieveUserFirstName(Connection con) {
        String firstName = "";

        try {
            String query = "select top 1 * from MyUser";
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                firstName = "First Name: " + res.getString("FirstName");
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return firstName;
    }
}
