package com.onlineMaktab.repository;

import com.onlineMaktab.util.DatabaseContext;

import java.sql.*;

public class ProductRepository {


    public void showDetails(DatabaseContext context, Connection connection) throws SQLException {
        String showProduct = "select p.id,p.price,p.quantity,p.name from product as p " +
                "inner join productType as pt on pt.id=p.typeid ";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(showProduct);
        String showDetails = "select s.specName,s.specValue from product as p "+
        "inner join specification as s on p.id=s.product_id "+
        "where s.product_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(showDetails);

        while (resultSet.next()) {
            int productId = resultSet.getInt("p.id");
            preparedStatement.setInt(1,productId);
            ResultSet resultSet1=preparedStatement.executeQuery();
            System.out.print(resultSet.getInt(1) + "\t");
            System.out.print(resultSet.getString(4)+"\t");
            System.out.print(resultSet.getInt(2) + "\t");
            System.out.print(resultSet.getInt(3) + "\t");
            while (resultSet1.next()) {
                System.out.print(resultSet1.getString("s.specName")+"\t");
                System.out.print(resultSet1.getString("s.specValue")+"\t");
            }
            System.out.println();
        }


    }


    public void showProductsNoDetails(Connection connection) throws SQLException {
        String show = "select * from productType";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(show);
        while (resultSet.next()) {
            System.out.print(resultSet.getInt(1) + "\t");
            System.out.println(resultSet.getString(2));
        }
    }
}