package com.onlineMaktab.util;

import com.onlineMaktab.repository.OrderRepository;
import com.onlineMaktab.repository.OrderTableRepository;
import com.onlineMaktab.repository.ProductRepository;
import com.onlineMaktab.repository.UserRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseContext {
    private DatabaseUtil databaseUtil = null;
    private Scanner strScanner = null;
    private Scanner intScanner = null;
    private MenuText menuTexts=new MenuText();
    private CurrentUser currentUser=new CurrentUser();
    private UserRepository userRepository=null;
    private ProductRepository productRepository=null;
    private Logic logic=null;
    private OrderRepository orderRepository=null;
    private OrderTableRepository orderTableRepository=null;





    public OrderTableRepository getOrderTableRepository() {
        if(orderTableRepository==null)
            this.orderTableRepository=new OrderTableRepository();
        return orderTableRepository;
    }

    public OrderRepository getOrderRepository() {
        if(orderRepository==null)
            this.orderRepository=new OrderRepository();
        return orderRepository;
    }

    public Logic getLogic() {
        if(logic==null)
            this.logic=new Logic();
        return logic;
    }

    public ProductRepository getProductRepository() {
        if(productRepository==null)
            this.productRepository=new ProductRepository();
        return productRepository;
    }

    public UserRepository getUserRepository() throws SQLException, ClassNotFoundException {
        if(userRepository==null)
            this.userRepository=new UserRepository();
        return userRepository;
    }

    public CurrentUser getCurrentUser() {
        return currentUser;
    }

    public MenuText getMenuTexts() {
        return menuTexts;
    }

    public Scanner getStrScanner() {
        if (strScanner == null)
            this.strScanner = new Scanner(System.in);
        return strScanner;
    }

    public Scanner getIntScanner() {
        if (intScanner == null)
            this.intScanner = new Scanner(System.in);
        return intScanner;
    }

    public DatabaseUtil getDatabaseUtil() throws SQLException, ClassNotFoundException {

        if (databaseUtil == null)
            this.databaseUtil = new DatabaseUtil();
        return databaseUtil;
    }
}
