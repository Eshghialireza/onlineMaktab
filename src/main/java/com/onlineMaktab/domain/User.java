package com.onlineMaktab.domain;

public class User extends Base{
    private String name;
    private String family;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String province;
    private String city;
    private String streetName;
    private String postalCode;

    public User(int id, String name, String family, String username, String password, String phoneNumber, String email, String province, String city, String streetName, String postalCode) {
        super(id);
        this.name = name;
        this.family = family;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.province = province;
        this.city = city;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }

    public User(String name, String family, String username, String password, String phoneNumber, String email, String province, String city, String streetName, String postalCode) {
        this.name = name;
        this.family = family;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.province = province;
        this.city = city;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
