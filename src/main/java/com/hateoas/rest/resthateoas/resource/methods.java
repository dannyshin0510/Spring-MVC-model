package com.hateoas.rest.resthateoas.resource;

import com.hateoas.rest.resthateoas.model.Users;
import org.springframework.hateoas.EntityModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class methods extends Object{
    public static void insertOperation(String name, long revenue){
        try{
            Connection line = DriverManager.getConnection("jdbc:mysql://localhost/products", "user", "pass");
            String queryState = " INSERT into Products (name, revenue" + " values (?, ?)";
            PreparedStatement preparedStatement = line.prepareStatement(queryState);
            preparedStatement.setString (1, name);
            preparedStatement.setLong (2, revenue);
            preparedStatement.execute();
            line.close();
        }catch (Exception e){
            System.out.println ("ERROR: insertion operation failed: " + e.getMessage());
        }
    }
    public static ResultSet returnSearch(String name){
        try{
            Connection line = DriverManager.getConnection("jdbc:mysql://localhost/products", "user", "pass");
            String queryState = " SELECT * FROM Products WHERE name = " + name;
            PreparedStatement preparedStatement = line.prepareStatement(queryState);
            ResultSet results= preparedStatement.executeQuery(queryState);
            line.close();
            return results;
        }catch (Exception e){
            System.out.println ("ERROR: query operation failed: " + e.getMessage());
            return null;
        }
    }
}





