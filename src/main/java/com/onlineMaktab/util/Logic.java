package com.onlineMaktab.util;

import java.sql.Connection;
import java.sql.SQLException;

public class Logic {





// login menu
    public void loginMenu(DatabaseContext context){
        context.getMenuTexts().showLoggedMenu();
        int userInput=context.getIntScanner().nextInt();
        switch (userInput){
            case 1:
context.
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:

                break;
        }
    }

    //this is just for see the products
public void productDetails(DatabaseContext context,Connection connection) throws SQLException {
    context.getProductRepository().showDetails(context,connection);
    context.getMenuTexts().showZeroToExit();
    int userInput=context.getIntScanner().nextInt();
    if(userInput!=0){
        productDetails(context,connection);
    }else{
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
                        productDetails(context,connection);
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
