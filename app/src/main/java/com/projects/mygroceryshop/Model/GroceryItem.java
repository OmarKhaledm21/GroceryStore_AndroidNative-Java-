package com.projects.mygroceryshop.Model;

public class GroceryItem {
    private String name;
    private double price;
    private ItemCategory itemCategory;
    private int imgResId;
    private final int NO_IMAGE_RES = -1;

    public GroceryItem(String name, double price,ItemCategory itemCategory) {
        this.name = name;
        this.price = price;
        this.itemCategory=itemCategory;
        imgResId = NO_IMAGE_RES;
    }

    public GroceryItem(String name, double price, int imgResId,ItemCategory itemCategory) {
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

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
}
