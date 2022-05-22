package com.onlineMaktab.domain;

public abstract class  Electronical extends Base{
    private String powerUsage;
    private String brand;

    public Electronical() {
    }

    public Electronical(int id, String powerUsage, String brand) {
        super(id);
        this.powerUsage = powerUsage;
        this.brand = brand;
    }

    public String getPowerUsage() {
        return powerUsage;
    }

    public void setPowerUsage(String powerUsage) {
        this.powerUsage = powerUsage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
