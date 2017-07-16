package com.food.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

    public  static void  main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "select * from item WHERE name='Apple'";

        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                String calories = resultSet.getString("calories" );
                System.out.println(calories);
                String weight = resultSet.getString("weight" );
                System.out.println(weight);


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
