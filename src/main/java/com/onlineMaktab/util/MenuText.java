package com.onlineMaktab.util;

public class MenuText {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public void showWelcomeMenu(){

        System.out.println(YELLOW +"welcome to maktabshop.com");
        System.out.println("please choose a number :");
        System.out.println("1: login");
        System.out.println("2: signup");
        System.out.println("3: show all products");
        System.out.println("4 : exit"+RESET);
    }

    public void showLoggedMenu(){
        System.out.println(YELLOW +"welcome to maktabshop.com");
        System.out.println("please choose a number :");
        System.out.println("1 : see your order table");
        System.out.println("2 : go for shopping !8)");
        System.out.println("3 : log out"+RESET);
    }

    public void showOrderTableMenu() {
        System.out.println(YELLOW +"choose a number");
        System.out.println("1 : edit quantity");
        System.out.println("2 : remove an order");
        System.out.println("3 : show products");
        System.out.println("4 : confirm");
        System.out.println("5 : go back!"+RESET);

    }


    public void showEnterName() {
        System.out.println("please enter your name");
    }
    public void showEnterFamily() {
        System.out.println("please enter your last name");
    }
    public void showEnterUsername() {
        System.out.println("please enter your username");
    }
    public void showEnterPassword() {
        System.out.println("please enter your password");
    }
    public void showEnterPhoneNumber() {
        System.out.println("please enter your phoneNumber");
    }
    public void showEnterEmail() {
        System.out.println("please enter your email");
    }
    public void showEnterProvince() {
        System.out.println("please enter your province");
    }
    public void showEnterCity() {
        System.out.println("please enter your city");
    }
    public void showEnterStreetName() {
        System.out.println("please enter your street name");
    }
    public void showSelectId() {
        System.out.println("enter id");
    }
    public void showEnterQuantity() {
        System.out.println("please enter the quantity to add");
    }
    public void showZeroToExit() {
        System.out.println("enter zero to exit");
    }
    public void showEnterPostalCode() {
        System.out.println("please enter your postalCode");
    }

    public void showNumberIsWrong() {
        System.out.println(RED+"wrong number!"+RESET);
    }
    public void showWrongPass() {
        System.out.println(RED+"username or password is wrong"+RESET);
    }
    public void showLowQuantity() {
        System.out.println(RED+"please select lower number of that product!"+RESET);
    }
    public void showOrderTableFull() {
    System.out.println(RED+"you cant add new product because your order table is full"+RESET);
    }
    public void showProductExist() {
        System.out.println(RED+"the product you choose is exist in your order table"+RESET);
    }
    public void showLowQuantityOfAnProduct(int productId,String productName) {
        System.out.println(RED+"low shop quantity of id :"+productId+" "+productName+RESET);
    }



    public void showExitMessage() {
        System.out.println(BLUE+"good bye!"+RESET);
    }
    public void showSuccessfullySignUp() {
        System.out.println(BLUE+"your account created!"+RESET);
    }
    public void showSuccessfullySignIn() {
        System.out.println(BLUE+"logged"+RESET);
    }
    public void showDone() {
        System.out.println(BLUE+"done!"+RESET);
    }
    public void showOrderAdded() {
        System.out.println(BLUE+"your product successfully added to your order table!"+RESET);
        System.out.println(BLUE+"thanks for your shop!"+RESET);
    }
    public void showLogOut() {
        System.out.println(BLUE+"you logged out successfully"+RESET);
    }
    public void showOrderUpdated() {
        System.out.println(BLUE+"your order table has updated"+RESET);
    }
    public void showDeleteDone() {
        System.out.println(BLUE+"a column deleted successfully"+RESET);
    }
    public void showOrderTableConfirmed() {
        System.out.println(BLUE+"order table successfully confirmed"+RESET);
    }


}
