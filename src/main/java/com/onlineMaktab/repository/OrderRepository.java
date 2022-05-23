package com.onlineMaktab.repository;

import com.onlineMaktab.util.DatabaseContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository {
    public int findOrderCount(Connection connection,DatabaseContext context) throws SQLException {
        int count=0;
        String findCount="select count(*) from orders as o where o.user_id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(findCount);
        preparedStatement.setInt(1,context.getCurrentUser().getCurrentUser().getId());
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }
    public void insert(int productId,DatabaseContext context,Connection connection,int quantity) throws SQLException {
        int price=context.getProductRepository().findPrice(connection,productId);
        int totalPrice=(price*quantity);
        String insert="insert into orders (user_id,product_id,quantity,lastPrice) " +
                "values (?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(insert);
        preparedStatement.setInt(1,context.getCurrentUser().getCurrentUser().getId());
        preparedStatement.setInt(2,productId);
        preparedStatement.setInt(3,quantity);
        preparedStatement.setInt(4,totalPrice);
        preparedStatement.executeUpdate();
        context.getMenuTexts().showOrderAdded();
    }

    public void showOrders(Connection connection, DatabaseContext context) throws SQLException {
        String showOrders="select p.id,p.name,p.price,o.quantity,o.lastprice " +
                "from product as p inner join orders as o " +
                "on p.id=o.product_id where o.user_id=? order by p.name";
        PreparedStatement preparedStatement=connection.prepareStatement(showOrders);
        preparedStatement.setInt(1,context.getCurrentUser().getCurrentUser().getId());
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.print("product id : "+resultSet.getInt(1)+"\t");
            System.out.print("product name : "+resultSet.getString(2)+"\t");
            System.out.print("price : "+resultSet.getInt(3)+"\t");
            System.out.print("quantity : "+resultSet.getInt(4)+"\t");
            System.out.println("total price : "+resultSet.getInt(5)+"\t");
        }

    }


    public void updateQuantityAndPrice(DatabaseContext context,Connection connection) throws SQLException {
        context.getOrderRepository().showOrders(connection, context);
        context.getMenuTexts().showSelectId();
        int userInput=context.getIntScanner().nextInt();
        context.getMenuTexts().showEnterQuantity();
        int newQuantity=context.getIntScanner().nextInt();
        if(newQuantity<=context.getProductRepository().findQuantity(connection,userInput)){
        int price=context.getProductRepository().findPrice(connection,userInput);
            System.out.println(price);
        int newPrice=(newQuantity*price);
        String update="update orders as o set o.quantity=? , o.lastPrice=? where o.user_id=? and o.product_id=? ";
        PreparedStatement preparedStatement=connection.prepareStatement(update);
        preparedStatement.setInt(1,newQuantity);
        preparedStatement.setInt(2,newPrice);
        preparedStatement.setInt(3,context.getCurrentUser().getCurrentUser().getId());
            preparedStatement.setInt(4,userInput);


            preparedStatement.executeUpdate();
        context.getMenuTexts().showOrderUpdated();
        }else{
            context.getMenuTexts().showLowQuantity();
            updateQuantityAndPrice(context,connection);
        }

    }
}
