package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection con = connect();
                if (con != null) {
                    try {
                        String query = "select * from MyUser";
                        Statement statement = con.createStatement();
                        ResultSet res = statement.executeQuery(query);
                        while (res.next()) {
                            textView.setText("First Name: " + res.getString("FirstName") + "\nLast Name: " + res.getString("LastName") + "\nEmail: " + res.getString("Email") + "\nPassword: " + res.getString("Pass"));
                        }
                        con.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
    }

    protected Connection connect() {
        String ip = "10.180.184.27";
        String port = "1433";
        String db = "MobileApp";
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
}