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
        context.getLogic().firstMenu(context,connection);

    }




}
