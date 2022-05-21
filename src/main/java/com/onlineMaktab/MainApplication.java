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
                        inWhile = false;

                        break;
                    }
                    case 2: {
                        inWhile = false;

                        break;
                    }
                    case 3: {
                        inWhile = false;

                        break;
                    }
                    case 4: {
                        inWhile = false;
                        endApplication = false;
                        context.getDatabaseUtil().getConnection().close();

                        break;
                    }
                    default: {
                        //wrong number
                    }
                }
            }
        }
    }


}
