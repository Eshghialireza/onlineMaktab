package com.onlineMaktab.domain;

public abstract class Wearable extends Base{
    private String size;
    private String gender;

    public Wearable() {
    }

    public Wearable(String size, String gender) {
        this.size = size;
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
