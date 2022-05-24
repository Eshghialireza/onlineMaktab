package com.onlineMaktab.domain;

public abstract class  Electronical extends Base{
    private String powerUsage;
    private String brand;
    private String model;



    public Electronical() {
    }

    public Electronical(int id, String powerUsage, String brand,String model) {
        super(id);
        this.powerUsage = powerUsage;
        this.brand = brand;
        this.model=model;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
