package com.onlineMaktab.repository;

import com.onlineMaktab.util.DatabaseContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderTableRepository {
    public void showOrderTable(DatabaseContext context,Connection connection) throws SQLException {
        String show="select o.totalPrice from orderTable as o where o.user_id=? ";
        PreparedStatement preparedStatement=connection.prepareStatement(show);
        preparedStatement.setInt(1,context.getCurrentUser().getCurrentUser().getId());
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("total price : "+resultSet.getInt(1));
        }
    }

public void UpdateOrderTable(DatabaseContext context, Connection connection) throws SQLException {
    int price=0;
    int ifNull=0;
    String findPrice="select o.lastPrice from orders as o where o.user_id=?";
    PreparedStatement preparedStatement=connection.prepareStatement(findPrice);
    preparedStatement.setInt(1,context.getCurrentUser().getCurrentUser().getId());
    ResultSet resultSet=preparedStatement.executeQuery();
    while (resultSet.next()){
        price=(price+resultSet.getInt(1));
    }
    //just to find if user has a column or not!--
    String ifNotNull="select * from orderTable as o where o.user_id=?";
    PreparedStatement preparedStatement1=connection.prepareStatement(ifNotNull);
    preparedStatement1.setInt(1,context.getCurrentUser().getCurrentUser().getId());
    ResultSet resultSet1=preparedStatement1.executeQuery();
    while (resultSet1.next()){
        ifNull++;
    }
    if(ifNull==0){
        String insert="insert into orderTable (totalPrice,user_id) values(?,?)";
        PreparedStatement preparedStatement2=connection.prepareStatement(insert);
        preparedStatement2.setInt(1,price);
        preparedStatement2.setInt(2,context.getCurrentUser().getCurrentUser().getId());
        preparedStatement2.executeUpdate();
    }else{
        String update="update orderTable set totalPrice=? where user_id=?";
        PreparedStatement preparedStatement3=connection.prepareStatement(update);
        preparedStatement3.setInt(1,price);
        preparedStatement3.setInt(2,context.getCurrentUser().getCurrentUser().getId());
        preparedStatement3.executeUpdate();
    }
}
}
