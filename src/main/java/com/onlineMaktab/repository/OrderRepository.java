package com.onlineMaktab.repository;

import com.onlineMaktab.util.DatabaseContext;

import java.sql.*;

public class OrderRepository {
    public int findOrderCount(Connection connection, DatabaseContext context) throws SQLException {
        int count = 0;
        String findCount = "select count(*) from orders as o where o.user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(findCount);
        preparedStatement.setInt(1, context.getCurrentUser().getCurrentUser().getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return count;
    }

    public void insert(int productId, DatabaseContext context, Connection connection, int quantity) throws SQLException {
        //at first i search in orders for that product
        boolean exist = false;
        String ifExist = "select o.product_id from orders as o where o.user_id=? and o.product_id=? ";
        PreparedStatement preparedStatement1 = connection.prepareStatement(ifExist);
        preparedStatement1.setInt(1, context.getCurrentUser().getCurrentUser().getId());
        preparedStatement1.setInt(2, productId);
        ResultSet resultSet = preparedStatement1.executeQuery();
        while (resultSet.next()) {
            exist = true;
        }
        if (exist == false) {
            int price = context.getProductRepository().findPrice(connection, productId);
            int totalPrice = (price * quantity);
            String insert = "insert into orders (user_id,product_id,quantity,lastPrice) " +
                    "values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setInt(1, context.getCurrentUser().getCurrentUser().getId());
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setInt(4, totalPrice);
            preparedStatement.executeUpdate();
            context.getMenuTexts().showOrderAdded();
        } else {
            context.getMenuTexts().showProductExist();
        }

    }

    public void showOrders(Connection connection, DatabaseContext context) throws SQLException {
        String showOrders = "select p.id,p.name,p.price,o.quantity,o.lastprice,p.quantity " +
                "from product as p inner join orders as o " +
                "on p.id=o.product_id where o.user_id=? order by p.name";
        PreparedStatement preparedStatement = connection.prepareStatement(showOrders);
        preparedStatement.setInt(1, context.getCurrentUser().getCurrentUser().getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.print("product id : " + resultSet.getInt(1) + "\t");
            System.out.print("product name : " + resultSet.getString(2) + "\t");
            System.out.print("price : " + resultSet.getInt(3) + "\t");
            System.out.print("quantity : " + resultSet.getInt(4) + "\t");
            System.out.print("shop quantity : " + resultSet.getInt(6) + "\t");
            System.out.println("total price : " + resultSet.getInt(5) + "\t");
        }
        context.getOrderTableRepository().UpdateOrderTable(context, connection);
        context.getOrderTableRepository().showOrderTable(context, connection);
    }


    public void updateQuantityAndPrice(DatabaseContext context, Connection connection) throws SQLException {
        context.getOrderRepository().showOrders(connection, context);
        context.getMenuTexts().showSelectId();
        context.getMenuTexts().showZeroToExit();
        int userInput = context.getIntScanner().nextInt();
        switch (userInput) {
            case 0:
                context.getMenuTexts().showDone();
                break;
            default:
                context.getMenuTexts().showEnterQuantity();
                int newQuantity = context.getIntScanner().nextInt();
                if (newQuantity <= context.getProductRepository().findQuantity(connection, userInput)) {
                    int price = context.getProductRepository().findPrice(connection, userInput);
                    System.out.println(price);
                    int newPrice = (newQuantity * price);
                    String update = "update orders as o set o.quantity=? , o.lastPrice=? where o.user_id=? and o.product_id=? ";
                    PreparedStatement preparedStatement = connection.prepareStatement(update);
                    preparedStatement.setInt(1, newQuantity);
                    preparedStatement.setInt(2, newPrice);
                    preparedStatement.setInt(3, context.getCurrentUser().getCurrentUser().getId());
                    preparedStatement.setInt(4, userInput);


                    preparedStatement.executeUpdate();
                    context.getMenuTexts().showOrderUpdated();
                } else {
                    context.getMenuTexts().showLowQuantity();
                    updateQuantityAndPrice(context, connection);
                }

                break;
        }
    }

    public void delete(DatabaseContext context, Connection connection) throws SQLException {
        context.getOrderRepository().showOrders(connection, context);
        context.getMenuTexts().showSelectId();
        int productId = context.getIntScanner().nextInt();
        String delete = "delete from orders as o where o.product_id=? and o.user_id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, productId);
        preparedStatement.setInt(2, context.getCurrentUser().getCurrentUser().getId());
        preparedStatement.executeUpdate();
        context.getMenuTexts().showDeleteDone();
    }

    public boolean checkLowQuantity(DatabaseContext context, Connection connection) throws SQLException {
        boolean lowQuantity = false;
        String order = "select o.product_id,o.quantity,p.name from orders as o inner join product as p on o.product_id=p.id where o.user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(order);
        preparedStatement.setInt(1, context.getCurrentUser().getCurrentUser().getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int productId = resultSet.getInt(1);
            int quantity = resultSet.getInt(2);
            String productName = resultSet.getString(3);
            if (context.getProductRepository().findQuantity(connection, productId) < quantity) {
                System.out.println(quantity);
                System.out.println(context.getProductRepository().findQuantity(connection, productId));
                context.getMenuTexts().showLowQuantityOfAnProduct(productId, productName);
                lowQuantity = true;
            }
        }
        return lowQuantity;
    }

    public void confirm(DatabaseContext context, Connection connection) throws SQLException {
        if (checkLowQuantity(context, connection) == false) {
            String order="select o.quantity,o.product_id from orders as o where o.user_id=?";
            PreparedStatement preparedStatement1=connection.prepareStatement(order);
            preparedStatement1.setInt(1,context.getCurrentUser().getCurrentUser().getId());
            ResultSet resultSet=preparedStatement1.executeQuery();


            String updateProduct = "update product as p set quantity=? where p.id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateProduct);

            while (resultSet.next()){
                int productId=resultSet.getInt(2);
                int quantity=(context.getProductRepository().findQuantity(connection,productId))-(resultSet.getInt(1));
               preparedStatement.setInt(1,quantity);
               preparedStatement.setInt(2,productId);
               preparedStatement.executeUpdate();
            }
            String delete="delete from orders as o where o.user_id=?";
            PreparedStatement preparedStatement2=connection.prepareStatement(delete);
            preparedStatement2.setInt(1,context.getCurrentUser().getCurrentUser().getId());
            preparedStatement2.executeUpdate();
            context.getMenuTexts().showOrderTableConfirmed();
        }
    }
}
