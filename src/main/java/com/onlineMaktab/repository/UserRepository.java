package com.onlineMaktab.repository;

import com.onlineMaktab.util.DatabaseContext;

import java.sql.Connection;
import java.sql.SQLException;

public class UserRepository {
    private DatabaseContext context;
    private Connection connection=context.getDatabaseUtil().getConnection();

    public void insert(){

    }





    public UserRepository() throws SQLException, ClassNotFoundException {
    }
}
