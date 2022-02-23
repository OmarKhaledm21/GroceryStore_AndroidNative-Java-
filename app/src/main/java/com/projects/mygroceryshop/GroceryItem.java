package com.projects.mygroceryshop;

public class GroceryItem {
    private String name;
    private double price;
    private int imgResId;
    private final int NO_IMAGE_RES = -1;

    public GroceryItem(String name, double price) {
        this.name = name;
        this.price = price;
        imgResId = NO_IMAGE_RES;
    }

    public GroceryItem(String name, double price, int imgResId) {
        this.name = name;
        this.price = price;
        this.imgResId = imgResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }

    public boolean hasImage(){
        return (imgResId != NO_IMAGE_RES);
    }
}
