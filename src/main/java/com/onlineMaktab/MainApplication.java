package com.onlineMaktab;

import com.onlineMaktab.util.DatabaseContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainApplication {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DatabaseContext context = new DatabaseContext();
        Connection connection = context.getDatabaseUtil().getConnection();
showRealMenu(context,connection);

    }

    public static void showRealMenu(DatabaseContext context, Connection connection) throws SQLException, ClassNotFoundException {
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
