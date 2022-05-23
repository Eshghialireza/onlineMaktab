package com.onlineMaktab.repository;

import com.onlineMaktab.domain.User;
import com.onlineMaktab.util.DatabaseContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {



        public void insert(DatabaseContext context,Connection connection) throws SQLException {
            context.getMenuTexts().showEnterName();
            String name=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterFamily();
            String family=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterUsername();
            String username=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterPassword();
            String password=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterPhoneNumber();
            String phoneNumber=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterEmail();
            String email=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterProvince();
            String province=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterCity();
            String city=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterStreetName();
            String streetName=context.getStrScanner().nextLine();
            context.getMenuTexts().showEnterPostalCode();
            String postalCode=context.getStrScanner().nextLine();
            User user=new User(name,family,username,password,phoneNumber,email,province,city,streetName,postalCode);
            PreparedStatement preparedStatement=connection.prepareStatement("insert into user (name,family,username,phoneNumber,email,password," +
                    "province,city,streetName,postalCode)" +
                    " values (?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getFamily());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,user.getPhoneNumber());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getPassword());
            preparedStatement.setString(7,user.getProvince());
            preparedStatement.setString(8,user.getCity());
            preparedStatement.setString(9,user.getStreetName());
            preparedStatement.setString(10,user.getPostalCode());
            preparedStatement.executeUpdate();
            context.getMenuTexts().showSuccessfullySignUp();
    }
// we have two types of login and this a simple login
    public void loggin(DatabaseContext context, Connection connection) throws SQLException {
        int count=0;
        context.getMenuTexts().showEnterUsername();
        String username =context.getStrScanner().nextLine();
        context.getMenuTexts().showEnterPassword();
        String password =context.getStrScanner().nextLine();
        String check ="select * from user where username=? and password=?";
        PreparedStatement preparedStatement=connection.prepareStatement(check);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            User user=new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("userName"),
                    resultSet.getString("password"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("email"),
                    resultSet.getString("province"),
                    resultSet.getString("city"),
                    resultSet.getString("streetName"),
                    resultSet.getString("postalCode")
            );
            context.getCurrentUser().setCurrentUser(user);
            count++;
        }
        if(count>0)
            context.getMenuTexts().showSuccessfullySignIn();
        else
            context.getMenuTexts().showWrongPass();
    }
    //this is the login after sign up
    public void loginAfterSignUp(DatabaseContext context, Connection connection,String username,String password) throws SQLException {
        int count=0;
        context.getMenuTexts().showEnterUsername();
        String check ="select * from user where username=? and password=?";
        PreparedStatement preparedStatement=connection.prepareStatement(check);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet= preparedStatement.executeQuery();
        while (resultSet.next()){
            User user=new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("userName"),
                    resultSet.getString("password"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("email"),
                    resultSet.getString("province"),
                    resultSet.getString("city"),
                    resultSet.getString("streetName"),
                    resultSet.getString("postalCode")
            );
            context.getCurrentUser().setCurrentUser(user);
            count++;
        }
        if(count>0)
            context.getMenuTexts().showSuccessfullySignIn();
        else
            context.getMenuTexts().showWrongPass();
    }





    public UserRepository() throws SQLException, ClassNotFoundException {
    }
}
