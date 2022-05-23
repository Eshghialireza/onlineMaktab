package com.onlineMaktab.util;

import java.sql.Connection;
import java.sql.SQLException;

public class Logic {

    public void addToOrderMenu(DatabaseContext context, Connection connection) throws SQLException {
        if (context.getOrderRepository().findOrderCount(connection, context) < 5) {
            context.getProductRepository().showDetails(context, connection);
            context.getMenuTexts().showSelectId();
            int productId = context.getIntScanner().nextInt();
            context.getMenuTexts().showEnterQuantity();
            int quantity = context.getIntScanner().nextInt();
            switch (quantity) {
                case 0:
                    context.getMenuTexts().showDone();
                    break;
                default:
                    if (context.getProductRepository().findQuantity(connection, productId) >= quantity) {
                        context.getOrderRepository().insert(productId, context, connection, quantity);

                    } else {
                        context.getMenuTexts().showLowQuantity();
                        addToOrderMenu(context, connection);
                    }
                    break;
            }
        } else {
            context.getMenuTexts().showOrderTableFull();
        }
    }
//see order tables menu
    public void orderTableMenu(DatabaseContext context,Connection connection) throws SQLException {
        context.getOrderRepository().showOrders(connection, context);
        context.getMenuTexts().showOrderTableMenu();
        int userInput=context.getIntScanner().nextInt();
        switch (userInput){
            case 1:
                context.getOrderRepository().updateQuantityAndPrice(context,connection);
                break;
            case 2:

                break;
            case 3:

                break;
            default:
                context.getMenuTexts().showNumberIsWrong();
                orderTableMenu(context,connection);
                break;
        }
    }

    // login menu
    public void loginMenu(DatabaseContext context, Connection connection) throws SQLException {
        context.getMenuTexts().showLoggedMenu();
        int userInput = context.getIntScanner().nextInt();
        switch (userInput) {
            case 1:
                orderTableMenu(context,connection);
                loginMenu(context, connection);
                break;
            case 2:
                addToOrderMenu(context, connection);
                loginMenu(context, connection);
                break;
            case 3:
                context.getCurrentUser().setCurrentUser(null);
                context.getMenuTexts().showLogOut();
                break;
            default:
                context.getMenuTexts().showNumberIsWrong();
                loginMenu(context, connection);
                break;
        }
    }

    //this is just for see the products
    public void productDetails(DatabaseContext context, Connection connection) throws SQLException {
        context.getProductRepository().showDetails(context, connection);
        context.getMenuTexts().showZeroToExit();
        int userInput = context.getIntScanner().nextInt();
        if (userInput != 0) {
            productDetails(context, connection);
        } else {
            context.getMenuTexts().showDone();
        }
    }

    //this is the real menu and the firs menu
    public void firstMenu(DatabaseContext context, Connection connection) throws SQLException, ClassNotFoundException {
        boolean endApplication = true;
        while (endApplication) {
            context.getMenuTexts().showWelcomeMenu();
            boolean inWhile = true;
            while (inWhile) {
                int userInput = context.getIntScanner().nextInt();
                switch (userInput) {
                    case 1: {
                        //this is for login
                        inWhile = false;
                        context.getUserRepository().loggin(context, connection);
                        break;
                    }
                    case 2: {
                        //this is for signUp
                        inWhile = false;
                        context.getUserRepository().insert(context, connection);
                        break;
                    }
                    case 3: {
                        //this is for see all products
                        inWhile = false;
                        productDetails(context, connection);
                        break;
                    }
                    case 4: {
                        //this is for exit
                        inWhile = false;
                        endApplication = false;
                        context.getDatabaseUtil().getConnection().close();
                        context.getMenuTexts().showExitMessage();
                        break;
                    }
                    default: {
                        context.getMenuTexts().showNumberIsWrong();
                    }
                }
            }
        }
    }
}
